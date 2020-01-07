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

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

    private Service service=new ServiceImpl(new DaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
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
        Object usernameObj=null;
        if (!sessionDestroyed) {
            usernameObj = session.getAttribute("username");
        }

        if (usernameObj == null || usernameObj.toString().isEmpty()) {
            resp.getWriter().println("please sign in ");
            String signInLink = "<a href='/html/form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String username=usernameObj.toString();
        AppUser user=service.getUserByUsername(username);
        int age=user.getAge();
        writer.println("Welcome " + username +" age="+age);
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}







