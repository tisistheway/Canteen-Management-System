package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.management.timer.Timer;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;


import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class Main_Win extends JFrame {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Win window = new Main_Win();
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
	public Main_Win() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1013, 716);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(256, 316, 171, 55);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUsername.setBounds(439, 232, 274, 55);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPassword.setColumns(10);
		txtPassword.setBounds(439, 316, 274, 55);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setForeground(Color.WHITE);
		lblLoginPage.setFont(new Font("Palatino Linotype", Font.BOLD, 50));
		lblLoginPage.setBackground(Color.WHITE);
		lblLoginPage.setBounds(332, 131, 302, 62);
		frame.getContentPane().add(lblLoginPage);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		btnAdmin.setFont(new Font("Cambria", Font.BOLD, 42));
		btnAdmin.setBounds(47, 492, 213, 62);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    if (txtUsername.getText().isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Provide Username","Error",JOptionPane.ERROR_MESSAGE);}
			    else if (txtPassword.getText().isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Provide Password","Error",JOptionPane.ERROR_MESSAGE);}
			    else {
			    	try {
						Connection con = MyConnection.getConnection();
						 PreparedStatement st = (PreparedStatement) con.prepareStatement("Select roll_no from student where email=? and password=?;");
						 st.setString(1, txtUsername.getText());
			             st.setString(2, txtPassword.getText());
			             ResultSet rs = st.executeQuery();
			                 if (rs.next()) {
			         			frame.dispose();
			    				frame.setVisible(false);
			    	            java.awt.EventQueue.invokeLater(new Runnable()
			    	            {
			    	                public void run()
			    	                {
			    	                	try {
											StudentViewMarksheet up = new StudentViewMarksheet(rs.getInt(1));
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
			    	                }
			                    });
			    	            
			                 } else {
			                	
			                	 JOptionPane.showMessageDialog(new JFrame(), "Invalid Username and Password","Error",JOptionPane.ERROR_MESSAGE);						
			                 }

			    		
			    	} catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(new JFrame(), "Error Occure "+e,"Error",JOptionPane.ERROR_MESSAGE);						
					}
			    }
			 
			

	   
			}
		});
		btnStudent.setForeground(UIManager.getColor("Button.foreground"));
		btnStudent.setFont(new Font("Cambria", Font.BOLD, 42));
		btnStudent.setBounds(392, 492, 244, 62);
		frame.getContentPane().add(btnStudent);
		
		JButton btnTeacher = new JButton("TEACHER ");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			    if (txtUsername.getText().isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Provide Username","Error",JOptionPane.ERROR_MESSAGE);}
			    else if (txtPassword.getText().isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Provide Password","Error",JOptionPane.ERROR_MESSAGE);}
			    else {
			    	if (txtUsername.getText().equals("teacher") && txtPassword.getText().equals("pass")) {
			    		frame.dispose();
	    				frame.setVisible(false);
	    	            java.awt.EventQueue.invokeLater(new Runnable()
	    	            {
	    	                public void run()
	    	                {
	    	                	new TeacherMainMenu();
	    	                }
	                    });	    	    
			    	} else {
	                	 JOptionPane.showMessageDialog(new JFrame(), "Invalid Username and Password","Error",JOptionPane.ERROR_MESSAGE);							
			    	}
			    	
//			    	try {
//						Connection con = MyConnection.getConnection();
//						 PreparedStatement st = (PreparedStatement) con.prepareStatement("Select roll_no from student where email=? and password=?;");
//						 st.setString(1, txtUsername.getText());
//			             st.setString(2, txtPassword.getText());
//			             ResultSet rs = st.executeQuery();
//			                 if (rs.next()) {
//			         			frame.dispose();
//			    				frame.setVisible(false);
//			    	            java.awt.EventQueue.invokeLater(new Runnable()
//			    	            {
//			    	                public void run()
//			    	                {
//			    	                	new TeacherMainMenu();
//			    	                }
//			                    });
//			    	            
//			                 } else {
//			                	
//			                	 JOptionPane.showMessageDialog(new JFrame(), "Invalid Username and Password","Error",JOptionPane.ERROR_MESSAGE);						
//			                 }
//
//			    		
//			    	} catch (Exception e){
//						e.printStackTrace();
//						JOptionPane.showMessageDialog(new JFrame(), "Error Occure "+e,"Error",JOptionPane.ERROR_MESSAGE);						
//					}

			    }
			 
			}
		});
		btnTeacher.setForeground(UIManager.getColor("CheckBox.foreground"));
		btnTeacher.setFont(new Font("Cambria", Font.BOLD, 42));
		btnTeacher.setBounds(719, 492, 244, 62);
		frame.getContentPane().add(btnTeacher);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setBounds(256, 232, 171, 55);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main_Win.class.getResource("/images/viit-coll-back - Copy.jpg")));
		lblNewLabel.setBounds(0, 0, 1505, 669);
		frame.getContentPane().add(lblNewLabel);
		
		frame.pack();
		frame.setSize(1020,700);
		frame.setVisible(true);
		
		
	}
}
