/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.comps;

import java.io.InputStream;
import java.util.Optional;

import io.github.jsoagger.jfxcore.api.IBuildable;
import io.github.jsoagger.jfxcore.api.IJSoaggerController;
import io.github.jsoagger.jfxcore.components.actions.PushViewToSecondaryRSContentAction;
import io.github.jsoagger.jfxcore.engine.client.apiimpl.ActionRequest;
import io.github.jsoagger.jfxcore.engine.controller.AbstractViewController;
import io.github.jsoagger.jfxcore.viewdef.json.xml.model.VLViewComponentXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class WhiteCopyRightWithLogo extends VBox implements IBuildable{

	Button btn = new Button();
	ImageView imageView  = null;
	AbstractViewController controller;

	public WhiteCopyRightWithLogo() {

	}

	@Override
	public Node getDisplay() {
		return this;
	}

	@Override
	public void buildFrom(IJSoaggerController controller, VLViewComponentXML configuration) {
		this.controller = (AbstractViewController) controller;

		InputStream input = null;
		try {
			input = getClass().getResourceAsStream("/images/JSOAGGER_FX_WHITE_2.png");
			Image image = new Image(input);
			imageView = new ImageView(image);
			imageView.setPreserveRatio(true);
			imageView.setFitHeight(180);
			imageView.setFitWidth(120);

			setAlignment(Pos.BASELINE_LEFT);

			btn.setGraphic(imageView);
			btn.getStyleClass().addAll("app-header-btn","app-header-button");
			getChildren().add(btn);

			setMaxWidth(120);
			setMaxHeight(180);

			ActionRequest actionRequest = new ActionRequest();
			actionRequest.setController(controller);
			actionRequest.setProperty("viewId", "ManageObjectInSecondaryRSView");
			actionRequest.setProperty("contentId", "SwitchContainerView");
			actionRequest.setTargetController(controller);


			btn.setOnAction(e-> {
				PushViewToSecondaryRSContentAction action = new PushViewToSecondaryRSContentAction();
				action.execute(actionRequest, Optional.empty());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
