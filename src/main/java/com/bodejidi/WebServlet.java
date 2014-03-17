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
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
		try 
		{            
           	Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
	    catch (Exception ex)
	    {
        }

        try
	    {
           	conn =	DriverManager.getConnection("jdbc:mysql://localhost/test?"
                                            	+ "user=root"
                                           		+ "&password=");

            resp.setContentType("text/html; charset=UTF-8");
            stmt = conn.createStatement();
            String sql2 = "SELECT * from member";
            rs = stmt.executeQuery(sql2);
            resp.getWriter().println("<html><head><title>Member List</title></head><body><h1>Member List</h1><table border=\"1\"><tr><td>Name</td></tr>\n");
            while(rs.next()) 
			{
                		
                String firstName = rs.getString("first_name"); 
				String lastName = rs.getString("last_name");
                resp.getWriter().println("<tr><td>" +firstName + " "  + lastName + " " +"</td></tr>\n");
            }
            resp.getWriter().println("</table>");
            resp.getWriter().println("<p><a href=\".\"><button>·µ»Ø</button></a></p>");
            resp.getWriter().println("</body></html>");
       	}
			
		catch (SQLException ex)
		{            
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            resp.getWriter().println("Error!");
       	} 
		finally 
		{
            if (rs != null) 
			{
                try 
				{
                    rs.close();
                } 
				catch (SQLException sqlEx) 
				{
                }
                rs = null;
            }

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
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    			throws IOException, ServletException
    {
		//resp.setContentType("text/html; charset=UTF-8");
		Connection conn = null;
		Statement stmt = null;
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
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
		
		try
		{
			stmt = conn.createStatement();
			
			
				String sql = "INSERT INTO member(first_name, last_name, date_created, last_updated) " 
						   + "VALUES('" + firstName + "', '" + lastName + "', now(), now());";
				stmt.executeUpdate(sql);
				resp.getWriter().println( "add  " + firstName + "   " +  lastName + "  success");
			
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
