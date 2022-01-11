package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

   public static void main(String[] args) {
        try {
            //MySQL
            String url = "jdbc:mysql://localhost:8889/northwind";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url,user,password);

            Statement st = conn.createStatement();
            String sql1 = "insert into tipo values(0, 'Nuevo producto')";
            st.execute (sql1);

            String sql2 = "insert into tipo values(?,?)";
            PreparedStatement pst = conn.prepareStatement(sql2);
            pst.setInt(1,0);
            pst.setString(2,"Nuevo prepared");
            pst.execute();

            conn.close();
            System.out.println("Insertado");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e);
        }
    }
}
