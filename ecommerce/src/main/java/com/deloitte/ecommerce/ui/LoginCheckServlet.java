package com.deloitte.ecommerce.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.ecommerce.dao.CustomerWalletDaoImpl;
import com.deloitte.ecommerce.service.CustomerWalletServiceImpl;
import com.deloitte.ecommerce.service.ICustomerWalletService;

@WebServlet(value = "/login")
public class LoginCheckServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private ICustomerWalletService service=new CustomerWalletServiceImpl(new CustomerWalletDaoImpl());
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String mobileno = req.getParameter("mobileno");
        String password = req.getParameter("password");
        boolean correct=service.credentialsCorrect(mobileno,password);
        if (correct) {
            HttpSession session=req.getSession();
            session.setAttribute("mobileno",mobileno);
            resp.sendRedirect("/home");
        }else {
            resp.sendRedirect("/form.html");
        }
    }

}
