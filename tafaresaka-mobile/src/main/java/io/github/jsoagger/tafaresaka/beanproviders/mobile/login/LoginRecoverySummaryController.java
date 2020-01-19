/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.login;

import io.github.jsoagger.jfxcore.api.IBuildable;
import io.github.jsoagger.jfxcore.engine.client.utils.NodeHelper;
import io.github.jsoagger.jfxcore.engine.controller.main.StandardController;
import io.github.jsoagger.jfxcore.engine.utils.ComponentUtils;
import io.github.jsoagger.jfxcore.viewdef.json.xml.model.VLViewComponentXML;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.comps.CopyRighWithLogo;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class LoginRecoverySummaryController extends StandardController {

	private Label label = new Label();


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void process() {
		super.process();

		label.setText(getLocalised("RECOVERY_SUMMARY_INFO"));
		label.getStyleClass().add("login-recovery-summary-label");

		VBox pane = new VBox();
		pane.setSpacing(20);
		NodeHelper.setVgrow(pane);
		pane.getStyleClass().add("login-recovery-summary-wrapper");
		pane.getChildren().add(label);

		VLViewComponentXML config = getConfiguration().getComponentById("OkButton").orElse(null);

		IBuildable buildable = ComponentUtils.build(this, config);
		pane.getChildren().add(buildable.getDisplay());

		pane.getChildren().add(new CopyRighWithLogo());

		processedView(pane);
	}
}
