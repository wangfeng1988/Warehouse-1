package com.ssh.jutem.edit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class WarehousingEntryCollectDetail
{
	private int id;
	private String maked_year_month;
	private String supplier;
	private double total_money;
	private String remark;
	private Set<WarehousingEntry> entrys=new HashSet<WarehousingEntry>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaked_year_month() {
		return maked_year_month;
	}
	public void setMaked_year_month(String maked_year_month) {
		this.maked_year_month = maked_year_month;
	}
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name = "entrycollectdetail_id")
	public Set<WarehousingEntry> getEntrys() {
		return entrys;
	}
	public void setEntrys(Set<WarehousingEntry> entrys) {
		this.entrys = entrys;
	}
	
	@Override
	public String toString() {
		return "WarehouseingEntryCollectDetail [supplier=" + supplier
				+ ", total_money=" + total_money + ", remark=" + remark
				+ ", entrys=" + entrys + "]";
	}
}
