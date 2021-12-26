package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			
			String name = "Sahil";
			String email = "Sahil";
			String gender = "Sahil";
			String branch = "Sahil";
			int mobile = 83385;
			int rollno = 5;
			
			int comp_fund = 90;
			int comp_grap = 90;
			int comp_net = 90;
			int math = 90;
			int chem = 90;
			int c_lab = 45;
			int obtainedTotal = comp_fund+comp_grap+comp_net+math+chem+c_lab;
			int percentage = (obtainedTotal * 100 ) / 550;
			
//			String sql="insert into marksheet values('"+rollno+"','"+comp_fund+"','"+comp_net+"','"+comp_grap+"','"+math+"','"+chem+"','"+c_lab+"','"+550+"','"+obtainedTotal+"','"+percentage+"');";
//			String sql="insert into student values('"+name+"','"+email+"','"+mobile+"','"+gender+"','"+branch+"','"+rollno+"');";
//			String sql = "Select * From student where roll_no ="+rollno+";";
//			String query = "Insert into student values (
//					+ "'"+name+"',"+email+","+Long.parseLong(mobile)+","+gender+","+branch+","+Integer.parseInt(rollno)+");";
			String sql = "Select roll_no From student where email ="+"sss"+" and password="+2345+";";

			
			Connection con = MyConnection.getConnection();
			Statement stmt=con.createStatement();
//			int rs = stmt.executeUpdate(sql); // for insert
//			Resultset rs = (Resultset) stmt.executeQuery(sql);// for selectt
			 PreparedStatement st = (PreparedStatement) con
                     .prepareStatement("Select roll_no from student where email=? and password=?;");

                 st.setString(1, "ss8s");
                 st.setString(2, "2345");
                 ResultSet rs1 = st.executeQuery();

                 if (rs1.next()) {
////                     dispose();
////                     UserHome ah = new UserHome(userName);
////                     ah.setTitle("Welcome");
////                     ah.setVisible(true);
                	 System.out.println("Login");
//                     JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                 } else {
                	 System.out.println("Invalid");
//                     JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                 }
			   while(((ResultSet) rs1).next()){  
			    System.out.println(((ResultSet) rs1).getString(1)); 
//			    System.out.println(((ResultSet) rs).getString(2)); 
//			    System.out.println(((ResultSet) rs).getString(3)); 
//			    System.out.println(((ResultSet) rs).getString(4)); 
//			    System.out.println(((ResultSet) rs).getString(5)); 
//			    System.out.println(((ResultSet) rs).getString(6)); 
			    
			   }  
			  
			   
			con.close();
			
		} catch (Exception e){
			e.printStackTrace();
	}

	}
}
