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
import com.ssh.jutem.edit.service.IMaterialService;

public class MaterialAction extends ActionSupport implements ServletRequestAware
{
	public String select()
	{
		try
		{
			System.out.println("this is select material");
			
			searchKey=request.getParameter("searchKey");
			searchType=request.getParameter("searchType");
			
			System.out.println(searchKey+"   "+searchType);
			
			List<Material> materials=materialService.select(searchKey, searchType);
				
			Map<String, List<Material>> map=new HashMap<String, List<Material>>();
			
			map.put("result", materials);
			
			JsonConfig jsonConfig = new JsonConfig();
	        String[] excludes = {"entry","requisition_material"}; 		
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public IMaterialService getMaterialService() {
		return materialService;
	}
	public void setMaterialService(IMaterialService materialService) {
		this.materialService = materialService;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) 
	{
		request=arg0;	
	}

	/*查询*/
	private String searchKey;
	private String searchType;
	
	private String result;
	
	/*type
	 * 0,普通查询
	 * 1,为领料出库单查询
	 * */
/*	private int type=0;*/
	
	private HttpServletRequest request;
	
	@Resource
	private IMaterialService materialService;
		
	private static final long serialVersionUID = 1L;

}
