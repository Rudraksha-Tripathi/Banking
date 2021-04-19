package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import model.*;
import java.util.*;

public class AllCustomers extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Customer customer = new Customer();
		ArrayList<Customer> allCustomers = customer.getAllCustomers();
		session.setAttribute("customers",allCustomers);
		request.getRequestDispatcher("customer.jsp").forward(request,response);
	}
}