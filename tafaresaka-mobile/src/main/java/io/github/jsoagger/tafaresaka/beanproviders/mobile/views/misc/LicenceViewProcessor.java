/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.views.misc;

import java.util.List;

import io.github.jsoagger.core.utils.FileUtils;
import io.github.jsoagger.jfxcore.api.IComponentProcessor;
import io.github.jsoagger.jfxcore.api.IJSoaggerController;
import io.github.jsoagger.jfxcore.viewdef.json.xml.model.VLViewComponentXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class LicenceViewProcessor implements IComponentProcessor{


	@Override
	public Node process(IJSoaggerController arg0, VLViewComponentXML arg1) {

		ScrollPane sp = new ScrollPane();
		sp.setFitToWidth(true);

		StackPane content = new StackPane();
		sp.setContent(content);
		content.setStyle("-fx-padding:32 16 16 16");

		List<String> lines = FileUtils.readAllLines("/mobile/views/menu/apacheLicence.txt");
		StringBuffer buffer = new StringBuffer();
		Label label = new Label();
		lines.forEach(e -> {
			buffer.append(e);
		});

		label.setText(buffer.toString());
		label.setWrapText(true);
		content.getChildren().add(label);
		return sp;
	}
}
