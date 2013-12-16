package com.ssh.jutem.edit.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;
import com.ssh.jutem.edit.model.Requisition_Material;
import com.ssh.jutem.edit.service.IMaterialsRequisitionService;

public class MaterialsRequisitionAction extends ActionSupport implements ServletRequestAware
{

	public String add()
	{
		System.out.println("this is material requisition action");	
		System.out.println(requisitionBean.toString());	
		
		if(!requisitionService.add(requisitionBean,materialBeans,requisitionMaterialBeans))
			System.out.println("spring success");
		
		return SUCCESS;
	}
	
	
	public String select() throws Exception
	{
		try
		{
			System.out.println("this is select entry");
			
			searchKey=request.getParameter("searchKey");
			searchType=request.getParameter("searchType");
			
			System.out.println(searchKey+"   "+searchType);
			
			List<MaterialsRequisition> requisitions=requisitionService.select(searchKey, searchType);
				
			Map<String, List<MaterialsRequisition>> map=new HashMap<String, List<MaterialsRequisition>>();
			
			map.put("result", requisitions);
			
			JsonConfig jsonConfig = new JsonConfig();
	        String[] excludes = {"requisition_material"}; 		
	        jsonConfig.setExcludes(excludes);
			
			JSONObject json=JSONObject.fromObject(map,jsonConfig);
				
			result=json.toString();
			
			System.out.println(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	public String selectDetails() throws Exception
	{
		System.out.println("this is select requisition");
		System.out.println(id);
		
		requisition_detials=requisitionService.selectDetial(id);
		
		System.out.println(requisition_detials.toString());
		
		if(isExcel==1)
			return "excel";
		else
			return SUCCESS;
	}
		
	/*get(),set()*/
	public MaterialsRequisition getRequisitionBean() {
		return requisitionBean;
	}
	public void setRequisitionBean(MaterialsRequisition requisitionBean) {
		this.requisitionBean = requisitionBean;
	}
	public IMaterialsRequisitionService getRequisitionService() {
		return requisitionService;
	}
	public void setRequisitionService(
			IMaterialsRequisitionService requisitionService) {
		this.requisitionService = requisitionService;
	}
	public List<Requisition_Material> getRequisitionMaterialBeans() {
		return requisitionMaterialBeans;
	}
	public void setRequisitionMaterialBeans(
			List<Requisition_Material> requisitionMaterialBeans) {
		this.requisitionMaterialBeans = requisitionMaterialBeans;
	}
	public List<Material> getMaterialBeans() {
		return materialBeans;
	}
	public void setMaterialBeans(List<Material> materialBeans) {
		this.materialBeans = materialBeans;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MaterialsRequisition getRequisition_detials() {
		return requisition_detials;
	}
	public void setRequisition_detials(MaterialsRequisition requisition_detials) {
		this.requisition_detials = requisition_detials;
	}
	public int getIsExcel() {
		return isExcel;
	}

	public void setIsExcel(int isExcel) {
		this.isExcel = isExcel;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0)
	{
		this.request=arg0;
	}

	private List<Material> materialBeans;
	private MaterialsRequisition requisitionBean;
	private List<Requisition_Material> requisitionMaterialBeans;
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private String result;
	
	/*查询详情*/
	private int id;
	private MaterialsRequisition requisition_detials;
	
	/*excel*/
	private int isExcel=0; //可改成boolean，strutsBean赋值
	
	private HttpServletRequest request;
	
	@Resource
	private IMaterialsRequisitionService requisitionService;
	
	private static final long serialVersionUID = 1L;

}
