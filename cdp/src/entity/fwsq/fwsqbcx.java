package entity.fwsq;

public class fwsqbcx {

	private String lcmc	 ;

	private String jdmc	 ;
	private String kssj	 ;
	private String jssj	 ;
	private String zls	 ;

	
	private int xuhao;
	private int  id						;//'主键',
	private String  sqbt	;//'申请标题',
	private String  lcdm					;//'流程代码',
	private String  sqdbh					;//'申请单编号',
	private int  jddm					;//'当前节点代码',
	private String  bjbz					;//'当前办结标志',
	private String  create_by				;//'创建人',
	private String  create_date				;//'创建时间',
	private String  remarks					;//'备注',
	private String  xtbh					;//'应用系统编号',
	private String  xtmc					;//'应用系统名称',
	private String  bmbh					;//'单位编号',
	private String  bmmc					;//'所属单位名称',
	private String  ccwz					;//'云服务商',
	private String  access_system_desc			;//'系统描述',
	private String  apply_address				;//'申请单位地址',
	private String  apply_linkman				;//'申请单位联系人',
	private String  apply_phone				;//'申请单位联系电话(座机+手机)',
	private String  apply_email				;//'申请单位联系邮箱',
	private String  company_linkman				;//'承建/运维单位联系人',
	private String  company					;//'承建/运维单位',
	private String  company_phone				;//'承建/运维单位联系电话(座机+手机)',
	private String  company_email				;//'承建/运维单位联系邮箱2',
	private String  system_dep_location			;//'云服务商',
	private String  standby_data_type			;//'备份数据类型',
	private String  standby_data_size			;//'备份数据大小',
	private String  op_system_type				;//'操作系统类型',
	private String  tc_disaster_preparedness1		;//'是否同城一级灾备服务',
	private String  tc_dp1_backup_strategy			;//'同城一级灾备服务备份策略',
	private String  tc_dp1_space_quotas			;//'同城一级灾备服务空间配额',
	private String  tc_disaster_preparedness2		;//'是否同城二级灾备服务',
	private String  tc_dp2_backup_strategy			;//'同城二级灾备服务备份策略',
	private String  tc_dp2_space_quotas			;//'同城二级灾备服务空间配额',
	private String  tc_disaster_preparedness3		;//'是否同城三级灾备服务',
	private String  tc_dp3_backup_strategy			;//'同城三级灾备服务备份策略3',
	private String  tc_dp3_space_quotas			;//'同城三级灾备服务空间配额3',
	private String  tc_disaster_preparedness4		;//'是否同城四级灾备服务',
	private String  tc_dp4_backup_strategy			;//'同城四级灾备服务备份策略2',
	private String  tc_dp4_space_quotas			;//'同城四级灾备服务空间配额2',
	private String  remote_disaster_preparedness		;//'是否异地灾备服务',
	private String  remote_dp_backup_strategy2		;//'异地灾备服务备份策略',
	private String  remote_dp_space_quotas2			;//'异地灾备服务空间配额',
	private String  data_validation_service			;//'是否数据验证服务',
	private String  data_validation_service_times		;//'数据验证服务（次/年）',
	private String  data_disaster_preparedness_drill	;//'是否数据灾备演练',
	private String  data_disaster_preparedness_drill_times	;//'数据灾备演练（次/年）',
	private String  other_service_requirements		;//'其它服务：备份保留时间周期需求以及其它需求',
	private String  jfsj									;//'服务交付时间',
	private String  tc_disaster_preparedness5		;//'是否同城一级灾备服务(交付)',
	private String  tc_dp1_backup_strategy2			;//'同城一级灾备服务备份策略(交付)',
	private String  tc_dp1_space_quotas2			;//'同城一级灾备服务空间配额(交付)',
	private String  tc_disaster_preparedness6		;//'是否同城二级灾备服务(交付)',
	private String  tc_dp2_backup_strategy2			;//'同城二级灾备服务备份策略(交付)',
	private String  tc_dp2_space_quotas2			;//'同城二级灾备服务空间配额(交付)',
	private String  tc_disaster_preparedness7		;//'是否同城三级灾备服务(交付)',
	private String  tc_dp3_backup_strategy2			;//'同城三级灾备服务备份策略3(交付)',
	private String  tc_dp3_space_quotas2			;//'同城三级灾备服务空间配额3(交付)',
	private String  tc_disaster_preparedness8		;//'是否同城四级灾备服务(交付)',
	private String  tc_dp4_backup_strategy2			;//'同城四级灾备服务备份策略2(交付)',
	private String  tc_dp4_space_quotas2			;//'同城四级灾备服务空间配额2(交付)',
	private String  remote_disaster_preparedness2		;//'是否异地灾备服务(交付)',
	private String  remote_dp_backup_strategy3		;//'异地灾备服务备份策略(交付)',
	private String  remote_dp_space_quotas3			;//'异地灾备服务空间配额(交付)',
	private String  data_validation_service2		;//'是否数据验证服务(交付)',
	private String  data_validation_service_times2		;//'数据验证服务（次/年）(交付)',
	private String  data_disaster_preparedness_drill2	;//'是否数据灾备演练(交付)',
	private String  data_disaster_preparedness_drill_times2	;//'数据灾备演练（次/年）(交付)',
	public String getLcmc() {
		return lcmc;
	}
	public void setLcmc(String lcmc) {
		this.lcmc = lcmc;
	}
	public String getJdmc() {
		return jdmc;
	}
	public void setJdmc(String jdmc) {
		this.jdmc = jdmc;
	}
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getZls() {
		return zls;
	}
	public void setZls(String zls) {
		this.zls = zls;
	}
	public int getXuhao() {
		return xuhao;
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSqbt() {
		return sqbt;
	}
	public void setSqbt(String sqbt) {
		this.sqbt = sqbt;
	}
	public String getLcdm() {
		return lcdm;
	}
	public void setLcdm(String lcdm) {
		this.lcdm = lcdm;
	}
	public String getSqdbh() {
		return sqdbh;
	}
	public void setSqdbh(String sqdbh) {
		this.sqdbh = sqdbh;
	}
	public int getJddm() {
		return jddm;
	}
	public void setJddm(int jddm) {
		this.jddm = jddm;
	}
	public String getBjbz() {
		return bjbz;
	}
	public void setBjbz(String bjbz) {
		this.bjbz = bjbz;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getXtbh() {
		return xtbh;
	}
	public void setXtbh(String xtbh) {
		this.xtbh = xtbh;
	}
	public String getXtmc() {
		return xtmc;
	}
	public void setXtmc(String xtmc) {
		this.xtmc = xtmc;
	}
	public String getBmbh() {
		return bmbh;
	}
	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}
	public String getCcwz() {
		return ccwz;
	}
	public void setCcwz(String ccwz) {
		this.ccwz = ccwz;
	}
	public String getAccess_system_desc() {
		return access_system_desc;
	}
	public void setAccess_system_desc(String access_system_desc) {
		this.access_system_desc = access_system_desc;
	}
	public String getApply_address() {
		return apply_address;
	}
	public void setApply_address(String apply_address) {
		this.apply_address = apply_address;
	}
	public String getApply_linkman() {
		return apply_linkman;
	}
	public void setApply_linkman(String apply_linkman) {
		this.apply_linkman = apply_linkman;
	}
	public String getApply_phone() {
		return apply_phone;
	}
	public void setApply_phone(String apply_phone) {
		this.apply_phone = apply_phone;
	}
	public String getApply_email() {
		return apply_email;
	}
	public void setApply_email(String apply_email) {
		this.apply_email = apply_email;
	}
	public String getCompany_linkman() {
		return company_linkman;
	}
	public void setCompany_linkman(String company_linkman) {
		this.company_linkman = company_linkman;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getSystem_dep_location() {
		return system_dep_location;
	}
	public void setSystem_dep_location(String system_dep_location) {
		this.system_dep_location = system_dep_location;
	}
	public String getStandby_data_type() {
		return standby_data_type;
	}
	public void setStandby_data_type(String standby_data_type) {
		this.standby_data_type = standby_data_type;
	}
	public String getStandby_data_size() {
		return standby_data_size;
	}
	public void setStandby_data_size(String standby_data_size) {
		this.standby_data_size = standby_data_size;
	}
	public String getOp_system_type() {
		return op_system_type;
	}
	public void setOp_system_type(String op_system_type) {
		this.op_system_type = op_system_type;
	}
	public String getTc_disaster_preparedness1() {
		return tc_disaster_preparedness1;
	}
	public void setTc_disaster_preparedness1(String tc_disaster_preparedness1) {
		this.tc_disaster_preparedness1 = tc_disaster_preparedness1;
	}
	public String getTc_dp1_backup_strategy() {
		return tc_dp1_backup_strategy;
	}
	public void setTc_dp1_backup_strategy(String tc_dp1_backup_strategy) {
		this.tc_dp1_backup_strategy = tc_dp1_backup_strategy;
	}
	public String getTc_dp1_space_quotas() {
		return tc_dp1_space_quotas;
	}
	public void setTc_dp1_space_quotas(String tc_dp1_space_quotas) {
		this.tc_dp1_space_quotas = tc_dp1_space_quotas;
	}
	public String getTc_disaster_preparedness2() {
		return tc_disaster_preparedness2;
	}
	public void setTc_disaster_preparedness2(String tc_disaster_preparedness2) {
		this.tc_disaster_preparedness2 = tc_disaster_preparedness2;
	}
	public String getTc_dp2_backup_strategy() {
		return tc_dp2_backup_strategy;
	}
	public void setTc_dp2_backup_strategy(String tc_dp2_backup_strategy) {
		this.tc_dp2_backup_strategy = tc_dp2_backup_strategy;
	}
	public String getTc_dp2_space_quotas() {
		return tc_dp2_space_quotas;
	}
	public void setTc_dp2_space_quotas(String tc_dp2_space_quotas) {
		this.tc_dp2_space_quotas = tc_dp2_space_quotas;
	}
	public String getTc_disaster_preparedness3() {
		return tc_disaster_preparedness3;
	}
	public void setTc_disaster_preparedness3(String tc_disaster_preparedness3) {
		this.tc_disaster_preparedness3 = tc_disaster_preparedness3;
	}
	public String getTc_dp3_backup_strategy() {
		return tc_dp3_backup_strategy;
	}
	public void setTc_dp3_backup_strategy(String tc_dp3_backup_strategy) {
		this.tc_dp3_backup_strategy = tc_dp3_backup_strategy;
	}
	public String getTc_dp3_space_quotas() {
		return tc_dp3_space_quotas;
	}
	public void setTc_dp3_space_quotas(String tc_dp3_space_quotas) {
		this.tc_dp3_space_quotas = tc_dp3_space_quotas;
	}
	public String getTc_disaster_preparedness4() {
		return tc_disaster_preparedness4;
	}
	public void setTc_disaster_preparedness4(String tc_disaster_preparedness4) {
		this.tc_disaster_preparedness4 = tc_disaster_preparedness4;
	}
	public String getTc_dp4_backup_strategy() {
		return tc_dp4_backup_strategy;
	}
	public void setTc_dp4_backup_strategy(String tc_dp4_backup_strategy) {
		this.tc_dp4_backup_strategy = tc_dp4_backup_strategy;
	}
	public String getTc_dp4_space_quotas() {
		return tc_dp4_space_quotas;
	}
	public void setTc_dp4_space_quotas(String tc_dp4_space_quotas) {
		this.tc_dp4_space_quotas = tc_dp4_space_quotas;
	}
	public String getRemote_disaster_preparedness() {
		return remote_disaster_preparedness;
	}
	public void setRemote_disaster_preparedness(String remote_disaster_preparedness) {
		this.remote_disaster_preparedness = remote_disaster_preparedness;
	}
	public String getRemote_dp_backup_strategy2() {
		return remote_dp_backup_strategy2;
	}
	public void setRemote_dp_backup_strategy2(String remote_dp_backup_strategy2) {
		this.remote_dp_backup_strategy2 = remote_dp_backup_strategy2;
	}
	public String getRemote_dp_space_quotas2() {
		return remote_dp_space_quotas2;
	}
	public void setRemote_dp_space_quotas2(String remote_dp_space_quotas2) {
		this.remote_dp_space_quotas2 = remote_dp_space_quotas2;
	}
	public String getData_validation_service() {
		return data_validation_service;
	}
	public void setData_validation_service(String data_validation_service) {
		this.data_validation_service = data_validation_service;
	}
	public String getData_validation_service_times() {
		return data_validation_service_times;
	}
	public void setData_validation_service_times(
			String data_validation_service_times) {
		this.data_validation_service_times = data_validation_service_times;
	}
	public String getData_disaster_preparedness_drill() {
		return data_disaster_preparedness_drill;
	}
	public void setData_disaster_preparedness_drill(
			String data_disaster_preparedness_drill) {
		this.data_disaster_preparedness_drill = data_disaster_preparedness_drill;
	}
	public String getData_disaster_preparedness_drill_times() {
		return data_disaster_preparedness_drill_times;
	}
	public void setData_disaster_preparedness_drill_times(
			String data_disaster_preparedness_drill_times) {
		this.data_disaster_preparedness_drill_times = data_disaster_preparedness_drill_times;
	}
	public String getOther_service_requirements() {
		return other_service_requirements;
	}
	public void setOther_service_requirements(String other_service_requirements) {
		this.other_service_requirements = other_service_requirements;
	}
	public String getJfsj() {
		return jfsj;
	}
	public void setJfsj(String jfsj) {
		this.jfsj = jfsj;
	}
	public String getTc_disaster_preparedness5() {
		return tc_disaster_preparedness5;
	}
	public void setTc_disaster_preparedness5(String tc_disaster_preparedness5) {
		this.tc_disaster_preparedness5 = tc_disaster_preparedness5;
	}
	public String getTc_dp1_backup_strategy2() {
		return tc_dp1_backup_strategy2;
	}
	public void setTc_dp1_backup_strategy2(String tc_dp1_backup_strategy2) {
		this.tc_dp1_backup_strategy2 = tc_dp1_backup_strategy2;
	}
	public String getTc_dp1_space_quotas2() {
		return tc_dp1_space_quotas2;
	}
	public void setTc_dp1_space_quotas2(String tc_dp1_space_quotas2) {
		this.tc_dp1_space_quotas2 = tc_dp1_space_quotas2;
	}
	public String getTc_disaster_preparedness6() {
		return tc_disaster_preparedness6;
	}
	public void setTc_disaster_preparedness6(String tc_disaster_preparedness6) {
		this.tc_disaster_preparedness6 = tc_disaster_preparedness6;
	}
	public String getTc_dp2_backup_strategy2() {
		return tc_dp2_backup_strategy2;
	}
	public void setTc_dp2_backup_strategy2(String tc_dp2_backup_strategy2) {
		this.tc_dp2_backup_strategy2 = tc_dp2_backup_strategy2;
	}
	public String getTc_dp2_space_quotas2() {
		return tc_dp2_space_quotas2;
	}
	public void setTc_dp2_space_quotas2(String tc_dp2_space_quotas2) {
		this.tc_dp2_space_quotas2 = tc_dp2_space_quotas2;
	}
	public String getTc_disaster_preparedness7() {
		return tc_disaster_preparedness7;
	}
	public void setTc_disaster_preparedness7(String tc_disaster_preparedness7) {
		this.tc_disaster_preparedness7 = tc_disaster_preparedness7;
	}
	public String getTc_dp3_backup_strategy2() {
		return tc_dp3_backup_strategy2;
	}
	public void setTc_dp3_backup_strategy2(String tc_dp3_backup_strategy2) {
		this.tc_dp3_backup_strategy2 = tc_dp3_backup_strategy2;
	}
	public String getTc_dp3_space_quotas2() {
		return tc_dp3_space_quotas2;
	}
	public void setTc_dp3_space_quotas2(String tc_dp3_space_quotas2) {
		this.tc_dp3_space_quotas2 = tc_dp3_space_quotas2;
	}
	public String getTc_disaster_preparedness8() {
		return tc_disaster_preparedness8;
	}
	public void setTc_disaster_preparedness8(String tc_disaster_preparedness8) {
		this.tc_disaster_preparedness8 = tc_disaster_preparedness8;
	}
	public String getTc_dp4_backup_strategy2() {
		return tc_dp4_backup_strategy2;
	}
	public void setTc_dp4_backup_strategy2(String tc_dp4_backup_strategy2) {
		this.tc_dp4_backup_strategy2 = tc_dp4_backup_strategy2;
	}
	public String getTc_dp4_space_quotas2() {
		return tc_dp4_space_quotas2;
	}
	public void setTc_dp4_space_quotas2(String tc_dp4_space_quotas2) {
		this.tc_dp4_space_quotas2 = tc_dp4_space_quotas2;
	}
	public String getRemote_disaster_preparedness2() {
		return remote_disaster_preparedness2;
	}
	public void setRemote_disaster_preparedness2(
			String remote_disaster_preparedness2) {
		this.remote_disaster_preparedness2 = remote_disaster_preparedness2;
	}
	public String getRemote_dp_backup_strategy3() {
		return remote_dp_backup_strategy3;
	}
	public void setRemote_dp_backup_strategy3(String remote_dp_backup_strategy3) {
		this.remote_dp_backup_strategy3 = remote_dp_backup_strategy3;
	}
	public String getRemote_dp_space_quotas3() {
		return remote_dp_space_quotas3;
	}
	public void setRemote_dp_space_quotas3(String remote_dp_space_quotas3) {
		this.remote_dp_space_quotas3 = remote_dp_space_quotas3;
	}
	public String getData_validation_service2() {
		return data_validation_service2;
	}
	public void setData_validation_service2(String data_validation_service2) {
		this.data_validation_service2 = data_validation_service2;
	}
	public String getData_validation_service_times2() {
		return data_validation_service_times2;
	}
	public void setData_validation_service_times2(
			String data_validation_service_times2) {
		this.data_validation_service_times2 = data_validation_service_times2;
	}
	public String getData_disaster_preparedness_drill2() {
		return data_disaster_preparedness_drill2;
	}
	public void setData_disaster_preparedness_drill2(
			String data_disaster_preparedness_drill2) {
		this.data_disaster_preparedness_drill2 = data_disaster_preparedness_drill2;
	}
	public String getData_disaster_preparedness_drill_times2() {
		return data_disaster_preparedness_drill_times2;
	}
	public void setData_disaster_preparedness_drill_times2(
			String data_disaster_preparedness_drill_times2) {
		this.data_disaster_preparedness_drill_times2 = data_disaster_preparedness_drill_times2;
	}
	
	
	
}
