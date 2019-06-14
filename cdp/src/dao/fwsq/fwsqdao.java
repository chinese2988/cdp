package dao.fwsq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconnect.DBConnection;
import entity.fwsq.flow_config;
import entity.fwsq.fwsqb;
import entity.fwsq.fwsqbcx;
import entity.fwsq.xtxx;
import entity.user.d_role;
import entity.user.department;


public class fwsqdao {
	
	
	public ArrayList<fwsqbcx> findAllUser(int pageSize, int pageNow) throws Exception {
		fwsqbcx user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select  *   from fwsqb  limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new fwsqbcx();
				user.setXuhao(xuhao);
				user.setSqdbh(rs.getString("sqdbh"));
				user.setBmbh(rs.getString("bmbh"));
				user.setBmmc(rs.getString("bmmc"));
				user.setXtbh(rs.getString("xtbh"));
				user.setXtmc(rs.getString("xtmc"));
				user.setLcdm(rs.getString("lcdm"));
				user.setBjbz(rs.getString("bjbz"));
				user.setCcwz(rs.getString("ccwz"));
				user.setCreate_by(rs.getString("create_by"));
				user.setCreate_date(rs.getString("create_date"));
				user.setSystem_dep_location(rs.getString("system_dep_location"));
				fwsqbs.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return fwsqbs;
	}
	
	//联合查询出服务申请情况
	public ArrayList<fwsqbcx> findAllUser(int pageSize, int pageNow,String bmbh) throws Exception {
		fwsqbcx user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select  *   from fwsqb  where  bmbh= "+bmbh +" limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int xuhao=1;
			while(rs.next()){
				user = new fwsqbcx();
				user.setXuhao(xuhao);
				user.setSqdbh(rs.getString("sqdbh"));
				user.setBmbh(rs.getString("bmbh"));
				user.setBmmc(rs.getString("bmmc"));
				user.setXtbh(rs.getString("xtbh"));
				user.setXtmc(rs.getString("xtmc"));
				user.setLcdm(rs.getString("lcdm"));
				user.setBjbz(rs.getString("bjbz"));
				user.setCcwz(rs.getString("ccwz"));
				user.setCreate_by(rs.getString("create_by"));
				user.setCreate_date(rs.getString("create_date"));
				user.setSystem_dep_location(rs.getString("system_dep_location"));
				fwsqbs.add(user);
				xuhao++;
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return fwsqbs;
	}
	//联合查询出服务申请流程情况 依据部门编号
		public ArrayList<fwsqbcx> findAllLCMC(String bmbh) throws Exception {
			fwsqbcx user = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select  distinct b.lcmc as lcmc    from fwsqb a,flow_blqk b,xtxx c where a.sqdbh=b.sqdbh and a.xtbh=c.xtbh and a.bmbh= "+bmbh  ;
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()){
					user = new fwsqbcx();
					
					user.setLcmc(rs.getString("lcmc"));
					
					fwsqbs.add(user);
					
				}
			} finally {
				DBConnection.close(rs, ps, conn);
			}
			return fwsqbs;
		}
	
	//单表查询出服务申请详细情况
	
	
	
	//
public int sumb(String bmbh) throws Exception{
		
		int sumb=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			try {
				conn = DBConnection.getConnection();
				String sql = "select count(*) as sum from (select  b.sqdbh as sqdbh,a.bmmc as bmmc,a.xtmc as xtmc ,b.lcmc as lcmc,a.create_date as create_date,a.create_by as create_by,c.system_dep_location as system_dep_location   from fwsqb a,flow_blqk b,xtxx c where a.sqdbh=b.sqdbh and a.xtbh=c.xtbh and a.bmbh="+bmbh+") a" ;
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


//通过部门编号查询服务申请中的部门
	public ArrayList<fwsqbcx> findAllBMMCbybmbh(String bmbh) throws Exception {
		fwsqbcx user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select  distinct a.bmmc as bmmc    from fwsqb a where  a.bmbh= "+bmbh  ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				user = new fwsqbcx();
				user.setBmmc(rs.getString("bmmc"));
				
				fwsqbs.add(user);
				
			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return fwsqbs;
	}

	//通过部门编号查询服务申请中的系统
		public ArrayList<fwsqbcx> findAllXTMCbybmbh(String bmbh) throws Exception {
			fwsqbcx user = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select  distinct a.xtmc as xtmc ,a.bmmc as bmmc   from fwsqb a where  a.bmbh= "+bmbh  ;
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()){
					user = new fwsqbcx();
					user.setXtmc(rs.getString("xtmc"));
					user.setBmmc(rs.getString("bmmc"));
					fwsqbs.add(user);
					
				}
			} finally {
				DBConnection.close(rs, ps, conn);
			}
			return fwsqbs;
		}
	
	//管理单位查询服务申请中的部门
		public ArrayList<fwsqbcx> findAllBMMC() throws Exception {
			fwsqbcx user = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select  distinct a.bmmc as bmmc    from fwsqb a " ;
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()){
					user = new fwsqbcx();
					user.setBmmc(rs.getString("bmmc"));
					
					fwsqbs.add(user);
					
				}
			} finally {
				DBConnection.close(rs, ps, conn);
			}
			return fwsqbs;
		}
		//管理单位查询服务申请中的系统名称
		public ArrayList<fwsqbcx> findAllXTMCbybmbh() throws Exception {
			fwsqbcx user = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select  distinct a.xtmc as xtmc    from fwsqb a " ;
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()){
					user = new fwsqbcx();
					user.setXtmc(rs.getString("xtmc"));
					
					fwsqbs.add(user);
					
				}
			} finally {
				DBConnection.close(rs, ps, conn);
			}
			return fwsqbs;
		}
		//管理用户查询流程名称
		public ArrayList<fwsqbcx> findAllLCMC() throws Exception {
			fwsqbcx user = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select  distinct b.lcmc as lcmc    from fwsqb a,flow_blqk b,xtxx c where a.sqdbh=b.sqdbh and a.xtbh=c.xtbh  "  ;
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				
				while(rs.next()){
					user = new fwsqbcx();
					
					user.setLcmc(rs.getString("lcmc"));
					
					fwsqbs.add(user);
					
				}
			} finally {
				DBConnection.close(rs, ps, conn);
			}
			return fwsqbs;
		}
		
		//判断服务申请属于哪个流程阶段，通过部门编号和系统编号获取当前节点代码，判断是否为空
		public String findjddm(String bmmc,String xtmc) throws Exception{
			boolean result=false;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String jddm="";
			try {
				conn = DBConnection.getConnection();
				String sql = "select jddm from fwsqb where bmmc='"+bmmc+"'"+" and  xtmc='"+xtmc+"'" ;
				ps=conn.prepareStatement(sql);
				
				rs=ps.executeQuery();
				if(rs.next()){
					jddm=rs.getString("jddm");	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBConnection.close(rs, ps, conn);
			}
			
			return jddm;
		}
		
		//插入数据到资源申请表
				public String InsertIntoFwsqb(fwsqb fw) throws Exception{
					boolean result=false;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					String jddm="";
					try {
						conn = DBConnection.getConnection();
						String sql = "insert into fwsqb(xtmc,bmmc,apply_address,apply_linkman,apply_phone," +
								"apply_email,company,company_linkman,company_phone,company_email," +
								"access_system_desc,standby_data_size,lcdm,jddm,ccwz,) value(?,?,?,?,?,?)" ;
						ps=conn.prepareStatement(sql);
						
						rs=ps.executeQuery();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						DBConnection.close(rs, ps, conn);
					}
					
					return jddm;
				}
				
				//查询系统信息
				public ArrayList<xtxx> findXtxxByBmbh(String bmbh) throws Exception {
					xtxx user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ArrayList<xtxx> xtxxs=new ArrayList<xtxx>();
					try {
						conn = DBConnection.getConnection();
						String sql = "select xtbh, xtmc, bmbh ,bmmc , apply_address, apply_linkman, apply_phone, apply_email , company, company_linkman,company_phone , company_email ,system_dep_location from xtxx where bmbh = "+bmbh ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						int xuhao=1;
						while(rs.next()){
							user = new xtxx();
							user.setXtbh(rs.getString("xtbh"));
							user.setXtmc(rs.getString("xtmc"));
							user.setBmmc(rs.getString("bmmc"));
							user.setApply_address(rs.getString("apply_address"));
							user.setApply_linkman(rs.getString("apply_linkman"));
							user.setApply_phone(rs.getString("apply_phone"));
							user.setApply_email(rs.getString("apply_email"));
							user.setCompany(rs.getString("company"));
							user.setCompany_linkman(rs.getString("company_linkman"));
							user.setCompany_phone(rs.getString("company_phone"));
							user.setCompany_email(rs.getString("company_email"));
							user.setSystem_dep_location(rs.getString("system_dep_location"));
							xtxxs.add(user);
							xuhao++;
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return xtxxs;
				}		
				
				
				//查询所有系统信息
				public ArrayList<xtxx> findALLXtxx() throws Exception {
					xtxx user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ArrayList<xtxx> xtxxs=new ArrayList<xtxx>();
					try {
						conn = DBConnection.getConnection();
						String sql = "select distinct xtbh, xtmc, bmbh ,bmmc  from xtxx "  ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						int xuhao=1;
						while(rs.next()){
							user = new xtxx();
							user.setXtbh(rs.getString("xtbh"));
							user.setXtmc(rs.getString("xtmc"));
							user.setBmmc(rs.getString("bmmc"));
							user.setBmbh(rs.getString("bmbh"));
							xtxxs.add(user);
							xuhao++;
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return xtxxs;
				}			
				
				//查询所有部门信息
				public ArrayList<department> findALLDept() throws Exception {
					department user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ArrayList<department> xtxxs=new ArrayList<department>();
					try {
						conn = DBConnection.getConnection();
						String sql = "select distinct bmbh ,bmmc  from dwxx "  ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						int xuhao=1;
						while(rs.next()){
							user = new department();
							user.setBmbh(rs.getInt("bmbh"));
							user.setBmmc(rs.getString("bmmc"));
							xtxxs.add(user);
							xuhao++;
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return xtxxs;
				}			
				//查询所有部门信息
				public ArrayList<department> findALLDeptByBmbh(String bmbh) throws Exception {
					department user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ArrayList<department> xtxxs=new ArrayList<department>();
					try {
						conn = DBConnection.getConnection();
						String sql = "select distinct bmbh,bmmc  from dwxx where bmbh="+bmbh  ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						int xuhao=1;
						while(rs.next()){
							user = new department();
							user.setBmbh(rs.getInt("bmbh"));
							user.setBmmc(rs.getString("bmmc"));
							xtxxs.add(user);
							xuhao++;
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return xtxxs;
				}
				
				
				public void updateXtxx(xtxx u) throws Exception{
					Connection conn =null;
					try {
				   String sql = "Update xtxx set    apply_address = ?,   apply_linkman = ?,   apply_phone = ?,   apply_email = ? ,   company = ?,   company_linkman=?,   company_phone = ?,   company_email = ? ,   system_dep_location = ? where xtbh = ?";
				 	  conn= DBConnection.getConnection();
				    PreparedStatement pstmt;
				    pstmt=(PreparedStatement) conn.prepareStatement(sql);
				    pstmt.setString(1,u.getApply_address());
				    pstmt.setString(2,u.getApply_linkman());
				    pstmt.setString(3,u.getApply_phone());
				    pstmt.setString(4,u.getApply_email());
				    pstmt.setString(5,u.getCompany());
				    pstmt.setString(6,u.getCompany_linkman());
				    pstmt.setString(7,u.getCompany_phone());
				    pstmt.setString(8,u.getCompany_email());
				    pstmt.setString(9,u.getSystem_dep_location());
				    pstmt.setString(10,u.getXtbh());
				    pstmt.executeUpdate();
				    pstmt.close();
				    conn.close();
				    DBConnection.close( pstmt, conn);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}finally{
				    
				   
					}
				
				    
				}
				
				// 查詢系統名稱 
			
				public  xtxx findALLXtxxByBmbhAndXtbh(String bmbh,String xtbh) throws Exception {
					xtxx user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					
					try {
						conn = DBConnection.getConnection();
						String sql = "select bmbh,xtmc,bmmc,xtbh  from xtxx where bmbh="+bmbh +"  and xtbh="+xtbh ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
					
						while(rs.next()){
							user = new xtxx();
							user.setXtbh(rs.getString("xtbh"));
							user.setXtmc(rs.getString("xtmc"));
							user.setBmbh(rs.getString("bmbh"));
							user.setBmmc(rs.getString("bmmc"));
							
							
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return user;
				}
				
				// 查詢流程信息
				
				public  flow_config findflowconfigBylcdmjddm(String lcdm,int jddm) throws Exception {
					flow_config user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					
					try {
						conn = DBConnection.getConnection();
						String sql = "select *  from flow_config where lcdm="+lcdm +"  and jddm="+jddm ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
					
						while(rs.next()){
							user = new flow_config();
							user.setId(rs.getInt("id"));
							user.setLcdm(rs.getString("lcdm"));		
							user.setLcmc(rs.getString("lcmc"));		
							user.setJddm(rs.getInt("jddm"));		
							user.setJdmc(rs.getString("jdmc"));		
							user.setDqjs(rs.getString("dqjs"));		
							user.setDbjs(rs.getString("dbjs"));		
							user.setBjbz(rs.getString("bjbz"));		
							user.setCreate_by(rs.getString("create_by"));
							user.setUpdate_by(rs.getString("update_by"));
							user.setRemarks(rs.getString("remarks"));
							user.setCreate_date(rs.getString("create_date"));
							user.setUpdate_date(rs.getString("update_date"));

							
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return user;
				}
				
				//插入fwsqb
				public void  insertfwsqb(fwsqb fwsqb) throws Exception{
					Connection conn =null;
					
				   String sql = "INSERT INTO fwsqb(sqbt,lcdm,sqdbh,jddm,bjbz,create_by,create_date,remarks,xtbh,xtmc,bmbh,bmmc,ccwz,access_system_desc,apply_address,apply_linkman,apply_phone,apply_email,company_linkman,company,company_phone,company_email,system_dep_location,standby_data_type,standby_data_size,op_system_type,tc_disaster_preparedness1,tc_dp1_backup_strategy,tc_dp1_space_quotas,tc_disaster_preparedness2,tc_dp2_backup_strategy,tc_dp2_space_quotas,tc_disaster_preparedness3,tc_dp3_backup_strategy,tc_dp3_space_quotas,tc_disaster_preparedness4,tc_dp4_backup_strategy,tc_dp4_space_quotas,remote_disaster_preparedness,remote_dp_backup_strategy2,remote_dp_space_quotas2,data_validation_service,data_validation_service_times,data_disaster_preparedness_drill,data_disaster_preparedness_drill_times,other_service_requirements,jfsj,tc_disaster_preparedness5,tc_dp1_backup_strategy2,tc_dp1_space_quotas2,tc_disaster_preparedness6,tc_dp2_backup_strategy2,tc_dp2_space_quotas2,tc_disaster_preparedness7,tc_dp3_backup_strategy2,tc_dp3_space_quotas2,tc_disaster_preparedness8,tc_dp4_backup_strategy2,tc_dp4_space_quotas2,remote_disaster_preparedness2,remote_dp_backup_strategy3,remote_dp_space_quotas3,data_validation_service2,data_validation_service_times2,data_disaster_preparedness_drill2,data_disaster_preparedness_drill_times2) " +
				   		"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					   
				 	  conn= DBConnection.getConnection();
				    PreparedStatement pstmt;
				    pstmt=(PreparedStatement) conn.prepareStatement(sql);
			
			pstmt.setString(1, fwsqb.getSqbt());//申请标题
			pstmt.setString(2, fwsqb.getLcdm());//流程代码
			pstmt.setString(3, fwsqb.getSqdbh());//申请单编号
			pstmt.setInt(4, fwsqb.getJddm());//当前节点代码
			pstmt.setString(5, fwsqb.getBjbz());//当前办结标志
			pstmt.setString(6, fwsqb.getCreate_by());//创建人
			pstmt.setString(7, fwsqb.getCreate_date());//创建时间
			pstmt.setString(8, fwsqb.getRemarks());//备注
			pstmt.setString(9, fwsqb.getXtbh());//应用系统编号
			pstmt.setString(10, fwsqb.getXtmc());//应用系统名称
			pstmt.setString(11, fwsqb.getBmbh());//单位编号
			pstmt.setString(12, fwsqb.getBmmc());//所属单位名称
			pstmt.setString(13, fwsqb.getCcwz());//云服务商
			pstmt.setString(14, fwsqb.getAccess_system_desc());//系统描述
			pstmt.setString(15, fwsqb.getApply_address());//申请单位地址
			pstmt.setString(16, fwsqb.getApply_linkman());//申请单位联系人
			pstmt.setString(17, fwsqb.getApply_phone());//申请单位联系电话(座机+手机)
			pstmt.setString(18, fwsqb.getApply_email());//申请单位联系邮箱
			pstmt.setString(19, fwsqb.getCompany_linkman());//承建/运维单位联系人
			pstmt.setString(20, fwsqb.getCompany());//承建/运维单位
			pstmt.setString(21, fwsqb.getCompany_phone());//承建/运维单位联系电话(座机+手机)
			pstmt.setString(22, fwsqb.getCompany_email());//承建/运维单位联系邮箱2
			pstmt.setString(23, fwsqb.getSystem_dep_location());//云服务商
			pstmt.setString(24, fwsqb.getStandby_data_type());//备份数据类型
			pstmt.setString(25, fwsqb.getStandby_data_size());//备份数据大小
			pstmt.setString(26, fwsqb.getOp_system_type());//操作系统类型
			pstmt.setString(27, fwsqb.getTc_disaster_preparedness1());//是否同城一级灾备服务
			pstmt.setString(28, fwsqb.getTc_dp1_backup_strategy());//同城一级灾备服务备份策略
			pstmt.setString(29, fwsqb.getTc_dp1_space_quotas());//同城一级灾备服务空间配额
			pstmt.setString(30, fwsqb.getTc_disaster_preparedness2());//是否同城二级灾备服务
			pstmt.setString(31, fwsqb.getTc_dp2_backup_strategy());//同城二级灾备服务备份策略
			pstmt.setString(32, fwsqb.getTc_dp2_space_quotas());//同城二级灾备服务空间配额
			pstmt.setString(33, fwsqb.getTc_disaster_preparedness3());//是否同城三级灾备服务
			pstmt.setString(34, fwsqb.getTc_dp3_backup_strategy());//同城三级灾备服务备份策略3
			pstmt.setString(35, fwsqb.getTc_dp3_space_quotas());//同城三级灾备服务空间配额3
			pstmt.setString(36, fwsqb.getTc_disaster_preparedness4());//是否同城四级灾备服务
			pstmt.setString(37, fwsqb.getTc_dp4_backup_strategy());//同城四级灾备服务备份策略2
			pstmt.setString(38, fwsqb.getTc_dp4_space_quotas());//同城四级灾备服务空间配额2
			pstmt.setString(39, fwsqb.getRemote_disaster_preparedness());//是否异地灾备服务
			pstmt.setString(40, fwsqb.getRemote_dp_backup_strategy2());//异地灾备服务备份策略
			pstmt.setString(41, fwsqb.getRemote_dp_space_quotas2());//异地灾备服务空间配额
			pstmt.setString(42, fwsqb.getData_validation_service());//是否数据验证服务
			pstmt.setString(43, fwsqb.getData_validation_service_times());//数据验证服务（次/年）
			pstmt.setString(44, fwsqb.getData_disaster_preparedness_drill());//是否数据灾备演练
			pstmt.setString(45, fwsqb.getData_disaster_preparedness_drill_times());//数据灾备演练（次/年）
			pstmt.setString(46, fwsqb.getOther_service_requirements());//其它服务：备份保留时间周期需求以及其它需求
			pstmt.setString(47, fwsqb.getJfsj());//服务交付时间
			pstmt.setString(48, fwsqb.getTc_disaster_preparedness5());//是否同城一级灾备服务(交付)
			pstmt.setString(49, fwsqb.getTc_dp1_backup_strategy2());//同城一级灾备服务备份策略(交付)
			pstmt.setString(50, fwsqb.getTc_dp1_space_quotas2());//同城一级灾备服务空间配额(交付)
			pstmt.setString(51, fwsqb.getTc_disaster_preparedness6());//是否同城二级灾备服务(交付)
			pstmt.setString(52, fwsqb.getTc_dp2_backup_strategy2());//同城二级灾备服务备份策略(交付)
			pstmt.setString(53, fwsqb.getTc_dp2_space_quotas2());//同城二级灾备服务空间配额(交付)
			pstmt.setString(54, fwsqb.getTc_disaster_preparedness7());//是否同城三级灾备服务(交付)
			pstmt.setString(55, fwsqb.getTc_dp3_backup_strategy2());//同城三级灾备服务备份策略3(交付)
			pstmt.setString(56, fwsqb.getTc_dp3_space_quotas2());//同城三级灾备服务空间配额3(交付)
			pstmt.setString(57, fwsqb.getTc_disaster_preparedness8());//是否同城四级灾备服务(交付)
			pstmt.setString(58, fwsqb.getTc_dp4_backup_strategy2());//同城四级灾备服务备份策略2(交付)
			pstmt.setString(59, fwsqb.getTc_dp4_space_quotas2());//同城四级灾备服务空间配额2(交付)
			pstmt.setString(60, fwsqb.getRemote_disaster_preparedness2());//是否异地灾备服务(交付)
			pstmt.setString(61, fwsqb.getRemote_dp_backup_strategy3());//异地灾备服务备份策略(交付)
			pstmt.setString(62, fwsqb.getRemote_dp_space_quotas3());//异地灾备服务空间配额(交付)
			pstmt.setString(63, fwsqb.getData_validation_service2());//是否数据验证服务(交付)
			pstmt.setString(64, fwsqb.getData_validation_service_times2());//数据验证服务（次/年）(交付)
			pstmt.setString(65, fwsqb.getData_disaster_preparedness_drill2());//是否数据灾备演练(交付)
			pstmt.setString(66, fwsqb.getData_disaster_preparedness_drill_times2());//数据灾备演练（次/年）(交付)

				    pstmt.executeUpdate();
				    pstmt.close();
				    conn.close();
				    DBConnection.close( pstmt, conn);
					
				
				    
				}

		//查询fwsqb
				//查询所有部门信息
				public fwsqb findFwsqbBySqbt(String sqbt) throws Exception {
					fwsqb fwsqb = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					
					try {
						conn = DBConnection.getConnection();
						String sql = "select *  from fwsqb where sqdbh="+sqbt  ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						
						while(rs.next()){
							fwsqb = new fwsqb();
							fwsqb.setId(rs.getInt("id"));
							fwsqb.setSqbt(rs.getString("sqbt"));				
							fwsqb.setLcdm(rs.getString("lcdm"));			
							fwsqb.setSqdbh(rs.getString("sqdbh"));			
							fwsqb.setJddm(rs.getInt("Jddm"));				
							fwsqb.setBjbz(rs.getString("bjbz"));				
							fwsqb.setCreate_by(rs.getString("create_by"));				
							fwsqb.setCreate_date(rs.getString("create_date"));				
							fwsqb.setRemarks(rs.getString("remarks"));				
							fwsqb.setXtbh(rs.getString("xtbh"));				
							fwsqb.setXtmc(rs.getString("xtmc"));				
							fwsqb.setBmbh(rs.getString("bmbh"));				
							fwsqb.setBmmc(rs.getString("bmmc"));				
							fwsqb.setCcwz(rs.getString("ccwz"));				
							fwsqb.setAccess_system_desc(rs.getString("access_system_desc"));			
							fwsqb.setApply_address(rs.getString("apply_address"));			
							fwsqb.setApply_linkman(rs.getString("apply_linkman"));			
							fwsqb.setApply_phone(rs.getString("apply_phone"));				
							fwsqb.setApply_email(rs.getString("apply_email"));				
							fwsqb.setCompany_linkman(rs.getString("company_linkman"));			
							fwsqb.setCompany(rs.getString("company"));				
							fwsqb.setCompany_phone(rs.getString("company_phone"));			
							fwsqb.setCompany_email(rs.getString("company_email"));			
							fwsqb.setSystem_dep_location(rs.getString("system_dep_location"));			
							fwsqb.setStandby_data_type(rs.getString("standby_data_type"));			
							fwsqb.setStandby_data_size(rs.getString("standby_data_size"));			
							fwsqb.setOp_system_type(rs.getString("op_system_type"));			
							fwsqb.setTc_disaster_preparedness1(rs.getString("tc_disaster_preparedness1"));		
							fwsqb.setTc_dp1_backup_strategy(rs.getString("tc_dp1_backup_strategy"));		
							fwsqb.setTc_dp1_space_quotas(rs.getString("tc_dp1_space_quotas"));			
							fwsqb.setTc_disaster_preparedness2(rs.getString("tc_disaster_preparedness2"));		
							fwsqb.setTc_dp2_backup_strategy(rs.getString("tc_dp2_backup_strategy"));		
							fwsqb.setTc_dp2_space_quotas(rs.getString("tc_dp2_space_quotas"));			
							fwsqb.setTc_disaster_preparedness3(rs.getString("tc_disaster_preparedness3"));		
							fwsqb.setTc_dp3_backup_strategy(rs.getString("tc_dp3_backup_strategy"));		
							fwsqb.setTc_dp3_space_quotas(rs.getString("tc_dp3_space_quotas"));			
							fwsqb.setTc_disaster_preparedness4(rs.getString("tc_disaster_preparedness4"));		
							fwsqb.setTc_dp4_backup_strategy(rs.getString("tc_dp4_backup_strategy"));		
							fwsqb.setTc_dp4_space_quotas(rs.getString("tc_dp4_space_quotas"));			
							fwsqb.setRemote_disaster_preparedness(rs.getString("remote_disaster_preparedness"));	
							fwsqb.setRemote_dp_backup_strategy2(rs.getString("remote_dp_backup_strategy2"));		
							fwsqb.setRemote_dp_space_quotas2(rs.getString("remote_dp_space_quotas2"));		
							fwsqb.setData_validation_service(rs.getString("data_validation_service"));		
							fwsqb.setData_validation_service_times(rs.getString("data_validation_service_times"));	
							fwsqb.setData_disaster_preparedness_drill(rs.getString("data_disaster_preparedness_drill"));	
							fwsqb.setData_disaster_preparedness_drill_times(rs.getString("data_disaster_preparedness_drill_times"));
							fwsqb.setOther_service_requirements(rs.getString("other_service_requirements"));		
							fwsqb.setJfsj(rs.getString("jfsj"));				
							fwsqb.setTc_disaster_preparedness5(rs.getString("tc_disaster_preparedness5"));		
							fwsqb.setTc_dp1_backup_strategy2(rs.getString("tc_dp1_backup_strategy2"));		
							fwsqb.setTc_dp1_space_quotas2(rs.getString("tc_dp1_space_quotas2"));		
							fwsqb.setTc_disaster_preparedness6(rs.getString("tc_disaster_preparedness6"));		
							fwsqb.setTc_dp2_backup_strategy2(rs.getString("tc_dp2_backup_strategy2"));		
							fwsqb.setTc_dp2_space_quotas2(rs.getString("tc_dp2_space_quotas2"));		
							fwsqb.setTc_disaster_preparedness7(rs.getString("tc_disaster_preparedness7"));		
							fwsqb.setTc_dp3_backup_strategy2(rs.getString("tc_dp3_backup_strategy2"));		
							fwsqb.setTc_dp3_space_quotas2(rs.getString("tc_dp3_space_quotas2"));		
							fwsqb.setTc_disaster_preparedness8(rs.getString("tc_disaster_preparedness8"));		
							fwsqb.setTc_dp4_backup_strategy2(rs.getString("tc_dp4_backup_strategy2"));		
							fwsqb.setTc_dp4_space_quotas2(rs.getString("tc_dp4_space_quotas2"));		
							fwsqb.setRemote_disaster_preparedness2(rs.getString("remote_disaster_preparedness2"));	
							fwsqb.setRemote_dp_backup_strategy3(rs.getString("remote_dp_backup_strategy3"));		
							fwsqb.setRemote_dp_space_quotas3(rs.getString("remote_dp_space_quotas3"));		
							fwsqb.setData_validation_service2(rs.getString("data_validation_service2"));		
							fwsqb.setData_validation_service_times2(rs.getString("data_validation_service_times2"));	
							fwsqb.setData_disaster_preparedness_drill2(rs.getString("data_disaster_preparedness_drill2"));	
							fwsqb.setData_disaster_preparedness_drill_times2(rs.getString("data_disaster_preparedness_drill_times2"));
							
							
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return fwsqb;
				}
				
				
				//服务代办工单查询
				
				public ArrayList<fwsqbcx> findAllTask(int pageSize, int pageNow,String lcdm,String roleid) throws Exception {
					fwsqbcx user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
					try {
						conn = DBConnection.getConnection();
						String sql = "Select *   From fwsqb a, flow_config  c  where c. dqjs like '"+roleid+"'" +
								" and  c. lcdm = '"+lcdm+"'  and a. lcdm = c. lcdm     And  a. jddm = c. jddm" +
								"      And a. bjbz = 'Y'     And c.bjbz = 'N'   limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						int xuhao=1;
						while(rs.next()){
							user = new fwsqbcx();
							user.setXuhao(xuhao);
							user.setSqdbh(rs.getString("sqdbh"));
							user.setSqbt(rs.getString("sqbt"));
							user.setBmbh(rs.getString("bmbh"));
							user.setBmmc(rs.getString("bmmc"));
							user.setXtbh(rs.getString("xtbh"));
							user.setXtmc(rs.getString("xtmc"));
							user.setLcdm(rs.getString("lcdm"));
							user.setLcmc(rs.getString("lcmc"));
							user.setJddm(rs.getInt("jddm"));
							user.setJdmc(rs.getString("jdmc"));
							user.setBjbz(rs.getString("bjbz"));
							user.setCcwz(rs.getString("ccwz"));
							user.setCreate_by(rs.getString("create_by"));
							user.setCreate_date(rs.getString("create_date"));
							user.setSystem_dep_location(rs.getString("system_dep_location"));
							fwsqbs.add(user);
							xuhao++;
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return fwsqbs;
				}
				
				//任务总量
				public int sumtask(int roleid) throws Exception{
					
					int sumb=0;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					
						try {
							conn = DBConnection.getConnection();
							String sql = "select count(*) as sum From fwsqb a, flow_config  c  where c. dqjs like '"+roleid+"'" +
									"   and a. lcdm = c. lcdm     And  a. jddm = c. jddm" +
									"      And a. bjbz = 'Y'     And c.bjbz = 'N'" ;
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
				
					//服务代办工单查询所有查询
				
				public ArrayList<fwsqbcx> findAllTask(int pageSize, int pageNow,int roleid) throws Exception {
					fwsqbcx user = null;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					ArrayList<fwsqbcx> fwsqbs=new ArrayList<fwsqbcx>();
					try {
						conn = DBConnection.getConnection();
						String sql = "Select *   From fwsqb a, flow_config  c  where c. dqjs like '"+roleid+"'" +
								"   and a. lcdm = c. lcdm     And  a. jddm = c. jddm" +
								"      And a. bjbz = 'Y'     And c.bjbz = 'N'   limit "+(pageNow*pageSize-pageSize)+","+pageSize ;
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						int xuhao=1;
						while(rs.next()){
							user = new fwsqbcx();
							user.setXuhao(xuhao);
							user.setSqdbh(rs.getString("sqdbh"));
							user.setSqbt(rs.getString("sqbt"));
							user.setBmbh(rs.getString("bmbh"));
							user.setBmmc(rs.getString("bmmc"));
							user.setXtbh(rs.getString("xtbh"));
							user.setXtmc(rs.getString("xtmc"));
							user.setLcdm(rs.getString("lcdm"));
							user.setLcmc(rs.getString("lcmc"));
							user.setJddm(rs.getInt("jddm"));
							user.setJdmc(rs.getString("jdmc"));
							user.setBjbz(rs.getString("bjbz"));
							user.setCcwz(rs.getString("ccwz"));
							user.setCreate_by(rs.getString("create_by"));
							user.setCreate_date(rs.getString("create_date"));
							user.setSystem_dep_location(rs.getString("system_dep_location"));
							fwsqbs.add(user);
							xuhao++;
						}
					} finally {
						DBConnection.close(rs, ps, conn);
					}
					return fwsqbs;
				}
				//任务总量条件查询使用
				public int sumtask(String lcdm,String roleid) throws Exception{
					
					int sumb=0;
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					
						try {
							conn = DBConnection.getConnection();
							String sql = "select count(*) as sum From fwsqb a, flow_config  c  where c. dqjs like '"+roleid+"'" +
									"and  c. lcdm = '"+lcdm+"'   and a. lcdm = c. lcdm     And  a. jddm = c. jddm" +
									"      And a. bjbz = 'Y'     And c.bjbz = 'N'" ;
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
				//任务工单签收
				public void updateTask(String  sqdbh,String name) throws Exception{
					Connection conn =null;
					try {
				   String sql = " Update  fwsqb a  Set a.jddm = a.jddm + 1 , a.bjbz = 'N'  where sqdbh='"+sqdbh+"'";
				 	  conn= DBConnection.getConnection();
				    PreparedStatement pstmt;
				    pstmt=(PreparedStatement) conn.prepareStatement(sql);
				
				    pstmt.executeUpdate();
				    
				    String sql2="INSERT INTO wgbf.flow_blqk  (lcdm, sqdbh,  lcmc,   jddm,  jdmc, kssj, jssj,  zls,  create_by,  remarks)   select    lcdm,   sqdbh,  lcmc,   jddm,  jdmc,  Now(),' null',' null','"+name+"',  ' Null'  from fwsqb a where a. sqdbh = "+sqdbh+"'";
				    
				    pstmt=(PreparedStatement) conn.prepareStatement(sql2);
					
				    pstmt.executeUpdate();
				    
				    pstmt.close();
				    conn.close();
				    DBConnection.close( pstmt, conn);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}finally{
				    
				   
					}
				
				    
				}
				
				
				
}
