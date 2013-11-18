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
		System.out.println("this is material requisition delete action");
		if(!requisitionService.delete(requisitionBean))
			System.out.println("spring success");
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

	private List<Material> materialBeans;
	private MaterialsRequisition requisitionBean;
	private List<Requisition_Material> requisitionMaterialBeans;
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private List<MaterialsRequisition> result=new ArrayList<MaterialsRequisition>();
	
	@Resource
	private IMaterialsRequisitionService requisitionService;
	
	private static final long serialVersionUID = 1L;

}
