package dao.js;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconnect.DBConnection;
import entity.js.xtxx_yz;


public class XtxxyzDao {
	public ArrayList<xtxx_yz> findAllxtxx_yz(int pageSize, int pageNow) throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<xtxx_yz> users=new ArrayList<xtxx_yz>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from xtxx_yz limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new xtxx_yz();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				 user.setXtbh(rs.getString("xtbh")) 		  ;
				 user.setXtmc(rs.getString("xtmc")) 		  ;
				 user.setHtkssj(rs.getInt("htkssj"))		  ;
				 user.setHtjssj(rs.getInt("htjssj")) 		  ;
				 user.setDwbh(rs.getString("dwbh"))		  ;
				 user.setDwmc(rs.getString("dwmc")) 		  ;
				 user.setFwmldm(rs.getString("fwmldm"))		  ;
				 user.setFwmlmc(rs.getString("fwmlmc")) 		  ;
				 user.setFwdj(rs.getDouble("fwdj")) 		  ;
				 user.setFwys(rs.getDouble("fwys"))		  ;
				 user.setFwjghj(rs.getDouble("fwjghj"))		  ;
				 user.setZjhj(rs.getInt("zjhj")) 		  ;
				 user.setGhrl(rs.getDouble("ghrl"))		  ;
				 user.setSyrl(rs.getDouble("syrl"))		  ;
				 user.setKxrl(rs.getDouble("kxrl"))		  ;
				 user.setBfcl(rs.getString("bfcl"))		  ;
				 user.setCcwz(rs.getString("ccwz"))		  ;
				 user.setBlqx(rs.getString("blqx")) 		  ;
				 user.setPXH(rs.getInt("pXH")) 			  ;
				 user.setTjsj(rs.getInt("tjsj")) 		  ;
				 user.setUpdate_type(rs.getString("update_type"))  ;
				 user.setCreate_by(rs.getString("create_by"))	  ;
				 user.setCreate_date(rs.getString("create_date"))  ;
				 users.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList<xtxx_yz> findAllxtxx_yz(int pageSize, int pageNow,String htkssj) throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<xtxx_yz> users=new ArrayList<xtxx_yz>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from xtxx_yz where tjsj='"+htkssj+"' limit "+(pageNow*pageSize-pageSize)+","+pageSize ;  //根据统计期号
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new xtxx_yz();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				 user.setXtbh(rs.getString("xtbh")) 		  ;
				 user.setXtmc(rs.getString("xtmc")) 		  ;
				 user.setHtkssj(rs.getInt("htkssj"))		  ;
				 user.setHtjssj(rs.getInt("htjssj")) 		  ;
				 user.setDwbh(rs.getString("dwbh"))		  ;
				 user.setDwmc(rs.getString("dwmc")) 		  ;
				 user.setFwmldm(rs.getString("fwmldm"))		  ;
				 user.setFwmlmc(rs.getString("fwmlmc")) 		  ;
				 user.setFwdj(rs.getDouble("fwdj")) 		  ;
				 user.setFwys(rs.getDouble("fwys"))		  ;
				 user.setFwjghj(rs.getDouble("fwjghj"))		  ;
				 user.setZjhj(rs.getInt("zjhj")) 		  ;
				 user.setGhrl(rs.getDouble("ghrl"))		  ;
				 user.setSyrl(rs.getDouble("syrl"))		  ;
				 user.setKxrl(rs.getDouble("kxrl"))		  ;
				 user.setBfcl(rs.getString("bfcl"))		  ;
				 user.setCcwz(rs.getString("ccwz"))		  ;
				 user.setBlqx(rs.getString("blqx")) 		  ;
				 user.setPXH(rs.getInt("pXH")) 			  ;
				 user.setTjsj(rs.getInt("tjsj")) 		  ;
				 user.setUpdate_type(rs.getString("update_type"))  ;
				 user.setCreate_by(rs.getString("create_by"))	  ;
				 user.setCreate_date(rs.getString("create_date"))  ;
				 users.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList<xtxx_yz> findAllxtxx_yz() throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<xtxx_yz> users=new ArrayList<xtxx_yz>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from xtxx_yz ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new xtxx_yz();
				user.setXuhao(xuhao);
				user.setId(rs.getInt("id"));
				 user.setXtbh(rs.getString("xtbh")) 		  ;
				 user.setXtmc(rs.getString("xtmc")) 		  ;
				 user.setHtkssj(rs.getInt("htkssj"))		  ;
				 user.setHtjssj(rs.getInt("htjssj")) 		  ;
				 user.setDwbh(rs.getString("dwbh"))		  ;
				 user.setDwmc(rs.getString("dwmc")) 		  ;
				 user.setFwmldm(rs.getString("fwmldm"))		  ;
				 user.setFwmlmc(rs.getString("fwmlmc")) 		  ;
				 user.setFwdj(rs.getDouble("fwdj")) 		  ;
				 user.setFwys(rs.getDouble("fwys"))		  ;
				 user.setFwjghj(rs.getDouble("fwjghj"))		  ;
				 user.setZjhj(rs.getInt("zjhj")) 		  ;
				 user.setGhrl(rs.getDouble("ghrl"))		  ;
				 user.setSyrl(rs.getDouble("syrl"))		  ;
				 user.setKxrl(rs.getDouble("kxrl"))		  ;
				 user.setBfcl(rs.getString("bfcl"))		  ;
				 user.setCcwz(rs.getString("ccwz"))		  ;
				 user.setBlqx(rs.getString("blqx")) 		  ;
				 user.setPXH(rs.getInt("pXH")) 			  ;
				 user.setTjsj(rs.getInt("tjsj")) 		  ;
				 user.setUpdate_type(rs.getString("update_type"))  ;
				 user.setCreate_by(rs.getString("create_by"))	  ;
				 user.setCreate_date(rs.getString("create_date"))  ;
				users.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	
	public ArrayList<xtxx_yz> findAllxtxx_yzDWXX() throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<xtxx_yz> users=new ArrayList<xtxx_yz>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select DISTINCT dwmc,xtmc,tjsj from xtxx_yz ORDER BY dwmc ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				user = new xtxx_yz();
				user.setDwmc(rs.getString("dwmc"))		  ;
				 user.setXtmc(rs.getString("xtmc")) 		  ;
				 user.setTjsj(rs.getInt("tjsj"))		  ;
				users.add(user);
				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	//查询统计时间
	public ArrayList<xtxx_yz> findAllxtxxyzHTKSSJ() throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<xtxx_yz> users=new ArrayList<xtxx_yz>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select DISTINCT tjsj from xtxx_yz  ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				user = new xtxx_yz();
				 user.setTjsj(rs.getInt("tjsj"))		  ;
				users.add(user);
				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return users;
	}
	//查询合同某一期的费用
	public String findSUMxtxxyzBYHTKSSJ(String tjsj) throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<xtxx_yz> users=new ArrayList<xtxx_yz>();
		String sumcost="";
		try {
			conn = DBConnection.getConnection();
			String sql = "select sum(fwjghj) as cost  from xtxx_yz where tjsj='"+tjsj+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()){
				sumcost=rs.getString("cost");
				}
			
			
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return sumcost;
	}
	
	public xtxx_yz findFwulByxtxx_yzdm(String id) throws Exception {
		xtxx_yz user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from xtxx_yz where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				user = new xtxx_yz();
				user.setId(rs.getInt("id"));
				 user.setXtbh(rs.getString("xtbh")) 		  ;
				 user.setXtmc(rs.getString("xtmc")) 		  ;
				 user.setHtkssj(rs.getInt(" htkssj"))		  ;
				 user.setHtjssj(rs.getInt(" htjssj")) 		  ;
				 user.setDwbh(rs.getString("dwbh"))		  ;
				 user.setDwmc(rs.getString("dwmc")) 		  ;
				 user.setFwmldm(rs.getString("fwmldm"))		  ;
				 user.setFwmlmc(rs.getString("fwmlmc")) 		  ;
				 user.setFwdj(rs.getDouble("fwdj")) 		  ;
				 user.setFwys(rs.getDouble(" fwys"))		  ;
				 user.setFwjghj(rs.getDouble(" fwjghj"))		  ;
				 user.setZjhj(rs.getInt(" zjhj")) 		  ;
				 user.setGhrl(rs.getDouble(" ghrl"))		  ;
				 user.setSyrl(rs.getDouble(" syrl"))		  ;
				 user.setKxrl(rs.getDouble(" kxrl"))		  ;
				 user.setBfcl(rs.getString("bfcl"))		  ;
				 user.setCcwz(rs.getString("ccwz"))		  ;
				 user.setBlqx(rs.getString("blqx")) 		  ;
				 user.setPXH(rs.getInt(" pXH")) 			  ;
				 user.setTjsj(rs.getInt(" tjsj")) 		  ;
				 user.setUpdate_type(rs.getString("update_type"))  ;
				 user.setCreate_by(rs.getString("create_by"))	  ;
				 user.setCreate_date(rs.getString("create_date"))  ;
				
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
				String sql = "select count(*) as sum from xtxx_yz ";
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
public int sumb(String htkssj) throws Exception{
	
	int sumb=0;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(*) as sum from xtxx_yz where tjsj='"+htkssj+"'" ;
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
public static  void main(String[] args){
	XtxxyzDao xdao=new XtxxyzDao();
	String cost;
	try {
		cost=xdao.findSUMxtxxyzBYHTKSSJ("20181201");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
