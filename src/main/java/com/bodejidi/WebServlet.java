package com.bodejidi;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class WebServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse resp) 
                      throws IOException, ServletException
    {
        resp.getWriter().println("hello webservlet!");
    }		      
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    			throws IOException, ServletException
    {
		//resp.setContentType("text/html; charset=UTF-8");
		Connection conn = null;
		Statement stmt = null;
		//resp.getWriter().println("    " + firstName + "  " + lastName );
		try
       	{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?"
												+ "user=root" + "&password=");
			resp.getWriter().println("Connect data base success");
		}
		catch (Exception ex)
       	{
            
       	}
		finally 
		{
           
           	if (stmt != null)
			{
              	try
				{
                    stmt.close();
               	}
				catch (SQLException sqlEx)
				{
                  
              	}
                stmt = null;
			}

           	if (conn != null)
			{
                try 
				{
                   	conn.close();
              	} 
				catch (SQLException sqlEx)
				{
                   
               	}
                conn = null;
            }
    
		}
			
		
    }
		      
}
