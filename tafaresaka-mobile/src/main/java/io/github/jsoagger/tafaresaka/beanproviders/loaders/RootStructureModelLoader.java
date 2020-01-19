/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.loaders;

import com.google.gson.JsonObject;

import io.github.jsoagger.core.bridge.operation.IOperation;
import io.github.jsoagger.core.bridge.operation.IOperationResult;
import io.github.jsoagger.core.business.cloud.services.utils.CloudServicesLocator;
import io.github.jsoagger.jfxcore.api.IJSoaggerController;
import io.github.jsoagger.jfxcore.api.IModelProvider;
import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.jfxcore.components.modelprovider.AbstractModelProvider;
import io.github.jsoagger.jfxcore.engine.controller.AbstractViewController;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.action.LocalStorage;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class RootStructureModelLoader extends AbstractModelProvider implements IModelProvider {

	private IOperation loadContainerByOidOperation;

	/**
	 * @{inheritedDoc}
	 */
	@Override
	public IOperationResult loadModel(IJSoaggerController controller, String compId) {
		this.controller = (AbstractViewController) controller;

		// set model to current working container
		LocalStorage ls = (LocalStorage) Services.getBean("LocalStorage");
		String wcId = ls.getWorkingContainerId();

		JsonObject query = new JsonObject();
		query.addProperty("id", wcId);

		IOperationResult or = CloudServicesLocator.getContainerApi().getContainer(query);
		onModelLoadSuccess(or);
		return or;
	}

	public IOperation getLoadContainerByOidOperation() {
		return loadContainerByOidOperation;
	}

	public void setLoadContainerByOidOperation(IOperation loadContainerByOidOperation) {
		this.loadContainerByOidOperation = loadContainerByOidOperation;
	}
}
