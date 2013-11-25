package com.ssh.jutem.edit.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.service.IMaterialService;

public class MaterialAction extends ActionSupport
{
	public String select()
	{
		System.out.println("this is select material");
		System.out.println(searchKey+"   "+searchType);
		
		result=materialService.select(searchKey, searchType);
		
		System.out.println(result);
		
		if(type==1)
			return "for_req";
		else
			return SUCCESS;
	}
	
	/*get(),set()*/
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
	public List<Material> getResult() {
		return result;
	}
	public void setResult(List<Material> result) {
		this.result = result;
	}
	public IMaterialService getMaterialService() {
		return materialService;
	}
	public void setMaterialService(IMaterialService materialService) {
		this.materialService = materialService;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	/*查询*/
	private String searchKey;
	private String searchType;
	
	/*type
	 * 0,普通查询
	 * 1,为领料出库单查询
	 * */
	private int type=0;
	
	private List<Material> result=new ArrayList<Material>();
	
	@Resource
	private IMaterialService materialService;
		
	private static final long serialVersionUID = 1L;
}
