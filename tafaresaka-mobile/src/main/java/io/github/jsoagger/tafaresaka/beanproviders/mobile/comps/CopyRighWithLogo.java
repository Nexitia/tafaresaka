/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.comps;

import java.io.InputStream;

import io.github.jsoagger.jfxcore.api.IBuildable;
import io.github.jsoagger.jfxcore.api.IJSoaggerController;
import io.github.jsoagger.jfxcore.viewdef.json.xml.model.VLViewComponentXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class CopyRighWithLogo extends VBox implements IBuildable{

	ImageView imageView  = null;

	public CopyRighWithLogo() {
		InputStream input = null;
		try {
			input = getClass().getResourceAsStream("/images/logo.png");
			Image image = new Image(input);
			imageView = new ImageView(image);
			imageView.setPreserveRatio(true);
			imageView.setFitHeight(180);
			imageView.setFitWidth(120);

			getChildren().add(imageView);

			setMaxWidth(120);
			setMaxHeight(180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Node getDisplay() {
		return imageView;
	}

	@Override
	public void buildFrom(IJSoaggerController controller, VLViewComponentXML configuration) {

	}
}
