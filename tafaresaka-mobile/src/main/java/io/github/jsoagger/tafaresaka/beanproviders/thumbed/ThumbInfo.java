/*-
 * ========================LICENSE_START=================================
 * JSoagger
 * %%
 * Copyright (C) 2019 JSOAGGER
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

package io.github.jsoagger.tafaresaka.beanproviders.thumbed;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

import org.kordamp.ikonli.javafx.FontIcon;

import com.google.gson.JsonObject;

import io.github.jsoagger.core.bridge.result.OperationData;
import io.github.jsoagger.core.utils.StringUtils;
import io.github.jsoagger.jfxcore.api.IJSoaggerController;
import io.github.jsoagger.jfxcore.api.presenter.ModelIconPresenter;
import io.github.jsoagger.jfxcore.engine.client.utils.NodeHelper;
import io.github.jsoagger.jfxcore.engine.components.tablestructure.CellPresenterImpl;
import io.github.jsoagger.jfxcore.viewdef.json.xml.model.VLViewComponentXML;
import io.github.jsoagger.tafaresaka.beanproviders.services.SiCommanderServices;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Ramilafananana Vonjisoa
 * @mailTo yvonjisoa@nexitia.com
 * @date 29 janv. 2018
 */
public class ThumbInfo extends CellPresenterImpl implements ModelIconPresenter {

	protected static final String NO_THUMB = "/images/placeholder-image.png";

	// needs platformProperties
	Properties platformProperties;
	StackPane content = new StackPane();

	String caption;
	Label captionLabel = new Label();

	String emptyImageStyleClass;

	double width;
	double height;
	double DEFAULT_WIDTH = 120;
	double DEFAULT_HEIGHT = 120;

	/**
	 * Constructor
	 */
	public ThumbInfo() {
		super();
		content.getStyleClass().add("ep-flow-item-icon-wrapper");
	}

	public void setContentStyleClass(String name) {
		content.getStyleClass().setAll(name);
	}

	public void setCaptionLabelStyleClass(String name) {
		captionLabel.getStyleClass().addAll(name);
	}


	public void setEmptyImageStyleClass(String emptyImageStyleClass) {
		this.emptyImageStyleClass = emptyImageStyleClass;
	}

	public Pane getDisplay() {
		return content;
	}

	/**
	 * @{inheritedDoc}
	 */
	@Override
	public Node provideIcon(IJSoaggerController controller, VLViewComponentXML configuration) {
		return provideIcon(controller, configuration, null);
	}

	public boolean isNetworkOKForLoadingImages() {
		return true;
	}

	/**
	 * @{inheritedDoc}
	 */
	@Override
	public Node provideIcon(IJSoaggerController controller, VLViewComponentXML configuration, Object forModel) {
		final OperationData data = (OperationData) forModel;
		try {
			Task<Void> loadthumbTask = new Task<Void>() {

				@Override
				protected Void call() throws Exception {
					String thumbedId = (String) data.getAttributes().get("id");
					JsonObject query = new JsonObject();
					query.addProperty("id", thumbedId);
					byte[] datas = SiCommanderServices.thumbedSrv().getThumb(query);

					if (datas.length <= 0) {
						displayEmptyThumb();
					} else {
						displayFullThumb(datas);
					}

					return null;
				}
			};

			loadthumbTask.setOnFailed(e ->{
				displayEmptyThumb();
			});

			if(isNetworkOKForLoadingImages()) {
				displayLoadingThumb();
				new Thread(loadthumbTask).start();
			}
			else {
				displayLoadManualThumb();
			}

		} catch (Exception e) {
			displayEmptyThumb();
		}

		return content;
	}

	protected void displayFullThumb(byte[] imageDataBytes) {
		double width = getWidth() > 0 ? getWidth() : DEFAULT_WIDTH;
		double height = getHeight() > 0 ? getHeight() : DEFAULT_HEIGHT;

		byte[] decodedString = Base64.getDecoder().decode(imageDataBytes);
		final Image img = new Image(new ByteArrayInputStream(decodedString), width, height, true, true);
		final ImageView imgView = new ImageView(img);
		imgView.setPreserveRatio(true);
		//imgView.setSmooth(true);
		imgView.setFitWidth(width);
		//imgView.setFitHeight(height);

		Platform.runLater(() -> {
			content.getChildren().clear();
			content.getChildren().add(imgView);
		});
	}

	protected void displayLoadManualThumb() {
		double width = getWidth() > 0 ? getWidth() : DEFAULT_WIDTH;
		double height = getHeight() > 0 ? getHeight() : DEFAULT_HEIGHT;

		StackPane loadinManualgImage = new StackPane();
		loadinManualgImage.setMinWidth(width);
		loadinManualgImage.setMinHeight(height);

		loadinManualgImage.getStyleClass().add("ep-loading-manual-image");
		loadinManualgImage.setAlignment(Pos.CENTER);

		Label loadManual = new Label();
		loadManual.getStyleClass().add("half-opacity");
		FontIcon icon = new FontIcon("fa-picture-o");
		loadManual.setGraphic(icon);

		loadinManualgImage.getChildren().add(loadManual);

		Platform.runLater(() -> {
			if(StringUtils.isNotBlank(getCaption())) {
				captionLabel.setText(getCaption());
				captionLabel.setTranslateY(20);
				loadinManualgImage.getChildren().add(captionLabel);
			}
			content.getChildren().add(loadinManualgImage);
		});
	}

	protected void displayLoadingThumb() {
		double width = getWidth() > 0 ? getWidth() : DEFAULT_WIDTH;
		double height = getHeight() > 0 ? getHeight() : DEFAULT_HEIGHT;

		StackPane loadingImage = new StackPane();
		loadingImage.setMinWidth(width);
		loadingImage.setMinHeight(height);

		loadingImage.getStyleClass().add("ep-loading-image");
		loadingImage.getChildren().add(NodeHelper.getLoadingIndicator());

		Platform.runLater(() -> {
			content.getChildren().add(loadingImage);
		});
	}


	protected void displayEmptyThumb() {
		Platform.runLater(() -> {
			double width = getWidth() > 0 ? getWidth() : DEFAULT_WIDTH;
			double height = getHeight() > 0 ? getHeight() : DEFAULT_HEIGHT;

			InputStream input = null;
			ImageView imageView = null;
			try {
				input = getClass().getResourceAsStream("/images/placeholder-image.png");
				Image image = new Image(input);
				imageView = new ImageView(image);
				imageView.setPreserveRatio(true);
				//imageView.setFitHeight(height);
				//imageView.setFitWidth(height);
				imageView.setFitWidth(width);

			} catch (Exception e) {
				e.printStackTrace();
			}

		StackPane emptyImage = new StackPane();
		emptyImage.setMaxWidth(width);
		emptyImage.setMaxHeight(height);


		emptyImage.getStyleClass().add("ep-empty-image");
		if(StringUtils.isNotBlank(emptyImageStyleClass))
			emptyImage.getStyleClass().setAll(emptyImageStyleClass);
			emptyImage.getChildren().add(imageView);
			content.getChildren().add(emptyImage);
		});
	}

	/**
	 * @{inheritedDoc}
	 */
	@Override
	public Node present(IJSoaggerController controller, VLViewComponentXML configuration, Object forModel) {
		return provideIcon(controller, configuration, forModel);
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the platformProperties
	 */
	public Properties getPlatformProperties() {
		return platformProperties;
	}

	/**
	 * @param platformProperties the platformProperties to set
	 */
	public void setPlatformProperties(Properties platformProperties) {
		this.platformProperties = platformProperties;
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
}
