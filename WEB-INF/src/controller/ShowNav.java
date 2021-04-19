package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import model.*;
import java.util.*;

public class ShowNav extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Customer customer = new Customer();
		ArrayList<Customer> allCustomers = customer.getAllCustomers();
        Integer cust_id = Integer.parseInt(request.getParameter("id"));
        Customer cust =allCustomers.get(cust_id-1);
        request.setAttribute("cust",cust);
		request.getRequestDispatcher("nav.jsp").forward(request,response);
	}
}