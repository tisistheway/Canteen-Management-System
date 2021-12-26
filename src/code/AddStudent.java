package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Scrollbar;
import java.awt.color.CMMException;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddStudent {

	private JFrame frame1;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPass;
	private JTextField txtRollNo;
	private JComboBox cmbGender;
	private JComboBox cmbBranch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddStudent() {
		initialize();
			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	        
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 859, 665);
		frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddStudent.class.getResource("/images/students-icon.png")));
		lblNewLabel.setBounds(12, 138, 495, 437);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setFont(new Font("Georgia", Font.BOLD, 50));
		lblAddStudent.setBounds(90, 37, 349, 64);
		frame1.getContentPane().add(lblAddStudent);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName.setBounds(633, 37, 94, 32);
		frame1.getContentPane().add(lblName);
		
		JLabel lblSuname = new JLabel("Gender :");
		lblSuname.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblSuname.setBounds(614, 226, 113, 32);
		frame1.getContentPane().add(lblSuname);
		
		JLabel lblRollNo = new JLabel("Roll No :");
		lblRollNo.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblRollNo.setBounds(606, 350, 121, 32);
		frame1.getContentPane().add(lblRollNo);
		
		JLabel lblName_3 = new JLabel(" Branch:");
		lblName_3.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName_3.setBounds(614, 284, 113, 32);
		frame1.getContentPane().add(lblName_3);
		
		JLabel lblName_4 = new JLabel("Password :");
		lblName_4.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName_4.setBounds(592, 165, 135, 32);
		frame1.getContentPane().add(lblName_4);
		
		JLabel lblName_5 = new JLabel("Email :");
		lblName_5.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName_5.setBounds(633, 104, 94, 32);
		frame1.getContentPane().add(lblName_5);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText().toString();
				String email = txtEmail.getText().toString();
				String pass = txtPass.getText().toString();
				String gender = cmbGender.getSelectedItem().toString();
				String branch = cmbBranch.getSelectedItem().toString();
				String rollno = txtRollNo.getText().toString();
				if (name.isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Pls Provide Valid Name ", "Error",JOptionPane.ERROR_MESSAGE);}
				else if (email.isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Pls Provide Valid Email ", "Error",JOptionPane.ERROR_MESSAGE);}
				else if (pass.isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Pls Provide Valid Password ", "Error",JOptionPane.ERROR_MESSAGE);}
				else if (gender.equals("Select Gender")) {JOptionPane.showMessageDialog(new JFrame(), "Pls Select the Gender ", "Error",JOptionPane.ERROR_MESSAGE);}
				else if (branch.equals("Select Branch")) {JOptionPane.showMessageDialog(new JFrame(), "Pls Select the Branch ", "Error",JOptionPane.ERROR_MESSAGE);}
				else if (rollno.isEmpty()) {JOptionPane.showMessageDialog(new JFrame(), "Pls Provide Roll No ", "Error",JOptionPane.ERROR_MESSAGE);}
				else {
					try {
						String query="insert into student values('"+name+"','"+email+"','"+pass+"','"+gender+"','"+branch+"','"+Integer.parseInt(rollno)+"');";
						Connection con = MyConnection.getConnection();
						Statement stmt=con.prepareStatement(query);
						stmt.executeUpdate(query);
						con.close();
						JOptionPane.showMessageDialog(new JFrame(), "Student Registered Successfully UserName :"+email+" & Pass : "+pass,"Success",JOptionPane.INFORMATION_MESSAGE);
						txtEmail.setText("");
						txtPass.setText("");
						txtName.setText("");
						txtRollNo.setText("");
						cmbBranch.setSelectedIndex(0);
						cmbGender.setSelectedIndex(0);
					} catch (Exception e){
						e.printStackTrace();
						JOptionPane.showMessageDialog(new JFrame(), "Error Occure "+e,"Error",JOptionPane.ERROR_MESSAGE);						
					}
					
				}
			}
		});
		
		btnAddStudent.setFont(new Font("Segoe UI", Font.BOLD, 33));
		btnAddStudent.setBounds(648, 429, 290, 53);
		frame1.getContentPane().add(btnAddStudent);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				frame1.dispose();
				frame1.setVisible(false);
	           
				java.awt.EventQueue.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                	new Main_Win();
					}
                });
			}
		});
		btnLogOut.setFont(new Font("Segoe UI", Font.BOLD, 33));
		btnLogOut.setBounds(820, 507, 179, 53);
		frame1.getContentPane().add(btnLogOut);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				frame1.dispose();
				frame1.setVisible(false);
	           
				java.awt.EventQueue.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                	new Main_Win();
					}
                });

			}
		});
		btnMainMenu.setFont(new Font("Segoe UI", Font.BOLD, 33));
		btnMainMenu.setBounds(568, 507, 219, 53);
		frame1.getContentPane().add(btnMainMenu);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtName.setBounds(751, 33, 240, 42);
		frame1.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBounds(751, 94, 240, 42);
		frame1.getContentPane().add(txtEmail);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtPass.setColumns(10);
		txtPass.setBounds(751, 155, 240, 42);
		frame1.getContentPane().add(txtPass);
		
		txtRollNo = new JTextField();
		txtRollNo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtRollNo.setColumns(10);
		txtRollNo.setBounds(751, 345, 240, 42);
		frame1.getContentPane().add(txtRollNo);
		
		cmbGender = new JComboBox();
		cmbGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbGender.setBounds(751, 222, 240, 42);
		frame1.getContentPane().add(cmbGender);
		cmbGender.addItem("Select Gender");
		cmbGender.addItem("Male");
		cmbGender.addItem("Female");
		
		cmbBranch = new JComboBox();
		cmbBranch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbBranch.setBounds(751, 284, 240, 42);
		frame1.getContentPane().add(cmbBranch);
		cmbBranch.addItem("Select Branch");
		cmbBranch.addItem("Computer Engineering");
		cmbBranch.addItem("Information Technology");
		cmbBranch.addItem("Mechanical Engineering");
		cmbBranch.addItem("Civil Engineering");
		cmbBranch.addItem("Electrical Engineering");
		
		frame1.pack();
		frame1.setSize(1100,650);
		frame1.setVisible(true);
	}
	

}
