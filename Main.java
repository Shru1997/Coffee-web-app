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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Main frame = new Main();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Coffee Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoffeeManagementSystem = new JLabel("Coffee Management System");
		lblCoffeeManagementSystem.setForeground(Color.WHITE);
		lblCoffeeManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCoffeeManagementSystem.setBounds(10, 83, 378, 41);
		contentPane.add(lblCoffeeManagementSystem);
		
		JButton btnClickHereTo = new JButton("Click here to order");
		btnClickHereTo.setForeground(Color.DARK_GRAY);
		btnClickHereTo.setBackground(new Color(250, 235, 215));
		btnClickHereTo.setBounds(134, 145, 147, 23);
		contentPane.add(btnClickHereTo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shruthi\\Downloads\\coffee2.jpg"));
		lblNewLabel.setBounds(0, 0, 640, 323);
		contentPane.add(lblNewLabel);
		btnClickHereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				Main.frame.setVisible(false);
			}
		});
	}
}
