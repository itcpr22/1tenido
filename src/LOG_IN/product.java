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
    public int deleteProduct(Object id){
        int r = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
            String sql = "DELETE FROM product WHERE id = ?;";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            
            int newid = Integer.parseInt(id.toString());
            pstmt.setInt(1, newid);
            
            r = pstmt.executeUpdate();
            //System.out.println(pstmt);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
        public int editProduct(Object id, String product_name, Object price){
        int r = 0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
        
        String sql = "UPDATE product SET prdct_name = ?, price = ? WHERE id = ?;";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        
        pstmt.setString(1, product_name);
        float newprice = Float.parseFloat(price.toString());
        pstmt.setFloat(2, newprice);
        String newid = (String) id;
        pstmt.setString(3, newid);
        
        //System.out.println(pstmt);
        r = pstmt.executeUpdate();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
        public int product_addQty(int id, Object quantity){int y = 0;
        try{
    String sql = "update product set quantity = quantity+ ? where id=?;";
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection conn = (java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost/tenidodb?", "root", "");
    java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
    
    pstmt.setString(1, quantity.toString());
    pstmt.setInt(2, id);
    y=pstmt.executeUpdate();
    
    
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }return y; 
    }  
}

