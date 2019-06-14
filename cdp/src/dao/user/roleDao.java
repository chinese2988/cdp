package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnect.DBConnection;
import entity.user.d_action;
import entity.user.d_role;


public class roleDao {
	public d_role findroleById(int id) throws Exception{
		d_role user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = DBConnection.getConnection();
			String sql = "select * from d_role where id=?" ;
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new d_role();
				user.setId(rs.getInt("id"));
				user.setRolecontent(rs.getString("rolecontent"));
				user.setRolename(rs.getString("rolename"));
				user.setRolestyle(rs.getInt("rolestyle"));
				user.setRolecontentdetail(rs.getString("rolecontentdetail"));
				user.setRolestyledetail(rs.getString("rolestyledetail"));
				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return user;
	}
	
	public ArrayList<d_role> findAllUser(int pageSize, int pageNow) throws Exception {
		d_role user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_role> users=new ArrayList<d_role>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_role limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new d_role();
				user.setId(rs.getInt("id"));
				user.setRolecontent(rs.getString("rolecontent"));
				user.setRolename(rs.getString("rolename"));
				user.setRolestyle(rs.getInt("rolestyle"));
				user.setRolecontentdetail(rs.getString("rolecontentdetail"));
				user.setRolestyledetail(rs.getString("rolestyledetail"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList<d_role> findAllRole(int pageSize, int pageNow) throws Exception {
		d_role user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_role> users=new ArrayList<d_role>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_role limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				user = new d_role();
				user.setId(rs.getInt("id"));
				user.setRolecontent(rs.getString("rolecontent"));
				user.setRolename(rs.getString("rolename"));
				user.setRolestyle(rs.getInt("rolestyle"));
				user.setRolecontentdetail(rs.getString("rolecontentdetail"));
				user.setRolestyledetail(rs.getString("rolestyledetail"));
				users.add(user);
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	

	public ArrayList<d_role> findAllUser() throws Exception {
		d_role user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_role> users=new ArrayList<d_role>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_role ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new d_role();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				user.setRolecontent(rs.getString("rolecontent"));
				user.setRolename(rs.getString("rolename"));
				user.setRolestyle(rs.getInt("rolestyle"));
				user.setRolecontentdetail(rs.getString("rolecontentdetail"));
				user.setRolestyledetail(rs.getString("rolestyledetail"));
				users.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList<d_role> findAllUserByPage(int pageSize, int pageNow) throws Exception {
		d_role user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_role> users=new ArrayList<d_role>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_role limit "+(pageNow*pageSize-pageSize)+","+pageSize;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new d_role();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				user.setRolecontent(rs.getString("rolecontent"));
				user.setRolename(rs.getString("rolename"));
				user.setRolestyle(rs.getInt("rolestyle"));
				user.setRolecontentdetail(rs.getString("rolecontentdetail"));
				user.setRolestyledetail(rs.getString("rolestyledetail"));
				users.add(user);
				xuhao++;
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
				String sql = "select count(*) as sum from d_role" ;
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
		
	    String sql = "delete from d_role where id='" +id+ "'";
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
		
	   String sql = "insert into d_role(rolename,rolecontent,rolestyle,rolecontentdetail,rolestyledetail) value(?,?,?,?,?)";
	 	  conn= DBConnection.getConnection();
	 	 System.out.println(u.getRolename());
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,u.getRolename());
	    pstmt.setString(2,u.getRolecontent());
	    pstmt.setInt(3,u.getRolestyle());
	    pstmt.setString(4,u.getRolecontentdetail());
	    pstmt.setString(5,u.getRolestyledetail());
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public void updateRole(d_role u) throws Exception{
		Connection conn =null;
		
	   String sql = "update d_role set rolename=?,rolecontent=?,rolestyle=?,rolestyledetail=? where id=?";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,u.getRolename());
	    pstmt.setString(2,u.getRolecontent());
	    pstmt.setInt(3,u.getRolestyle());
	    pstmt.setString(4,u.getRolestyledetail());
	    pstmt.setInt(5,u.getId());
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	
	public void  updateRolectiondetail(int  id) throws Exception{
		
		
		d_role r=new d_role();
		try {
			
			r=new roleDao().findroleById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String[] ro=r.getRolecontent().split(",");
		//END获取权限代码
		//查询权限名称
		d_action dac=new d_action();
		actionDao ad=new actionDao();
		String roleactiondetail="";
		for(int i=0;i<ro.length;i++){
			int p =Integer.parseInt(ro[i].toString());
			try {
				dac=ad.findDactionByParentId(p);//获取每一个action对象
				//拼接字符串获得描述
				roleactiondetail=roleactiondetail+","+dac.getActionname();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		roleactiondetail=roleactiondetail.substring(1);
		
		
		Connection conn =null;
		
	   String sql = "update d_role set rolecontentdetail=? where id=?";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,roleactiondetail);	 
	    pstmt.setInt(2, id);
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	
	
	
	
}
