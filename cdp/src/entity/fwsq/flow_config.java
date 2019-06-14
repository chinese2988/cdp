package entity.fwsq;

public class flow_config {
	private int   id		;//	bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	private String   lcdm		;//varchar(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '流程代码',
	private String   lcmc		;//varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '流程名称',
	private int   jddm		;//int(2) DEFAULT NULL COMMENT '节点代码',
	private String   jdmc		;//varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '节点名称',
	private String   dqjs		;//varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '待签角色（多个用,分割）',
	private String   dbjs		;//varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '待办角色（多个用,分割）',
	private String   bjbz		;//char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '办结标志',
	private String   create_by	;//	varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人',
	private String   update_by	;//	varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '修改人',
	private String   remarks	;//	varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
	private String   create_date	;//	datetime DEFAULT NULL COMMENT '创建时间',
	private String   update_date	;//	datetime DEFAULT NULL COMMENT '修改时间',
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLcdm() {
		return lcdm;
	}
	public void setLcdm(String lcdm) {
		this.lcdm = lcdm;
	}
	public String getLcmc() {
		return lcmc;
	}
	public void setLcmc(String lcmc) {
		this.lcmc = lcmc;
	}
	public int getJddm() {
		return jddm;
	}
	public void setJddm(int jddm) {
		this.jddm = jddm;
	}
	public String getJdmc() {
		return jdmc;
	}
	public void setJdmc(String jdmc) {
		this.jdmc = jdmc;
	}
	public String getDqjs() {
		return dqjs;
	}
	public void setDqjs(String dqjs) {
		this.dqjs = dqjs;
	}
	public String getDbjs() {
		return dbjs;
	}
	public void setDbjs(String dbjs) {
		this.dbjs = dbjs;
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
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
}
