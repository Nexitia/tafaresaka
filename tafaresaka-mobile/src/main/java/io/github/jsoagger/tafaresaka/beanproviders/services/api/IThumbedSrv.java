/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.services.api;

import com.google.gson.JsonObject;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public interface IThumbedSrv {

	byte[] getThumb(JsonObject query);
}
