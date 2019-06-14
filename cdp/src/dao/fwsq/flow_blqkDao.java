package dao.fwsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import dbconnect.DBConnection;

import entity.fwsq.flow_blqk;

public class flow_blqkDao {
	public flow_blqk findflow_blqkById(String id) throws Exception{
		flow_blqk flow_blqk = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = (Connection) DBConnection.getConnection();
			String sql = "SELECT lcdm,sqdbh,lcmc,jddm,jdmc,kssj,jssj,zls,create_by,remarks FROM flow_blqk where lcdm =? " ;

			
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){

				flow_blqk = new flow_blqk();

				
				flow_blqk.setLcdm(rs.getString("lcdm"));  //流程代码
				flow_blqk.setSqdbh(rs.getString("sqdbh"));  //申请单编号
				flow_blqk.setLcmc(rs.getString("lcmc"));  //流程名称
				flow_blqk.setJddm(rs.getInt("jddm"));  //节点代码
				flow_blqk.setJdmc(rs.getString("jdmc"));  //节点名称
				flow_blqk.setKssj(rs.getString("kssj"));  //开始时间
				flow_blqk.setJssj(rs.getString("jssj"));  //结束时间
				flow_blqk.setZls(rs.getString("zls"));  //总历时
				flow_blqk.setCreate_by(rs.getString("create_by"));  //创建人
				flow_blqk.setRemarks(rs.getString("remarks"));  //备注

				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return flow_blqk;
	}

public ArrayList<flow_blqk>  findAllflow_blqk(int pageSize, int pageNow) throws Exception {
		flow_blqk flow_blqk = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<flow_blqk> flow_blqks=new ArrayList<flow_blqk>();
		try {
			conn = (Connection) DBConnection.getConnection();
			String sql = "SELECT lcdm,sqdbh,lcmc,jddm,jdmc,kssj,jssj,zls,create_by,remarks FROM flow_blqk limit "+(pageNow*pageSize-pageSize)+","+pageSize;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				flow_blqk = new flow_blqk();
			

				flow_blqk.setLcdm(rs.getString("lcdm"));  //流程代码
				flow_blqk.setSqdbh(rs.getString("sqdbh"));  //申请单编号
				flow_blqk.setLcmc(rs.getString("lcmc"));  //流程名称
				flow_blqk.setJddm(rs.getInt("jddm"));  //节点代码
				flow_blqk.setJdmc(rs.getString("jdmc"));  //节点名称
				flow_blqk.setKssj(rs.getString("kssj"));  //开始时间
				flow_blqk.setJssj(rs.getString("jssj"));  //结束时间
				flow_blqk.setZls(rs.getString("zls"));  //总历时
				flow_blqk.setCreate_by(rs.getString("create_by"));  //创建人
				flow_blqk.setRemarks(rs.getString("remarks"));  //备注

				
				flow_blqks.add(flow_blqk);
			
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return flow_blqks;
	}
	
public ArrayList<flow_blqk> findAllflow_blqk() throws Exception {
	flow_blqk flow_blqk = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<flow_blqk> flow_blqks =new ArrayList<flow_blqk>();
		try {
			conn = (Connection) DBConnection.getConnection();
		String sql = "SELECT lcdm,sqdbh,lcmc,jddm,jdmc,kssj,jssj,zls,create_by,remarks FROM flow_blqk ";
		
		
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				flow_blqk = new flow_blqk();
				

				flow_blqk.setLcdm(rs.getString("lcdm"));  //流程代码
				flow_blqk.setSqdbh(rs.getString("sqdbh"));  //申请单编号
				flow_blqk.setLcmc(rs.getString("lcmc"));  //流程名称
				flow_blqk.setJddm(rs.getInt("jddm"));  //节点代码
				flow_blqk.setJdmc(rs.getString("jdmc"));  //节点名称
				flow_blqk.setKssj(rs.getString("kssj"));  //开始时间
				flow_blqk.setJssj(rs.getString("jssj"));  //结束时间
				flow_blqk.setZls(rs.getString("zls"));  //总历时
				flow_blqk.setCreate_by(rs.getString("create_by"));  //创建人
				flow_blqk.setRemarks(rs.getString("remarks"));  //备注

				
				flow_blqks.add(flow_blqk);

			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return  flow_blqks;
	}

public void deleteflow_blqkById(int id) throws Exception{
		Connection conn = null;
		
	    String sql = "DELETE FROM flow_blqk ";//--带int型主键的条件
			
	    PreparedStatement pstmt;
	    try {
	    	conn=(Connection) DBConnection.getConnection();
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
	
	public void  insertflow_blqk(flow_blqk flow_blqk) throws Exception{
		Connection conn =null;
		
	   String sql = "INSERT INTO flow_blqk(lcdm,sqdbh,lcmc,jddm,jdmc,kssj,jssj,zls,create_by,remarks) VALUES(?,?,?,?,?,?,?,?,?,?)";
	 	  conn= (Connection) DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
		            pstmt.setString(1, flow_blqk.getLcdm());//流程代码
		pstmt.setString(2, flow_blqk.getSqdbh());//申请单编号
		pstmt.setString(3, flow_blqk.getLcmc());//流程名称
		pstmt.setInt(4, flow_blqk.getJddm());//节点代码
		pstmt.setString(5, flow_blqk.getJdmc());//节点名称
		pstmt.setString(6, flow_blqk.getKssj());//开始时间
		pstmt.setString(7, flow_blqk.getJssj());//结束时间
		pstmt.setString(8, flow_blqk.getZls());//总历时
		pstmt.setString(9, flow_blqk.getCreate_by());//创建人
		pstmt.setString(10, flow_blqk.getRemarks());//备注

		  //  遍历生成 flow_blqk.get字段
	   
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	
	
	public void  insertflow_blqkWithFwsqb(String lcdm,String create_by,String sqdbh) throws Exception{
		Connection conn =null;
		
	   String sql = "INSERT INTO flow_blqk (lcdm,sqdbh,lcmc, jddm, jdmc, kssj, jssj,zls, create_by, remarks)" +
	   		"SELECT	a.lcdm as lcdm,	a.sqdbh as sqdbh,	b.lcmc as lcdm,	a.jddm as jddm,	b.jdmc as jdmc,	a.create_date as kssj,	Now() as jssj," +
	   		"	c.zls as zls,	'"+create_by+"' as create_by,'Null' as remarks FROM	fwsqb a,	flow_config b,(SELECT" +
	   		"			sqdbh,CONCAT(CONCAT(aa DIV(3600 * 24), '天'),CONCAT(aa MOD (3600 * 24) DIV 3600," +
	   		"					'小时'),CONCAT(aa MOD(3600) DIV 60, '分'),CONCAT(aa MOD(60), '秒')) zls		FROM" +
	   		"			(SELECT					sqdbh,TIMESTAMPDIFF(SECOND,	fwsqb.create_date,NOW()) AS aa	FROM" +
	   		"					fwsqb		where sqdbh='"+sqdbh+"'	) c	) c  WHERE	b.lcdm = '"+lcdm+"' AND b.jddm = 1 AND a.sqdbh = c.sqdbh";
	 	  conn= (Connection) DBConnection.getConnection();
	    PreparedStatement pstmt;
	    System.out.println(sql);
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
		         
		  //  遍历生成 flow_blqk.get字段
	   
	    pstmt.execute();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public void updateflow_blqk(flow_blqk flow_blqk) throws Exception{
		Connection conn =null;
		
	   String sql = "UPDATE flow_blqk SET lcdm = ?,sqdbh = ?,lcmc = ?,jddm = ?,jdmc = ?,kssj = ?,jssj = ?,zls = ?,create_by = ?,remarks = ?";
	 	  conn= (Connection) DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
             pstmt.setString(1, flow_blqk.getLcdm());//流程代码
				pstmt.setString(2, flow_blqk.getSqdbh());//申请单编号
				pstmt.setString(3, flow_blqk.getLcmc());//流程名称
				pstmt.setInt(4, flow_blqk.getJddm());//节点代码
				pstmt.setString(5, flow_blqk.getJdmc());//节点名称
				pstmt.setString(6, flow_blqk.getKssj());//开始时间
				pstmt.setString(7, flow_blqk.getJssj());//结束时间
				pstmt.setString(8, flow_blqk.getZls());//总历时
				pstmt.setString(9, flow_blqk.getCreate_by());//创建人
				pstmt.setString(10, flow_blqk.getRemarks());//备注


	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	
	public static void main(String[] args){
		flow_blqkDao fbd=new flow_blqkDao();
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
