/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.google.gson.JsonObject;

import io.github.jsoagger.core.bridge.operation.IOperation;
import io.github.jsoagger.core.bridge.operation.IOperationResult;
import io.github.jsoagger.core.business.cloud.services.utils.CloudServicesLocator;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class LoadContainerByOidOperation implements IOperation {

	Map<String, IOperationResult> CACHE = new HashMap<String, IOperationResult>();

	@Override
	public void doOperation(JsonObject params, Consumer<IOperationResult> resultHandler,
			Consumer<Throwable> exHandler) {

		String id = params.get("id") != null ?
				params.get("id").getAsString() : params.get("oid").getAsString();
		if(CACHE.containsKey(id)) {
			resultHandler.accept(CACHE.get(id));
		}
		else {
			IOperationResult res = CloudServicesLocator.getContainerApi().getContainer(params);
			if(!res.hasBusinessError()) {
				CACHE.put(id, res);
			}
			resultHandler.accept(res);
		}
	}

}
