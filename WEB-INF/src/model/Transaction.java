package model;

import java.sql.*;
import java.util.*;

public class Transaction{
    private Integer trans_id;
	private String sender;
	private String reciever;
	private Integer amount;

	public Transaction(){
		super();
	}
	public Transaction(Integer trans_id,String sender,String reciever,Integer amount){
		this.trans_id = trans_id;
        this.sender = sender;
		this.reciever = reciever;
		this.amount = amount;
	}
	
	public ArrayList<Transaction> getAllTransactions(){
		Connection con = null;
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?user=root&password=1234");

			String query = "select trans_id,sender,reciever,amount from transaction order by trans_id desc";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				transactions.add(new Transaction(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{con.close();	}catch(SQLException e){e.printStackTrace();}
		}
		return transactions;
	}

	public ArrayList<Transaction> getTransaction(Integer cust_id){
		Connection con = null;
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking?user=root&password=1234");

			String query = "select trans_id,sender,reciever,amount from transaction inner join customer as c where (sender=c.name or reciever=c.name) and c.cust_id=? order by trans_id desc";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,cust_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				transactions.add(new Transaction(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{con.close();	}catch(SQLException e){e.printStackTrace();}
		}
		return transactions;
	}

	
	public Integer gettrans_id(){
		return trans_id;
	}
	public void settrans_id(Integer trans_id){
		this.trans_id = trans_id;
	}
	public String getsender(){
		return sender;
	}
	public void setsender(String sender){
		this.sender = sender;
	}
	public String getreciever(){
		return reciever;
	}
	public void setreciever(String reciever){
		this.reciever = reciever;
	}
	public Integer getamount(){
		return amount;
	}
	public void setamount(Integer amount){
		this.amount = amount;
	}
}