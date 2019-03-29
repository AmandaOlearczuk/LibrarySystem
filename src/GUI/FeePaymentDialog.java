package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


//WIP
//TODO: fix layout, add functionality to buttons, show this dialog on payFee click in searchCustomer pane
public class FeePaymentDialog extends JDialog {
	private JTextField payAmount;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeePaymentDialog dialog = new FeePaymentDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FeePaymentDialog() {
		setBounds(100, 100, screenSize.width/5, screenSize.height/4);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_30 = new JPanel();
		getContentPane().add(panel_30);
		panel_30.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblName = new JLabel("Name:");
		panel_30.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel nameLabel = new JLabel("Sophie Lee");
		panel_30.add(nameLabel);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("");
		panel_30.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID:");
		panel_30.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel idLabel = new JLabel("101");
		panel_30.add(idLabel);
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_31 = new JPanel();
		getContentPane().add(panel_31);
		panel_31.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblFees = new JLabel("Fees:");
		panel_31.add(lblFees);
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel feesLabel = new JLabel("38.00");
		panel_31.add(feesLabel);
		feesLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panel_32 = new JPanel();
		getContentPane().add(panel_32);
		panel_32.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		payAmount = new JTextField();
		panel_32.add(payAmount);
		payAmount.setColumns(10);
		
		JButton payBtn = new JButton("Pay Amount");
		panel_32.add(payBtn);
		payBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_33 = new JPanel();
		getContentPane().add(panel_33);
		panel_33.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel updateInfo = new JLabel("Change Due:");
		panel_33.add(updateInfo);
		updateInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_34 = new JPanel();
		getContentPane().add(panel_34);
		panel_34.setLayout(new BorderLayout(0, 0));
		
		JButton quitBtn = new JButton("Quit");
		panel_34.add(quitBtn, BorderLayout.EAST);
		quitBtn.setFont(new Font("Tahoma", Font.BOLD, 12));

	}
}
