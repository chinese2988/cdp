package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnect.DBConnection;

import entity.user.department;

public class departmentDao {
	public department findDeptById(int id) throws Exception{
		department dept = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = DBConnection.getConnection();
			String sql = "select bmbh,bmmc,sjbmbh,sjbmmc,xthj,zjhj,ghrl,syrl,kxrl,ybmbh,chartdata,dwdz,bmjc,tsbj,picture from dwxx where bmbh=?" ;
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				dept = new department();
				dept.setBmbh(rs.getInt("bmbh"));
				dept.setBmmc(rs.getString("bmmc"));
				dept.setSjbmbh(rs.getInt("sjbmbh"));
				dept.setSjbmmc(rs.getString("sjbmmc"));
				dept.setXthj(rs.getInt("xthj"));
				dept.setZjhj(rs.getInt("zjhj"));
				dept.setGhrl(rs.getDouble("ghrl"));
				dept.setSyrl(rs.getDouble("syrl"));
				dept.setKxrl(rs.getDouble("kxrl"));
				dept.setYbmbh(rs.getInt("ybmbh"));
				dept.setChartdata(rs.getString("chartdata"));
				dept.setDwdz(rs.getString("dwdz"));
				dept.setBmjc(rs.getString("bmjc"));
				dept.setTsbj(rs.getInt("tsbj"));
				dept.setPicture(rs.getString("picture"));
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return dept;
	}
	public String findDeptById(String bmbh) throws Exception{
		department dept = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String bmmc="";
		try {
			
			conn = DBConnection.getConnection();
			String sql = "select bmbh,bmmc,sjbmbh,sjbmmc,xthj,zjhj,ghrl,syrl,kxrl,ybmbh,chartdata,dwdz,bmjc,tsbj,picture from dwxx where bmbh="+bmbh ;
			
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				
				bmmc=rs.getString("bmmc").toString();
			
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return bmmc;
	}
	public ArrayList<department> findAllDepts(int pageSize, int pageNow) throws Exception {
		department dept = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<department> depts=new ArrayList<department>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select bmbh,bmmc,sjbmbh,sjbmmc,xthj,zjhj,ghrl,syrl,kxrl,ybmbh,chartdata,dwdz,bmjc,tsbj,picture from dwxx limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()){
				dept = new department();
				dept.setId(id);
				dept.setBmbh(rs.getInt("bmbh"));
				dept.setBmmc(rs.getString("bmmc"));
				dept.setSjbmbh(rs.getInt("sjbmbh"));
				dept.setSjbmmc(rs.getString("sjbmmc"));
				dept.setXthj(rs.getInt("xthj"));
				dept.setZjhj(rs.getInt("zjhj"));
				dept.setGhrl(rs.getDouble("ghrl"));
				dept.setSyrl(rs.getDouble("syrl"));
				dept.setKxrl(rs.getDouble("kxrl"));
				dept.setYbmbh(rs.getInt("ybmbh"));
				dept.setChartdata(rs.getString("chartdata"));
				dept.setDwdz(rs.getString("dwdz"));
				dept.setBmjc(rs.getString("bmjc"));
				dept.setTsbj(rs.getInt("tsbj"));
				dept.setPicture(rs.getString("picture"));
				depts.add(dept);
				id++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return depts;
	}
	
	public ArrayList<department> findAllDeptsByBMBH(int pageSize, int pageNow,int bmbh) throws Exception {
		department dept = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<department> depts=new ArrayList<department>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select bmbh,bmmc,sjbmbh,sjbmmc,xthj,zjhj,ghrl,syrl,kxrl,ybmbh,chartdata,dwdz,bmjc,tsbj,picture from dwxx where bmbh='"+bmbh+"' limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()){
				dept = new department();
				dept.setId(id);
				dept.setBmbh(rs.getInt("bmbh"));
				dept.setBmmc(rs.getString("bmmc"));
				dept.setSjbmbh(rs.getInt("sjbmbh"));
				dept.setSjbmmc(rs.getString("sjbmmc"));
				dept.setXthj(rs.getInt("xthj"));
				dept.setZjhj(rs.getInt("zjhj"));
				dept.setGhrl(rs.getDouble("ghrl"));
				dept.setSyrl(rs.getDouble("syrl"));
				dept.setKxrl(rs.getDouble("kxrl"));
				dept.setYbmbh(rs.getInt("ybmbh"));
				dept.setChartdata(rs.getString("chartdata"));
				dept.setDwdz(rs.getString("dwdz"));
				dept.setBmjc(rs.getString("bmjc"));
				dept.setTsbj(rs.getInt("tsbj"));
				dept.setPicture(rs.getString("picture"));
				depts.add(dept);
				id++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return depts;
	}
	

	public ArrayList<department> findAllDepts() throws Exception {
		department dept = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<department> depts=new ArrayList<department>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select bmbh,bmmc,sjbmbh,sjbmmc,xthj,zjhj,ghrl,syrl,kxrl,ybmbh,chartdata,dwdz,bmjc,tsbj,picture from dwxx ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()){
				dept = new department();
				dept.setId(id);
				dept.setBmbh(rs.getInt("bmbh"));
				dept.setBmmc(rs.getString("bmmc"));
				dept.setSjbmbh(rs.getInt("sjbmbh"));
				dept.setSjbmmc(rs.getString("sjbmmc"));
				dept.setXthj(rs.getInt("xthj"));
				dept.setZjhj(rs.getInt("zjhj"));
				dept.setGhrl(rs.getDouble("ghrl"));
				dept.setSyrl(rs.getDouble("syrl"));
				dept.setKxrl(rs.getDouble("kxrl"));
				dept.setYbmbh(rs.getInt("ybmbh"));
				dept.setChartdata(rs.getString("chartdata"));
				dept.setDwdz(rs.getString("dwdz"));
				dept.setBmjc(rs.getString("bmjc"));
				dept.setTsbj(rs.getInt("tsbj"));
				dept.setPicture(rs.getString("picture"));
				depts.add(dept);
				id++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return depts;
	}
public int sumb(int bmbh) throws Exception{
		
		int sumb=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				conn = DBConnection.getConnection();
				String sql = "select count(*) as sum from dwxx where bmbh="+bmbh ;
				ps=conn.prepareStatement(sql);
				
				rs=ps.executeQuery();
				if(rs.next()){
				 sumb=rs.getInt("sum");	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnection.close(rs, ps, conn);
			}
			
			
			
		return sumb;
	}
	
public int sumb() throws Exception{
		
		int sumb=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				conn = DBConnection.getConnection();
				String sql = "select count(*) as sum from dwxx" ;
				ps=conn.prepareStatement(sql);
				
				rs=ps.executeQuery();
				if(rs.next()){
				 sumb=rs.getInt("sum");	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnection.close(rs, ps, conn);
			}
			
			
			
		return sumb;
	}
	
	public void deleteDeptById(int id) throws Exception{
		Connection conn = null;
		
	    String sql = "delete from dwxx where bmbh=?";
	    PreparedStatement pstmt;
	    try {
	    	conn=DBConnection.getConnection();
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        System.out.println(id);
	        pstmt.setInt(1, id);
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	   
	}
	
	public void  insertUser(department u) throws Exception{
		Connection conn =null;
		
	   String sql = "insert into dwxx(bmbh,bmmc,sjbmbh,sjbmmc,xthj,zjhj,ghrl,syrl,kxrl,ybmbh,chartdata,dwdz,bmjc,tsbj,picture) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setInt(1, u.getBmbh());
	    pstmt.setString(2,u.getBmmc());
	   pstmt.setInt(3, u.getSjbmbh());
	   pstmt.setString(4, u.getSjbmmc());
	   pstmt.setInt(5, u.getXthj());
	   pstmt.setInt(6, u.getZjhj());
	   pstmt.setDouble(7, u.getGhrl());
	   pstmt.setDouble(8, u.getSyrl());
	   pstmt.setDouble(9, u.getKxrl());
	   pstmt.setInt(10, u.getYbmbh());
	   pstmt.setString(11, u.getChartdata());
	   pstmt.setString(12, u.getDwdz());
	   pstmt.setString(13, u.getBmjc());
	   pstmt.setInt(14, u.getTsbj());
	   pstmt.setString(15, u.getPicture());
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public void updateDept(department u) throws Exception{
		Connection conn =null;
		
	   //String sql = "update dwxx set bmbh=?,bmmc=?,sjbmbh=?,sjbmmc=?,xthj=?,zjhj=?,ghrl=?,syrl=?,kxrl=?,ybmbh=?,chartdata=?,dwdz=?,bmjc=?,tsbj=?  where bmbh=?";
	 	String sql="update dwxx set bmbh=?,bmmc=?,chartdata=?,dwdz=?,bmjc=?,picture=? where bmbh=?"; 
		conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setInt(1, u.getBmbh());
	    pstmt.setString(2,u.getBmmc());
	
	   pstmt.setString(3, u.getChartdata());
	   pstmt.setString(4, u.getDwdz());
	   pstmt.setString(5, u.getBmjc());
	   pstmt.setString(6, u.getPicture());
	   pstmt.setInt(7, u.getBmbh());
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public static void main(String[] args){
		departmentDao dpd=new departmentDao();
		try {
			department dept=new department();
			dept.setBmbh(1000);
			dept.setBmmc("测试部2");
			
			dpd.insertUser(dept);
			//dpd.updateDept(dept);
			//dpd.deleteDeptById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
