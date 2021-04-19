package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import model.*;
import java.util.*;

public class TransferMoney extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		String fs = (String)request.getParameter("from");
		String[] arrStr1 = fs.split("_");

		Integer from_id = Integer.parseInt(arrStr1[0]);
		String from_name = arrStr1[1];

		String ts = (String)request.getParameter("to");
		String[] arrStr2 = ts.split("_");

		Integer to_id = Integer.parseInt(arrStr2[0]);
		String to_name = arrStr2[1];

        Integer amount = Integer.parseInt(request.getParameter("amount"));

        Customer customer = new Customer();
		
		ArrayList<Customer> customers = customer.getAllCustomers();
		Integer frombalance = customers.get(from_id-1).getbalance();
		Integer tobalance = customers.get(to_id-1).getbalance();
        customer.transferMoney(from_id,frombalance,from_name,to_id,tobalance,to_name,amount);

		request.getRequestDispatcher("transactions.do").forward(request,response);
	}
}