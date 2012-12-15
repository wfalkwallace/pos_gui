import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
public class SessionTester {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		String menuFile = "";
		String logFile = "";
		
		JFrame frame = new JFrame("WFW's POS-GUI; pick your files"); //set title
		JFileChooser fc = new JFileChooser(); 
		fc.setDialogTitle("Pick a valid menu file");
		int returnVal = fc.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			menuFile = fc.getSelectedFile().getAbsolutePath();
		}
			
		fc.setDialogTitle("Pick a valid log file");
		returnVal = fc.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			logFile = fc.getSelectedFile().getAbsolutePath();
		}
		
//		String menuFile = "/Users/wgf2104/Documents/Eclipse/1007_Set3_WFW/src/max-soha.txt";
//		String logFile = "/Users/wgf2104/Documents/Eclipse/1007_Set3_WFW/src/max-soha-LOGFILE.txt";

		//String menuFile = JOptionPane.showInputDialog("Please Specify Menu File Location");
		//String logFile = JOptionPane.showInputDialog("Please Specify Log File Location");

		File mFile = new File(menuFile);
		File lFile = new File(logFile);
		
		//create a GUI and pass in the name of the user to it
		@SuppressWarnings("unused")
		POSGUI pg = new POSGUI(mFile, lFile);



















	}

}
