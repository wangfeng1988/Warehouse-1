package com.ssh.jutem.edit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.edit.service.IUserService;

public class UserAction extends ActionSupport implements ServletRequestAware
{
	public String login()
	{
		try
		{
			System.out.println("this is user login");
			System.out.println(username+"   "+password);
			
			Map<String, Boolean> map=new HashMap<String, Boolean>();
			
			if(userService.login(username,password))
				map.put("result", true);
			else
				map.put("result", false);
						
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
	
	/*get(),set()*/
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) 
	{
		request=arg0;	
	}

	/*查询*/
	private String username;
	private String password;
	
	private String result;
	
	private HttpServletRequest request;
	
	@Resource
	private IUserService userService;
		
	private static final long serialVersionUID = 1L;

}
