/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.utils;

import io.github.jsoagger.jfxcore.engine.client.utils.NodeHelper;
import io.github.jsoagger.jfxcore.engine.controller.main.StandardViewController;
import javafx.scene.layout.StackPane;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class EmptyPaneController extends StandardViewController {

	StackPane pane = new StackPane();

	@Override
	protected void process() {
		super.process();
		processedView(pane);

		pane.getStyleClass().add("ep-empty-pane");
		NodeHelper.setHVGrow(pane);
	}
}
