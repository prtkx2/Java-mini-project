package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static sample.Main.getConnection;


public class adddata {
    
    public adddata(){
        
    }
    public void add( String Id, String owname, String vehname, String regno, String regdate, String vehclass) throws SQLException{
        String sql = "INSERT INTO `vehreg`(Id, owname, vehname, regno, regdate, vehclass) VALUES (?,?,?,?,?,?)";
        try(
            Connection con= getConnection("root", "hello1234");
            PreparedStatement stmt =con.prepareStatement(sql))
        {
            stmt.setString(1, Id);
            stmt.setString(2, owname);
            stmt.setString(3, vehname);
            stmt.setString(4, regno);
            stmt.setString(5, regdate);
            stmt.setString(6, vehclass);
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }  
        
    }

}