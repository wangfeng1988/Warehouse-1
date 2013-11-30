package com.ssh.jutem.edit.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.model.WarehousingEntry;
import com.ssh.jutem.edit.service.IWarehousingEntryService;

public class WarehousingEntryCollectAction extends ActionSupport
{
	public String add() throws Exception
	{
		System.out.println("this is warehousing entry action");	
		System.out.println(entryBean.toString());
		for(Material m:materialBeans)
			System.out.println(m.toString());
		
		if(!entryService.add(entryBean,materialBeans))
			System.out.println("spring success");
		return SUCCESS;
	}
	
	public String delete() throws Exception
	{
		System.out.println("this is warehousing delete action");
		if(!entryService.delete(entryBean))
			System.out.println("spring success");
		return SUCCESS;
	}
	
	public String modify() throws Exception
	{
		return SUCCESS;
	}
	
	public String select() throws Exception
	{
		System.out.println("this is select entry");
		System.out.println(searchKey+"   "+searchType);
		
		result=entryService.select(searchKey, searchType);
		
		System.out.println(result);
		
		return SUCCESS;
	}
	
	public String selectDetails() throws Exception
	{
		System.out.println("this is select entry");
		System.out.println(id);
		System.out.println(isExcel);
		
		entry_detials=entryService.selectDetial(id);
		
		System.out.println(entry_detials.toString());
		
		if(isExcel==1)
			return "excel";
		else
			return SUCCESS;
	}
	
	/*get(),set()*/
	public WarehousingEntry getEntryBean() {
		return entryBean;
	}
	public void setEntryBean(WarehousingEntry entryBean) {
		this.entryBean = entryBean;
	}
	public IWarehousingEntryService getEntryService() {
		return entryService;
	}
	public void setEntryService(IWarehousingEntryService entryService) {
		this.entryService = entryService;
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
	public List<WarehousingEntry> getResult() {
		return result;
	}
	public void setResult(List<WarehousingEntry> result) {
		this.result = result;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WarehousingEntry getEntry_detials() {
		return entry_detials;
	}
	public void setEntry_detials(WarehousingEntry entry_detials) {
		this.entry_detials = entry_detials;
	}
	public int getIsExcel() {
		return isExcel;
	}

	public void setIsExcel(int isExcel) {
		this.isExcel = isExcel;
	}

	private WarehousingEntry entryBean;
	private List<Material> materialBeans;
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private List<WarehousingEntry> result=new ArrayList<WarehousingEntry>();
	
	/*查询详情*/
	private int id;
	private WarehousingEntry entry_detials;
	/*excel*/
	private int isExcel=0; //可改成boolean，strutsBean赋值
	
	@Resource
	private IWarehousingEntryService entryService; 
	
	private static final long serialVersionUID = 1L;
}