package dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnect.DBConnection;
import entity.user.d_user;

public class userDao {
	public d_user findUserByUsernameAndPassword(d_user u) throws Exception {
		
		d_user user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select id,loginname,aes_decrypt(loginpassword,'zk') as loginpassword,name,telephone,bmbh,userroleid,userstat  from d_user where loginname=? and loginpassword = aes_encrypt(?,'zk')";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,u.getLoginname());
			ps.setString(2, u.getLoginpassword());
			rs=ps.executeQuery();
			if(rs.next()){
				user = new d_user();
				user.setId(rs.getInt("id"));
				user.setBmbh(rs.getInt("bmbh"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpassword(rs.getString("loginpassword"));
				user.setName(rs.getString("name"));
				user.setTelephone(rs.getString("telephone"));
				user.setUserroleid(rs.getInt("userroleid"));
				user.setUserstat(rs.getInt("userstat"));
			}
			
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return user;
	}
	
	public d_user findUserById(int id) throws Exception {
		d_user user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select id,loginname,aes_decrypt(loginpassword,'zk') as loginpassword,name,telephone,bmbh,userroleid,userstat  from d_user where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			rs=ps.executeQuery();
			if(rs.next()){
				user = new d_user();
				user.setId(rs.getInt("id"));
				user.setBmbh(rs.getInt("bmbh"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpassword(rs.getString("loginpassword"));
				user.setName(rs.getString("name"));
				user.setTelephone(rs.getString("telephone"));
				user.setUserroleid(rs.getInt("userroleid"));
				user.setUserstat(rs.getInt("userstat"));
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return user;
	}
		public boolean  updateUserPasswd(d_user u,String newpassword) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update d_user  set loginpassword=AES_ENCRYPT(?,'zk') where loginname=?";
			ps=conn.prepareStatement(sql);
	
			ps.setString(1, newpassword);
			ps.setString(2, u.getLoginname());
			ps.executeUpdate();
			
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return true;
		
	}
	
	public void updateUserById(d_user u) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "update d_user  set loginname=?,loginpassword=AES_ENCRYPT(?,'zk'),name=?,telephone=?,bmbh=?,userroleid=?,userstat=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getLoginname());
			ps.setString(2, u.getLoginpassword());
			ps.setString(3, u.getName());
			ps.setString(4,  u.getTelephone());
			ps.setInt(5,u.getBmbh());
			ps.setInt(6,u.getUserroleid());
			ps.setInt(7,u.getUserstat());
			ps.setInt(8,u.getId());
			ps.executeUpdate();
			
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		
	}
	public Boolean findUserByUsernameAndPasswd(d_user u) throws Exception {
		d_user user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select loginname from d_user where loginname=? and loginpassword=AES_ENCRYPT(?,'zk')";
			ps=conn.prepareStatement(sql);
			ps.setString(1,u.getLoginname());
			ps.setString(2,u.getLoginpassword());
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return false;
	}
	
	public Boolean findUserByUsername(d_user u) throws Exception {
		d_user user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select loginname from d_user where loginname=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,u.getLoginname());
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return false;
	}
	

	public ArrayList<d_user> findAllUser() throws Exception {
		d_user user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_user> users=new ArrayList<d_user>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_user ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new d_user();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				user.setBmbh(rs.getInt("bmbh"));
				user.setLoginname(rs.getString("loginname"));
				user.setName(rs.getString("name"));
				user.setTelephone(rs.getString("telephone"));
				user.setUserroleid(rs.getInt("userroleid"));
				user.setUserstat(rs.getInt("userstat"));
				
				users.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	
	public ArrayList<d_user> findAllUser(int pageSize, int pageNow) throws Exception {
		d_user user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<d_user> users=new ArrayList<d_user>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_user limit "+(pageNow*pageSize-pageSize)+","+pageSize;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new d_user();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				user.setBmbh(rs.getInt("bmbh"));
				user.setLoginname(rs.getString("loginname"));
				user.setName(rs.getString("name"));
				user.setTelephone(rs.getString("telephone"));
				user.setUserroleid(rs.getInt("userroleid"));
				user.setUserstat(rs.getInt("userstat"));
				
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
				String sql = "select count(*) as sum from d_user" ;
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
		
	    String sql = "delete from d_user where id='" +id+ "'";
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
	
	public void  insertUser(d_user u) throws Exception{
		Connection conn =null;
		
	   String sql = "insert into d_user(loginname,loginpassword,name,telephone,userroleid,bmbh,userstat) value(?,AES_ENCRYPT(?,'zk'),?,?,?,?,?)";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1,u.getLoginname());
	    pstmt.setString(2,u.getLoginpassword());
	    pstmt.setString(3,u.getName());
	    pstmt.setString(4,u.getTelephone());
	    pstmt.setInt(5,u.getUserroleid());
	    pstmt.setInt(6,u.getBmbh());
	    pstmt.setInt(7,u.getUserstat());
	    
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public static void main(String[] args){
		userDao ud=new userDao();
		d_user uer=new d_user();
		uer.setLoginname("feng");
		uer.setLoginpassword("zhangkai");
		uer.setName("");
		uer.setTelephone("");
		uer.setUserroleid(2000);
		uer.setBmbh(1);
	
		//ArrayList<d_user> users=new ArrayList<d_user>();
		try {	//ud.insertUser(uer);
			d_user	u=ud.findUserByUsernameAndPassword(uer);
//			users=ud.findAllUser();
//			
//			System.out.println(users.size());
			System.out.println(u.getId()+" "+u.getLoginpassword()+u.getName()+u.getLoginname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
