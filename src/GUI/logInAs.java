package GUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import Actors.Customer;
import Actors.Librarian;
import DataStorage.Database;
import DataStorage.Order;
import DataStorage.OrderRequest;
import Media.CD;
import Media.DVD;
import Media.PaperMedia;
import Media.PhysicalMedia;
import Utilities.Address;
import Utilities.CalendarPeriod;
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
import java.awt.Graphics;
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
import javax.swing.BorderFactory;

import java.awt.List;

import javax.swing.JScrollBar;

import java.awt.Button;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.Panel;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;

import net.miginfocom.swing.MigLayout;

//import net.miginfocom.swing.MigLayout;

public class logInAs {

	private JFrame frame = new JFrame();

	private JPanel ParentJPanel = new JPanel();
	private JPanel LogInAs = new JPanel();
	private JPanel LogInAsSomeone = new JPanel();
	private JPanel CustomerWindow = new JPanel();
	private JPanel LibrarianWindow = new JPanel();
	
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel person = new JPanel();
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
	private final JPanel search_customer = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JPanel panel_15 = new JPanel();
	private final JPanel panel_16 = new JPanel();
	private final JPanel panel_17 = new JPanel();
	private final JPanel panel_20 = new JPanel();
	private final JPanel panel_21 = new JPanel();
	private final JPanel panel_18 = new JPanel();
	private final JPanel panel_19 = new JPanel();
	private final JPanel customerMiddle = new JPanel();
	private final JPanel customerPerson = new JPanel();
	private final JPanel customerMenu = new JPanel();
	private Panel panel_8 = new Panel();
	private JPanel buttonPanel = new JPanel(new GridLayout(1,2,5,5));
	
	//For scrollable list
	private JScrollPane scroll; 
	private JScrollPane scrollCustomers; 
	private JScrollPane scrollCustomerHolds;
	private JScrollPane scrollBorrowedSearch;
	private JScrollPane scrollHeldSearch;
	private JScrollPane scrollLibrarianOrders;
	private final JScrollPane scrollPane = new JScrollPane();
		
	private JButton btnBack1 = new JButton("Back");
	private JButton studentBtn = new JButton("Student/Faculty");
	private JButton librarianBtn = new JButton("Librarian");
    private final JButton loginButton = new JButton("Log in");
	private final JButton librarianReturnButton = new JButton("Return media");
	private final JButton btnNewButton_1 = new JButton("Add media");
	private final JButton librarianBrowseButton = new JButton("Browse media");
	private final JButton browseBtn = new JButton("Browse");
	private final JButton logOutBtn = new JButton("Log Out");
	private final JButton borrow_button = new JButton("Borrow");
	private final JButton changeStatusButton = new JButton("Change status");
	private final JButton okButton1 = new JButton("Ok");
	private final JButton returnBtn = new JButton("Return");
	private final JButton pickupBtn = new JButton("Pick-up from Hold");
	private final JButton okButtonPickup = new JButton("Ok");
	private final JButton pickupButton = new JButton("Pickup");
	private final JButton searchCustomerBtn = new JButton("Search Customer");
	private final JButton HoldBtnStudent = new JButton("Hold");
	private final JButton logOutBtn2 = new JButton("Log Out");
	private final JButton btnPlaceOnHold = new JButton("Browse Media");
	private final JButton btnOk = new JButton("Ok");
	private final JButton button = new JButton("Browse");
	private final JButton changeStatusOKButton = new JButton("Ok");
	private final JButton changeStatusCancelButton = new JButton("Cancel");
	private final JButton cancelButton_requestMedia = new JButton("Cancel");
	private final JButton cancelButton_showOrders = new JButton("Cancel");
	private final JButton cancelButton_customerRequest= new JButton("Cancel");
	
	private CardLayout cl = new CardLayout();
	private  CardLayout cl1 = new CardLayout(5,5);
	
	private final JLabel lblNewLabel = new JLabel("Log in as ..");
	private final JLabel lblNewLabel_3 = new JLabel("ID:");
	private final JLabel lblNewLabel_4 = new JLabel("Password : ");
	private final JLabel who = new JLabel("Librarian");
	private final JLabel lblNewLabel_6 = new JLabel("");
	private final JLabel lblNewLabel_7 = new JLabel("");
	private final JLabel lblWelcome = new JLabel("Logged in as Librarian: ");
	private final JLabel nameLabel = new JLabel("<name>");
	private final JLabel lblNewLabel_5 = new JLabel("Customer ID:");
	private final JLabel lblNewLabel_12 = new JLabel("Birthdate:");
	private final JLabel lblFeesDue = new JLabel("Fees Due:");
	private final JLabel custBorrowed = new JLabel("Media Borrowed:");
	private final JLabel custHeld = new JLabel("Media Held:");
	private final JLabel lblLoggedInAs = new JLabel("Logged in as Student: ");
	private final JLabel customerNameLabel = new JLabel("<name>");
	private final JLabel customerIDLab = new JLabel("Customer ID:");
	private final JLabel lblName = new JLabel("Name:");
	private final JLabel label = new JLabel("");
	private final JLabel label_3 = new JLabel("");
	private JLabel label_1 = new JLabel("Customer ID:");
	
	private final JPasswordField passwordField = new JPasswordField();
	
	private final JComboBox comboBox = new JComboBox();
	private final JComboBox comboBox_studentHold = new JComboBox();
	private final JComboBox statusComboBox = new JComboBox();
	
	private final JTextField idTxtField = new JTextField();
	private JTextField custIDField;
	private final JTextField custIDField2 = new JTextField();
	private final JTextField custIDField3 = new JTextField();
	
	private final JList list = new JList();
	private final JList customerBorrowedList = new JList();
	private final JList customerHoldsList = new JList();
	private final JList list_1 = new JList();
	
	private final DefaultListModel dlm = new DefaultListModel();
	private final DefaultListModel customerDLM = new DefaultListModel();
	private final DefaultListModel customerHoldsDLM = new DefaultListModel();
	private final DefaultListModel searchHoldsDLM = new DefaultListModel();
	private final DefaultListModel searchBorrowDLM = new DefaultListModel();
	private final DefaultListModel currentOrderRequestsModel = new DefaultListModel();
	private final DefaultListModel customerOrderRequestsModel = new DefaultListModel();

	
	//Items for Ordering Media Pop-up
	private JLabel mediaTypeLabel = new JLabel(" Media Type: ");
	private JComboBox mediaTypeComboBox = new JComboBox();
	private JLabel mediaNameLabel = new JLabel(" Name of Media: ");
	private JTextField mediaNameTextField = new JTextField();
	private JLabel mediaAuthorLabel = new JLabel(" Author of Media: ");
	private JTextField mediaAuthorTextField = new JTextField();
	private JLabel mediaDateLabel_y = new JLabel(" Year of Creation: ");
	private JTextField mediaDateTextField_y = new JTextField();
	private JLabel mediaDateLabel_m = new JLabel(" Month of Creation: ");
	private JTextField mediaDateTextField_m = new JTextField();
	private JLabel mediaDateLabel_d = new JLabel(" Day of Creation: ");
	private JTextField mediaDateTextField_d = new JTextField();
	private JButton orderMediaOkBtn = new JButton("Send");
	
	//Items for Student Media Order Requests
	private JButton btnRequestMediaSend = new JButton("Send");
	
	//Items for the pop up for current Media Orders
	private final JList currentOrdersList = new JList();
    private JLabel currMedOrdersLabel = new JLabel("Current Media Orders: ");
    private JButton btnOrderRecieved = new JButton("Order Recieved");

    private JDialog dialogRequestMedia = new JDialog();
    private JDialog dialogShowOrders= new JDialog();
    private JDialog dialogCustomerRequestMedia = new JDialog();
    
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
	
	//Items for fee payment after search
	private JLabel lblName2 = new JLabel("Name:");
	private JLabel nameLabel2 = new JLabel();
	private JLabel lblNewLabel2 = new JLabel("");
	private JLabel lblId = new JLabel("ID:");
	private JLabel idLabel = new JLabel();
	private JLabel lblFees = new JLabel("Fees:");
	private JLabel feesLabel = new JLabel();
	private JTextField payAmount = new JTextField();
	private JButton payBtn = new JButton("Pay Amount");
	private JLabel updateInfo = new JLabel();
	private JButton quitBtn = new JButton("Cancel");
	private JPanel panel_30 = new JPanel();
	private JPanel panel_31 = new JPanel();
	private JPanel panel_32 = new JPanel();
	private JPanel panel_33 = new JPanel();
	private JPanel panel_34 = new JPanel();
	private JDialog dialogFeePayment = new JDialog();
	
	//Pop-up window items for librarian's "change status" 
	private JDialog dialogChangeStatus = new JDialog();
		
	private final JList searchBorrowList = new JList();
	private final JList searchHoldList = new JList();

	//Screen-size of current monitor screen
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Database initialization
	private Database dtb = new Database();
	private final JLabel label_2 = new JLabel("");
	private final JButton btnPayFees = new JButton("Pay Fees");
	private final JButton btnOrderMedia = new JButton("Order Media");
	private final JPanel order_media = new JPanel();
	private final JPanel panel_22 = new JPanel();
	private final JPanel panel_23 = new JPanel();
	private final JPanel panel_24 = new JPanel();
	private final JPanel panel_25 = new JPanel();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JList listMediaOrders = new JList(customerOrderRequestsModel);
	private final JButton btnCreateNewOrder = new JButton("Create New Order");
	private final JLabel lblNewLabel_1 = new JLabel("Media Order Requests:");
	private final JButton btnViewMediaOrders = new JButton("Current Media Orders");
	private final JLabel label_empty = new JLabel("");
	private final JButton btnRequestMedia = new JButton("Request Media");
	private final JPanel panel_26 = new JPanel();
	
	// These are to keep info of LOGGED IN PERSON - either customer/librarian and their ID.
	Librarian librarian;
	Customer customer;
	String IDPersonLoggedIn;
	private final JButton btnDeleteRequest = new JButton("Delete Request");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
					 
					logInAs window = new logInAs();
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
	public logInAs() {

		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		custIDField3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		custIDField3.setColumns(10);

		idTxtField.setHorizontalAlignment(SwingConstants.LEFT);
		idTxtField.setColumns(10);
		
		//Load customers & media
		dtb.loadData(); 
		
		//System.out.println(dtb.shelfString());
		
		cl.setVgap(5);
		cl.setHgap(5);
		
		who.setOpaque(true);
		LogInAs.setOpaque(true);
		
		ParentJPanel.setLayout(cl);
		
		//Add cards to Parent JPanel 
		ParentJPanel.add(LogInAs,"1");
		ParentJPanel.add(LogInAsSomeone,"2");
        ParentJPanel.add(LibrarianWindow,"LibrarianWindow");
        ParentJPanel.add(CustomerWindow,"CustomerWindow");
        
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_10.add(lblNewLabel_5);
		custIDField2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		custIDField2.setColumns(10);
		panel_10.add(custIDField2);
		okButtonPickup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_10.add(okButtonPickup);
		LibrarianWindow.setLayout(new BorderLayout(0, 0));
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		person.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		LibrarianWindow.add(person, BorderLayout.SOUTH);
		person.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		person.add(lblWelcome);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		person.add(nameLabel);
		logOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		person.add(logOutBtn);
		menu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		LibrarianWindow.add(menu, BorderLayout.WEST);
		menu.setLayout(new GridLayout(5, 0, 0, 0));
		menu.add(librarianReturnButton);
		menu.add(librarianBrowseButton);
		menu.add(pickupBtn);
		menu.add(searchCustomerBtn);
		menu.add(btnOrderMedia);
		middle.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		LibrarianWindow.add(middle, BorderLayout.CENTER);
		middle.setLayout(cl1);
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
		return_media.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
		
		CustomerWindow.setLayout(new BorderLayout(0, 0));
		customerMenu.setBorder(null);
		CustomerWindow.add(customerMenu, BorderLayout.WEST);
		customerMenu.setLayout(new GridLayout(5, 0, 0, 0));
		customerMenu.add(btnPlaceOnHold);
		
		customerMenu.add(btnRequestMedia);
		customerMiddle.setBorder(new LineBorder(new Color(0, 0, 0)));
		CustomerWindow.add(customerMiddle, BorderLayout.CENTER);
		customerMiddle.setLayout(new GridLayout(0, 1, 0, 0));
		
		customerMiddle.add(panel_26);
		panel_26.setLayout(new GridLayout(0, 1, 0, 0));
		comboBox_studentHold.setModel(new DefaultComboBoxModel(new String[] {"Books/Magazines/Comics", "CDs", "DVDs"}));
		panel_26.add(panel_16);
		panel_16.add(comboBox_studentHold);
		panel_16.add(button);
		panel_26.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));
		panel_17.add(panel_18);
		panel_18.setLayout(new GridLayout(0, 1, 0, 0));
		panel_18.add(scrollPane);
		scrollPane.setViewportView(list_1);
		panel_17.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 1, 0, 0));
		panel_19.add(HoldBtnStudent);
		customerPerson.setBorder(new LineBorder(new Color(0, 0, 0)));
		CustomerWindow.add(customerPerson, BorderLayout.SOUTH);
		customerPerson.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		lblLoggedInAs.setHorizontalAlignment(SwingConstants.CENTER);
		customerPerson.add(lblLoggedInAs);
		customerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerPerson.add(customerNameLabel);
		logOutBtn2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		customerPerson.add(logOutBtn2);
		
		LogInAs.setLayout(new GridLayout(5, 1, 0, 0));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLACK);
		LogInAs.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LogInAs.add(studentBtn);
		LogInAs.add(librarianBtn);
		LogInAsSomeone.setLayout(new GridLayout(5, 3, 0, 0));
		LogInAsSomeone.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		btnBack1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnBack1.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(btnBack1);
		btnBack1.setHorizontalAlignment(SwingConstants.LEFT);
		who.setFont(new Font("Yu Gothic Light", Font.PLAIN, 30));
		who.setHorizontalAlignment(SwingConstants.CENTER);
		LogInAsSomeone.add(who);
		LogInAsSomeone.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 5));
		panel.add(lblNewLabel_6);
		panel_21.setBorder(null);
		panel.add(panel_21);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_21.setLayout(new GridLayout(0, 2, 0, 2));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_3);
		panel_21.add(idTxtField);
		panel_21.add(lblNewLabel_4);
		panel_21.add(passwordField);
		panel.add(lblNewLabel_7);
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
		panel_7.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		panel_9.add(returnBtn);	
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		borrow_button.setAlignmentY(0.0f);
		panel_6.add(borrow_button);
		panel_6.add(changeStatusButton);
		middle.add(search_customer, "search");
		search_customer.setLayout(new BorderLayout(0, 0));
		search_customer.add(panel_13, BorderLayout.NORTH);
		customerIDLab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_13.add(customerIDLab);
		panel_13.add(custIDField3);
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_13.add(btnOk);
		search_customer.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new GridLayout(0, 2, 0, 0));
		JPanel panel_14 = new JPanel();
		panel_20.add(panel_14);
		panel_14.setLayout(new GridLayout(11, 2, 0, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblName);
		panel_14.add(custName);
		JLabel lblNewLabel_11 = new JLabel("User ID:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblNewLabel_11);
		panel_14.add(custID);
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblAddress);
		panel_14.add(custAddress1);
		panel_14.add(label);
		panel_14.add(custAddress2);
		panel_14.add(label_3);
		panel_14.add(custAddress3);
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblPhoneNumber);
		panel_14.add(custPhone);
		JLabel lblCustomerType = new JLabel("Max Media:");
		lblCustomerType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblCustomerType);
		panel_14.add(custType);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblNewLabel_12);
		panel_14.add(custBirth);
		JLabel lblNewLabel_10 = new JLabel("Blacklist?");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblNewLabel_10);
		panel_14.add(custBlacklist);
		lblFeesDue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_14.add(lblFeesDue);
		custFees.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_14.add(custFees);
		
		panel_14.add(label_2);
		btnPayFees.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panel_14.add(btnPayFees);
		
		//Scroll thingy 4 for search customer borrowed
		searchBorrowList.setModel(searchBorrowDLM);
		searchBorrowList.setLayoutOrientation(JList.VERTICAL);
		//searchBorrowList.setBounds(20, 36, 458, 159);
		searchBorrowList.setVisibleRowCount(3);
		scrollBorrowedSearch = new JScrollPane(searchBorrowList);
		scrollBorrowedSearch.setPreferredSize(new Dimension(458,159));
		panel_20.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));
		custBorrowed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel_15.add(custBorrowed);
		panel_15.add(scrollBorrowedSearch);
		custHeld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_15.add(custHeld);
		
		
		//Scroll thingy 5 for search customer held
		searchHoldList.setModel(searchHoldsDLM);
		searchHoldList.setLayoutOrientation(JList.VERTICAL);
		//searchHoldList.setBounds(20, 241, 458, 142);
		searchHoldList.setVisibleRowCount(3);
		scrollHeldSearch = new JScrollPane(searchHoldList);
		scrollHeldSearch.setPreferredSize(new Dimension(458,142));
		panel_15.add(scrollHeldSearch);
		
		middle.add(order_media, "order");
		order_media.setLayout(new GridLayout(0, 1, 0, 0));
		order_media.add(panel_22);
		panel_22.setLayout(new GridLayout(3, 6, 0, 0));
		
		panel_22.add(btnViewMediaOrders);
		
		panel_22.add(label_empty);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		
		panel_22.add(lblNewLabel_1);
		order_media.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		panel_23.add(panel_24);
		panel_24.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_24.add(scrollPane_1);
		
		scrollPane_1.setViewportView(listMediaOrders);
		
		scrollLibrarianOrders = new JScrollPane(currentOrdersList);

		
		panel_23.add(panel_25, BorderLayout.EAST);
		panel_25.setLayout(new GridLayout(2, 1, 0, 0));

		panel_25.add(btnCreateNewOrder);
		btnDeleteRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// and remove the request
				dtb.removeOrderRequest(listMediaOrders.getSelectedIndex());
				
				dtb.save();
				
				dialogRequestMedia.setVisible(false);
				dialogRequestMedia.dispose();
				
				//Refresh dlm
				customerOrderRequestsModel.clear();
				int numRequests = dtb.getNumberOfOrderRequests();
				for (int i = 0; i < dtb.getOrderRequests().size(); i++) {
					customerOrderRequestsModel.addElement(dtb.getOrderRequests().get(i));
				}
				
				dlm.clear();
			}
		});
		
		panel_25.add(btnDeleteRequest);
		
		cl.show(ParentJPanel, "1");
		
		borrow_media.repaint();
		
		/**
	     * Frame settings
	     */
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(logInAs.class.getResource("icon.png")));
		frame.setResizable(false);
		frame.setTitle("Mount Royal Library Management System");
		frame.setBounds(0,0,screenSize.width/2, screenSize.height/2 );
		frame.setLocationRelativeTo ( null );
		frame.getContentPane().add(ParentJPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		
		/**
		 * Click "back button from selected person log in
		 */
		btnBack1.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(ParentJPanel, "1");
				idTxtField.setText("");
				passwordField.setText("");
			}
		});
			
		/**
		 * Click "log in as Student/Faculty/Librarian"
		 */
		
		// Student/Faculty (Customers)
	   studentBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			        cl.show(ParentJPanel, "2");
			        who.setText("Student/Faculty");
				}
			});
	   
	   librarianBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        cl.show(ParentJPanel, "2");
		        who.setText("Librarian");
			}
		});
	   
	        
	   /**
	   * Click on "log in" & verify info, then load appropriate window for student/faculty/librarian
	   */
	   
	   loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Boolean verifyLogin = false;
				
				//Try looking for librarians
				if (who.getText().equals("Librarian")){
					try {
						librarian = dtb.searchLibrarianByID(idTxtField.getText());
						librarian.getPassword();
						String tempPass = new String(passwordField.getPassword());
						if (tempPass.equals(librarian.getPassword()))
						verifyLogin = true;
						
							
					}catch(NullPointerException e){
						//Nothing
					}
				}
				else{ //Try looking for customers
					try {
						customer = dtb.searchByID(idTxtField.getText());
						customer.getPassword();
						String tempPass = new String(passwordField.getPassword());
						if (tempPass.equals(customer.getPassword()))
						verifyLogin = true;
						
					}catch(NullPointerException e){
						//Nothing
					}
				}

				//LogIn enter = new LogIn();
				//Boolean verifyLogin = enter.verifyLogin(emailTextField.getText(), passwordField.getText());
				
				if (verifyLogin == true) {
					
					JOptionPane.showMessageDialog(null, "Log in was successful", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
					if (who.getText().equals("Librarian")){
						cl.show(ParentJPanel, "LibrarianWindow");
						
						IDPersonLoggedIn = idTxtField.getText();
						librarian = dtb.searchLibrarianByID(IDPersonLoggedIn);
						nameLabel.setText(librarian.getFirstName() + " " + librarian.getLastName());
					
					}
			        if (who.getText().equals("Student/Faculty")) {
			        	cl.show(ParentJPanel, "CustomerWindow");
			        	
			        	IDPersonLoggedIn = idTxtField.getText();
			        	customer = dtb.searchByID(IDPersonLoggedIn);
			    		customerNameLabel.setText(customer.getFirstName() + " " + customer.getLastName());		       			        	
			        }
			   
				}
				else {
					JOptionPane.showMessageDialog(null, "Log in was unsuccessful", "InfoBox: " + "No Success", JOptionPane.ERROR_MESSAGE);
					//cl.show(ParentJPanel, "2");
				}
				
		    idTxtField.setText("");
		    passwordField.setText("");
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
	     
	    
	
	
	/////////////////////////////////////////////PUT ALL FUNCTIONS RELATED TO LIBRARIAN BELOW////////////////////////////////////////////
		
		librarianBrowseButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					cl1.show(middle,"browse");
					dlm.clear();
					
					
				}
			});
		
		librarianReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl1.show(middle, "return");
				customerDLM.clear();
			}
		});
		
		pickupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl1.show(middle, "pickup");
				customerHoldsDLM.clear();
				custIDField2.setText("");
				
			}
		});
		
		searchCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchHoldsDLM.clear();
				searchBorrowDLM.clear();
				
				custIDField3.setText("");
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
				
				cl1.show(middle, "search");
				
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
				
					dialogMediaBorrow.setBounds(0,0 ,screenSize.width/5, screenSize.height/4);
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
						
					librarian.returnMedia(item, item.getCustomer());
					
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
		 * Cancel button within  borrow dialog
		 */
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialogMediaBorrow.setVisible(false);
				dialogMediaBorrow.dispose();
			}
		});
		
		/**
		 * Cancel button within show orders dialog
		 */
		cancelButton_requestMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialogRequestMedia.setVisible(false);
				dialogRequestMedia.dispose();
			}
		});
		
		cancelButton_showOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialogShowOrders.setVisible(false);
				dialogShowOrders.dispose();
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
					
					String msg = librarian.addMediaOwned(c,item,String.valueOf(holdOrTakeComboBox.getSelectedItem()));
							
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
					
					String msg = librarian.removeFromHoldsToPickup(item.getKey(),item.getKey().getCustomer());
					
					
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
		changeStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() != -1) {

					dialogChangeStatus.getContentPane().setLayout(new GridLayout(3,1,5,5));
					dialogChangeStatus.setModalityType(ModalityType.TOOLKIT_MODAL);
				
					dialogChangeStatus.setBounds(0,0 ,screenSize.width/5, screenSize.height/5);
					dialogChangeStatus.setLocationRelativeTo(null);
					
					statusComboBox.setBackground(Color.white);
					statusComboBox.setModel(new DefaultComboBoxModel(new String[] {"available" , "reserved","unavailable"}));
					
					dialogChangeStatus.getContentPane().add(statusComboBox);
					dialogChangeStatus.getContentPane().add(changeStatusOKButton);
					dialogChangeStatus.getContentPane().add(changeStatusCancelButton);
					
					dialogChangeStatus.setVisible(true);
					
					dialogChangeStatus.setAlwaysOnTop(true);
								
				} else {
					JOptionPane.showMessageDialog(null, "Select an item from a list", "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
				
		/**
		 * Ok button within change status dialog
		 */
		changeStatusOKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PhysicalMedia item = (PhysicalMedia) list.getSelectedValue();
				
				String action = String.valueOf(statusComboBox.getSelectedItem());
				
				if (action.equals("available")){
					item.getStatus().setPrimaryStatus("available"); 
					if (!item.getStatus().getCurrentStatus().equals("in use")) {
						item.getStatus().setCurrentStatus("available");}
					}
				
				else if (action.equals("reserved")){
					item.getStatus().setReserved();
					if (!item.getStatus().getCurrentStatus().equals("in use")) {
						item.getStatus().setCurrentStatus("reserved");
					}
				}
				
				else {
					item.getStatus().setPrimaryStatus("unavailable");
					if (!item.getStatus().getCurrentStatus().equals("in use")) {
						item.getStatus().setCurrentStatus("unavailable");}
				}
				
				dialogChangeStatus.setVisible(false);
				dialogChangeStatus.dispose();
				dtb.save();
				
				System.out.println("Primary status : " + item.getStatus().getPrimaryStatus());
				System.out.println("Current status : " + item.getStatus().getCurrentStatus());
				
				JOptionPane.showMessageDialog(dialogMediaBorrow, "Status was set to : " + item.getStatus().getPrimaryStatus(), "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
				
				dlm.clear();
				
				
			}});
				
		/**
		 * Cancel button within change status dialog
		 */
		changeStatusCancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				dialogChangeStatus.setVisible(false);
				dialogChangeStatus.dispose();
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
						custFees.setText("$ " + c.getFeesOwned());
						
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
				
		/**
		 * pay fees button in search tab
		 * 
		 */
		btnPayFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!custFees.getText().isEmpty() /*&& Double.parseDouble(custFees.getText().substring(1)) > 0*/) {

					dialogFeePayment.setBounds(0, 0, screenSize.width/4, screenSize.height/4);
					dialogFeePayment.getContentPane().setLayout(new GridLayout(0,1,0,0));
					dialogFeePayment.setModalityType(ModalityType.TOOLKIT_MODAL);
					dialogFeePayment.setLocationRelativeTo(null);


					//panel 30

					panel_30.setLayout(new GridLayout(0,3,0,0));

					panel_30.add(lblName2);
					lblName2.setFont(new Font("Tahoma", Font.BOLD, 12));

					panel_30.add(nameLabel2);
					nameLabel2.setText(custName.getText());
					nameLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));

					panel_30.add(lblNewLabel2);

					panel_30.add(lblId);
					lblId.setFont(new Font("Tahoma", Font.BOLD, 12));

					panel_30.add(idLabel);
					idLabel.setText(custID.getText());
					idLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

					//panel 31

					panel_31.setLayout(new GridLayout(0, 3, 0, 0));

					panel_31.add(lblFees);
					lblFees.setFont(new Font("Tahoma", Font.BOLD, 12));

					panel_31.add(feesLabel);
					feesLabel.setText(custFees.getText());
					feesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

					//panel 32

					panel_32.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

					panel_32.add(payAmount);
					payAmount.setColumns(10);

					panel_32.add(payBtn);
					payBtn.setFont(new Font("Tahoma", Font.BOLD, 12));

					//panel 33

					panel_33.setLayout(new GridLayout(1, 0, 0, 0));

					panel_33.add(updateInfo);
					updateInfo.setFont(new Font("Tahoma", Font.BOLD, 12));

					//panel 34
					panel_34.setLayout(new BorderLayout(0, 0));

					panel_34.add(quitBtn, BorderLayout.CENTER);
					quitBtn.setFont(new Font("Tahoma", Font.BOLD, 12));


					dialogFeePayment.getContentPane().add(panel_30);
					dialogFeePayment.getContentPane().add(panel_31);
					dialogFeePayment.getContentPane().add(panel_32);
					dialogFeePayment.getContentPane().add(panel_33);
					dialogFeePayment.getContentPane().add(panel_34);

					dialogFeePayment.setVisible(true);




				}else {
					JOptionPane.showMessageDialog(null, "No fees to be payed.", "No Fees Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		/**
		 * pay amount button in fee payment dialog
		 */
		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double paying, change, curFee, newFee;
				Customer c = dtb.searchByID(idLabel.getText());

				try {
					paying = Double.parseDouble(payAmount.getText());
					curFee = Double.parseDouble(custFees.getText().substring(1));

					/*if(paying < 0) {
						JOptionPane.showMessageDialog(dialogFeePayment, "Please enter a positive number.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
					}else */if(curFee - paying < 0) {
						change = paying-curFee;

						c.setFeesOwned(0.0);
						dtb.save();

						custFees.setText("$ 0.0");
						JOptionPane.showMessageDialog(dialogFeePayment, "Fees paid in full.\nChange Due: $" + change.toString(), "Change Due", JOptionPane.INFORMATION_MESSAGE);

						dialogFeePayment.setVisible(false);
						payAmount.setText("");
						dialogFeePayment.dispose();


					}else {
						newFee = Math.round((curFee-paying)*100.0)/100.0;
						c.setFeesOwned(newFee);
						dtb.save();

						custFees.setText("$ " + newFee.toString());

						JOptionPane.showMessageDialog(dialogFeePayment, "Remaining Fees: " + newFee.toString(), "Remaining Fees", JOptionPane.INFORMATION_MESSAGE);

						dialogFeePayment.setVisible(false);
						payAmount.setText("");
						dialogFeePayment.dispose();
					}

				}
				catch (NumberFormatException g){
					JOptionPane.showMessageDialog(dialogFeePayment, "Please enter a valid number.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException f) {
					JOptionPane.showMessageDialog(dialogFeePayment, "Please enter a number.", "Number Format Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		/**
		 * Cancel button in fee payment dialog
		 */
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogFeePayment.setVisible(false);
				payAmount.setText("");
				dialogFeePayment.dispose();
			}
		});

				
		/**
		 * Librarian's order media button
		 */
		btnOrderMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian temp = dtb.searchLibrarianByID(IDPersonLoggedIn);
				if (!temp.getAdmin()) {	
					cl1.show(middle, "order");
					customerDLM.clear();
					customerOrderRequestsModel.clear();
					
					//populate list with current Media Requests from Customers
					int numRequests = dtb.getNumberOfOrderRequests();
					for (int i = 0; i < dtb.getOrderRequests().size(); i++) {
						customerOrderRequestsModel.addElement(dtb.getOrderRequests().get(i));
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "ERROR! You do not have permission to access that, please contact a system administrator",
							"ERROR!", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			
		});
		
		/**
		 * Librarian button to create new order from existing requests
		 * 
		 */
		btnCreateNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// If a request is selected, auto-fill author and name fields
				mediaNameTextField.setText("");
				mediaAuthorTextField.setText("");
				mediaDateTextField_y.setText("");
				mediaDateTextField_m.setText("");
				mediaDateTextField_d.setText("");
				
				mediaTypeComboBox.setBackground(Color.white);
				mediaTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"CDs" , "DVDs", "Books/Magazines/Comics"}));
				mediaTypeComboBox.setBackground(Color.white);
				
				if (listMediaOrders.getSelectedIndex() != -1) {
					OrderRequest request = (OrderRequest)listMediaOrders.getSelectedValue();
				
					mediaAuthorTextField.setText(request.getCreator());
					mediaNameTextField.setText(request.getName());
	
					if(request.getMediaType().equals("CDs")){
						mediaTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"CDs" , "DVDs", "Books/Magazines/Comics"}));
					}
					
					if(request.getMediaType().equals("DVDs")){
						mediaTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"DVDs" , "CDs", "Books/Magazines/Comics"}));
					}
					
					if(request.getMediaType().equals("Books/Magazines/Comics")){
						mediaTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Books/Magazines/Comics" , "DVDs", "CDs"}));
					}
						
				} else { //No index selected - raw order created
					mediaNameTextField.setText("");
					mediaAuthorTextField.setText("");
					mediaDateTextField_y.setText("");
					mediaDateTextField_m.setText("");
					mediaDateTextField_d.setText("");
					
					mediaTypeComboBox.setBackground(Color.white);
					mediaTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"CDs" , "DVDs", "Books/Magazines/Comics"}));
				}
				
				// Dialog creation and display
				dialogRequestMedia.getContentPane().setLayout(new GridLayout(0,2,5,5));
				dialogRequestMedia.setModalityType(ModalityType.TOOLKIT_MODAL);
				
				dialogRequestMedia.setBounds(0,0 ,screenSize.width/3, screenSize.height/2);
				dialogRequestMedia.setLocationRelativeTo(null);
						
				dialogRequestMedia.getContentPane().add(mediaTypeLabel);
				dialogRequestMedia.getContentPane().add(mediaTypeComboBox);
				dialogRequestMedia.getContentPane().add(mediaNameLabel);
				dialogRequestMedia.getContentPane().add(mediaNameTextField);
				dialogRequestMedia.getContentPane().add(mediaAuthorLabel);
				dialogRequestMedia.getContentPane().add(mediaAuthorTextField);
				dialogRequestMedia.getContentPane().add(mediaDateLabel_y);
				dialogRequestMedia.getContentPane().add(mediaDateTextField_y);
				dialogRequestMedia.getContentPane().add(mediaDateLabel_m);
				dialogRequestMedia.getContentPane().add(mediaDateTextField_m);
				dialogRequestMedia.getContentPane().add(mediaDateLabel_d);
				dialogRequestMedia.getContentPane().add(mediaDateTextField_d);
				
									
				dialogRequestMedia.getContentPane().add(orderMediaOkBtn);
				dialogRequestMedia.getContentPane().add(cancelButton_requestMedia);
					
				dialogRequestMedia.setVisible(true);
				
			}
		});
	
			
		/**
		 * Ok Button for the ordering media pop-up window
		 * 
		 */
		orderMediaOkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// error checking
				if (mediaNameTextField.getText().equals("") || mediaAuthorTextField.getText().equals("") || mediaDateTextField_d.getText().equals("")
						|| mediaDateTextField_m.getText().equals("") || mediaDateTextField_y.getText().equals("")) {
					JOptionPane.showMessageDialog(dialogRequestMedia, "Please Complete All Fields", "Errorbox ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int day = -1;
				int month = -1;
				int year = -1;
				try {
					day = Integer.parseInt(mediaDateTextField_d.getText());
					month = Integer.parseInt(mediaDateTextField_m.getText());
					year = Integer.parseInt(mediaDateTextField_y.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(dialogRequestMedia, "Please Enter Only Numbers in the Date Fields", "Errorbox ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if (day > 31 || month > 12 || year > 9999) {
					JOptionPane.showMessageDialog(dialogRequestMedia, "Incorrect Date Format, Please Fix", "Errorbox ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				// if the error checking passes , add order to librarian's account 
				dtb.addLibrarianOrder(dtb.searchLibrarianByID(librarian.getID()), (String)mediaTypeComboBox.getSelectedItem(), mediaNameTextField.getText(), mediaAuthorTextField.getText(), 
						mediaDateTextField_y.getText(), mediaDateTextField_m.getText(), mediaDateTextField_d.getText());

				// and remove the request
				if (listMediaOrders.getSelectedIndex() != -1) {
					dtb.removeOrderRequest(listMediaOrders.getSelectedIndex());
				}
				
				dtb.save();
				
				dialogRequestMedia.setVisible(false);
				dialogRequestMedia.dispose();
				
				//Refresh dlm
				customerOrderRequestsModel.clear();
				int numRequests = dtb.getNumberOfOrderRequests();
				for (int i = 0; i < dtb.getOrderRequests().size(); i++) {
					customerOrderRequestsModel.addElement(dtb.getOrderRequests().get(i));
				}
				
				dlm.clear();
				
				JOptionPane.showMessageDialog(dialogRequestMedia, "Media Successfully Ordered", "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	
		/**
		 * Lists the current orders to be filled sent in by librarian
		 */
		btnViewMediaOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buttonPanel.add(btnOrderRecieved);
				buttonPanel.add(cancelButton_showOrders);
				
				dialogShowOrders.getContentPane().setLayout(new GridLayout(3,1,5,5));
				dialogShowOrders.setModalityType(ModalityType.TOOLKIT_MODAL);
				dialogShowOrders.setResizable(false);
				
				dialogShowOrders.setBounds(0,0 ,(int) Math.abs(screenSize.width/2.5), (int) Math.abs(screenSize.height/2.5));
				dialogShowOrders.setLocationRelativeTo(null);
				
				dialogShowOrders.getContentPane().add(currMedOrdersLabel);
				dialogShowOrders.getContentPane().add(scrollLibrarianOrders);
				dialogShowOrders.getContentPane().add(buttonPanel);
				//dialogShowOrders.getContentPane().add(cancelButton_showOrders);
				//dialogShowOrders.getContentPane().add(btnOrderRecieved);
				

				currentOrderRequestsModel.clear();
				
				// Add orders to the dlm
				int num = dtb.getOrders().size();
				
				currentOrdersList.setModel(currentOrderRequestsModel);
				currentOrderRequestsModel.clear();
				
				for (int i = 0; i < num; i++) {
					currentOrderRequestsModel.addElement(dtb.getOrders().get(i));
				}
					
				dialogShowOrders.setVisible(true);	
				
			}
		});
		
		/**
		 * Removes the order from the list and adds the media to the shelf
		 */
		btnOrderRecieved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentOrdersList.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(dialogShowOrders, "Please Select an Order From the List", "Errorbox ", JOptionPane.INFORMATION_MESSAGE);
				} else {								
					// add to shelf
					System.out.println(currentOrdersList.getSelectedIndex());
					Order currOrder = dtb.getOrders().get(currentOrdersList.getSelectedIndex());
					ArrayList<String> authors = new ArrayList<String>();
					authors.add(currOrder.getAuthor());
					if (currOrder.getType().equals("CDs")) {
						CD newMedia = new CD(currOrder.getName(), authors, currOrder.getDate(), new Status("available"));
						dtb.getCds().add(newMedia);
						
					} else if (currOrder.getType().equals("DVDs")) {
						DVD newMedia = new DVD(currOrder.getName(), authors, currOrder.getDate(), new Status("available"));
						dtb.getDvds().add(newMedia);
						
					} else {
						PaperMedia newMedia = new PaperMedia(currOrder.getName(), authors, currOrder.getDate(), new Status("available"));
						dtb.getPaperMedias().add(newMedia);
					}
					
					// remove order
					dtb.removeOrder(currentOrdersList.getSelectedIndex());
					
					dtb.save();
					System.out.println(dtb.shelfString());
					
					// clear and re-populate the dlm
					currentOrderRequestsModel.clear();
					
					int num = dtb.getOrders().size();
					
					for (int i = 0; i < num; i++) {
						currentOrderRequestsModel.addElement(dtb.getOrders().get(i));
					}
					
					
					JOptionPane.showMessageDialog(dialogShowOrders, "Media Successfully Recieved", "Infobox ", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
				
		/**
		  *  log out button for librarian
		 */
		    logOutBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				   
				   cl.show(ParentJPanel, "1");
				   	  
				   
			   }});
	
	
		


///////////////////////////////////////////PUT ALL FUNCTIONS FOR CUSTOMER HERE/////////////////////////////////////////////////
			
		
		/**
		 * Button for Browsing media
		 */
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String comboBoxValue = (String) comboBox_studentHold.getSelectedItem();
				
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
		
				list_1.setModel(dlm);
			}
		});
		
		/**
		 * Button to press for hold in student/faculty window
		 */
		HoldBtnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//comboBox_studentHold
				if (list_1.getSelectedIndex() != -1) {
					//Search customer by ID
					
					Customer c = dtb.searchByID(IDPersonLoggedIn);
					
					if (c == null) { //ok this will never execute because we verified the student in log-in section
						JOptionPane.showMessageDialog(dialogMediaBorrow, "No customer with such ID exists", "InfoBox ", JOptionPane.WARNING_MESSAGE);
					} else {
						
						PhysicalMedia item = new PhysicalMedia();
						try{item = (CD)list_1.getSelectedValue();}catch(Exception e) {
							try {item = (DVD)list_1.getSelectedValue();}catch(Exception f) {
								try {item = (PaperMedia)list_1.getSelectedValue();}catch(Exception g) {}}}
						
						System.out.println(item.getCustomer());
						
						//No one has the media on hold/ or owns it, there's no line up to item and media status isn't unavailable
						if (item.getCustomer() == null && item.getLineUp().size() == 0 && !item.getStatus().getCurrentStatus().equals("unavailable")) { //& book status isn't unavailable 
							
							item.setCustomer(c); //set media to customer that will take it or hold it
								
							c.addMediaOnHold(item); //add media to customer's holds for 1 week from now
												
							JOptionPane.showMessageDialog(dialogMediaBorrow, "Media is put on hold by customer: " + c.getID(), "InfoBox ", JOptionPane.WARNING_MESSAGE);
							
						//Media is helf or borrowed by someone already & customer isn't the one that holds that media and isn't already in line
						} else if (item.getCustomer() != null && item.getCustomer() != c && item.getLineUp().isInLine(c) == false) {
						    item.getLineUp().addToLine(c);
							JOptionPane.showMessageDialog(dialogMediaBorrow,("You are put in queue in position: " + item.getLineUp().size()),
									"InfoBox",JOptionPane.INFORMATION_MESSAGE);
							
						}else { //Customer already holds or has media borrowed
							JOptionPane.showMessageDialog(dialogMediaBorrow, "You are already in queue/on hold or already own the media", "InfoBox ", JOptionPane.WARNING_MESSAGE);
						}
							
							
						}
						
						System.out.println(dtb.shelfString());
						
						for (int i=0;i<dtb.getCustomers().size();i++) {
							System.out.println(dtb.getCustomers().get(i).toString());
						}

						dtb.save();
						
						dialogMediaBorrow.setVisible(false);
						dialogMediaBorrow.dispose();
						dlm.clear();
				
				}else {
					JOptionPane.showMessageDialog(null, "Please select media from the list", "InfoBox ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	
	/**
	 * Request button in customer's window (to request a media)
	 */
	btnRequestMedia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			dialogCustomerRequestMedia.getContentPane().setLayout(new GridLayout(0,2,5,5));
			dialogCustomerRequestMedia.setModalityType(ModalityType.TOOLKIT_MODAL);
			
			dialogCustomerRequestMedia.setBounds(0,0 ,screenSize.width/3, screenSize.height/4);
			dialogCustomerRequestMedia.setLocationRelativeTo(null);
				
			mediaTypeComboBox.setBackground(Color.white);
			mediaTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"CDs" , "DVDs", "Books/Magazines/Comics"}));

			dialogCustomerRequestMedia.getContentPane().add(mediaTypeLabel);
			dialogCustomerRequestMedia.getContentPane().add(mediaTypeComboBox);
			dialogCustomerRequestMedia.getContentPane().add(mediaNameLabel);
			dialogCustomerRequestMedia.getContentPane().add(mediaNameTextField);
			dialogCustomerRequestMedia.getContentPane().add(mediaAuthorLabel);
			dialogCustomerRequestMedia.getContentPane().add(mediaAuthorTextField);
				
			dialogCustomerRequestMedia.getContentPane().add(btnRequestMediaSend);
			dialogCustomerRequestMedia.getContentPane().add(cancelButton_customerRequest);
			
			//clear all fields
			mediaNameTextField.setText("");
			mediaNameTextField.setText("");
			mediaAuthorTextField.setText("");
			
			dialogCustomerRequestMedia.setVisible(true);
		}
	});
	
	/**
	 * Send button for Customer's request to order a media
	 */
	btnRequestMediaSend.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String type = mediaTypeComboBox.getSelectedItem().toString();
			String name = mediaNameTextField.getText();
			String author = mediaAuthorTextField.getText();
			
			if (name.equals("") || author.equals("")) {
				JOptionPane.showMessageDialog(dialogCustomerRequestMedia, "Please Enter all Fields", "InfoBox ", JOptionPane.ERROR_MESSAGE);	
				return;
			}
			
			// Check to see if the input represents a valid media
			if (type.equals("Books/Magazines/Comics")) {
				for (PaperMedia media : dtb.getPaperMedias()) {
					if (media.getTitle().toLowerCase().equals(name.toLowerCase())) {
						// The given name matches the name of a media in the system
						for (String author2 : media.getAuthors()) {
							if (author2.toLowerCase().equals(author.toLowerCase())) {
								// The author also matches
								JOptionPane.showMessageDialog(dialogCustomerRequestMedia, "Paper media already exists with the given name/author", "InfoBox ", JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				}
			} else if (type.equals("CDs")) {
				for (CD media : dtb.getCds()) {
					if (media.getTitle().toLowerCase().equals(name.toLowerCase())) {
						// The given name matches the name of a media in the system
						for (String author2 : media.getComposers()) {
							if (author2.toLowerCase().equals(author.toLowerCase())) {
								// The author also matches
								JOptionPane.showMessageDialog(dialogCustomerRequestMedia, "CD already exists with the given name/author", "InfoBox ", JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				}
			} else if (type.equals("DVDs")) {
				for (DVD media : dtb.getDvds()) {
					if (media.getTitle().toLowerCase().equals(name.toLowerCase())) {
						// The given name matches the name of a media in the system
						for (String author2 : media.getDirectors()) {
							if (author2.toLowerCase().equals(author.toLowerCase())) {
								// The author also matches
								JOptionPane.showMessageDialog(dialogCustomerRequestMedia, "DVD already exists with the given name/author", "InfoBox ", JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				}
			} else {
				// This should never get run, but just in case
				JOptionPane.showMessageDialog(dialogCustomerRequestMedia, "Unknown media type: \""+type+"\"", "InfoBox ", JOptionPane.ERROR_MESSAGE);
			}
			//dtb.loadData();
			dtb.addCustomerOrderRequest(customer, type, name, author);
			dtb.save();
			System.out.println("order saved");
			//System.out.println(dtb.getOrderRequests());
			dialogCustomerRequestMedia.setVisible(false);
			dialogCustomerRequestMedia.dispose();
			JOptionPane.showMessageDialog(dialogCustomerRequestMedia, "Request form successfully sent", "InfoBox ", JOptionPane.INFORMATION_MESSAGE);

		}
	});
	
	/**
	 * Cancel button for customer's requests
	 */
	cancelButton_customerRequest.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dialogCustomerRequestMedia.setVisible(false);
			dialogCustomerRequestMedia.dispose();
		}
	});
	
	/**
	 * Log out button for customer
	 */
	logOutBtn2.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) {
			   			   
			   cl.show(ParentJPanel, "1");
			   
		   }});
	
    
	}
}

	
