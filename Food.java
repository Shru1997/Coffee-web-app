package coffee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class Food extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food frame = new Food();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Food() {
		setTitle("Food");
		setForeground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblDrinks = new JLabel("Food");
		lblDrinks.setBounds(104, 11, 83, 72);
		lblDrinks.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblDrinks);
		JButton btnNewButton = new JButton("Cake");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(94, 120, 95, 44);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cake().setVisible(true);
				Main.frame.setVisible(false);
			}});
		JButton btnNewButton_1 = new JButton("Icecream");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(82, 232, 115, 44);
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shruthi\\Desktop\\images\\food.JPG"));
		lblNewLabel.setBounds(0, 0, 291, 322);
		contentPane.add(lblNewLabel);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cream().setVisible(true);
				Main.frame.setVisible(false);
			}});
		}
}
