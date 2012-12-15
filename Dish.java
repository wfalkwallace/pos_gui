/**
 * 
 */

/**
 * the Dish object to characterize plates/menu items
 * @author wgf2104
 *
 */
public class Dish {

	private String name;
	private double price;
/**
 * 
 * @param name menu item name, ingredients
 * @param price unit price
 */
	public Dish(String name, double price) {
		this.name = name;
		this.price = price;
	}
/**
 * 
 * @return dish name
 */
	public String getName() {
		return name;
	}
/**
 * 
 * @return dish price
 */
	public double getPrice() {
		return price;
	}

}
