/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.utils;

import io.github.jsoagger.jfxcore.engine.events.GenericEvent;
import io.github.jsoagger.jfxcore.engine.events.VLEvent;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public enum SiCommanderEvent implements VLEvent {

	// @formatter:on
	  SHOPPING_CART_NEED_UPDATE_EVENT(ShoppingCartNeedUpdateEvent.class),
	  ORDER_CANCELED_EVENT(OrderCanceledEvent.class);

	  private Class clazz;

	  /**
	   * Constructor
	   *
	   * @param s
	   */
	  SiCommanderEvent(Class<? extends GenericEvent> clazz) {
	    this.clazz = clazz;
	  }


	  /**
	   * @return
	   */
	  @Override
	  public <T extends GenericEvent> Class<T> filter() {
	    return clazz;
	  }
}
