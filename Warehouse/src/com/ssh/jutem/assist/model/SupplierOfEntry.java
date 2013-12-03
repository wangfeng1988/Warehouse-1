package com.ssh.jutem.assist.model;

import java.util.HashSet;
import java.util.Set;

import com.ssh.jutem.edit.model.WarehousingEntry;

public class SupplierOfEntry 
{
	private String supplier;
	private double total_money;
	private String remark;
	private Set<WarehousingEntry> entrys=new HashSet<WarehousingEntry>();
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getTotal_money() {
		return total_money;
	}
	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}
	public Set<WarehousingEntry> getEntrys() {
		return entrys;
	}
	public void setEntrys(Set<WarehousingEntry> entrys) {
		this.entrys = entrys;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "SupplierOfEntry [supplier=" + supplier + ", total_money="
				+ total_money + ", entrys=" + entrys + "]";
	}
	
}
