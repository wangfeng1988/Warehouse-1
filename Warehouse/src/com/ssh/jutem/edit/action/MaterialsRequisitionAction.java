package com.ssh.jutem.edit.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.MaterialsRequisition;
import com.ssh.jutem.edit.model.Requisition_Material;
import com.ssh.jutem.edit.service.IMaterialsRequisitionService;

public class MaterialsRequisitionAction extends ActionSupport 
{
	//由于点击详情会刷新搜索页面，这个时候存在BUG会使以下两项为空，所以验证防止出错（之后ajax修改)
	public void validateSelect()
	{
		if(searchKey==null || searchType==null)
			addFieldError("search_error","请填写必要信息");
	}
	
	public String add()
	{
		System.out.println("this is material requisition action");	
		System.out.println(requisitionBean.toString());	
		
		if(!requisitionService.add(requisitionBean,materialBeans,requisitionMaterialBeans))
			System.out.println("spring success");
		
		return SUCCESS;
	}
	
	public String delete()
	{
/*		System.out.println("this is material requisition delete action");
		if(!requisitionService.delete(requisitionBean))
			System.out.println("spring success");*/
		return SUCCESS;
	}
	
	public String modify()
	{
		return SUCCESS;
	}
	
	public String select() throws Exception
	{
		System.out.println("this is select entry");
		System.out.println(searchKey+"   "+searchType);
		
		result=requisitionService.select(searchKey, searchType);
		
		System.out.println(result);
		
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
	public List<MaterialsRequisition> getResult() {
		return result;
	}
	public void setResult(List<MaterialsRequisition> result) {
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

	private List<Material> materialBeans;
	private MaterialsRequisition requisitionBean;
	private List<Requisition_Material> requisitionMaterialBeans;
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private List<MaterialsRequisition> result=new ArrayList<MaterialsRequisition>();
	
	/*查询详情*/
	private int id;
	private MaterialsRequisition requisition_detials;
	
	/*excel*/
	private int isExcel=0; //可改成boolean，strutsBean赋值
	
	@Resource
	private IMaterialsRequisitionService requisitionService;
	
	private static final long serialVersionUID = 1L;

}
