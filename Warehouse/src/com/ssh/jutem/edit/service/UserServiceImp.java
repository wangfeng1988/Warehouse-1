package com.ssh.jutem.edit.service;

import java.util.List;

import javax.annotation.Resource;

import com.ssh.jutem.edit.dao.IUserDao;
import com.ssh.jutem.edit.model.User;

public class UserServiceImp implements IUserService
{
	@Override
	public boolean login(String userName, String password) 
	{
		System.out.println("This is select user service");
		
		List<?> temp_all=selectAll();
		
		for(Object u:temp_all)
		{
			if(((User) u).getName().equals(userName) && ((User) u).getPassword().equals(password))
				return true;
		}
		return false;
	}

	private List<?> selectAll() 
	{
		if(!isCache)
		{
			System.out.println("not cache");
			
			allOfUser=userDao.selectAll();			
			isCache=true;
		}
		else
		{
			System.out.println("cache");
		}
		
		return allOfUser;
	}
	
	/*get(),set()*/
	public static List<?> getAllOfUser() {
		return allOfUser;
	}
	public static void setAllOfUser(List<?> allOfUser) {
		UserServiceImp.allOfUser = allOfUser;
	}
	public static boolean isCache() {
		return isCache;
	}
	public static void setCache(boolean isCache) {
		UserServiceImp.isCache = isCache;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/*User cache*/
	private static List<?> allOfUser;
	private static boolean isCache=false;
	
	@Resource
	private IUserDao userDao;
	
}
