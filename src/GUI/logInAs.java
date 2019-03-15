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
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
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
import DataStorage.Database;
import Media.CD;
import Media.DVD;
import Media.PaperMedia;
import Media.PhysicalMedia;
import Utilities.Address;
import Utilities.CalendarPeriod;
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
	private final JPanel pickup_media = new JPanel();
	private final JPanel return_media = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel borrow_media = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JPanel panel_10 = new JPanel();
	private final JPanel panel_11 = new JPanel();
	
	//For scrollable list
	private JScrollPane scroll; 
	private JScrollPane scrollCustomers; 
	private JScrollPane scrollCustomerHolds;
	private JScrollPane scrollBorrowedSearch;
	private JScrollPane scrollHeldSearch;
		
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
	private final JButton borrow_button = new JButton("Borrow");
	private final JButton reserveButton = new JButton("Make Reserved");
	private final JButton okButton1 = new JButton("Ok");
	private final JButton returnBtn = new JButton("Return");
	private final JButton pickupBtn = new JButton("Pick-up from Hold");
	private final JButton okButtonPickup = new JButton("Ok");
	
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
	private final JLabel lblNewLabel_5 = new JLabel("Customer ID:");
	
	private final JPasswordField passwordField = new JPasswordField();
	
	private final JComboBox comboBox = new JComboBox();
	
	private final JTextField emailTextField = new JTextField();
	private JTextField custIDField;
	private final JTextField custIDField2 = new JTextField();
	
	private final JList list = new JList();
	private final JList customerBorrowedList = new JList();
	private final JList customerHoldsList = new JList();
	
	private final DefaultListModel dlm = new DefaultListModel();
	private final DefaultListModel customerDLM = new DefaultListModel();
	private final DefaultListModel customerHoldsDLM = new DefaultListModel();
	private final DefaultListModel searchHoldsDLM = new DefaultListModel();
	private final DefaultListModel searchBorrowDLM = new DefaultListModel();
	
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
	
	//Items for search page
	private JLabel custName = new JLabel();
	private JLabel custBlacklist = new JLabel();
	private JLabel custID = new JLabel();
	private JLabel custBirth = new JLabel();
	private JLabel custFees = new JLabel();
	private JLabel custAddress1 = new JLabel();
	private JLabel custAddress2 = new JLabel();
	private JLabel custAddress3 = new JLabel();
	private JLabel custPhone = new JLabel();
	private JLabel custType = new JLabel();
	
	private final JList searchBorrowList = new JList();
	private final JList searchHoldList = new JList();

	
	//Screen-size of current monitor screen
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Database initialization
	private Database dtb = new Database();
	private final JButton pickupButton = new JButton("Pickup");
	private final JButton searchCustomerBtn = new JButton("Search Customer");
	private final JPanel search_customer = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JLabel customerIDLab = new JLabel("Customer ID:");
	private final JTextField custIDField3 = new JTextField();
	private final JButton btnOk = new JButton("Ok");
	private final JLabel lblName = new JLabel("Name:");
	private final JPanel panel_15 = new JPanel();
	private final JLabel lblNewLabel_12 = new JLabel("Birthdate:");
	private final JLabel lblFeesDue = new JLabel("Fees Due:");
	private final JLabel custBorrowed = new JLabel("Media Borrowed:");
	private final JLabel custHeld = new JLabel("Media Held:");

	
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
		custIDField3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		custIDField3.setColumns(10);

		emailTextField.setHorizontalAlignment(SwingConstants.LEFT);
		emailTextField.setColumns(10);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Load customers & media
		dtb.loadData(); 
		
		System.out.println(dtb.shelfString());
		
		cl.setVgap(5);
		cl.setHgap(5);
		
		panelCont.setLayout(cl);
		panelCont.add(LogInAs,"1");
		panelCont.add(LogInAsSomeone,"2");
		panelCont.add(panel_4, "name_88267641545600");
		panelCont.add(LibrarianWindow,"LibrarianWindow");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_10.add(lblNewLabel_5);
		custIDField2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		custIDField2.setColumns(10);
		panel_10.add(custIDField2);
		okButtonPickup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_10.add(okButtonPickup);
		
		LibrarianWindow.setLayout(new BorderLayout(0, 0));
		person.setBorder(new LineBorder(new Color(0, 0, 0)));
		LibrarianWindow.add(person, BorderLayout.SOUTH);
		person.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		
		menu.add(pickupBtn);
		menu.add(searchCustomerBtn);
		
		middle.setBorder(new LineBorder(new Color(0, 0, 0)));
		LibrarianWindow.add(middle, BorderLayout.CENTER);
		middle.setLayout(mid);
		middle.add(browse_media, "browse");
		middle.add(pickup_media, "pickup");
		pickup_media.setLayout(new GridLayout(0, 1, 0, 0));
		
		pickup_media.add(panel_10);
		
		pickup_media.add(panel_11);
		
		browse_media.setLayout(new GridLayout(2, 1, 0, 0));
		browse_media.add(panel_3);
		
				
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_3.add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Books/Magazines/Comics", "CDs", "DVDs"}));
	
		panel_3.add(browseBtn);
		
		browse_media.add(panel_5);
		
		middle.add(return_media, "return");
		return_media.setLayout(new GridLayout(0, 1, 0, 0));
		
		Panel panel_8 = new Panel();
		return_media.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_1 = new JLabel("Customer ID:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(label_1);
		
		custIDField = new JTextField();
		custIDField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		custIDField.setColumns(10);
		panel_8.add(custIDField);
		okButton1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel_8.add(okButton1);
		
		return_media.add(panel_7);
		
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
		
		middle.add(borrow_media, "name_49849626154600");
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
				
		panel_5.add(list);
				
		//Scroll thingy 1 for media
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(3);
		scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(600, 90));
		panel_5.add(scroll);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		//Scroll thingy 2 for customer owned media
		customerBorrowedList.setModel(customerDLM);
		customerBorrowedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customerBorrowedList.setLayoutOrientation(JList.VERTICAL);
		customerBorrowedList.setVisibleRowCount(3);
		scrollCustomers = new JScrollPane(customerBorrowedList);
		scrollCustomers.setPreferredSize(new Dimension(600, 90));
		panel_7.add(scrollCustomers);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.X_AXIS));
		
		//Scroll thingy 3 for customer held media
		customerHoldsList.setModel(customerHoldsDLM);
		customerHoldsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customerHoldsList.setLayoutOrientation(JList.VERTICAL);
		customerHoldsList.setVisibleRowCount(3);
		scrollCustomerHolds = new JScrollPane(customerHoldsList);
		scrollCustomerHolds.setPreferredSize(new Dimension(600, 90));
		panel_11.add(scrollCustomerHolds);
		
		panel_11.add(pickupButton);
		
		//Scroll thingy 4 for search customer borrowed
		searchBorrowList.setModel(searchBorrowDLM);
		searchBorrowList.setLayoutOrientation(JList.VERTICAL);
		//searchBorrowList.setBounds(20, 36, 458, 159);
		searchBorrowList.setVisibleRowCount(3);
		scrollBorrowedSearch = new JScrollPane(searchBorrowList);
		scrollBorrowedSearch.setPreferredSize(new Dimension(458,159));
		scrollBorrowedSearch.setBounds(20, 36, 458, 159);
		panel_15.add(scrollBorrowedSearch);
		
		
		//Scroll thingy 5 for search customer held
		searchHoldList.setModel(searchHoldsDLM);
		searchHoldList.setLayoutOrientation(JList.VERTICAL);
		//searchHoldList.setBounds(20, 241, 458, 142);
		searchHoldList.setVisibleRowCount(3);
		scrollHeldSearch = new JScrollPane(searchHoldList);
		scrollHeldSearch.setPreferredSize(new Dimension(458,142));
		scrollHeldSearch.setBounds(20, 241, 458, 142);
		panel_15.add(scrollHeldSearch);
		
		
		panel_7.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_9.add(returnBtn);
				
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		borrow_button.setAlignmentY(0.0f);
		panel_6.add(borrow_button);
		
		panel_6.add(reserveButton);
		middle.add(search_customer, "search");
		search_customer.setLayout(null);
		panel_13.setBounds(0, 0, 827, 73);
		
		search_customer.add(panel_13);
		customerIDLab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel_13.add(customerIDLab);
		
		panel_13.add(custIDField3);
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel_13.add(btnOk);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 72, 323, 394);
		search_customer.add(panel_14);
		panel_14.setLayout(null);
		lblName.setBounds(31, 32, 96, 15);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panel_14.add(lblName);
		
		custName.setBounds(158, 32, 141, 15);
		panel_14.add(custName);
		
		JLabel lblNewLabel_10 = new JLabel("Blacklist?");
		lblNewLabel_10.setBounds(31, 345, 96, 15);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_14.add(lblNewLabel_10);
		
		custBlacklist.setBounds(158, 345, 141, 15);
		panel_14.add(custBlacklist);
		
		JLabel lblNewLabel_11 = new JLabel("User ID:");
		lblNewLabel_11.setBounds(31, 58, 96, 15);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_14.add(lblNewLabel_11);
		
		custID.setBounds(158, 58, 141, 15);
		panel_14.add(custID);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(31, 92, 96, 15);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_14.add(lblAddress);
		
		custAddress1.setBounds(158, 92, 141, 15);
		panel_14.add(custAddress1);
		custAddress2.setBounds(158, 112, 141, 15);
		
		panel_14.add(custAddress2);
		custAddress3.setBounds(158, 132, 46, 14);
		
		panel_14.add(custAddress3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(31, 162, 96, 15);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_14.add(lblPhoneNumber);
		
		custPhone.setBounds(158, 162, 141, 15);
		panel_14.add(custPhone);
		
		JLabel lblCustomerType = new JLabel("Max Media:");
		lblCustomerType.setBounds(31, 188, 96, 15);
		lblCustomerType.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_14.add(lblCustomerType);
		
		custType.setBounds(158, 188, 141, 15);
		panel_14.add(custType);
		lblNewLabel_12.setBounds(31, 214, 96, 15);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panel_14.add(lblNewLabel_12);
		custBirth.setBounds(158, 214, 141, 15);
		
		panel_14.add(custBirth);
		lblFeesDue.setBounds(31, 240, 58, 15);
		lblFeesDue.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panel_14.add(lblFeesDue);
		custFees.setBounds(158, 240, 141, 15);
		
		panel_14.add(custFees);
		panel_15.setBounds(320, 72, 507, 394);
		
		search_customer.add(panel_15);
		panel_15.setLayout(null);
		custBorrowed.setFont(new Font("Tahoma", Font.BOLD, 12));
		custBorrowed.setBounds(10, 11, 119, 14);
		
		panel_15.add(custBorrowed);
		custHeld.setFont(new Font("Tahoma", Font.BOLD, 12));
		custHeld.setBounds(10, 216, 119, 14);
		
		panel_15.add(custHeld);
		
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
				
				ArrayList<PaperMedia> papermedia = dtb.getPaperMedias();
				ArrayList<CD> cds = dtb.getCds();
				ArrayList<DVD> dvds = dtb.getDvds();
				
				if (comboBoxValue.equals("CDs")) 
				{
					dlm.clear();
					for (int i=0; i<cds.size();i++) {
						dlm.addElement(dtb.getCds().get(i));
					}
				}
				
				if (comboBoxValue.equals("DVDs")) 
				{
					dlm.clear();
					for (int i=0; i<dvds.size();i++) {
						dlm.addElement(dtb.getDvds().get(i));
					}
				}
				
				if (comboBoxValue.equals("Books/Magazines/Comics")) 
				{
					dlm.clear();
					for (int i=0; i<papermedia.size();i++) {
						dlm.addElement(dtb.getPaperMedias().get(i));
					}
				}
		
				list.setModel(dlm);
				
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
				
				pickupBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mid.show(middle, "pickup");
					}
				});
				
				searchCustomerBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mid.show(middle, "search");
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
						
					}		
						
				});
				
				
				/** 
				 * Ok button for book return tab
				 */
				okButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if ( !custIDField.getText().isEmpty() ) {
							
							Customer c = dtb.searchByID(custIDField.getText());
							
							if(c==null){
								customerDLM.clear();
								JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
							} else {
								
								if (c.getMediaOwned().size() == 0) {
									JOptionPane.showMessageDialog(null, "Customer doesn't own any media", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
								}else {
									
									customerDLM.clear();
									for (Map.Entry<PhysicalMedia, Calendar> entry : c.getMediaOwned().entrySet())
									{
										customerDLM.addElement(entry.getKey());
										
									}
								}
								
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Please fill in Customer ID", "ErrorBox", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				
				/**
				 * Return button in return tab
				 */
				returnBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (customerBorrowedList.getSelectedIndex() != -1) {
							PhysicalMedia item = new PhysicalMedia();
							try{item = (CD)customerBorrowedList.getSelectedValue();}catch(Exception e) {
								try {item = (DVD)customerBorrowedList.getSelectedValue();}catch(Exception f) {
									try {item = (PaperMedia)customerBorrowedList.getSelectedValue();}catch(Exception g) {}}}
						
							JOptionPane.showMessageDialog(dialogMediaBorrow, "Media was removed from customer's : " + item.getCustomer().getID() + " account." , "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
								
							Sophie.returnMedia(item, item.getCustomer());
							
							for (int i=0;i<dtb.getCustomers().size();i++) {
								System.out.println(dtb.getCustomers().get(i).toString());
							}
							
							
							dtb.save();
							
							customerDLM.clear();
							
						}else {
							JOptionPane.showMessageDialog(null, "Please select media from the list", "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
						}
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
				 * Ok button within a borrow dialog
				 */
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//Search customer by ID
						
						Customer c = dtb.searchByID(idTextField.getText());
						
						if (c == null) {
							JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
						} else {
							
							PhysicalMedia item = new PhysicalMedia();
							try{item = (CD)list.getSelectedValue();}catch(Exception e) {
								try {item = (DVD)list.getSelectedValue();}catch(Exception f) {
									try {item = (PaperMedia)list.getSelectedValue();}catch(Exception g) {}}}
							
							String msg = Sophie.addMediaOwned(c,item,String.valueOf(holdOrTakeComboBox.getSelectedItem()));
									
							JOptionPane.showMessageDialog(dialogMediaBorrow, msg, "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
							
							System.out.println(dtb.shelfString());
							
							for (int i=0;i<dtb.getCustomers().size();i++) {
								System.out.println(dtb.getCustomers().get(i).toString());
							}

							dtb.save();
							
							dialogMediaBorrow.setVisible(false);
							dialogMediaBorrow.dispose();
							dlm.clear();
					
						}
					}
				});

				/**
				 * Ok button in a pickup tab
				 */
				okButtonPickup.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if ( !custIDField2.getText().isEmpty() ) {
							
							Customer c = dtb.searchByID(custIDField2.getText());
							
							if(c==null){
								customerHoldsDLM.clear();
								JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
							} else {
								
								if (c.getMediaOnHold().size() == 0) {
									JOptionPane.showMessageDialog(null, "Customer doesn't have any media on hold", "InfoBox", JOptionPane.INFORMATION_MESSAGE);
									customerHoldsDLM.clear();
								}else {
									
									customerHoldsDLM.clear();
									for (Map.Entry<PhysicalMedia, CalendarPeriod> entry : c.getMediaOnHold().entrySet())
									{
										customerHoldsDLM.addElement(entry);
										
									}
								}
								
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Please fill in Customer ID", "ErrorBox", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				
				/**
				 * Pickup button in pickup tab
				 */
				pickupButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (customerHoldsList.getSelectedIndex() != -1) {
							Map.Entry<PhysicalMedia,CalendarPeriod> item = 
									new AbstractMap.SimpleEntry<PhysicalMedia, CalendarPeriod>(new PhysicalMedia(), new CalendarPeriod(Calendar.getInstance(),Calendar.getInstance()));
							try{item = (Map.Entry<PhysicalMedia, CalendarPeriod>) customerHoldsList.getSelectedValue();}catch(Exception e) {
								try {item = (Map.Entry<PhysicalMedia, CalendarPeriod>) customerHoldsList.getSelectedValue();}catch(Exception f) {
									try {item =(Map.Entry<PhysicalMedia, CalendarPeriod>) customerHoldsList.getSelectedValue();}catch(Exception g) {}}}
							
							String msg = Sophie.removeFromHoldsToPickup(item.getKey(),item.getKey().getCustomer());
							
							
							JOptionPane.showMessageDialog(dialogMediaBorrow, msg, "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
							customerHoldsDLM.clear();
							
						} else {
							JOptionPane.showMessageDialog(null, "Select item from a list", "InfoBox ", JOptionPane.WARNING_MESSAGE);
						}

						dtb.save();
				
					}
				});
				
				/**
				 * Change status button in browse tab
				 */
				reserveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (list.getSelectedIndex() != -1) {
							PhysicalMedia item = (PhysicalMedia) list.getSelectedValue();
							item.getStatus().setReserved();
							JOptionPane.showMessageDialog(null, "Status was set to reserved", "InfoBox ", JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				});
				
				/**
				 * Ok button in search tab
				 */
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						
						if ( !custIDField3.getText().isEmpty() ) {
							
							Customer c = dtb.searchByID(custIDField3.getText());
							
							/*
							 * customer does not exist
							 */
							if(c==null){
								searchHoldsDLM.clear();
								searchBorrowDLM.clear();
								
								custName.setText("");
								custBlacklist.setText("");
								custID.setText("");
								custPhone.setText("");
								custAddress1.setText("");
								custAddress2.setText("");
								custAddress3.setText("");
								custType.setText("");
								custBirth.setText("");
								custFees.setText("");
								JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
							} 
							/*
							 * customer does exist
							 */
							else {
								Address adr = c.getAddress();
								Calendar birth = c.getBirthDate();
								
								
								custName.setText(c.getFirstName() + " " + c.getLastName());
								if(c.getIsBlackListed()) {
									custBlacklist.setText("BLACKLISTED!");
								}
								else {
									custBlacklist.setText("Not blacklisted.");
								}
								
								custID.setText(c.getID());
								custPhone.setText(c.getPhoneNumber());
								
								custAddress1.setText(adr.getHouseNum() + " " + adr.getStreetName());
								custAddress2.setText(adr.getCity() + ", " + adr.getCountry());
								custAddress3.setText(adr.getZip());
								
								custType.setText(c.getMaxMedia() + "");
								custBirth.setText(birth.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH ) + " " + birth.get(Calendar.DATE) + ", " + birth.get(Calendar.YEAR) );
								custFees.setText(c.getFeesOwned() + "");
								
								searchHoldsDLM.clear();
								searchBorrowDLM.clear();
								for(Map.Entry<PhysicalMedia, Calendar> entry : c.getMediaOwned().entrySet())
								{
									searchBorrowDLM.addElement(entry.getKey());
								}
								
								for(Map.Entry<PhysicalMedia, CalendarPeriod> entry : c.getMediaOnHold().entrySet())
								{
									searchHoldsDLM.addElement(entry.getKey());
								}
									
								}
						}
						
						else {
							searchHoldsDLM.clear();
							searchBorrowDLM.clear();
							
							custName.setText("");
							custBlacklist.setText("");
							custID.setText("");
							custPhone.setText("");
							custAddress1.setText("");
							custAddress2.setText("");
							custAddress3.setText("");
							custType.setText("");
							custBirth.setText("");
							custFees.setText("");
							JOptionPane.showMessageDialog(null, "Please fill in Customer ID", "ErrorBox", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				});
					
				
			
			
	}
}
