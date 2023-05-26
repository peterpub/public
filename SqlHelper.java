package lib.git;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

//
public class SqlHelper {
    static Connection _c = null;
    public static void main(String[]z){

    }
    public static Connection c() {
        try {
            if (_c == null || _c.isClosed()) {
                try {
                    Class.forName("org.postgresql.Driver");
                    _c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin",
                            "admin");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                    System.exit(0);
                }
                // System.out.println("Opened database successfully");

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return _c;
    }

    public static CallableStatement callableStatement(String q){
        try {
            java.sql.CallableStatement s = c().prepareCall(q);
            return s;
        } catch (Exception e) {
            for(StackTraceElement ste:e.getStackTrace()){
                System.out.println(ste);
            }
        }
        return null;
    }

    public static ResultSet executeQuery(String q) {
        ResultSet rs = null;
        try {
            java.sql.CallableStatement s = c().prepareCall(q);
            //  System.out.println(s.toString());
            rs = s.executeQuery();
            return rs;
        } catch (Exception e) {
            for(StackTraceElement ste:e.getStackTrace()){
                System.out.println(ste);
            }
        }
        return null;
    }

    public static boolean execute(String q) {
        try {
            c().createStatement().execute(q);
            return true;
        } catch (Exception ex) {

        }
        return false;
    }
}