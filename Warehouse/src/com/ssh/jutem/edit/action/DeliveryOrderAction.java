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
import com.ssh.jutem.edit.model.DeliveryOrder;
import com.ssh.jutem.edit.model.Delivery_Material;
import com.ssh.jutem.edit.model.Material;
import com.ssh.jutem.edit.service.IDeliveryOrderService;

public class DeliveryOrderAction extends  ActionSupport implements ServletRequestAware
{
	public String add() throws Exception
	{
		try
		{
			System.out.println("this is delivery order action");	
			System.out.println(deliveryBean.toString());	
			
			for(Material m:materialBeans)
				System.out.println(m.toString());
			
			if(!deliveryService.add(deliveryBean,materialBeans,deliveryMaterialBeans))
				System.out.println("spring success");
			
			Map<String,String> map=new HashMap<String,String>();
			map.put("result", "添加成功");
			
			JSONObject json=JSONObject.fromObject(map);
			
			result=json.toString();
			
			System.out.println(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	
	public String select() throws Exception
	{
		try
		{
			System.out.println("this is select delivery");
			
			searchKey=request.getParameter("searchKey");
			searchType=request.getParameter("searchType");
			
			System.out.println(searchKey+"   "+searchType);
			
			List<DeliveryOrder> deliverys=deliveryService.select(searchKey, searchType);
				
			Map<String, List<DeliveryOrder>> map=new HashMap<String, List<DeliveryOrder>>();
			
			map.put("result", deliverys);
			
			JsonConfig jsonConfig = new JsonConfig();
	        String[] excludes = {"delivery_material"}; 		
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
		System.out.println("this is select delivery");
		System.out.println(id);
		
		delivery_detials=deliveryService.selectDetial(id);
		
		System.out.println(delivery_detials.toString());
		
		if(isExcel==1)
			return "excel";
		else
			return SUCCESS;
	}
		
	/*get(),set()*/
	public List<Material> getMaterialBeans() {
		return materialBeans;
	}
	public DeliveryOrder getDeliveryBean() {
		return deliveryBean;
	}
	public void setDeliveryBean(DeliveryOrder deliveryBean) {
		this.deliveryBean = deliveryBean;
	}
	public List<Delivery_Material> getDeliveryMaterialBeans() {
		return deliveryMaterialBeans;
	}
	public void setDeliveryMaterialBeans(
			List<Delivery_Material> deliveryMaterialBeans) {
		this.deliveryMaterialBeans = deliveryMaterialBeans;
	}
	public DeliveryOrder getDelivery_detials() {
		return delivery_detials;
	}
	public void setDelivery_detials(DeliveryOrder delivery_detials) {
		this.delivery_detials = delivery_detials;
	}
	public IDeliveryOrderService getDeliveryService() {
		return deliveryService;
	}
	public void setDeliveryService(IDeliveryOrderService deliveryService) {
		this.deliveryService = deliveryService;
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
	private DeliveryOrder deliveryBean;
	private List<Delivery_Material> deliveryMaterialBeans;
	
	/*查询*/
	private String searchKey;
	private String searchType;
	
	private String result;
	
	/*查询详情*/
	private int id;
	private DeliveryOrder delivery_detials;
	
	/*excel*/
	private int isExcel=0; //可改成boolean，strutsBean赋值
	
	private HttpServletRequest request;
	
	@Resource
	private IDeliveryOrderService deliveryService;
	
	private static final long serialVersionUID = 1L;
}
