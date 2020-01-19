/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile.action;

import java.util.function.Consumer;

import com.google.gson.JsonObject;

import io.github.jsoagger.core.bridge.operation.IOperation;
import io.github.jsoagger.core.bridge.operation.IOperationResult;
import io.github.jsoagger.core.business.cloud.services.utils.CloudServicesLocator;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class LoginOperation implements IOperation {

	@Override
	public void doOperation(JsonObject params, Consumer<IOperationResult> resultHandler,
			Consumer<Throwable> exHandler) {

		try {
			IOperationResult result = CloudServicesLocator.getAuthenticationApi().login(params);
			resultHandler.accept(result);

			if(!result.hasBusinessError()) {
				LocalStorage.instance().setSessionId((String) result.getMetaData().get("session_id"));
				LocalStorage.instance().setLoginResult(result);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
