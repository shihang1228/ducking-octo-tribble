package com.bodejidi;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class WebServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse resp) 
                      throws IOException,ServletException
    {
        resp.getWriter().println("hello webservlet!");
    }		      
		          
		      
}
