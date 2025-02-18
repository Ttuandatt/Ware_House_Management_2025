package DAO;

import Config.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.*; 
import DTO.PhieuNhapDTO;

public class PhieuNhapDAO implements DAOInterface<PhieuNhapDTO> {
    

	JDBCUtil jdbc = new JDBCUtil();

	@Override
	public ArrayList<PhieuNhapDTO> getAll() {
		ArrayList<PhieuNhapDTO> arr = new ArrayList<>();
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "Select * from phieunhap where trangthai=1";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    
                    //B4
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
			PhieuNhapDTO phieunhap = new PhieuNhapDTO();
                        phieunhap.setMaphieu(rs.getString(1));
                        phieunhap.setManguoitao(rs.getString(2));
			phieunhap.setMakho(rs.getString(3));
			phieunhap.setMancc(rs.getString(4));
			LocalDate dateFromDatabase = rs.getObject("thoigiantao", LocalDate.class);
                        phieunhap.setNgaytao(dateFromDatabase);
        		phieunhap.setTongtien(rs.getInt(6));
                                        
			arr.add(phieunhap);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
                
//		if (openConnection()) {
//			try {
//				String query = "Select * from phieunhap where trangthai=1";
//				PreparedStatement ps = con.prepareStatement(query);
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					PhieuNhapDTO phieunhap = new PhieuNhapDTO();
//                                        phieunhap.setMaphieu(rs.getString(1));
//                                        phieunhap.setManguoitao(rs.getString(2));
//					phieunhap.setMakho(rs.getString(3));
//					phieunhap.setMancc(rs.getString(4));
//					LocalDate dateFromDatabase = rs.getObject("thoigiantao", LocalDate.class);
//					phieunhap.setNgaytao(dateFromDatabase);
//					phieunhap.setTongtien(rs.getInt(6));
//                                        
//					arr.add(phieunhap);
//				}
//				rs.close();
//				ps.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//
//		}
		return arr;
	}

	@Override
	public boolean has(String mapn) {
		boolean result = false;
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "SELECT * FROM sanpham WHERE mapn = ?";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1, mapn);
                    
                    //B4
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query = "SELECT * FROM sanpham WHERE mapn = ?";
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1, mapn);
//				ResultSet rs = ps.executeQuery();
//				result = rs.next(); // Di chuyển con trỏ rs đến dòng tiếp theo, trả về true/false. Khi k có dòng
//									// tiếp theo để di chuyển tới thì trả về false, ngược lại thì true tức là có ít
//									// nhất 1 dòng dữ liệu
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		return result;
	}

	@Override
	public boolean add(PhieuNhapDTO pn) {
		boolean result = false;
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "Insert into phieunhap values(?,?,?,?,?,?,?)";// mapn,mancc,makho,
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1, pn.getMaphieu());
                    ps.setString(4, pn.getMancc());
                    ps.setString(2, pn.getManguoitao());
                    ps.setString(3, pn.getMakho());
                    ps.setDate(5, Date.valueOf( pn.getNgaytao()));
                    ps.setInt(6,pn.getTongtien());
                    ps.setInt(7, 1  );
                    
                 
                    //B4
                    if (ps.executeUpdate() > 0)
                        result = true;
                    
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query = "Insert into phieunhap values(?,?,?,?,?,?,?)";// mapn,mancc,makho,
//
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1, pn.getMaphieu());
//				ps.setString(4, pn.getMancc());
//				ps.setString(2, pn.getManguoitao());
//				ps.setString(3, pn.getMakho());
//				ps.setDate(5, Date.valueOf( pn.getNgaytao()));
//				ps.setInt(6,pn.getTongtien());
//                                 ps.setInt(7, 1  );
//				if (ps.executeUpdate() > 0)
//					result = true;
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//		}
		return result;
	}

	@Override
	public boolean delete(String mapn) {
		boolean result = false;
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "UPDATE phieunhap SET trangthai = 0 WHERE mapn = ?";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1, mapn);
                    
                    //B4
                    if (ps.executeUpdate() > 0) {
			result = true;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query = "UPDATE phieunhap SET trangthai = 0 WHERE mapn = ?";
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1, mapn);
//				if (ps.executeUpdate() > 0) {
//					result = true;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//		}
		return result;
	}



	@Override
	public PhieuNhapDTO getByID(String d) {
		PhieuNhapDTO pn = null;
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query="select mapn,makho,mancc,manguoitao,thoigiantao,tongtien from phieunhap where trangthai=1";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    
                    //B4
                    ResultSet rs=ps.executeQuery();
                    if(rs.next()) {
                        String mapn=rs.getString(1);
                        String makho=rs.getString(2);
			String mancc=rs.getString(3);
                        String manguoitao=rs.getString(4);
			LocalDate thoigiantao=rs.getObject("thoigiantao", LocalDate.class);
			int tongtien=rs.getInt(6);

			pn=new PhieuNhapDTO(mapn,mancc,manguoitao,makho,thoigiantao,tongtien,1);
               	    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query="select mapn,makho,mancc,manguoitao,thoigiantao,tongtien from phieunhap where trangthai=1";
//				 PreparedStatement ps = con.prepareStatement(query);
//				 ResultSet rs=ps.executeQuery();
//				 if(rs.next()) {
//					 String mapn=rs.getString(1);
//					 String makho=rs.getString(2);
//					 String mancc=rs.getString(3);
//					 String manguoitao=rs.getString(4);
//					 LocalDate thoigiantao=rs.getObject("thoigiantao", LocalDate.class);
//					 int tongtien=rs.getInt(6);
//
//					 pn=new PhieuNhapDTO(mapn,mancc,manguoitao,makho,thoigiantao,tongtien,1);
//				 }
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//		}
		return null;
	}

	public int countPhieuNhap() {
		int pn = -1;
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query="select count(mapn) from phieunhap ";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    
                    //B4
                    ResultSet rs=ps.executeQuery();
                    if(rs.next()) {
                        pn=rs.getInt(1);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query="select count(mapn) from phieunhap ";
//				
//				 PreparedStatement ps = con.prepareStatement(query);
//				 ResultSet rs=ps.executeQuery();
//				 if(rs.next()) {
//					 pn=rs.getInt(1);
//
//					
//				 }
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				closeConnection();
//			}
//		}
		return pn;
	}
        
        public ArrayList<PhieuNhapDTO> getByID(String data, String condition) {
		ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien from phieunhap where "
						+ condition + " like ? and trangthai=1";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1, "%" + data + "%");
                    
                    //B4
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
			String mapn = rs.getString(1);
			String mancc = rs.getString(2);
			String manguoitao = rs.getString(3);
			String makho = rs.getString(4);
			Date sqlDate = rs.getDate(5);
                        LocalDate thoigiantao = sqlDate.toLocalDate();
			int tongtien = rs.getInt(6);
                        
                        arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien from phieunhap where "
//						+ condition + " like ? and trangthai=1";
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1, "%" + data + "%");
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					String mapn = rs.getString(1);
//					String mancc = rs.getString(2);
//					String manguoitao = rs.getString(3);
//					String makho = rs.getString(4);
//					Date sqlDate = rs.getDate(5);
//					LocalDate thoigiantao = sqlDate.toLocalDate();
//					int tongtien = rs.getInt(6);
//					arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));
//
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			} finally {
//				closeConnection();
//			}
//		}
		// TODO Auto-generated method stub
		return arr;
	}

	public ArrayList<PhieuNhapDTO> getByTongTien(String data, String condition) {
		ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien,trangthai from phieunhap where tongtien "
						+ condition + " ?";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1, "%" + data + "%");
                    
                    //B4
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
			String mapn = rs.getString(1);
			String mancc = rs.getString(2);
                        String manguoitao = rs.getString(3);
			String makho = rs.getString(4);
                        Date sqlDate = rs.getDate(5);
                        LocalDate thoigiantao = sqlDate.toLocalDate();
			int tongtien = rs.getInt(6);
                        
                        arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));
                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien,trangthai from phieunhap where tongtien "
//						+ condition + " ?";
//
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1, "%" + data + "%");
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					String mapn = rs.getString(1);
//					String mancc = rs.getString(2);
//					String manguoitao = rs.getString(3);
//					String makho = rs.getString(4);
//					Date sqlDate = rs.getDate(5);
//					LocalDate thoigiantao = sqlDate.toLocalDate();
//					int tongtien = rs.getInt(6);
//					arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: hane exception
//			} finally {
//				closeConnection();
//			}
//		}
		// TODO Auto-generated method stub
		return arr;
	}

	public ArrayList<PhieuNhapDTO> getByDate(String data, String condition) {
		ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();

                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien,trangthai from phieunhap where  thoigiantao "
						+ condition + " ? and trangthai=1";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1,data );
                    
                    //B4
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
			String mapn = rs.getString(1);
			String mancc = rs.getString(2);
                        String manguoitao = rs.getString(3);
			String makho = rs.getString(4);
                        Date sqlDate = rs.getDate(5);
			LocalDate thoigiantao = sqlDate.toLocalDate();
                        int tongtien = rs.getInt(6);
				
                        arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));

                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if (openConnection()) {
//			try {
//				String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien,trangthai from phieunhap where  thoigiantao "
//						+ condition + " ? and trangthai=1";
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1,data );
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					String mapn = rs.getString(1);
//					String mancc = rs.getString(2);
//					String manguoitao = rs.getString(3);
//					String makho = rs.getString(4);
//					Date sqlDate = rs.getDate(5);
//					LocalDate thoigiantao = sqlDate.toLocalDate();
//					int tongtien = rs.getInt(6);
//					arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));
//
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			} finally {
//				closeConnection();
//			}
//		}
		// TODO Auto-generated method stub
		return arr;
	}
	public ArrayList<String> getAllMaKho(){
		ArrayList<String> arr =new ArrayList<String>();
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query="select distinct makho from phieunhap where trangthai=1";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    
                    //B4
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()) {
			arr.add(rs.getString(1));
                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                
//		if(openConnection()) {
//			try {
//				String query="select distinct makho from phieunhap where trangthai=1";
//				PreparedStatement ps = con.prepareStatement(query);
//				ResultSet rs=ps.executeQuery();
//				while(rs.next()) {
//
//					arr.add(rs.getString(1));
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}finally {
//				closeConnection();
//			}
//		}
		return arr;
	}
	public ArrayList<PhieuNhapDTO> getByStartEnd(String start,String end) {
		ArrayList<PhieuNhapDTO> arr = new ArrayList<PhieuNhapDTO>();
                
                try{
                    
                    //B1
                    jdbc.openConnection();
                    
                    //B2
                    String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien,trangthai from phieunhap where  thoigiantao between ?  and ?  and trangthai=1";
                    
                    //B3
                    PreparedStatement ps = jdbc.getConnection().prepareStatement(query);
                    ps.setString(1,  start  );
        	    ps.setString(2, end );
                    
                    //B4
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
			String mapn = rs.getString(1);
                        String mancc = rs.getString(2);
			String manguoitao = rs.getString(3);
                        String makho = rs.getString(4);
			Date sqlDate = rs.getDate(5);
                        LocalDate thoigiantao = sqlDate.toLocalDate();
			int tongtien = rs.getInt(6);
                        
                        arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));

			}
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    jdbc.closeConnection();
                }
                

//		if (openConnection()) {
//			try {
//				String query = "select mapn,mancc,manguoitao,makho,thoigiantao,tongtien,trangthai from phieunhap where  thoigiantao between ?  and ?  and trangthai=1";
//				PreparedStatement ps = con.prepareStatement(query);
//				ps.setString(1,  start  );
//				ps.setString(2, end );
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					String mapn = rs.getString(1);
//					String mancc = rs.getString(2);
//					String manguoitao = rs.getString(3);
//					String makho = rs.getString(4);
//					Date sqlDate = rs.getDate(5);
//					LocalDate thoigiantao = sqlDate.toLocalDate();
//					int tongtien = rs.getInt(6);
//					arr.add(new PhieuNhapDTO(mapn, mancc, manguoitao, makho, thoigiantao, tongtien, 1));
//
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				// TODO: handle exception
//			} finally {
//				closeConnection();
//			}
//		}
		// TODO Auto-generated method stub
		return arr;
	}
        
	@Override
	public boolean update(PhieuNhapDTO d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PhieuNhapDTO> search(String d) {
		// TODO Auto-generated method stub
		return null;
	}
}