/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.services.impl;

import com.google.gson.JsonObject;

import io.github.jsoagger.core.business.cloud.services.impl.AbstractClientApi;
import io.github.jsoagger.tafaresaka.beanproviders.services.api.IThumbedSrv;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class ThumbedSrv  extends AbstractClientApi implements IThumbedSrv {

	static String getThumb_URL = "api/thumbed/%s/thumb";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[]  getThumb(JsonObject query) {
		String thumbedId = query.get("id").getAsString();

	    try {
	      String url = getRootUrl().concat(String.format(getThumb_URL, thumbedId));
	      byte[] result = doGetByte(query, url);
	      return result;
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	      return null;
	    }
	}
}
