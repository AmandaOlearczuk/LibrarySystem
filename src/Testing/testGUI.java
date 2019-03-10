package Testing;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class testGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testGUI window = new testGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

			//Declaring JFrame, JPanel, JList, JScrollPane objects
			frame = new JFrame();
			JPanel panel = new JPanel();
			JList list; 
			JScrollPane scroll; 
			String[] numberTest = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

			//JFrame, frame
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500, 500);
			frame.setVisible(true);

			//JPanel, panel
			panel.setLayout(null);
			frame.add(panel);

			//JList, list
			list = new JList(numberTest);

			//list properties
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setVisibleRowCount(3);

			//Add JScrollPane to list   [What I need help with, its not working]
			JScrollPane listScroller = new JScrollPane(list);
			listScroller.setPreferredSize(new Dimension(250, 80));

			//Setbounds, add list and repaint frame
			listScroller.setBounds(25, 25, 100, 100);
			panel.add(listScroller);
			frame.repaint();
			}
			
	}


