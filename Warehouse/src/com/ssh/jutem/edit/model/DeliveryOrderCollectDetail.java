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
public class DeliveryOrderCollectDetail
{
	private int id;
	private String maked_year_month;
	private String customer_name;
	private double total_money;
	private String remark;
	private Set<DeliveryOrder> deliverys=new HashSet<DeliveryOrder>();
	
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
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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
	@JoinColumn(name = "deliverycollectdetail_id")
	public Set<DeliveryOrder> getDeliverys() {
		return deliverys;
	}
	public void setDeliverys(Set<DeliveryOrder> deliverys) {
		this.deliverys = deliverys;
	}
	
	@Override
	public String toString() {
		return "DeliveryOrderCollectDetail [id=" + id + ", maked_year_month="
				+ maked_year_month + ", customer_name=" + customer_name
				+ ", total_money=" + total_money + ", remark=" + remark + "]";
	}
}
