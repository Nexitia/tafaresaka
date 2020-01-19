/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.views.misc;

import io.github.jsoagger.jfxcore.api.IComponentProcessor;
import io.github.jsoagger.jfxcore.api.IJSoaggerController;
import io.github.jsoagger.jfxcore.viewdef.json.xml.model.VLViewComponentXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class AboutViewProcessor implements IComponentProcessor {

	VBox pane = new VBox();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Node process(IJSoaggerController arg0, VLViewComponentXML arg1) {

		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setSpacing(20);

		buildLogo();
		buildVersion();
		Label version = new Label("Version 1.0.1");
		version.setStyle("-fx-font-weight:bold;-fx-font-size:2em");
		pane.getChildren().add(version);

		buildCopyRight();

		Label rights = new Label("All rights reserverd.");
		Label rights2 = new Label("JSoagger and Tafaresaka are trademark of");
		Label rights3 = new Label("NEXITIA TECHNOLOGIES");
		rights3.setStyle("-fx-font-weight:bold;-fx-font-size:2em");
		pane.getChildren().addAll(rights, rights2, rights3);

		Separator separator = new Separator(Orientation.HORIZONTAL);
		pane.getChildren().add(separator);

		return pane;
	}


	private void buildLogo() {

	}

	private void buildVersion() {
		Label version = new Label("V1.0.1");
		pane.getChildren().add(version);
	}

	private void buildCopyRight() {
		Label label = new Label("Copyright TAFARESAKA 2020.");
		pane.getChildren().add(label);
	}
}
