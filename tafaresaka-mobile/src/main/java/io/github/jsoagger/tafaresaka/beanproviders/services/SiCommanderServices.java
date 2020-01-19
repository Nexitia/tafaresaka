/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.services;

import java.util.Properties;

import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.tafaresaka.beanproviders.services.api.IThumbedSrv;
import io.github.jsoagger.tafaresaka.beanproviders.services.impl.ThumbedSrv;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class SiCommanderServices {

	static IThumbedSrv thumbedSrv;

	public static IThumbedSrv thumbedSrv() {
		if(thumbedSrv == null) {
			thumbedSrv =  new ThumbedSrv();
			((ThumbedSrv)thumbedSrv).setCloudServicesProperties((Properties) Services.getBean("cloudServicesProperties"));
		}

		return thumbedSrv;
	}
}
