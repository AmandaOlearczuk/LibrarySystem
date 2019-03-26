package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


//WIP
//TODO: fix layout, add functionality to buttons, show this dialog on payFee click in searchCustomer pane
public class FeePaymentDialog extends JDialog {
	private JTextField payAmount;

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
		setBounds(100, 100, 750, 500);
		getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel nameLabel = new JLabel("");
		getContentPane().add(nameLabel);
		
		JLabel idLabel = new JLabel("");
		getContentPane().add(idLabel);
		
		JLabel feesLabel = new JLabel("");
		getContentPane().add(feesLabel);
		
		payAmount = new JTextField();
		getContentPane().add(payAmount);
		payAmount.setColumns(10);
		
		JButton payBtn = new JButton("Pay Amount");
		payBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(payBtn);
		
		JLabel label_1 = new JLabel("");
		getContentPane().add(label_1);
		
		JLabel updateInfo = new JLabel("");
		getContentPane().add(updateInfo);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(quitBtn);

	}

}
