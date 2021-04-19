package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import model.*;
import java.util.*;

public class ShowTransferMoney extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Customer customer = new Customer();
		if(request.getParameter("id")!=null){
			Integer cust_id = Integer.parseInt(request.getParameter("id"));
			String name = (String)request.getParameter("name");
			request.setAttribute("custId",cust_id);
			request.setAttribute("custName",name);
		}
		ArrayList<Customer> allCustomers = customer.getAllCustomers();
		request.setAttribute("customers",allCustomers);
		request.getRequestDispatcher("transfer.jsp").forward(request,response);
	}
}
