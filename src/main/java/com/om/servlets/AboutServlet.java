package com.om.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.om.model.UserRole;
import com.om.util.StoreUtil;

// HttpServlet extended class for showing the about information
public class AboutServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        // If the store is logged in as customer or seller, show about info
        if (StoreUtil.isLoggedIn(UserRole.CUSTOMER, req.getSession())) {
            RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.html");
            rd.include(req, res);
            StoreUtil.setActiveTab(pw, "about");

            // Insert photo and personal information
            pw.println("<div style='text-align:center;'>");
            pw.println("<img src='https://drive.google.com/file/d/1MVpyUmZy67A5NSwo5SMZAuSroertnufi/view?usp=sharing'alt='om patil' style='width:150px; height:150px; border-radius:50%;'>");
            pw.println("<h2>om patil</h2>");
            pw.println("<p>Welcome to my personal page. I am a cloude developer experience in web development and a passion for creating innovative solutions.</p>");
            pw.println("</div>");

        } else if (StoreUtil.isLoggedIn(UserRole.SELLER, req.getSession())) {
            RequestDispatcher rd = req.getRequestDispatcher("SellerHome.html");
            rd.include(req, res);
            StoreUtil.setActiveTab(pw, "about");

            // Insert photo and personal information
            pw.println("<div style='text-align:center;'>");
            pw.println("<img src='https://drive.google.com/file/d/1MVpyUmZy67A5NSwo5SMZAuSroertnufi/view?usp=sharing'alt='om patil' style='width:150px; height:150px; border-radius:50%;'>");
            pw.println("<h2>om patil</h2>");
            pw.println("<p>Welcome to my personal page. I am a cloude developer experience in web development and a passion for creating innovative solutions.</p>");
            pw.println("</div>");


        } else {
            // If the user is not logged in, ask to log in first
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
            pw.println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
        }
    }
}
