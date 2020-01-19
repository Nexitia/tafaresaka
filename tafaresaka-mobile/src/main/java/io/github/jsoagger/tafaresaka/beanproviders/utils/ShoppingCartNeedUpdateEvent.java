/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.utils;

import io.github.jsoagger.jfxcore.engine.events.GenericEvent;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class ShoppingCartNeedUpdateEvent extends GenericEvent {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class getFilter() {
		return ShoppingCartNeedUpdateEvent.class;
	}
}
