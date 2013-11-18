package com.ssh.jutem.edit.model;


public class DeliveryOrder 
{
	private int id;
	private String prepared_by_date;
	private Integer document_number;
	private String shipping_warehouse;
	private String customer_name;
	private double total_number;
	private double total_money;
	private String remark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getPrepared_by_date() {
		return prepared_by_date;
	}
	public void setPrepared_by_date(String prepared_by_date) {
		this.prepared_by_date = prepared_by_date;
	}
	public Integer getDocument_number() {
		return document_number;
	}
	public void setDocument_number(Integer document_number) {
		this.document_number = document_number;
	}
	public String getShipping_warehouse() {
		return shipping_warehouse;
	}
	public void setShipping_warehouse(String shipping_warehouse) {
		this.shipping_warehouse = shipping_warehouse;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public double getTotal_number() {
		return total_number;
	}
	public void setTotal_number(double total_number) {
		this.total_number = total_number;
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
	
	@Override
	public String toString() {
		return "DeliveryOrder [id=" + id + ", prepared_by_date="
				+ prepared_by_date + ", document_number=" + document_number
				+ ", shipping_warehouse=" + shipping_warehouse
				+ ", customer_name=" + customer_name + ", total_number="
				+ total_number + ", total_money=" + total_money + ", remark="
				+ remark + "]";
	}	
}
