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
import com.ssh.jutem.edit.model.WarehousingEntryCollect;
import com.ssh.jutem.edit.service.IWarehousingEntryCollectService;

public class WarehousingEntryCollectAction extends ActionSupport implements ServletRequestAware
{

	//由于点击详情会刷新搜索页面，这个时候存在BUG会使以下两项为空，所以验证防止出错（之后ajax修改)
/*	public void validateSelect()
	{
		if(searchKey==null || searchType==null)
			addFieldError("search_error","请填写必要信息");
	}*/
	
	public String select() throws Exception
	{
		try
		{
			System.out.println("this is select entry collect");
				
			searchKey=request.getParameter("searchKey");
			searchType=request.getParameter("searchType");
			
			System.out.println(searchKey+"   "+searchType);
			
			List<WarehousingEntryCollect> collects=entryCollectService.select(searchKey, searchType);
			
			Map<String, List<WarehousingEntryCollect>> map=new HashMap<String, List<WarehousingEntryCollect>>();
			
			map.put("result", collects);
			
			JsonConfig jsonConfig = new JsonConfig();
	        String[] excludes = {"entrysdetail"}; 		
	        jsonConfig.setExcludes(excludes);
			
			JSONObject json=JSONObject.fromObject(map,jsonConfig);
				
			result=json.toString();
			
			System.out.println(result);
		}
		catch (Exception e) 
		{
			 e.printStackTrace();
		}
	
		return SUCCESS;
	}
	
	public String selectDetails() throws Exception
	{
		System.out.println("this is select entry collect details");
		System.out.println(id);
		System.out.println(tag);
		
		entryCollect_details=entryCollectService.selectDetial(id);
		
		System.out.println(entryCollect_details.toString());
		
		/*标志0-3,分别为，汇总详情，制作汇总详情excel，明细，制作明细详情excel*/
		switch(tag)
		{
		case 0:
			return SUCCESS;
		case 1:
			return "excel";
		case 2:
			return "detail";
		case 3:
			return "detail_excel";
		default:
			return null;
		}
	}
	
	/*get(),set()*/
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
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
	public WarehousingEntryCollect getEntryCollect_details() {
		return entryCollect_details;
	}
	public void setEntryCollect_details(WarehousingEntryCollect entryCollect_details) {
		this.entryCollect_details = entryCollect_details;
	}
	public IWarehousingEntryCollectService getEntryCollectService() {
		return entryCollectService;
	}
	public void setEntryCollectService(
			IWarehousingEntryCollectService entryCollectService) {
		this.entryCollectService = entryCollectService;
	}
	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		
	}
	

/*	private WarehousingEntryCollect entryCollectBean;
	private List<WarehousingEntry> entryBeans;*/

	/*查询*/
	private String searchKey;
	private String searchType;
	
	private String result;
	
	/*查询详情*/
	private int id;
	private WarehousingEntryCollect entryCollect_details;
	
	/*查询跳转标志*/
	private int tag=0;
	
	private HttpServletRequest request;
	
	@Resource
	private IWarehousingEntryCollectService entryCollectService; 
	
	private static final long serialVersionUID = 1L;

}
