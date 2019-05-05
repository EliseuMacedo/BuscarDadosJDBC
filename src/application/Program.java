package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.DB;



public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		Statement st = null;
		
		ResultSet rs = null;
		
		try {
			//conectar o bd
			conn = DB.getConnection();
			//instanciar objeto do tipo statement
			st = conn.createStatement();
			
			
			//metodo execute query e o resultado da consulta ser� atribuido na vari�vel rs. resultset
			rs =  st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
