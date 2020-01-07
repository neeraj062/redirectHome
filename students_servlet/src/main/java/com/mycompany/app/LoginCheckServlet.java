package com.mycompany.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/first")
public class LoginCheckServlet extends HttpServlet {

    private Service service=new ServiceImpl(new DaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean correct=service.credentialsCorrect(username,password);
        if (correct) {
            HttpSession session=req.getSession();
            session.setAttribute("username",username);
            resp.sendRedirect("/second");
        }else {
            resp.sendRedirect("html/form.html");
        }
    }


}







