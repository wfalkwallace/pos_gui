import java.util.ArrayList;

/**
 * 
 */

/**
 * collection of dishes in an order
 * @author wgf2104
 *
 */
public class Order {

	private int table;
	private double totalCost;
	private ArrayList<Dish> order;
	
	
/**
 * initialize an order of a given table service index
 * @param table table index
 */
	public Order(int table){
		this.table = table;
		order = new ArrayList<Dish>();
	}
/**
 * 
 * @return int tableindex
 */
	public int getTableNumber(){
		return table;
	}
/**
 * 
 * @return double total order cost
 */
	public double getTotal(){
		for(Dish d: order){
			totalCost += d.getPrice();
		}
		return totalCost;
	}
/**
 * 	
 * @return Order
 */
	public ArrayList<Dish> getOrder(){
		return order;
	}
/**
 * 
 * @param Dish d
 */
	public void addToOrder(Dish d){
		order.add(d);
	}
/**
 * 
 */
	public void clearOrder(){
		order.clear();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
