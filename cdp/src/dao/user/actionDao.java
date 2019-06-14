package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnect.DBConnection;
import entity.user.d_action;
import entity.user.d_role;


public class actionDao {
	public ArrayList<d_action> findAllUser(int pageSize, int pageNow) throws Exception {
		d_action user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_action> users=new ArrayList<d_action>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_action limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new d_action();
				user.setId(rs.getInt("id"));
				user.setActiondetail(rs.getString("actiondetail"));
				user.setActionname(rs.getString("actionname"));
				user.setParentid(rs.getInt("parentid"));
				user.setStrutsaction(rs.getString("strutsaction"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	

	public ArrayList<d_action> findAllUser() throws Exception {
		d_action user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_action> users=new ArrayList<d_action>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_action ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new d_action();
				user.setId(rs.getInt("id"));
				user.setActiondetail(rs.getString("actiondetail"));
				user.setActionname(rs.getString("actionname"));
				user.setParentid(rs.getInt("parentid"));
				user.setStrutsaction(rs.getString("strutsaction"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList findAllparentId() throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList users=new ArrayList();
		try {
			conn = DBConnection.getConnection();
			String sql = "select DISTINCT(parentid) as parentid from d_action where parentid is not null; ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int parentid=rs.getInt("parentid");
				
				
				users.add(parentid);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList<d_action> findAllByParentId(int id) throws Exception {
		d_action user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_action> users=new ArrayList<d_action>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_action where parentid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new d_action();
				user.setId(rs.getInt("id"));
				user.setActiondetail(rs.getString("actiondetail"));
				user.setActionname(rs.getString("actionname"));
				user.setParentid(rs.getInt("parentid"));
				user.setStrutsaction(rs.getString("strutsaction"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public d_action findDactionByParentId(int id) throws Exception {
		d_action user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_action where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new d_action();
				user.setId(rs.getInt("id"));
				user.setActiondetail(rs.getString("actiondetail"));
				user.setActionname(rs.getString("actionname"));
				user.setParentid(rs.getInt("parentid"));
				user.setStrutsaction(rs.getString("strutsaction"));
				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return user;
	}
	
	public ArrayList findparentIdS() throws Exception {
		d_action user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_action> users=new ArrayList<d_action>();
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT a.parentid as parentid,b.actionname  as actionname ,strutsaction FROM (select DISTINCT(parentid) as parentid from d_action where parentid is not null) a LEFT JOIN d_action b on a.parentid=b.id ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				user=new d_action();
				user.setParentid(rs.getInt("parentid"));
				user.setActionname(rs.getString("actionname"));
				user.setStrutsaction(rs.getString("strutsaction"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
public int sumb() throws Exception{
		
		int sumb=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				conn = DBConnection.getConnection();
				String sql = "select count(*) as sum from d_action" ;
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
	
	public void deleteUserById(int id) throws Exception{
		Connection conn = null;
		
	    String sql = "delete from d_action where id='" +id+ "'";
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
	
	public void  insertUser(d_role u) throws Exception{
		Connection conn =null;
		
	   String sql = "insert into d_action value(?,?)";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,u.getRolename());
	    pstmt.setString(2,u.getRolecontent());
	  
	   
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public static void main(String[] args){
		actionDao ad=new actionDao();
		
	}
}
