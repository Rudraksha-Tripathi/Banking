package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import model.*;
import java.util.*;

public class AllTransaction extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
        Transaction trans = new Transaction();
		if(request.getParameter("id")!=null){
			Integer cust_id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Transaction> alltrans = trans.getTransaction(cust_id);
			request.setAttribute("transactions",alltrans);
		}else{
        ArrayList<Transaction> alltrans = trans.getAllTransactions();
        session.setAttribute("transactions",alltrans);
		}
		request.getRequestDispatcher("transaction.jsp").forward(request,response);
	}
}