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
import com.ssh.jutem.edit.model.WarehousingEntry;
import com.ssh.jutem.edit.service.IWarehousingEntryService;

public class WarehousingEntryAction extends ActionSupport implements ServletRequestAware
{
	public void validateAdd()
	{
		for(Material m:materialBeans)
		{
			if(m==null)
				continue;
			if(m.getCoding()==null || m.getName()==null || m.getSpecification()==null || m.getUnit()==null || m.getWarehousing_price()==0
					|| m.getSales_price()==0 || m.getAmount()==0 || m.getMoney()==0)
				addFieldError("material_error","请正确填写必要信息");
		}
	}
	
	public String add() throws Exception
	{
		try
		{
			System.out.println("this is warehousing entry action");	
			System.out.println(entryBean.toString());
			for(Material m:materialBeans)
				System.out.println(m.toString());
			
			Map<String,String> map=new HashMap<String,String>();
			map.put("result", "添加成功");
			
			JSONObject json=JSONObject.fromObject(map);
			
			result=json.toString();
			
			System.out.println(result);
			
			if(!entryService.add(entryBean,materialBeans))
				System.out.println("spring success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	public String delete() throws Exception
	{
		System.out.println("this is warehousing delete action");
		if(!entryService.delete(entryBean))
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
			
			List<WarehousingEntry> entrys=entryService.select(searchKey, searchType);
				
			Map<String, List<WarehousingEntry>> map=new HashMap<String, List<WarehousingEntry>>();
			
			map.put("result", entrys);
			
			JsonConfig jsonConfig = new JsonConfig();
	        String[] excludes = {"materials"}; 		
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
		System.out.println("this is select entry");
		System.out.println(id);
		System.out.println(isExcel);
		
		entry_details=entryService.selectDetial(id);
		
		System.out.println(entry_details.toString());
		
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
	public WarehousingEntry getEntry_details() {
		return entry_details;
	}
	public void setEntry_details(WarehousingEntry entry_details) {
		this.entry_details = entry_details;
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

	private WarehousingEntry entryBean;
	private List<Material> materialBeans;
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private String result;
	
	/*查询详情*/
	private int id;
	private WarehousingEntry entry_details;
	/*excel*/
	private int isExcel=0; //可改成boolean，strutsBean赋值
	
	private HttpServletRequest request;
	
	@Resource
	private IWarehousingEntryService entryService; 
	
	private static final long serialVersionUID = 1L;

}
