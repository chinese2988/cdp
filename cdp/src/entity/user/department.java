package entity.user;

public class department {
	private int id;
	private int bmbh;//部门编号
	private String bmmc;//部门名称
	
	private int sjbmbh;//上级部门编号
	private String sjbmmc;//上级部门名称
	private int xthj;//系统合计
	private int zjhj;//主机合计
	private double ghrl;//规划容量
	private double syrl;//使用容量
	private double kxrl;//空闲容量
	private int	ybmbh;//原始部门编号
	private String	chartdata;//详细架构图
	private String	dwdz;//单位地址
	private String bmjc;//部门简称
	private int	tsbj;//特殊标记 部门标记（区分备份单位与系统其他单位）0为不统计 1为统计标志
	private String picture;
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBmbh() {
		return bmbh;
	}
	public void setBmbh(int bmbh) {
		this.bmbh = bmbh;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}
	
	public int getSjbmbh() {
		return sjbmbh;
	}
	public void setSjbmbh(int sjbmbh) {
		this.sjbmbh = sjbmbh;
	}
	public String getSjbmmc() {
		return sjbmmc;
	}
	public void setSjbmmc(String sjbmmc) {
		this.sjbmmc = sjbmmc;
	}
	public int getXthj() {
		return xthj;
	}
	public void setXthj(int xthj) {
		this.xthj = xthj;
	}
	public int getZjhj() {
		return zjhj;
	}
	public void setZjhj(int zjhj) {
		this.zjhj = zjhj;
	}
	public double getGhrl() {
		return ghrl;
	}
	public void setGhrl(double ghrl) {
		this.ghrl = ghrl;
	}
	public double getSyrl() {
		return syrl;
	}
	public void setSyrl(double syrl) {
		this.syrl = syrl;
	}
	public double getKxrl() {
		return kxrl;
	}
	public void setKxrl(double kxrl) {
		this.kxrl = kxrl;
	}
	public int getYbmbh() {
		return ybmbh;
	}
	public void setYbmbh(int ybmbh) {
		this.ybmbh = ybmbh;
	}
	public String getChartdata() {
		return chartdata;
	}
	public void setChartdata(String chartdata) {
		this.chartdata = chartdata;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getBmjc() {
		return bmjc;
	}
	public void setBmjc(String bmjc) {
		this.bmjc = bmjc;
	}
	public int getTsbj() {
		return tsbj;
	}
	public void setTsbj(int tsbj) {
		this.tsbj = tsbj;
	}
	
}
