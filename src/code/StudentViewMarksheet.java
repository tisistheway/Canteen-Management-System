package code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentViewMarksheet{

	private JFrame frame;
	private JTextField txtComFun;
	private JTextField txtComNet;
	private JTextField txtComGrap;
	private JTextField txtMath;
	private JTextField txtChem;
	private JTextField txtCLab;
	int rollNo;
	JLabel lblName;
	JLabel lblGender;
	JLabel lblBranch;
	JLabel lblRollNo;
	JLabel lblTotalObt;
	JLabel lblEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentViewMarksheet window = new StudentViewMarksheet(10);
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
	public StudentViewMarksheet(int rollNo) {
		this.rollNo = rollNo;
		initialize();
		System.out.println("Initializing");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1210, 705);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 25));
		lblNewLabel.setIcon(new ImageIcon(StudentViewMarksheet.class.getResource("/images/student_icon.png")));
		lblNewLabel.setBounds(132, 13, 120, 132);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblStudent = new JLabel("Your Details Details ");
		lblStudent.setFont(new Font("Consolas", Font.BOLD, 26));
		lblStudent.setBounds(40, 158, 342, 53);
		frame.getContentPane().add(lblStudent);
		
		JLabel lblName_4 = new JLabel("Name :");
		lblName_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_4.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName_4.setBounds(12, 242, 136, 32);
		frame.getContentPane().add(lblName_4);
		
		JLabel lblSuname = new JLabel("Gender :");
		lblSuname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSuname.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblSuname.setBounds(12, 352, 136, 32);
		frame.getContentPane().add(lblSuname);
		
		JLabel lblName_3 = new JLabel(" Branch:");
		lblName_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName_3.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName_3.setBounds(12, 410, 136, 32);
		frame.getContentPane().add(lblName_3);
		
		JLabel lblRollNotxt = new JLabel("Roll No :");
		lblRollNotxt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRollNotxt.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblRollNotxt.setBounds(12, 471, 136, 32);
		frame.getContentPane().add(lblRollNotxt);
		

		
		lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblName.setBounds(137, 242, 211, 32);
		frame.getContentPane().add(lblName);
		
		lblGender = new JLabel("");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblGender.setBounds(137, 352, 211, 32);
		frame.getContentPane().add(lblGender);
		
		lblBranch = new JLabel("");
		lblBranch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBranch.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblBranch.setBounds(160, 410, 240, 32);
		frame.getContentPane().add(lblBranch);
		
		lblRollNo = new JLabel("");
		lblRollNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblRollNo.setBounds(137, 471, 219, 32);
		frame.getContentPane().add(lblRollNo);
		
		JLabel label = new JLabel("");
		label.setBounds(148, 80, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StudentViewMarksheet.class.getResource("/images/marksheet.png")));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 25));
		lblNewLabel_1.setBounds(472, 13, 120, 132);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEnterMarksObjtained = new JLabel("Marks Obtained in Last Exam");
		lblEnterMarksObjtained.setFont(new Font("Consolas", Font.BOLD, 26));
		lblEnterMarksObjtained.setBounds(651, 86, 618, 43);
		frame.getContentPane().add(lblEnterMarksObjtained);
		
		JLabel lblStudentExamMarks = new JLabel("Your Exam Marks");
		lblStudentExamMarks.setFont(new Font("Consolas", Font.BOLD, 30));
		lblStudentExamMarks.setBounds(685, 24, 518, 43);
		frame.getContentPane().add(lblStudentExamMarks);
		
		JLabel lblSubject = new JLabel("Sr No.");
		lblSubject.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblSubject.setBounds(431, 177, 111, 43);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblTotalMarks = new JLabel("Total Marks");
		lblTotalMarks.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblTotalMarks.setBounds(797, 182, 163, 29);
		frame.getContentPane().add(lblTotalMarks);
		
		JLabel lblSubject_1 = new JLabel("Subject");
		lblSubject_1.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblSubject_1.setBounds(612, 172, 111, 53);
		frame.getContentPane().add(lblSubject_1);
		
		JLabel lblObtainedMarks = new JLabel("Obtained Marks");
		lblObtainedMarks.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblObtainedMarks.setBounds(973, 178, 219, 33);
		frame.getContentPane().add(lblObtainedMarks);
		
		JLabel lblName_4_2 = new JLabel("1");
		lblName_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_4_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblName_4_2.setBounds(431, 242, 100, 32);
		frame.getContentPane().add(lblName_4_2);
		
		JLabel lblSuname_2 = new JLabel("2");
		lblSuname_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuname_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblSuname_2.setBounds(431, 287, 100, 32);
		frame.getContentPane().add(lblSuname_2);
		
		JLabel lblName_3_2 = new JLabel("3");
		lblName_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_3_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblName_3_2.setBounds(431, 332, 100, 32);
		frame.getContentPane().add(lblName_3_2);
		
		JLabel lblRollNo_2 = new JLabel("4");
		lblRollNo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblRollNo_2.setBounds(431, 377, 100, 32);
		frame.getContentPane().add(lblRollNo_2);
		
		JLabel lblRollNo_2_1 = new JLabel("5");
		lblRollNo_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblRollNo_2_1.setBounds(431, 422, 100, 32);
		frame.getContentPane().add(lblRollNo_2_1);
		
		JLabel lblRollNo_2_1_1 = new JLabel("6");
		lblRollNo_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_1_1.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblRollNo_2_1_1.setBounds(431, 471, 100, 32);
		frame.getContentPane().add(lblRollNo_2_1_1);
		
		JLabel lblName_4_2_1 = new JLabel("Computer Fundamental ");
		lblName_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_4_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblName_4_2_1.setBounds(524, 247, 282, 32);
		frame.getContentPane().add(lblName_4_2_1);
		
		JLabel lblSuname_2_1 = new JLabel("Computer Networking ");
		lblSuname_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuname_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblSuname_2_1.setBounds(555, 293, 219, 32);
		frame.getContentPane().add(lblSuname_2_1);
		
		JLabel lblName_3_2_1 = new JLabel("Mathematics - I");
		lblName_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_3_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblName_3_2_1.setBounds(563, 378, 195, 32);
		frame.getContentPane().add(lblName_3_2_1);
		
		JLabel lblRollNo_2_2 = new JLabel("Computer Graphics ");
		lblRollNo_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_2.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblRollNo_2_2.setBounds(565, 333, 205, 43);
		frame.getContentPane().add(lblRollNo_2_2);
		
		JLabel lblRollNo_2_1_2 = new JLabel("Chemistry ");
		lblRollNo_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_1_2.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblRollNo_2_1_2.setBounds(590, 427, 133, 32);
		frame.getContentPane().add(lblRollNo_2_1_2);
		
		JLabel lblRollNo_2_1_1_1 = new JLabel("C - Lab");
		lblRollNo_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_1_1_1.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblRollNo_2_1_1_1.setBounds(600, 477, 100, 32);
		frame.getContentPane().add(lblRollNo_2_1_1_1);
		
		JLabel lblName_4_2_2 = new JLabel("100");
		lblName_4_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_4_2_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblName_4_2_2.setBounds(829, 242, 100, 32);
		frame.getContentPane().add(lblName_4_2_2);
		
		JLabel lblSuname_2_2 = new JLabel("100");
		lblSuname_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuname_2_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblSuname_2_2.setBounds(829, 287, 100, 32);
		frame.getContentPane().add(lblSuname_2_2);
		
		JLabel lblName_3_2_2 = new JLabel("100");
		lblName_3_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_3_2_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblName_3_2_2.setBounds(829, 332, 100, 32);
		frame.getContentPane().add(lblName_3_2_2);
		
		JLabel lblRollNo_2_3 = new JLabel("100");
		lblRollNo_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_3.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblRollNo_2_3.setBounds(829, 377, 100, 32);
		frame.getContentPane().add(lblRollNo_2_3);
		
		JLabel lblRollNo_2_1_3 = new JLabel("100");
		lblRollNo_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_1_3.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblRollNo_2_1_3.setBounds(829, 422, 100, 32);
		frame.getContentPane().add(lblRollNo_2_1_3);
		
		JLabel lblRollNo_2_1_1_2 = new JLabel("50");
		lblRollNo_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNo_2_1_1_2.setFont(new Font("Sitka Text", Font.PLAIN, 23));
		lblRollNo_2_1_1_2.setBounds(829, 471, 100, 32);
		frame.getContentPane().add(lblRollNo_2_1_1_2);
		
		txtComFun = new JTextField();
		txtComFun.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtComFun.setHorizontalAlignment(SwingConstants.CENTER);
		txtComFun.setBounds(1024, 240, 111, 32);
		frame.getContentPane().add(txtComFun);
		txtComFun.setColumns(10);
		
		txtComNet = new JTextField();
		txtComNet.setHorizontalAlignment(SwingConstants.CENTER);
		txtComNet.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtComNet.setColumns(10);
		txtComNet.setBounds(1024, 290, 111, 32);
		frame.getContentPane().add(txtComNet);
		
		txtComGrap = new JTextField();
		txtComGrap.setHorizontalAlignment(SwingConstants.CENTER);
		txtComGrap.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtComGrap.setColumns(10);
		txtComGrap.setBounds(1024, 338, 111, 32);
		frame.getContentPane().add(txtComGrap);
		
		txtMath = new JTextField();
		txtMath.setHorizontalAlignment(SwingConstants.CENTER);
		txtMath.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtMath.setColumns(10);
		txtMath.setBounds(1024, 383, 111, 32);
		frame.getContentPane().add(txtMath);
		
		txtChem = new JTextField();
		txtChem.setHorizontalAlignment(SwingConstants.CENTER);
		txtChem.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtChem.setColumns(10);
		txtChem.setBounds(1024, 428, 111, 32);
		frame.getContentPane().add(txtChem);
		
		txtCLab = new JTextField();
		txtCLab.setHorizontalAlignment(SwingConstants.CENTER);
		txtCLab.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtCLab.setColumns(10);
		txtCLab.setBounds(1024, 471, 111, 32);
		frame.getContentPane().add(txtCLab);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
		btnMainMenu.setBounds(255, 591, 205, 54);
		frame.getContentPane().add(btnMainMenu);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			
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
		btnLogout.setFont(new Font("Segoe UI Emoji", Font.BOLD, 22));
		btnLogout.setBounds(40, 591, 188, 54);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblTotal = new JLabel("Total          550");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblTotal.setBounds(633, 537, 268, 32);
		frame.getContentPane().add(lblTotal);
		
		lblTotalObt = new JLabel("");
		lblTotalObt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalObt.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblTotalObt.setBounds(1024, 537, 111, 32);
		frame.getContentPane().add(lblTotalObt);
		
		JLabel lblEmail1 = new JLabel("Email :");
		lblEmail1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail1.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblEmail1.setBounds(30, 298, 118, 41);
		frame.getContentPane().add(lblEmail1);
		
		lblEmail = new JLabel("");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblEmail.setBounds(137, 287, 211, 41);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblResult = new JLabel("Result : ");
		lblResult.setForeground(Color.BLUE);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblResult.setBounds(534, 599, 282, 32);
		frame.getContentPane().add(lblResult);
		
		JLabel lblPercentage = new JLabel("Percentage : ");
		lblPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentage.setForeground(Color.BLUE);
		lblPercentage.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblPercentage.setBounds(840, 600, 282, 32);
		frame.getContentPane().add(lblPercentage);
		
		System.out.println("Initializing 2");
		
		frame.pack();
		frame.setSize(1200,720);
		frame.setVisible(true);
	
		System.out.println("Initializing ");

		try {
			setStudentData(rollNo);
			String sql = "Select * From marksheet where stud_rollNo ="+rollNo+"  LIMIT 1;";
			Connection con = MyConnection.getConnection();
			Statement stmt=con.createStatement();
			Resultset rs = (Resultset) stmt.executeQuery(sql);
			
			if (rs.getRows().size()!=0) {
				while(((ResultSet) rs).next()){ 
				txtComFun.setText(((ResultSet) rs).getString(2));
				txtComNet.setText(((ResultSet) rs).getString(3));
				txtComGrap.setText(((ResultSet) rs).getString(4));
				txtMath.setText(((ResultSet) rs).getString(5));
				txtChem.setText(((ResultSet) rs).getString(6));
				txtCLab.setText(((ResultSet) rs).getString(7));
				lblTotalObt.setText(((ResultSet) rs).getString(8));
				lblPercentage.setText("Percentage : "+((ResultSet) rs).getString(10)+"%");
				
				if (((ResultSet) rs).getInt(10)>=40){
					lblResult.setText("Result : Pass");
				} else { lblResult.setText("Result : failed");}

				}
				
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Teachers haven't review your exam paper yet","Waiting ...",JOptionPane.ERROR_MESSAGE);						
			}
			   
			con.close();

			
		}  catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), "Error Occure "+e,"Error",JOptionPane.ERROR_MESSAGE);						
		}
	
	}
	
	
	public void setStudentData(int rollno) {
		
		try {
		
			String sql = "Select * From student where roll_no ="+rollno+";";
			Connection con = MyConnection.getConnection();
			Statement stmt=con.createStatement();
			Resultset rs = (Resultset) stmt.executeQuery(sql);
			
			if (rs.getRows().size()!=0) {
				while(((ResultSet) rs).next()){ 
				lblName.setText(((ResultSet) rs).getString(1));
				lblEmail.setText(((ResultSet) rs).getString(2));
				lblGender.setText(((ResultSet) rs).getString(4));
				lblBranch.setText(((ResultSet) rs).getString(5));
				lblRollNo.setText(((ResultSet) rs).getString(6));
				}
				
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Invalid Roll No pls provide Valid no","Invalid",JOptionPane.ERROR_MESSAGE);						
			}
			   
			con.close();

			
		}  catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), "Error Occure "+e,"Error",JOptionPane.ERROR_MESSAGE);						
		}
	}

	
}
