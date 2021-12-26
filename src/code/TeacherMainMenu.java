package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.cj.jdbc.result.UpdatableResultSet;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TeacherMainMenu {

	private JFrame frame;

	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherMainMenu window = new TeacherMainMenu();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TeacherMainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1034, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		JLabel lblTeacherName = new JLabel("Welcome Teacher Name");
//		lblTeacherName.setFont(new Font("Sylfaen", Font.BOLD, 30));
//		lblTeacherName.setForeground(Color.WHITE);
//		lblTeacherName.setBounds(312, 78, 368, 91);
//		frame.getContentPane().add(lblTeacherName);
		
		JLabel lblVishwakarmaInstituteOf = new JLabel("Vishwakarma Institute of Technology");
		lblVishwakarmaInstituteOf.setForeground(Color.WHITE);
		lblVishwakarmaInstituteOf.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblVishwakarmaInstituteOf.setBounds(228, 34, 634, 56);
		frame.getContentPane().add(lblVishwakarmaInstituteOf);
		
		JButton btnAddNewStudent = new JButton("Add Student");
		btnAddNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				frame.setVisible(false);
	            java.awt.EventQueue.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                		AddStudent up = new AddStudent();
					}
                });
	        
			}
		});
		btnAddNewStudent.setForeground(Color.BLUE);
		btnAddNewStudent.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnAddNewStudent.setBounds(607, 195, 224, 45);
		frame.getContentPane().add(btnAddNewStudent);
		
		JButton btnUpdateMarksheet = new JButton("Update Marksheet");
		btnUpdateMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frame.setVisible(false);
	           
				java.awt.EventQueue.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                	new UpdateStudentMarksheet();
					}
                });
			}
		});
		btnUpdateMarksheet.setForeground(Color.BLUE);
		btnUpdateMarksheet.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnUpdateMarksheet.setBounds(607, 330, 224, 45);
		frame.getContentPane().add(btnUpdateMarksheet);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				frame.dispose();
				frame.setVisible(false);
	           
				java.awt.EventQueue.invokeLater(new Runnable()
	            {
	                public void run()
	                {
	                	new Main_Win();
					}
                });
			
			}
		});
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnLogOut.setBounds(440, 420, 391, 45);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TeacherMainMenu.class.getResource("/images/small-students-icon.png")));
		lblNewLabel_1.setBounds(440, 151, 155, 121);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TeacherMainMenu.class.getResource("/images/marksheet.png")));
		lblNewLabel_1_1.setBounds(450, 285, 116, 121);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(TeacherMainMenu.class.getResource("/images/teacher_back.jpg")));
		lblNewLabel.setBounds(12, -2, 1196, 567);
		frame.getContentPane().add(lblNewLabel);
		
		frame.pack();
		frame.setSize(1040,610);
		frame.setVisible(true);
	}
}
