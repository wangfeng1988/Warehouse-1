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
import com.ssh.jutem.edit.model.DeliveryOrderCollect;
import com.ssh.jutem.edit.service.IDeliveryOrderCollectService;

public class DeliveryOrderCollectAction extends ActionSupport implements ServletRequestAware
{
	public String select() throws Exception
	{
		try
		{
			System.out.println("this is select delivery collect");
				
			searchKey=request.getParameter("searchKey");
			searchType=request.getParameter("searchType");
			
			System.out.println(searchKey+"   "+searchType);
			
			List<DeliveryOrderCollect> collects=deliveryCollectService.select(searchKey, searchType);
			
			Map<String, List<DeliveryOrderCollect>> map=new HashMap<String, List<DeliveryOrderCollect>>();
			
			map.put("result", collects);
			
			JsonConfig jsonConfig = new JsonConfig();
	        String[] excludes = {"deliverysdetail"}; 		
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
		System.out.println("this is select delivery collect details");
		System.out.println(id);
		System.out.println(tag);
		
		deliveryCollect_details=deliveryCollectService.selectDetial(id);
		
		System.out.println(deliveryCollect_details.toString());
		
		/*标志0-3,分别为汇总详情，制作汇总详情excel，明细，制作明细详情excel*/
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
	public DeliveryOrderCollect getDeliveryCollect_details() {
		return deliveryCollect_details;
	}
	public void setDeliveryCollect_details(
			DeliveryOrderCollect deliveryCollect_details) {
		this.deliveryCollect_details = deliveryCollect_details;
	}
	public IDeliveryOrderCollectService getDeliveryCollectService() {
		return deliveryCollectService;
	}
	public void setDeliveryCollectService(
			IDeliveryOrderCollectService deliveryCollectService) {
		this.deliveryCollectService = deliveryCollectService;
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
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private String result;
	
	/*查询详情*/
	private int id;
	private DeliveryOrderCollect deliveryCollect_details;
	
	/*查询跳转标志*/
	private int tag=0;
	
	private HttpServletRequest request;
	
	@Resource
	private IDeliveryOrderCollectService deliveryCollectService; 
	
	private static final long serialVersionUID = 1L;
}
