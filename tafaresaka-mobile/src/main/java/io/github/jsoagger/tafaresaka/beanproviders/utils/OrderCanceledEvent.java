/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.utils;

import io.github.jsoagger.core.bridge.result.OperationData;
import io.github.jsoagger.jfxcore.engine.events.GenericEvent;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class OrderCanceledEvent extends GenericEvent {

	OperationData data;

	public OrderCanceledEvent(OperationData data) {
		this.data = data;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class getFilter() {
		return OrderCanceledEvent.class;
	}

	/**
	 * @return the data
	 */
	public OperationData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(OperationData data) {
		this.data = data;
	}
}
