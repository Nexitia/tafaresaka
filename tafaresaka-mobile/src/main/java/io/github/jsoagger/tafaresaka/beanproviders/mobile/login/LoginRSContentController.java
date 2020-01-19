/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.login;

import io.github.jsoagger.jfxcore.engine.controller.roostructure.content.RootStructureContentController;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.comps.CopyRighWithLogo;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class LoginRSContentController extends RootStructureContentController {

	@Override
	protected void process() {
		super.process();

		CopyRighWithLogo copyRighWithLogo = new CopyRighWithLogo();
		layout.getChildren().add(copyRighWithLogo);
		copyRighWithLogo.setTranslateY(200);
	}
}
