import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * menu file reader
 * @author wgf2104
 *
 */
public class MenuReader {

	private ArrayList<Dish> dishes;
	private Scanner menuReader;

/**
 * initializes menuReader of specified formatted menu file
 * @param menu menu file
 * @throws FileNotFoundException
 */
	public MenuReader(File menu) throws FileNotFoundException {
		menuReader = new Scanner(menu);
		dishes = new ArrayList<Dish>();
	}
/**
 * populate menu from menu file
 */
	public void populateMenu(){
		String tempName;
		double tempPrice;
		while(menuReader.hasNextLine()){
			tempName = menuReader.nextLine();
			tempPrice = Double.parseDouble(menuReader.nextLine());
			dishes.add(new Dish(tempName, tempPrice));
		}
		menuReader.close();
	}
/**
 * 
 * @return arraylist<dish> menu
 */
	public ArrayList<Dish> getMenu(){
		return dishes;
	}


}
