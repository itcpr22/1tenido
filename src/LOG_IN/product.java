/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOG_IN;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
/**
 *
 * @author hanni
 */
public class product {
    
    conn con = new conn();
    public int addProduct(String PNAME, int PQUANTITY, Object PPRICE){
        int r = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
            String sql = "insert into product values(null,?,?,?);";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            String np = PPRICE.toString();
            float newprice = Float.parseFloat(np);
                    
            pstmt.setString(1, PNAME);
            pstmt.setInt(2, PQUANTITY);
            pstmt.setFloat(3, newprice);
            
            r = pstmt.executeUpdate();
            //System.out.println(pstmt);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}

