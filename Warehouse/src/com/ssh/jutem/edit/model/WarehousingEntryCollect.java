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
public class WarehousingEntryCollect 
{
	private int id;
	private String maked_year_month;
	private double total_money;
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
	public double getTotal_money() {
		return total_money;
	}
	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name = "entrycollect_id")
	public Set<WarehousingEntry> getEntrys() {
		return entrys;
	}
	public void setEntrys(Set<WarehousingEntry> entrys) {
		this.entrys = entrys;
	}
	
	@Override
	public String toString() {
		return "WarehousingEntryCollect [id=" + id + ", maked_year_month="
				+ maked_year_month + ", total_money=" + total_money
				+ ", entrys=" + entrys + "]";
	}
}
