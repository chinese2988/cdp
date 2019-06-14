package action.user;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import dao.user.actionDao;
import dao.user.departmentDao;
import dao.user.roleDao;
import action.BaseAction;
import entity.user.d_action;
import entity.user.d_role;
import entity.user.d_user;
import entity.user.department;

public class deptUpAction extends BaseAction{
	private ArrayList<d_action> dacs;
	private ArrayList<d_action> adparentIds;
	private actionDao ad=new actionDao();
	private  d_role dr;
	private roleDao rd=new roleDao();
	
	private String message="";
	private department dept;
	private int pageNow ; // 初始化为1,默认从第一页开始显示
	private int pageSize=5; // 每页显示5条记录
	
	private int num; // 总数

	private int totalPage; // 总页数
	private int pageNum;// 页数
	
	 private File file;
	    
	    //提交过来的file的名字
	    private String fileFileName;
	    
	    //提交过来的file的MIME类型
	    private String fileContentType;
public ArrayList roles(String role){
		
		
		ArrayList roles=new ArrayList();
		String[] ro=role.split(",");
		for(int i=0;i<ro.length;i++){
			int p =Integer.parseInt(ro[i].toString());
			roles.add(p);
		}
		return roles;
	}

	private ArrayList<department> depts;
public String execute() {
		
		if (session.get("user_session") != null) {
			
			 departmentDao dpd=new departmentDao();
			
			try {
				//用户登陆和权限判断
				 d_user u=(d_user) this.session.get("user_session");
				 dr= rd.findroleById(u.getUserroleid());
				 
				adparentIds=ad.findparentIdS();
				 dacs=ad.findAllUser();
				 ArrayList roles=this.roles(dr.getRolecontent());
				 for(int i=0;i<dacs.size();i++){
					 	int pid=dacs.get(i).getParentid();
						int s=dacs.get(i).getId();
						for(int p=0;p<roles.size();p++){
							int ss=(Integer) roles.get(p);
							
							if(s==ss){
							
								dacs.get(i).setParentid(pid);
								break;
							}else{
								dacs.get(i).setParentid(0);
							}
						}
					}
					//END用户登陆和权限判断结束
				 
				 String root = ServletActionContext.getServletContext().getRealPath("/upload");
				 if(dept.getPicture()!=null&&fileFileName!=null && fileFileName.length()!=0){
					 File saveFile = new File(new File(root), fileFileName);
				        if(!saveFile.getParentFile().exists()){     //如果Images文件夹不存在  
				            saveFile.getParentFile().mkdirs();      //则创建新的多级文件夹  
				              
				        }  
				        FileUtils.copyFile(file, saveFile); 
				        System.out.println(saveFile);
				        dept.setPicture(saveFile.toString());
				 }
				 
				
				 
				 
				 
				 
				dpd.updateDept(dept);
				
			
				 depts=dpd.findAllDepts();
				 message="更新成功";
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message="更新失败";
				return "error";
			}
			}else{
				return "login";
			}
		}
public department getDept() {
	return dept;
}
public void setDept(department dept) {
	this.dept = dept;
}
public int getPageNow() {
	return pageNow;
}
public void setPageNow(int pageNow) {
	this.pageNow = pageNow;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getPageNum() {
	return pageNum;
}
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
public ArrayList<department> getDepts() {
	return depts;
}
public void setDepts(ArrayList<department> depts) {
	this.depts = depts;
}
public ArrayList<d_action> getDacs() {
	return dacs;
}
public void setDacs(ArrayList<d_action> dacs) {
	this.dacs = dacs;
}
public ArrayList<d_action> getAdparentIds() {
	return adparentIds;
}
public void setAdparentIds(ArrayList<d_action> adparentIds) {
	this.adparentIds = adparentIds;
}
public actionDao getAd() {
	return ad;
}
public void setAd(actionDao ad) {
	this.ad = ad;
}
public d_role getDr() {
	return dr;
}
public void setDr(d_role dr) {
	this.dr = dr;
}
public roleDao getRd() {
	return rd;
}
public void setRd(roleDao rd) {
	this.rd = rd;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public File getFile() {
	return file;
}
public void setFile(File file) {
	this.file = file;
}
public String getFileFileName() {
	return fileFileName;
}
public void setFileFileName(String fileFileName) {
	this.fileFileName = fileFileName;
}
public String getFileContentType() {
	return fileContentType;
}
public void setFileContentType(String fileContentType) {
	this.fileContentType = fileContentType;
}


}
