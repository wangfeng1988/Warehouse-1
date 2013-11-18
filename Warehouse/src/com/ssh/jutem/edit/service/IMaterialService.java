package com.ssh.jutem.edit.service;

import java.util.List;

import com.ssh.jutem.edit.model.Material;


public interface IMaterialService 
{
	public List<Material> select(String searchKey, String searchType);
}
