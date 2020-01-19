/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.utils;

/**
 * @author Ramilafananana  VONJISOA
 *
 */
public class PriceUtils {

	/**
	 *
	 * @param price
	 * @return
	 */
	public static String priceToString(Number price) {

		if(price.intValue() == 0) {
			return "";
		}

		StringBuffer cost = new StringBuffer();
		if(price.doubleValue() % 1.0 != 0) {
			cost.append(String.format("%.2f", price.doubleValue()));
		}
		else {
			cost.append(String.format("%.0f", price.doubleValue()));
		}

		cost.append(" €");
		return cost.toString();
	}

	/**
	 *
	 * @param price
	 * @return
	 */
	public static String price(String price) {
		return price + " €";
	}
}
