/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.JDBCUtil;
import DTO.NhaCungCapDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author ACER
 */
public class NhaCungCapDAO implements DAOInterface<NhaCungCapDTO>{
    JDBCUtil jdbc = new JDBCUtil();
    
    
    @Override
    public ArrayList<NhaCungCapDTO> getAll(){
        ArrayList<NhaCungCapDTO> arr = new ArrayList<NhaCungCapDTO>();
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhacungcap WHERE trangthai = 1";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            
            //B4
            ResultSet rs = ps.executeQuery();while(rs.next()){
                NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
                nhacungcapDTO.setMaNCC(rs.getString(1));
                nhacungcapDTO.setTenNCC(rs.getString(2));
                nhacungcapDTO.setDiaChiNCC(rs.getString(3));
                nhacungcapDTO.setSdt(rs.getString(4));
                    
                arr.add(nhacungcapDTO);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
            
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM nhacungcap WHERE trangthai = 1";
//                PreparedStatement ps = con.prepareStatement(query);
//                ResultSet rs = ps.executeQuery();
//                while(rs.next()){
//                    NhaCungCapDTO nhacungcapDTO = new NhaCungCapDTO();
//                    nhacungcapDTO.setMaNCC(rs.getString(1));
//                    nhacungcapDTO.setTenNCC(rs.getString(2));
//                    nhacungcapDTO.setDiaChiNCC(rs.getString(3));
//                    nhacungcapDTO.setSdt(rs.getString(4));
//                    
//                    arr.add(nhacungcapDTO);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return arr;
    }
    
    @Override
    public boolean has(String mancc){
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhacungcap WHERE mancc = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, mancc);
            
            //B4
            ResultSet rs =  ps.executeQuery();
            result = rs.next();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM nhacungcap WHERE mancc = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, mancc);
//                ResultSet rs =  ps.executeQuery();
//                result = rs.next();
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        
        return result;
    }
    
    @Override
    public boolean add(NhaCungCapDTO ncc){
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "INSERT INTO nhacungcap VALUES (?,?,?,?,?)";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getDiaChiNCC());
            ps.setString(4, ncc.getSdt());
            ps.setInt(5, 1);
                
            //B4
            if(ps.executeUpdate()>0)
                return true;
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "INSERT INTO nhacungcap VALUES (?,?,?,?,?)";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, ncc.getMaNCC());
//                ps.setString(2, ncc.getTenNCC());
//                ps.setString(3, ncc.getDiaChiNCC());
//                ps.setString(4, ncc.getSdt());
//                ps.setInt(5, 1);
//                if(ps.executeUpdate()>0)
//                    return true;
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return result;
    }
    
    
    
    @Override
    public boolean delete(String mancc) {
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "UPDATE nhacungcap SET trangthai = 0 WHERE maNCC = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, mancc);
            
            //B4
            if(ps.executeUpdate()>0)
                result = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try {
//                String query = "UPDATE nhacungcap SET trangthai = 0 WHERE maNCC = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, mancc);
//                if(ps.executeUpdate()>0)
//                    result = true;
//            }catch (Exception e) {
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        } 
        return result;
    }
    
    
    @Override
    public boolean update(NhaCungCapDTO ncc) {
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "UPDATE nhacungcap SET tenncc = ?, diachi = ?, sdt = ? WHERE mancc = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChiNCC());
            ps.setString(3, ncc.getSdt());
            ps.setString(4, ncc.getMaNCC());
            
            //B4
            if (ps.executeUpdate() > 0)
                return true;
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try {
//                Connection con = DriverManager.getConnection(dbUrl, username, password);
//                String query = "UPDATE nhacungcap SET tenncc = ?, diachi = ?, sdt = ? WHERE mancc = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, ncc.getTenNCC());
//                ps.setString(2, ncc.getDiaChiNCC());
//                ps.setString(3, ncc.getSdt());
//                ps.setString(4, ncc.getMaNCC());
//        
//                if (ps.executeUpdate() > 0)
//                    return true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return result;
    }
    
    @Override
    public NhaCungCapDTO getByID(String maNCC){
        NhaCungCapDTO ncc = null;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhacungcap WHERE mancc = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, maNCC);
            
            //B4
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String mancc = rs.getString(1);
                String tenncc = rs.getString(2);
                String diachi = rs.getString(3);
                String sdt = rs.getString(4);
                
                ncc = new NhaCungCapDTO(mancc, tenncc, diachi, sdt);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                Connection con = DriverManager.getConnection(dbUrl, username, password);
//                String query = "SELECT * FROM nhacungcap WHERE mancc = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, maNCC);
//                ResultSet rs = ps.executeQuery();
//                if(rs.next()){
//                    String mancc = rs.getString(1);
//                    String tenncc = rs.getString(2);
//                    String diachi = rs.getString(3);
//                    String sdt = rs.getString(4);
//                
//                    ncc = new NhaCungCapDTO(mancc, tenncc, diachi, sdt);
//                }
//                
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return ncc;
    }
    
    @Override
    public ArrayList<NhaCungCapDTO> search(String searchContent){
        ArrayList<NhaCungCapDTO> arr = new ArrayList<>();
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM sanpham WHERE "
                        + "mancc LIKE ? OR "
                        + "tenncc LIKE ? OR"
                        + "diachi LIKE ? OR"
                        + "sdt LIKE ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, "%" + searchContent + "%");
            ps.setString(2, "%" + searchContent + "%");
            ps.setString(3, "%" + searchContent + "%");
            ps.setString(4, "%" + searchContent + "%");
            
            //B4
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getString(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChiNCC(rs.getString(3));
                ncc.setSdt(rs.getString(4));
                   
                    
                arr.add(ncc);

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM sanpham WHERE "
//                        + "mancc LIKE ? OR "
//                        + "tenncc LIKE ? OR"
//                        + "diachi LIKE ? OR"
//                        + "sdt LIKE ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, "%" + searchContent + "%");
//                ps.setString(2, "%" + searchContent + "%");
//                ps.setString(3, "%" + searchContent + "%");
//                ps.setString(4, "%" + searchContent + "%");
//                
//                ResultSet rs = ps.executeQuery();
//                while(rs.next()){
//                    NhaCungCapDTO ncc = new NhaCungCapDTO();
//                    ncc.setMaNCC(rs.getString(1));
//                    ncc.setTenNCC(rs.getString(2));
//                    ncc.setDiaChiNCC(rs.getString(3));
//                    ncc.setSdt(rs.getString(4));
//                    
//                    
//                    arr.add(ncc);
//
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return arr;
    }
    
    public NhaCungCapDTO getByName(String tenncc) {
	NhaCungCapDTO ncc = null;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "select mancc,tenncc,diachi,sdt from nhacungcap where tenncc like ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, "%" + tenncc + "%");
            
            //B4
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
		String mancc = rs.getString(1);
		String tencc=rs.getString(2);
		String diachi=rs.getString(3);
		String sdt=rs.getString(4);
		ncc=new NhaCungCapDTO(mancc,tencc,diachi,sdt);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//		if (openConnection()) {
//			try {
//				String query = "select mancc,tenncc,diachi,sdt from nhacungcap where tenncc like ?";
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1, "%" + tenncc + "%");
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					String mancc = rs.getString(1);
//					String tencc=rs.getString(2);
//					String diachi=rs.getString(3);
//					String sdt=rs.getString(4);
//					ncc=new NhaCungCapDTO(mancc,tencc,diachi,sdt);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//		}
        return ncc;

	}
}
