/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.layout;

import java.net.URL;

import io.github.jsoagger.jfxcore.engine.controller.roostructure.layout.FullTableStructureContentLayoutManager;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class FullTableStructureScrollLessLayoutManager extends FullTableStructureContentLayoutManager {

	@Override
	public URL getFXMLLocation() {
		return FullTableStructureScrollLessLayoutManager.class.getResource("FullTableStructureContent.fxml");
	}
}
