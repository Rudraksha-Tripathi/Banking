package model;

import java.sql.*;
import java.util.*;

public class Customer{
	private Integer cust_id;
	private String name;
	private String email;
	private Integer balance;

	public Customer(){
		super();
	}
	public Customer(Integer cust_id,String name,String email,Integer balance){
		this.cust_id = cust_id;
		this.name = name;
		this.email = email;
		this.balance = balance;
	}
	
	public ArrayList<Customer> getAllCustomers(){
		Connection con = null;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?user=root&password=1234");

			String query = "select cust_id,name,email,balance from customer";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{con.close();	}catch(SQLException e){e.printStackTrace();}
		}
		return customers;
	}

	public void transferMoney(Integer from,Integer frombalance,String fromname,Integer to,Integer tobalance,String toname,Integer amount){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?user=root&password=1234");
			String query1 = "update customer set balance=? where cust_id=?";
			String query2 = "update customer set balance=? where cust_id=?";
			String query3 = "insert into transaction (sender,reciever,amount) value (?,?,?)";
			PreparedStatement pst1 = con.prepareStatement(query1);
			PreparedStatement pst2 = con.prepareStatement(query2);
			PreparedStatement pst3 = con.prepareStatement(query3);

			pst1.setInt(1,tobalance+amount);
			pst1.setInt(2,to);
			int rs1 = pst1.executeUpdate();

			pst2.setInt(1,frombalance-amount);
			pst2.setInt(2,from);
			int rs2 = pst2.executeUpdate();

			pst3.setString(1,fromname);
			pst3.setString(2,toname);
			pst3.setInt(3,amount);
			int rs3 = pst3.executeUpdate();

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{con.close();	}catch(SQLException e){e.printStackTrace();}
		}
	}
	
	public Integer getcust_id(){
		return cust_id;
	}
	public void setcust_id(Integer cust_id){
		this.cust_id = cust_id;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getemail(){
		return email;
	}
	public void setemail(String email){
		this.email = email;
	}
	public Integer getbalance(){
		return balance;
	}
	public void setname(Integer balance){
		this.balance = balance;
	}
}