package Testing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class for experimenting with the gui
 *
 */
public class testGUI {

	private JFrame frame;
	JDialog popDialog = new JDialog();
	
	JPanel parentPanel = new JPanel();		
	JPanel studentPanel = new JPanel();
	JPanel logInPanel = new JPanel();
	
	CardLayout cl = new CardLayout();
	
	JButton logInButton = new JButton("log in");
	JButton popButton = new JButton("show dialog");
	JButton backButton = new JButton("back");

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

			//Declaring JFrame, JPanels, CardLayout
			frame = new JFrame();		
			
			//JFrame, frame
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500, 500);
			frame.setVisible(true);
			frame.getContentPane().add(parentPanel);
			
			parentPanel.setLayout(cl);
			
			parentPanel.add(logInPanel, "1");
			parentPanel.add(studentPanel, "2");
			
			studentPanel.add(popButton);
			studentPanel.add(backButton);
			
			logInPanel.add(logInButton);
				
			cl.show(parentPanel,"1");
			frame.repaint();
			
			
			logInButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(parentPanel, "2");
				}
			});
			
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(parentPanel, "1");
				}
			});
			
			popButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					popDialog.setModalityType(ModalityType.TOOLKIT_MODAL);
					popDialog.setBounds(0,0 ,100,100);
					popDialog.setLocationRelativeTo(null);
					popDialog.setVisible(true);
				}
			});
			
			
			
			}
			
	}


