package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Actors.Customer;
import Actors.Librarian;
import DataStorage.CustomersDatabase;
import Media.CD;
import Media.DVD;
import Media.PaperMedia;
import Media.PhysicalMedia;
import DataStorage.Shelf;
import Utilities.Address;
import Utilities.LogIn;
import Utilities.Status;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dialog.ModalityType;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.AbstractListModel;
import java.awt.List;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Panel;

public class logInAs {

	private JFrame frmLogin = new JFrame();
	
	private JPanel panelCont = new JPanel();
	private JPanel LogInAs= new JPanel();
	private JPanel LogInAsSomeone = new JPanel();
	private JPanel StudentWindow = new JPanel();
	private JPanel LibrarianWindow = new JPanel();
	private JPanel FacultyWindow = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel person = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel menu = new JPanel();
	private final JPanel middle = new JPanel();
	private final JPanel browse_media = new JPanel();
	private final JPanel return_media = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel borrow_media = new JPanel();
	private final JPanel panel_6 = new JPanel();
	
	//For scrollable list
	private JScrollPane scroll; 
		
	private JButton btnBack1 = new JButton("Back");
	private JButton studentBtn = new JButton("Student");
	private JButton facultyBtn = new JButton("Faculty");
	private JButton librarianBtn = new JButton("Librarian");
    private final JButton loginButton = new JButton("Log in");
	private final JButton librarianReturnButton = new JButton("Return media");
	private final JButton btnNewButton_1 = new JButton("Add media");
	private final JButton librarianBrowseButton = new JButton("Browse media");
	private final JButton browseBtn = new JButton("Browse");
	private final JButton btnNewButton = new JButton("Log Out");
	private final JButton borrow_button = new JButton("Borrow       ");
	private final JButton btnNewButton_3 = new JButton("New button");
	private final JButton btnReturn = new JButton("Return");
	
	private CardLayout cl = new CardLayout();
	private final CardLayout mid = new CardLayout(0,0);
	
	private final JLabel lblNewLabel = new JLabel("Log in as ..");
	private final JLabel lblNewLabel_1 = new JLabel("");
	private final JLabel lblNewLabel_2 = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("Email : ");
	private final JLabel lblNewLabel_4 = new JLabel("Password : ");
	private final JLabel who = new JLabel("Librarian");
	private final JLabel lblNewLabel_6 = new JLabel("");
	private final JLabel lblNewLabel_7 = new JLabel("");
	private final JLabel lblNewLabel_8 = new JLabel("");
	private final JLabel lblNewLabel_9 = new JLabel("");
	private final JLabel lblWelcome = new JLabel("Logged in as Librarian: ");
	private final JLabel nameLabel = new JLabel("<name>");
	
	private final JPasswordField passwordField = new JPasswordField();
	
	private final JComboBox comboBox = new JComboBox();
	
	private final JTextField emailTextField = new JTextField();
	
	private final JList list = new JList();
	
	private final DefaultListModel dlm = new DefaultListModel();
	
	
	//Items for Pop up dialog for borrowing books 
    private JButton okButton = new JButton("Ok");
    private JLabel customerID = new JLabel("Customer ID: ");
	private JTextField idTextField = new JTextField();
	private JLabel holdOrTakeLabel = new JLabel("Hold/Take : ");
	private JComboBox holdOrTakeComboBox = new JComboBox();
	private JDialog dialogMediaBorrow = new JDialog();
	private JButton cancelButton = new JButton("Cancel");
	
	//Items for Pop up for returning items
	private JButton closBut = new JButton("Close");
	private JButton rtnButton = new JButton("Return");
	private JLabel medID = new JLabel("Media ID: ");
	private JTextField medIDTextField = new JTextField();
	private JDialog dialogMediaReturn = new JDialog();
	private JLabel userIDLab = new JLabel();
	private JLabel userFeeLab = new JLabel();
	
	//Screen-size of current monitor screen
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Shelf and customer database initialization
	private Shelf shelf = new Shelf();
	private CustomersDatabase customerDtb = new CustomersDatabase();
	private JTextField custIDField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInAs window = new logInAs();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logInAs() {
		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setColumns(10);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		//Load customers & media
		shelf.loadMedia();
		customerDtb.loadCustomers(shelf.getCds(),shelf.getDvds(),shelf.getPaperMedias()); 
		
		cl.setVgap(5);
		cl.setHgap(5);
		
		panelCont.setLayout(cl);
		panelCont.add(LogInAs,"1");
		panelCont.add(LogInAsSomeone,"2");
		panelCont.add(panel_4, "name_88267641545600");
		panelCont.add(LibrarianWindow,"LibrarianWindow");
		
		LibrarianWindow.setLayout(new BorderLayout(0, 0));
		person.setBorder(new LineBorder(new Color(0, 0, 0)));
		LibrarianWindow.add(person, BorderLayout.SOUTH);
		person.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		person.add(lblWelcome);
		
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		person.add(nameLabel);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		person.add(btnNewButton);
		
		menu.setBorder(null);
		LibrarianWindow.add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(5, 0, 0, 0));
		
		menu.add(librarianReturnButton);
		menu.add(librarianBrowseButton);
		
		middle.setBorder(new LineBorder(new Color(0, 0, 0)));
		LibrarianWindow.add(middle, BorderLayout.CENTER);
		middle.setLayout(mid);
		middle.add(browse_media, "browse");
		
		browse_media.setLayout(new GridLayout(2, 1, 0, 0));
		browse_media.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_3.add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Books/Magazines/Comics", "CDs", "DVDs"}));
	
		panel_3.add(browseBtn);
		
		browse_media.add(panel_5);
		
		middle.add(return_media, "return");
		return_media.setLayout(null);
		
		Panel panel_8 = new Panel();
		panel_8.setBounds(0, 138, 843, 258);
		return_media.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel label_1 = new JLabel("Customer ID:");
		label_1.setBounds(160, 68, 101, 14);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(label_1);
		
		custIDField = new JTextField();
		custIDField.setBounds(304, 65, 149, 20);
		custIDField.setColumns(10);
		panel_8.add(custIDField);
		
		
		btnReturn.setBounds(499, 63, 117, 25);
		panel_8.add(btnReturn);
		
		panelCont.add(StudentWindow,"StudentWindow");
		panelCont.add(FacultyWindow,"FacultyWindow");
		
		cl.show(panelCont, "1");
		
		GridLayout gl_LogInAs = new GridLayout(7, 1);
		LogInAs.setLayout(gl_LogInAs);
		
		LogInAs.add(lblNewLabel_2);
		LogInAs.add(lblNewLabel);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LogInAs.add(studentBtn);
		LogInAs.add(facultyBtn);
		LogInAs.add(librarianBtn);
		LogInAs.add(lblNewLabel_1);
		LogInAsSomeone.setLayout(new GridLayout(5, 3, 0, 0));
		LogInAsSomeone.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		btnBack1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBack1.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(btnBack1);
		btnBack1.setHorizontalAlignment(SwingConstants.LEFT);
		who.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		who.setHorizontalAlignment(SwingConstants.CENTER);
		
		LogInAsSomeone.add(who);
		
		LogInAsSomeone.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 5));
		
		panel.add(lblNewLabel_6);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(lblNewLabel_3);
		
		panel.add(emailTextField);
		
		panel.add(lblNewLabel_7);
		
		panel.add(lblNewLabel_8);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(lblNewLabel_4);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		
		panel.add(passwordField);
		
		panel.add(lblNewLabel_9);
		
		LogInAsSomeone.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1.add(loginButton);
		panel_5.setLayout(null);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel_5.add(list);
		panel_6.setLocation(563, 61);
		panel_6.setSize(100, 58);
		
		panel_5.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		borrow_button.setAlignmentY(0.0f);
		
		panel_6.add(borrow_button);
		panel_6.add(btnNewButton_3);
		
		middle.add(borrow_media, "name_49849626154600");

		//Scroll thingy
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				list.setLayoutOrientation(JList.VERTICAL);
				list.setVisibleRowCount(3);
				scroll = new JScrollPane(list);
				scroll.setPreferredSize(new Dimension(600, 90));
				scroll.setBounds(15, 15, 540, 140);
				panel_5.add(scroll);
				borrow_media.repaint();
		
		
		/**
		 * Click "back button from selected person log in
		 */
		btnBack1.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "1");
			}
		});
			
		/**
		 * Click "log in as Student/Librarian/Faculty"
		 */
		
	   studentBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			        cl.show(panelCont, "2");
			        who.setText("Student");
				}
			});
	   
	   facultyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(panelCont, "2");
		        who.setText("Faculty");
			}
		});
	   
	   librarianBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(panelCont, "2");
		        who.setText("Librarian");
			}
		});
	   
	        
	   /**
	   * Click on "log in" & verify info, then load appropriate window for student/faculty/librarian
	   */
	   
	   loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Verify login
				LogIn enter = new LogIn();
				Boolean verifyLogin = enter.verifyLogin(emailTextField.getText(), passwordField.getText());
				if (verifyLogin == true) {
					
					JOptionPane.showMessageDialog(null, "Log in was successful", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
					if (who.getText().equals("Librarian")){
						cl.show(panelCont, "LibrarianWindow");
						
						librarianWindowActions(emailTextField.getText());
					
					}
			        if (who.getText().equals("Student")) {
			        	cl.show(panelCont, "StudentWindow");
			        }
			        
			        if (who.getText().equals("Faculty")) {
			        	cl.show(panelCont, "FacultyWindow");
			        }
				}
				else {
					JOptionPane.showMessageDialog(null, "Log in was unsuccessful", "InfoBox: " + "No Success", JOptionPane.ERROR_MESSAGE);
					cl.show(panelCont, "2");
				}
				
		        
			}
		});
	        
	      
	   /**
	    * Click on BROWSE button to browse CD,DVD or book/magazine/comics
	    */
	   browseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String comboBoxValue = (String) comboBox.getSelectedItem();
				
				ArrayList<PaperMedia> papermedia = shelf.getPaperMedias();
				ArrayList<CD> cds = shelf.getCds();
				ArrayList<DVD> dvds = shelf.getDvds();
				
				if (comboBoxValue.equals("CDs")) 
				{
					dlm.clear();
					for (int i=0; i<shelf.getCds().size();i++) {
						dlm.addElement(shelf.getCds().get(i));
					}
				}
				
				if (comboBoxValue.equals("DVDs")) 
				{
					dlm.clear();
					for (int i=0; i<shelf.getDvds().size();i++) {
						dlm.addElement(shelf.getDvds().get(i));
					}
				}
				
				if (comboBoxValue.equals("Books/Magazines/Comics")) 
				{
					dlm.clear();
					for (int i=0; i<shelf.getPaperMedias().size();i++) {
						dlm.addElement(shelf.getPaperMedias().get(i));
					}
				}
		
				list.setModel(dlm);
				shelf.save();
				customerDtb.save();
				
			}
		});
	   
	    /**
	     * Window settings
	     */
	   
		frmLogin.setResizable(false);

		frmLogin.setTitle("Mount Royal Library Management System");
		
		frmLogin.setBounds(0,0,screenSize.width/2, screenSize.height/2 );
		frmLogin.setLocationRelativeTo ( null ); //centers the window
		frmLogin.getContentPane().add(panelCont);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmLogin.setVisible(true);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	public void librarianWindowActions(String ID) {
		
				//Load librarian's info based on ID from file TODO
		
				//Create a librarian
				Calendar librarianSophieBirthDate = Calendar.getInstance();
				librarianSophieBirthDate.set(1970,0,12);
				Librarian Sophie = new Librarian("101","Sophie", "L", librarianSophieBirthDate, 
						new Address(10,"St.Paul","AAAA33","Calgary","Canada"),"4035667080");
				
				nameLabel.setText(Sophie.getFirstName() + " " + Sophie.getLastName());
				
						
				librarianBrowseButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							mid.show(middle,"browse");
							
						}
					});
				
				librarianReturnButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mid.show(middle, "return");
					}
				});
				
				/**
				 * Borrow button 
				 */
				borrow_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
												
						if (list.getSelectedIndex() != -1) {
								
						
							dialogMediaBorrow.getContentPane().setLayout(new GridLayout(6,1,5,5));
							dialogMediaBorrow.setModalityType(ModalityType.TOOLKIT_MODAL);
						
							dialogMediaBorrow.setBounds(0,0 ,screenSize.width/3, screenSize.height/3);
							dialogMediaBorrow.setLocationRelativeTo(null);
						
							
							holdOrTakeComboBox.setBackground(Color.white);
							holdOrTakeComboBox.setModel(new DefaultComboBoxModel(new String[] {"hold" , "take"}));
							
						
							dialogMediaBorrow.getContentPane().add(customerID);
							dialogMediaBorrow.getContentPane().add(idTextField );
							dialogMediaBorrow.getContentPane().add(holdOrTakeLabel );
							dialogMediaBorrow.getContentPane().add(holdOrTakeComboBox );
							dialogMediaBorrow.getContentPane().add(okButton);
							dialogMediaBorrow.getContentPane().add(cancelButton);
							
							dialogMediaBorrow.setVisible(true);
						
						
						}else {
							JOptionPane.showMessageDialog(null, "Please select media from the list", "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
						}
						
				// Add call to write storage	
						//shelf.save();
					}		
						
				});
				
				
				/* 
				 * Return button
				 */
				btnReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if ( !custIDField.getText().isEmpty() ) {
							
							Customer c = customerDtb.searchByID(custIDField.getText());
							
							if(c==null){
								JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
							} else {
								
								//following is setting up layout of the Media Return Dialog Box
								dialogMediaReturn.getContentPane().setLayout(new GridBagLayout());
								GridBagConstraints g = new GridBagConstraints();
								
								g.fill = GridBagConstraints.HORIZONTAL;
								
								
								dialogMediaReturn.setModalityType(ModalityType.TOOLKIT_MODAL);
						
								dialogMediaReturn.setBounds(0,0 ,screenSize.width/3, screenSize.height/3);
								dialogMediaReturn.setLocationRelativeTo(null);
						
								userIDLab.setText("Customer ID: " + custIDField.getText());
								
								
								g.weightx = 0.5;
								
								g.fill = GridBagConstraints.HORIZONTAL;
								g.gridx = 0;
								g.gridy = 0;
								
								dialogMediaReturn.getContentPane().add(userIDLab, g);
								
								userFeeLab.setText("Fees due: $" + c.getFeesOwned());
								g.fill = GridBagConstraints.HORIZONTAL;
								g.weightx = 0.5;
								g.gridx = 2;
								g.gridy = 0;
								
								dialogMediaReturn.getContentPane().add(userFeeLab,g);
								
								g.fill = GridBagConstraints.HORIZONTAL;
								g.weightx = 0.5;
								g.weighty = 0.5;
								g.ipadx = 0;
								g.gridx = 1;
								g.gridy = 1;
								
								dialogMediaReturn.getContentPane().add(medIDTextField,g);
								
								g.ipadx = 0;
								g.fill = GridBagConstraints.HORIZONTAL;
								g.weightx = 0.5;
								g.weighty = 0.5;
								g.gridx = 0;
								g.gridy = 1;
								
								dialogMediaReturn.getContentPane().add(medID,g);
								
								g.fill = GridBagConstraints.HORIZONTAL;
								g.weightx = 0.5;
								g.weighty = 0.5;
								g.ipady = 40;
								g.gridx = 2;
								g.gridy = 1;
								
								dialogMediaReturn.getContentPane().add(rtnButton,g);
								
								g.fill = GridBagConstraints.HORIZONTAL;
								g.weighty = 0.5;
								g.anchor = GridBagConstraints.PAGE_END;
								g.ipady = 40;
								g.gridx = 2;
								g.gridy = 2;
								
								dialogMediaReturn.getContentPane().add(closBut,g);
							
								dialogMediaReturn.setVisible(true);
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Please fill in Customer ID", "ErrorBox", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				
				/**
				 * Return button within dialog
				 */
				
				rtnButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// get customer from ID (No error checking needed, done in the previous frame)
						Customer cust = customerDtb.searchByID(custIDField.getText());

						// get the customer's owned media and iterate to find the specified media
						Map<PhysicalMedia,Calendar> owndMed = cust.getMediaOwned();
						Iterator<Map.Entry<PhysicalMedia, Calendar>> iter = owndMed.entrySet().iterator();
						while (iter.hasNext()) {							
							Map.Entry<PhysicalMedia, Calendar> med = (Map.Entry<PhysicalMedia, Calendar>) iter.next();
							PhysicalMedia temp = (PhysicalMedia) med.getKey();
							
							// if found, add to the correct shelf and remove it from the customer
							if ( temp.getTitle().equals(medIDTextField.getText()) ) {
								
								//Note: need to change status rather than add new instance
								
								/*
								if (temp instanceof CD) {
									shelf.addCD((CD) temp);
								} else if (temp instanceof DVD) {
									shelf.addDVD((DVD) temp);
								} else if (temp instanceof PaperMedia) {
									shelf.addPaperMedia((PaperMedia) temp);
								}
								*/
								
								temp.setStatus(new Status("available"));
								
								iter.remove();
								// finished correctly pop up and return
								JOptionPane.showMessageDialog(dialogMediaReturn, "Media Sucessfully Removed", "InfoBox", JOptionPane.WARNING_MESSAGE);
								shelf.save();
								customerDtb.save();
							    return;
							}
							
						}
						
						// not found, state error
						JOptionPane.showMessageDialog(dialogMediaReturn, "Media Not Found For This User", "Error", JOptionPane.WARNING_MESSAGE);
						
					}
				});
				
				/**
				 * Close button within dialog
				 */
				
				closBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dialogMediaReturn.setVisible(false);
						dialogMediaReturn.dispose();
					}
				});
				
				/**
				 * Ok button within a dialog
				 */
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//Search customer by ID
						
						Customer c = customerDtb.searchByID(idTextField.getText());
						
						
						if (c == null) {
							JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
						} else {
							
							PhysicalMedia item = new PhysicalMedia();
							try{item = (CD)list.getSelectedValue();}catch(Exception e) {
								try {item = (DVD)list.getSelectedValue();}catch(Exception f) {
									try {item = (PaperMedia)list.getSelectedValue();}catch(Exception g) {}}}
							
							String msg = Sophie.addMediaOwned(c,item,String.valueOf(holdOrTakeComboBox.getSelectedItem()));
									
							JOptionPane.showMessageDialog(dialogMediaBorrow, msg, "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
							shelf.save();
							customerDtb.save();
					
						}
					}
				});
				
				/**
				 * Cancel button
				 */
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dialogMediaBorrow.dispose();
					}
				});
		
				
	}
}
