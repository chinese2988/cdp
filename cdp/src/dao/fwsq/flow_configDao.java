package dao.fwsq;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import dbconnect.DBConnection;
import entity.fwsq.flow_config;

public class flow_configDao {
	public flow_config findflow_configById(int id) throws Exception{
		flow_config flow_config = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			conn = DBConnection.getConnection();
			String sql = "SELECT id,lcdm,lcmc,jddm,jdmc,dqjs,dbjs,bjbz,create_by,update_by,remarks,create_date,update_date FROM flow_config where id ="+id ;

			
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){

				flow_config = new flow_config();

			
				flow_config.setId(rs.getInt("id"));  //主键
				flow_config.setLcdm(rs.getString("lcdm"));  //流程代码
				flow_config.setLcmc(rs.getString("lcmc"));  //流程名称
				flow_config.setJddm(rs.getInt("jddm"));  //节点代码
				flow_config.setJdmc(rs.getString("jdmc"));  //节点名称
				flow_config.setDqjs(rs.getString("dqjs"));  //待签角色（多个用,分割）
				flow_config.setDbjs(rs.getString("dbjs"));  //待办角色（多个用,分割）
				flow_config.setBjbz(rs.getString("bjbz"));  //办结标志
				flow_config.setCreate_by(rs.getString("create_by"));  //创建人
				flow_config.setUpdate_by(rs.getString("update_by"));  //修改人
				flow_config.setRemarks(rs.getString("remarks"));  //备注
				flow_config.setCreate_date(rs.getString("create_date"));  //创建时间
				flow_config.setUpdate_date(rs.getString("update_date"));  //修改时间

				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return flow_config;
	}

public ArrayList<flow_config>  findAllflow_config(int pageSize, int pageNow) throws Exception {
		flow_config flow_config = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<flow_config> flow_configs =new ArrayList<flow_config>();
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT id,lcdm,lcmc,jddm,jdmc,dqjs,dbjs,bjbz,create_by,update_by,remarks,create_date,update_date FROM flow_config limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=(PreparedStatement) conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				flow_config = new flow_config();


				flow_config.setId(rs.getInt("id"));  //主键
				flow_config.setLcdm(rs.getString("lcdm"));  //流程代码
				flow_config.setLcmc(rs.getString("lcmc"));  //流程名称
				flow_config.setJddm(rs.getInt("jddm"));  //节点代码
				flow_config.setJdmc(rs.getString("jdmc"));  //节点名称
				flow_config.setDqjs(rs.getString("dqjs"));  //待签角色（多个用,分割）
				flow_config.setDbjs(rs.getString("dbjs"));  //待办角色（多个用,分割）
				flow_config.setBjbz(rs.getString("bjbz"));  //办结标志
				flow_config.setCreate_by(rs.getString("create_by"));  //创建人
				flow_config.setUpdate_by(rs.getString("update_by"));  //修改人
				flow_config.setRemarks(rs.getString("remarks"));  //备注
				flow_config.setCreate_date(rs.getString("create_date"));  //创建时间
				flow_config.setUpdate_date(rs.getString("update_date"));  //修改时间

				
				flow_configs.add(flow_config);
				
				
		
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return flow_configs ;
	}
	
public ArrayList<flow_config> findAllflow_config() throws Exception {
	flow_config flow_config = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<flow_config> flow_configs =new ArrayList<flow_config>();
		try {
			conn = DBConnection.getConnection();
		String sql = "SELECT id,lcdm,lcmc,jddm,jdmc,dqjs,dbjs,bjbz,create_by,update_by,remarks,create_date,update_date FROM flow_config ";
		
		
			ps=(PreparedStatement) conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int id=1;
			while(rs.next()){
				flow_config = new flow_config();
				flow_config.setId(id);

				flow_config.setId(id);

				flow_config.setId(rs.getInt("id"));  //主键
				flow_config.setLcdm(rs.getString("lcdm"));  //流程代码
				flow_config.setLcmc(rs.getString("lcmc"));  //流程名称
				flow_config.setJddm(rs.getInt("jddm"));  //节点代码
				flow_config.setJdmc(rs.getString("jdmc"));  //节点名称
				flow_config.setDqjs(rs.getString("dqjs"));  //待签角色（多个用,分割）
				flow_config.setDbjs(rs.getString("dbjs"));  //待办角色（多个用,分割）
				flow_config.setBjbz(rs.getString("bjbz"));  //办结标志
				flow_config.setCreate_by(rs.getString("create_by"));  //创建人
				flow_config.setUpdate_by(rs.getString("update_by"));  //修改人
				flow_config.setRemarks(rs.getString("remarks"));  //备注
				flow_config.setCreate_date(rs.getString("create_date"));  //创建时间
				flow_config.setUpdate_date(rs.getString("update_date"));  //修改时间

				
				flow_configs.add(flow_config);

				id++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return  flow_configs ;
	}

public void deleteflow_configById(int id) throws Exception{
		Connection conn = null;
		
	    String sql = "DELETE FROM flow_config where dwbh = "+id;//--带int型主键的条件
			
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
	
	public void  insertflow_config(flow_config flow_config) throws Exception{
		Connection conn =null;
		
	   String sql = "INSERT INTO flow_config(id,lcdm,lcmc,jddm,jdmc,dqjs,dbjs,bjbz,create_by,update_by,remarks,create_date,update_date)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, flow_config.getId());//主键
			pstmt.setString(2, flow_config.getLcdm());//流程代码
			pstmt.setString(3, flow_config.getLcmc());//流程名称
			pstmt.setInt(4, flow_config.getJddm());//节点代码
			pstmt.setString(5, flow_config.getJdmc());//节点名称
			pstmt.setString(6, flow_config.getDqjs());//待签角色（多个用,分割）
			pstmt.setString(7, flow_config.getDbjs());//待办角色（多个用,分割）
			pstmt.setString(8, flow_config.getBjbz());//办结标志
			pstmt.setString(9, flow_config.getCreate_by());//创建人
			pstmt.setString(10, flow_config.getUpdate_by());//修改人
			pstmt.setString(11, flow_config.getRemarks());//备注
			pstmt.setString(12, flow_config.getCreate_date());//创建时间
			pstmt.setString(13, flow_config.getUpdate_date());//修改时间

		  //  遍历生成 flow_config.get字段
	   
	    pstmt.executeUpdate();
	    pstmt.close();
	    conn.close();
	    DBConnection.close( pstmt, conn);
		
	
	    
	}
	public void updateflow_config(flow_config flow_config) throws Exception{
		Connection conn =null;
		
	   String sql = "UPDATE flow_config SET id = ?,lcdm = ?,lcmc = ?,jddm = ?,jdmc = ?,dqjs = ?,dbjs = ?,bjbz = ?,create_by = ?,update_by = ?,remarks = ?,create_date = ?,update_date = ?";
	 	  conn= DBConnection.getConnection();
	    PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
             pstmt.setInt(1, flow_config.getId());//主键
				pstmt.setString(2, flow_config.getLcdm());//流程代码
				pstmt.setString(3, flow_config.getLcmc());//流程名称
				pstmt.setInt(4, flow_config.getJddm());//节点代码
				pstmt.setString(5, flow_config.getJdmc());//节点名称
				pstmt.setString(6, flow_config.getDqjs());//待签角色（多个用,分割）
				pstmt.setString(7, flow_config.getDbjs());//待办角色（多个用,分割）
				pstmt.setString(8, flow_config.getBjbz());//办结标志
				pstmt.setString(9, flow_config.getCreate_by());//创建人
				pstmt.setString(10, flow_config.getUpdate_by());//修改人
				pstmt.setString(11, flow_config.getRemarks());//备注
				pstmt.setString(12, flow_config.getCreate_date());//创建时间
				pstmt.setString(13, flow_config.getUpdate_date());//修改时间
				    pstmt.executeUpdate();
				    pstmt.close();
				    conn.close();
				    DBConnection.close( pstmt, conn);
		
	
	    
	}
	
	
	
}
