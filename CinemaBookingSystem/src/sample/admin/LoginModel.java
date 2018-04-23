package sample.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;
public class LoginModel {
    //A Connection object's database is able to provide information describing its tables, its supported SQL grammar
    //variable connection created
    Connection connection;


    //constructor loginmodel
    public LoginModel(){
        try { //try block
            //opening connection
            this.connection = dbConnection.getConnection();
        } catch (SQLException ex){ //catch block
            ex.printStackTrace();

        }
        //condition if there is no connection exit from program.
        if(this.connection==null){
            System.exit(1);
        }
    }
    //boolean method which will check connected or not.
    public boolean isDataBaseConnected(){
        return this.connection != null;
    }

    public boolean isLogin(String user,String pass) throws  Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where username = ? and password = ?";
        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1,user);
            pr.setString(2,pass);


            rs = pr.executeQuery();


            boolean bol1;
            if(rs.next()) {
                return true;
            }
            return false;
        }
        catch (SQLException ex){
            return false;

        }
        finally {
            {
                pr.close();
                rs.close();
            }
        }
    }
}



