import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class LogWriter {

	private PrintWriter logPrinter;
	private File logFile;
	private ArrayList<Order> orderSet;



/**
 * constructs a logWriter of a specified file and initializes the temporary log arraylist
 * @param log log file
 * @throws FileNotFoundException
 */
	public LogWriter(File log) throws FileNotFoundException{
		logFile = log;
		logPrinter = new PrintWriter(logFile);
		logPrinter.println("RESTAURANT LOG FILE \n CREATED " + new Timestamp(new Date().getTime()) + "\n\n\n");
		orderSet = new ArrayList<Order>();
	}
/**
 * adds an order to the temporary log
 * @param order order to log
 */
	public void log(Order order){
		orderSet.add(order);
	}
/**
 * prints the log to the log file
 */
	public void printLog(){
		for(Order order: orderSet){
			logPrinter.println(order.getTableNumber() + ": " + new Timestamp(new Date().getTime()));
			for(Dish d: order.getOrder()){
				logPrinter.println(d.getName() + ": " + d.getPrice());
			}
			logPrinter.println("---Total: " + order.getTotal() + "\n\n");
		}
		logPrinter.close();
	}

}
