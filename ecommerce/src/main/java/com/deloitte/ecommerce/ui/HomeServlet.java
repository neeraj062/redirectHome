package com.deloitte.ecommerce.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.CustomerWalletDaoImpl;
import com.deloitte.ecommerce.entities.CustomerWallet;
import com.deloitte.ecommerce.exceptions.CustomerWalletNotFoundException;
import com.deloitte.ecommerce.exceptions.IncorrectMobileNoException;
import com.deloitte.ecommerce.service.CustomerWalletServiceImpl;
import com.deloitte.ecommerce.service.ICustomerWalletService;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	ICustomerWalletService service =new CustomerWalletServiceImpl(new CustomerWalletDaoImpl());
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setContentType("text/html");
	        resp.setCharacterEncoding("UTF-8");
	        PrintWriter writer = resp.getWriter();
	        HttpSession session = req.getSession();
	        String signedOutVal = req.getParameter("signout");
	        boolean sessionDestroyed = false;
	        if (signedOutVal != null && signedOutVal.equals("true")) {
	            session.invalidate();
	            sessionDestroyed = true;
	        }
	        Object mobilenoObj=null;
	        if (!sessionDestroyed) {
	            mobilenoObj = session.getAttribute("mobileno");
	        }

	        if (mobilenoObj == null || mobilenoObj.toString().isEmpty()) {
	            resp.getWriter().println("you are not signed in yet");
	            String signInLink = "<a href='/form.html'>Sign In </a> ";
	            writer.println(signInLink);
	            return;
	        }
	        String mobileno=mobilenoObj.toString();
	        try {
	        CustomerWallet c=service.findByMobileNo(mobileno);
	        String name=c.getName();
	        double balance=c.getBalance();
	        writer.println("<h1>Welcome " + name+"</h1><br><br>");
	        writer.println("<h2>Account Details</h2>");
	        writer.println("<h3>Balance: "+balance+"</h3>");
	        String signoutLink = "<a href='/home?signout=true'>Sign out </a> ";
	        writer.println(signoutLink);
	        }catch(IncorrectMobileNoException e) {
	        	System.out.println("Incorrect mobile no.");
	        }
	        catch(CustomerWalletNotFoundException e) {
	        	System.out.println("Customer wallet not found.");
	        }
	        catch(Throwable e)
	        {
	        	System.out.println("something went wrong.");
	        }
	    }
		
		
		
	
}

	   
