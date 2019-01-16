package com.live.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.live.util.LoggerManager;
public class DBConn {
	public Connection con;
	private static Properties mProps;

	
	/**
	 * @return the props
	 */
	public Properties getProperties()
	{
		return mProps;
	}

	/**
	 * @param props
	 *            application properties object
	 */
	public void setProperties(Properties aProps)
	{
		mProps = aProps;
	}

	public Connection getConnection()
	{
		try
		{
			Properties aProps = getProperties();
			System.out.println(aProps.getProperty("driver"));
			Class.forName(aProps.getProperty("driver"));
			con = DriverManager.getConnection(aProps.getProperty("url"), aProps.getProperty("duser"), aProps.getProperty("dpass"));
			System.out.println(con);
			System.out.println("Connection Established");
		}
		catch (ClassNotFoundException cnfe)
		{
			LoggerManager.writeLogWarning(cnfe);
		}
		catch (SQLException se)
		{
			LoggerManager.writeLogWarning(se);
		}
		return con;
    	}
    	public void releaseResources(Connection con,PreparedStatement ps)
    	{
    		try
    		{
    			if(con!=null)
    			{
    				con.close();
    				System.out.println("Connection Closed");
    			}
    			else
    			{
    				con.close();
    			}
    			if(ps!=null)
    			{
    				ps.close();
    				System.out.println(" Prepare Connection Closed");
    			}
    			else
    			{
    				ps.close();
    			}
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    	public void releaseResources1(Connection con,Statement ps)
    	{
    		try
    		{
    			if(con!=null)
    			{
    				con.close();
    			}
    			else
    			{
    				con.close();
    			}
    			if(ps!=null)
    			{
    				ps.close();
    			}
    			else
    			{
    				ps.close();
    			}
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}


}