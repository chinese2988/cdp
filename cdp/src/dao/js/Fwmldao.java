package dao.js;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.user.actionDao;
import dbconnect.DBConnection;
import entity.js.fwml;
import entity.user.d_role;


public class Fwmldao {
	public ArrayList<fwml> findAllFwml(int pageSize, int pageNow) throws Exception {
		fwml user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<fwml> users=new ArrayList<fwml>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from fwml limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()){
				user = new fwml();
				user.setId(id);
				user.setBffs(rs.getString("bffs"));
				user.setFwdj(rs.getString("fwdj"));
				user.setFwmldm(rs.getString("fwmldm"));
				user.setFwmllx(rs.getString("fwmllx"));
				user.setFwmlmc(rs.getString("fwmlmc"));
				user.setJfbz(rs.getString("jfbz"));
				user.setJjdw(rs.getString("jjdw"));
				user.setRemarks(rs.getString("remarks"));
				user.setRpo(rs.getString("rpo"));
				user.setRto(rs.getString("rto"));
				users.add(user);
				id++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	

	public ArrayList<fwml> findAllFwml() throws Exception {
		fwml user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<fwml> users=new ArrayList<fwml>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from fwml ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()){
				user = new fwml();
				user.setId(id);
				user.setBffs(rs.getString("bffs"));
				user.setFwdj(rs.getString("fwdj"));
				user.setFwmldm(rs.getString("fwmldm"));
				user.setFwmllx(rs.getString("fwmllx"));
				user.setFwmlmc(rs.getString("fwmlmc"));
				user.setJfbz(rs.getString("jfbz"));
				user.setJjdw(rs.getString("jjdw"));
				user.setRemarks(rs.getString("remarks"));
				user.setRpo(rs.getString("rpo"));
				user.setRto(rs.getString("rto"));
				users.add(user);
				id++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	
	
	public ArrayList<fwml> findAllByFwmldm(String id) throws Exception {
		fwml user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<fwml> users=new ArrayList<fwml>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from fwml where fwmldm=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new fwml();
				user.setBffs(rs.getString("bffs"));
				user.setFwdj(rs.getString("fwdj"));
				user.setFwmldm(rs.getString("fwmldm"));
				user.setFwmllx(rs.getString("fwmllx"));
				user.setFwmlmc(rs.getString("fwmlmc"));
				user.setJfbz(rs.getString("jfbz"));
				user.setJjdw(rs.getString("jjdw"));
				user.setRemarks(rs.getString("remarks"));
				user.setRpo(rs.getString("rpo"));
				user.setRto(rs.getString("rto"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public fwml findFwulByFwmldm(String id) throws Exception {
		fwml user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from fwml where fwmldm=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new fwml();
				user.setBffs(rs.getString("bffs"));
				user.setFwdj(rs.getString("fwdj"));
				user.setFwmldm(rs.getString("fwmldm"));
				user.setFwmllx(rs.getString("fwmllx"));
				user.setFwmlmc(rs.getString("fwmlmc"));
				user.setJfbz(rs.getString("jfbz"));
				user.setJjdw(rs.getString("jjdw"));
				user.setRemarks(rs.getString("remarks"));
				user.setRpo(rs.getString("rpo"));
				user.setRto(rs.getString("rto"));
				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return user;
	}
	
	
public int sumb() throws Exception{
		
		int sumb=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				conn = DBConnection.getConnection();
				String sql = "select count(*) as sum from fwml" ;
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
	
	public void deleteFwmlById(String id) throws Exception{
		Connection conn = null;
		
	    String sql = "delete from fwml where fwmldm='" +id+ "'";
	    PreparedStatement pstmt;
	    try {
	    	conn=DBConnection.getConnection();
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	   
	}
	
	public void  insertFwml(fwml u) throws Exception{
		Connection conn =null;
		
	   String sql = "insert into fwml value(?,?,?,?,?,?,?,?,?,?)";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,u.getFwmllx());
	    pstmt.setString(2,u.getFwmldm());
	    pstmt.setString(3,u.getFwmlmc());
	    pstmt.setString(4,u.getRto());
	    pstmt.setString(5,u.getRpo());
	    pstmt.setString(6,u.getBffs());
	    pstmt.setString(7,u.getJfbz());
	    pstmt.setString(8,u.getFwdj());
	    pstmt.setString(9,u.getJjdw());
	    pstmt.setString(10,u.getRemarks());
	  
	   
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public void  udpateFwml(fwml u) throws Exception{
		Connection conn =null;
		
	   String sql = "udpate  fwml set fwmllx=?,fwmldm=?,fwmlmc=?,rto=?,rpo=?,bffs=?,jfbz=?,fwdj=?,jjdw=?,remarks=? where fwmldm="+u.getFwmldm();
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,u.getFwmllx());
	    pstmt.setString(2,u.getFwmldm());
	    pstmt.setString(3,u.getFwmlmc());
	    pstmt.setString(4,u.getRto());
	    pstmt.setString(5,u.getRpo());
	    pstmt.setString(6,u.getBffs());
	    pstmt.setString(7,u.getJfbz());
	    pstmt.setString(8,u.getFwdj());
	    pstmt.setString(9,u.getJjdw());
	    pstmt.setString(10,u.getRemarks());
	  
	   
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public static void main(String[] args){
		actionDao ad=new actionDao();
		
	}
}
