/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.JDBCUtil;
import DTO.NhanVienDTO;
import java.sql.*;
import java.util.*;

public class NhanVienDAO implements DAOInterface<NhanVienDTO>{
    JDBCUtil jdbc = new JDBCUtil();
    
    
    
    @Override
    public ArrayList<NhanVienDTO> getAll(){
        ArrayList<NhanVienDTO> arr = new ArrayList<>();
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhanvien WHERE trangthai = 1";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            
            //B4
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDTO nv = new NhanVienDTO();
                nv.setManv(rs.getString(1));
                nv.setTennv(rs.getString(2));
                nv.setNgaysinh(rs.getString(3));
                nv.setGioitinh(rs.getString(4));
                nv.setDiachi(rs.getString(5));
                nv.setSdt(rs.getString(6));
                nv.setNgayvao(rs.getString(7));
                nv.setLoai(rs.getInt(8));
                nv.setKho(rs.getString(9));
                arr.add(nv);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
            
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM nhanvien WHERE trangthai = 1";
//                PreparedStatement ps = con.prepareStatement(query);
//                ResultSet rs = ps.executeQuery();
//                while(rs.next()){
//                    NhanVienDTO nv = new NhanVienDTO();
//                    nv.setManv(rs.getString(1));
//                    nv.setTennv(rs.getString(2));
//                    nv.setNgaysinh(rs.getString(3));
//                    nv.setGioitinh(rs.getString(4));
//                    nv.setDiachi(rs.getString(5));
//                    nv.setSdt(rs.getString(6));
//                    nv.setNgayvao(rs.getString(7));
//                    nv.setLoai(rs.getInt(8));
//                    nv.setKho(rs.getString(9));
//                    arr.add(nv);
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
    public boolean has(String manv){
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhanvien WHERE manv = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, manv);
            
            //B4
            ResultSet rs = ps.executeQuery();
            result = rs.next();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM nhanvien WHERE manv = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, manv);
//                ResultSet rs = ps.executeQuery();
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
    public boolean add(NhanVienDTO nv){
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "INSERT INTO nhanvien VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setString(3, nv.getNgaysinh());
            ps.setString(4, nv.getGioitinh());
            ps.setString(5, nv.getDiachi());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getNgayvao());
            ps.setInt(8, nv.getLoai());
            ps.setString(9, nv.getKho());
            ps.setInt(10,1);
            
            //B4
            if(ps.executeUpdate()>0)
                result =  true;
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "INSERT INTO nhanvien VALUES (?,?,?,?,?,?,?,?,?,?)";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, nv.getManv());
//                ps.setString(2, nv.getTennv());
//                ps.setString(3, nv.getNgaysinh());
//                ps.setString(4, nv.getGioitinh());
//                ps.setString(5, nv.getDiachi());
//                ps.setString(6, nv.getSdt());
//                ps.setString(7, nv.getNgayvao());
//                ps.setInt(8, nv.getLoai());
//                ps.setString(9, nv.getKho());
//                ps.setInt(10,1);
//                if(ps.executeUpdate()>0)
//                    result =  true;
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return result;
    }
    
    @Override
    public boolean delete(String manv){
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String queryNV = "UPDATE nhanvien SET trangthai = 0 WHERE manv = ?";
            
            //B3
            PreparedStatement psNV = jdbc.getConnection().prepareStatement(queryNV);
            psNV.setString(1, manv);
            
            //B4
            if(psNV.executeUpdate()>0){
                String queryTK = "UPDATE taikhoan SET trangthai = 0 WHERE manv = ?";
                PreparedStatement psTK = jdbc.getConnection().prepareStatement(queryTK);
                psTK.setString(1, manv);
                if(psTK.executeUpdate()>0)
                    result = true;
                }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String queryNV = "UPDATE nhanvien SET trangthai = 0 WHERE manv = ?";
//                PreparedStatement psNV = con.prepareStatement(queryNV);
//                psNV.setString(1, manv);
//                if(psNV.executeUpdate()>0){
//                    String queryTK = "UPDATE taikhoan SET trangthai = 0 WHERE manv = ?";
//                    PreparedStatement psTK = con.prepareStatement(queryTK);
//                    psTK.setString(1, manv);
//                    if(psTK.executeUpdate()>0)
//                        result = true;
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return result;
    }
    
    @Override
    public boolean update(NhanVienDTO nv){
        boolean result = false;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "UPDATE nhanvien SET tennv = ?, ngsinh = ?, gioitinh = ?, diachi = ?, sdt = ?, ngayvao = ?, loai = ?,  kho = ? WHERE manv = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, nv.getTennv());
            ps.setString(2, nv.getNgaysinh());
            ps.setString(3, nv.getGioitinh());
            ps.setString(4, nv.getDiachi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getNgayvao());
            ps.setInt(7, nv.getLoai());
            ps.setString(8, nv.getKho());
            ps.setString(9, nv.getManv());
            
            
            //B4
            if(ps.executeUpdate()>0)
                result = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "UPDATE nhanvien SET tennv = ?, ngsinh = ?, gioitinh = ?, diachi = ?, sdt = ?, ngayvao = ?, loai = ?,  kho = ? WHERE manv = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, nv.getTennv());
//                ps.setString(2, nv.getNgaysinh());
//                ps.setString(3, nv.getGioitinh());
//                ps.setString(4, nv.getDiachi());
//                ps.setString(5, nv.getSdt());
//                ps.setString(6, nv.getNgayvao());
//                ps.setInt(7, nv.getLoai());
//                ps.setString(8, nv.getKho());
//                ps.setString(9, nv.getManv());
//                if(ps.executeUpdate()>0)
//                    result = true;
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return result;
        
    }
    
    @Override
    public NhanVienDTO getByID(String manv){
        NhanVienDTO nhanvien = null;
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhanvien WHERE manv = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, manv);
                
            //B4
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String maNv = rs.getString(1);
                String tenNv = rs.getString(2);
                String ngaySinh = rs.getString(3);
                String gioiTinh = rs.getString(4);
                String diaChi = rs.getString(5);
                String sdt = rs.getString(6);
                String ngayVao = rs.getString(7);
                int loai = rs.getInt(8);
                String kho = rs.getString(9);
                nhanvien = new NhanVienDTO(maNv, tenNv, ngaySinh, gioiTinh, diaChi, sdt, ngayVao, loai, kho);
                  
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM nhanvien WHERE manv = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, manv);
//                ResultSet rs = ps.executeQuery();
//                if(rs.next()){
//                    String maNv = rs.getString(1);
//                    String tenNv = rs.getString(2);
//                    String ngaySinh = rs.getString(3);
//                    String gioiTinh = rs.getString(4);
//                    String diaChi = rs.getString(5);
//                    String sdt = rs.getString(6);
//                    String ngayVao = rs.getString(7);
//                    int loai = rs.getInt(8);
//                    String kho = rs.getString(9);
//                    nhanvien = new NhanVienDTO(maNv, tenNv, ngaySinh, gioiTinh, diaChi, sdt, ngayVao, loai, kho);
//                    
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return nhanvien;
    }
    
    @Override
    public ArrayList<NhanVienDTO> search(String searchContent){
        ArrayList<NhanVienDTO> arr = new ArrayList<>();
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT * FROM nhanvien WHERE tennv LIKE ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, "%" + searchContent + "%");
            
            //B4
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDTO nhanvien = new NhanVienDTO();
                nhanvien.setManv(rs.getString(1));
                nhanvien.setTennv(rs.getString(2));
                nhanvien.setNgaysinh(rs.getString(3));
                nhanvien.setGioitinh(rs.getString(4));
                nhanvien.setDiachi(rs.getString(5));
                nhanvien.setSdt(rs.getString(6));
                nhanvien.setNgayvao(rs.getString(7));
                nhanvien.setLoai(rs.getInt(8));
                nhanvien.setKho(rs.getString(9));
                arr.add(nhanvien);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "SELECT * FROM nhanvien WHERE tennv LIKE ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, "%" + searchContent + "%");
//                ResultSet rs = ps.executeQuery();
//                while(rs.next()){
//                    NhanVienDTO nhanvien = new NhanVienDTO();
//                    nhanvien.setManv(rs.getString(1));
//                    nhanvien.setTennv(rs.getString(2));
//                    nhanvien.setNgaysinh(rs.getString(3));
//                    nhanvien.setGioitinh(rs.getString(4));
//                    nhanvien.setDiachi(rs.getString(5));
//                    nhanvien.setSdt(rs.getString(6));
//                    nhanvien.setNgayvao(rs.getString(7));
//                    nhanvien.setLoai(rs.getInt(8));
//                    nhanvien.setKho(rs.getString(9));
//                    arr.add(nhanvien);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return arr;
    }
    
    public String getMaKho(String manv) {
    	String ma="";
        
        try{
            
            //B1
            jdbc.openConnection();
            
            //B2
            String query = "SELECT kho FROM nhanvien WHERE manv = ?";
            
            //B3
            PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
            ps.setString(1, manv);
            
            //B4
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ma=rs.getString(1);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbc.closeConnection();
        }
        
//        if(openConnection()){
//            try{
//                String query = "SELECT kho FROM nhanvien WHERE manv = ?";
//                PreparedStatement ps = con.prepareStatement(query);
//                ps.setString(1, manv);
//                ResultSet rs = ps.executeQuery();
//                while(rs.next()){
//                  ma=rs.getString(1);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                closeConnection();
//            }
//        }
        return ma;
    }
}
