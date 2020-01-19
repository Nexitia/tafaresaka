/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.views.feeds;

import io.github.jsoagger.jfxcore.engine.controller.main.StandardController;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class RssFeedsController extends StandardController {

	VBox content = new VBox();
	Label cat1 = new Label();

	public RssFeedsController() {
		super();

		content.getStyleClass().add("ep-top-products-controller-wrapper");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void process() {
		super.process();
		processedView(content);

		cat1.setText("RSS Feeds");

		cat1.getStyleClass().add("ep-top-product-title");
		content.getChildren().addAll(cat1);
	}
}

