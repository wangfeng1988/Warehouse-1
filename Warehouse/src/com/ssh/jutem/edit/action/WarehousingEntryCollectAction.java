package com.ssh.jutem.edit.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.assist.model.SupplierOfEntry;
import com.ssh.jutem.edit.model.WarehousingEntryCollect;
import com.ssh.jutem.edit.service.IWarehousingEntryCollectService;

public class WarehousingEntryCollectAction extends ActionSupport
{

	//由于点击详情会刷新搜索页面，这个时候存在BUG会使以下两项为空，所以验证防止出错（之后ajax修改)
	public void validateSelect()
	{
		if(searchKey==null || searchType==null)
			addFieldError("search_error","请填写必要信息");
	}
	
	public String select() throws Exception
	{
		System.out.println("this is select entry collect");
		System.out.println(searchKey+"   "+searchType);
		
		result=entryCollectService.select(searchKey, searchType);
		
		System.out.println(result);
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String selectDetails() throws Exception
	{
		System.out.println("this is select entry collect details");
		System.out.println(id);
		System.out.println(isExcel);
		
		entryCollect_detials=(WarehousingEntryCollect) entryCollectService.selectDetial(id).get("Collect");
		supplier_of_entrys=(Set<SupplierOfEntry>) entryCollectService.selectDetial(id).get("SupplierOfEntry");
		
		System.out.println(entryCollect_detials.toString());
		System.out.println(supplier_of_entrys.toString());
		
		if(isExcel==1)
			return "excel";
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
	public List<WarehousingEntryCollect> getResult() {
		return result;
	}
	public void setResult(List<WarehousingEntryCollect> result) {
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
	public WarehousingEntryCollect getEntryCollect_detials() {
		return entryCollect_detials;
	}
	public void setEntryCollect_detials(WarehousingEntryCollect entryCollect_detials) {
		this.entryCollect_detials = entryCollect_detials;
	}
	public IWarehousingEntryCollectService getEntryCollectService() {
		return entryCollectService;
	}
	public void setEntryCollectService(
			IWarehousingEntryCollectService entryCollectService) {
		this.entryCollectService = entryCollectService;
	}
	public int getIsExcel() {
		return isExcel;
	}
	public void setIsExcel(int isExcel) {
		this.isExcel = isExcel;
	}
	public Set<SupplierOfEntry> getSupplier_of_entrys() {
		return supplier_of_entrys;
	}
	public void setSupplier_of_entrys(Set<SupplierOfEntry> supplier_of_entrys) {
		this.supplier_of_entrys = supplier_of_entrys;
	}

/*	private WarehousingEntryCollect entryCollectBean;
	private List<WarehousingEntry> entryBeans;*/
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private List<WarehousingEntryCollect> result=new ArrayList<WarehousingEntryCollect>();
	
	/*查询详情*/
	private int id;
	private WarehousingEntryCollect entryCollect_detials;
	
	/*查询明细,分类汇总*/
	private Set<SupplierOfEntry> supplier_of_entrys;
	
	/*excel*/
	private int isExcel=0; //可改成boolean，strutsBean赋值
	
	@Resource
	private IWarehousingEntryCollectService entryCollectService; 
	
	private static final long serialVersionUID = 1L;
}
