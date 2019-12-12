package coffee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Home home_frame = new Home();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Coffee Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblDrinksAndFood = new JLabel("Drinks And Food");
		lblDrinksAndFood.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDrinksAndFood.setBounds(75, 117, 179, 52);
		contentPane.add(lblDrinksAndFood);
		JButton btnDrinks = new JButton("Drinks");
		btnDrinks.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDrinks.setBounds(119, 212, 96, 36);
		contentPane.add(btnDrinks);
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Drinks().setVisible(true);
				Home.home_frame.setVisible(false);
			}	});
			JButton btnFood = new JButton("Food");
		btnFood.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFood.setBounds(119, 293, 96, 36);
		contentPane.add(btnFood);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shruthi\\Desktop\\images\\home1.JPG"));
		lblNewLabel.setBounds(0, 0, 403, 367);
		contentPane.add(lblNewLabel);
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Food().setVisible(true);
				Home.home_frame.setVisible(false);
			}	});
	}
}
