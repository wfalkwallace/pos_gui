import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 */

/**
 * @author wgf2104
 *
 */
@SuppressWarnings("serial")
public class POSGUI extends JFrame implements ActionListener, WindowListener{

	private static int tableIndex = 0;
	private MenuReader mr;
	private ArrayList<Dish> menu;
	private LogWriter lw;
	private Order orderUp;
	private JPanel mainPanel;
	private JPanel headerPanel;
	private JTextArea headerTextArea;
	private JPanel orderActionsPanel;
	private JPanel orderButtonsPanel;
	private JTextArea orderTextArea;
	private JScrollPane orderScrollPane;
	private JPanel dishesPanel;
	private JTextArea cost;
	private final static String HEADER_TEXT = "WGF2104 RESTAURANT PoS SYSTEM - Would You Like Fries With That?";
	private JButton orderPlace;
	private JButton orderClear;
	private JSplitPane orderPane;
	private double totalCost;

	
	
/**
 * set frame and define log print on window close
 * @param menuFile
 * @param logFile
 * @throws FileNotFoundException
 */
	public POSGUI(File menuFile, File logFile) throws FileNotFoundException {
		mr = new MenuReader(menuFile);
		lw = new LogWriter(logFile);
		
		init();
		setSize(10000, 5000);
		setTitle("WGF2104 PoS SYSTEM");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				lw.printLog();
			}
		});
		setVisible(true);
	}
/**
 * initialize all panes within frame
 */
	private void init() {
		
		mr.populateMenu();
		menu = mr.getMenu();
		totalCost = 0;
		
		mainPanel = (JPanel) getContentPane();
		mainPanel.setLayout(new BorderLayout());
		orderPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, getDishesButtonsPanel(), getOrderActionsPanel());
		orderPane.setDividerLocation(.75);
		mainPanel.add(getHeaderPanel(), BorderLayout.NORTH);
		mainPanel.add(orderPane, BorderLayout.CENTER);
		orderUp = new Order(tableIndex);
	}
/**
 * prepare and get the dish order button pane
 * @return scrollpane with buttons for ordering a specific dish
 */
	private JScrollPane getDishesButtonsPanel(){
		
		dishesPanel = new JPanel();
		dishesPanel.setLayout(new GridLayout(0, 3));
		for(final Dish d: menu){
			JButton b = new JButton(d.getName());
			b.setSize(100, 50);
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					addToOrder(d);
				}
			});
			
			dishesPanel.add(b);
			orderScrollPane = new JScrollPane(dishesPanel);
			orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		}
		return orderScrollPane;
	}
/**
 * prepare and get the GUI header pane
 * @return header panel
 */
	private JPanel getHeaderPanel(){
		headerPanel  = new JPanel();
		headerTextArea = new JTextArea(HEADER_TEXT, 1, 75);
		headerPanel.add(headerTextArea);
		return headerPanel;
	}
/**
 * prepare and get the order actions pane
 * @return panel with current order list and buttons for dealing with orders
 */
	private JPanel getOrderActionsPanel(){
		cost = new JTextArea("", 1, 20);
		orderActionsPanel = new JPanel();
		orderActionsPanel.setLayout(new BorderLayout());
		orderTextArea = new JTextArea(" ", 20, 50);
		orderTextArea.setLineWrap(false);
		orderScrollPane = new JScrollPane(orderTextArea);
		orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		orderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		orderButtonsPanel = new JPanel();
		orderPlace = new JButton("PLACE ORDER");
		orderClear = new JButton("CLEAR ORDER");
		orderPlace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				lw.log(orderUp);
				cost.setText("");
				orderTextArea.setText("");
				repaint();
				tableIndex++;
				orderUp = new Order(tableIndex);
				totalCost = 0.0;
			}
		});
		orderClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				cost.setText("");
				orderTextArea.setText("");
				repaint();
				orderUp.clearOrder();
				totalCost = 0.0;
			}
		});
		orderButtonsPanel.add(orderPlace);
		orderButtonsPanel.add(orderClear);
		
		orderActionsPanel.add(cost, BorderLayout.NORTH);
		orderActionsPanel.add(orderScrollPane, BorderLayout.CENTER);
		orderActionsPanel.add(orderButtonsPanel, BorderLayout.SOUTH);
		
		return orderActionsPanel;
	}
/**
 * adds a dish to order and sets and repaints order actions pane fields
 * @param d specified dish to add
 */
	private void addToOrder(Dish d){
		orderUp.addToOrder(d);
		totalCost += d.getPrice();
		cost.setText(Double.toString(totalCost));
		orderTextArea.append(d.getName() + ": " + d.getPrice() + "\n");
		orderTextArea.repaint();
	}


//following are unused action listener methods.

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}






	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
