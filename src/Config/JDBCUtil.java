/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class JDBCUtil {
    private static String dbUrl = "jdbc:mysql://localhost:3306/quanlykhohang";
    private static String username = "root";
    private static String password = "123456";
    private Connection con;
    
    public boolean openConnection(){
        boolean result = false;
        
        //Hàm thiết lập kết nối với database
        try{
            // Đăng ký MySQL Driver với DriverManager (có nghĩa là ta có thể kết nối 2 database trong cùng 1 app này, chi tiết thì search ChatGPT)
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(dbUrl, username, password);
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    
    //Hàm đóng kết nối với database
    public void closeConnection(){
        try{
            
            if(con!=null)
                con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Hàm trả về đối tượng Connection
	public Connection getConnection() {
		return con;
	}
}
