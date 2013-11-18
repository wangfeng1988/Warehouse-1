package com.ssh.jutem.edit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WarehousingEntry 
{
	private int id;
	private String prepared_by_date;
	private Integer document_number;
	private Integer original_invoice_number;
	private String shipping_warehouse;
	private String supplier;
	private double total_number;
	private double total_money;
	private String remark;	
	private Set<Material> materials=new HashSet<Material>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getDocument_number() {
		return document_number;
	}
	public void setDocument_number(Integer document_number) {
		this.document_number = document_number;
	}
	public Integer getOriginal_invoice_number() {
		return original_invoice_number;
	}
	public void setOriginal_invoice_number(Integer original_invoice_number) {
		this.original_invoice_number = original_invoice_number;
	}
	public String getPrepared_by_date() {
		return prepared_by_date;
	}
	public void setPrepared_by_date(String prepared_by_date) {
		this.prepared_by_date = prepared_by_date;
	}
	public String getShipping_warehouse() {
		return shipping_warehouse;
	}
	public void setShipping_warehouse(String shipping_warehouse) {
		this.shipping_warehouse = shipping_warehouse;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
	
	@OneToMany(mappedBy="entry",cascade={CascadeType.ALL})
	public Set<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}
	
	@Override
	public String toString() {
		return "WarehousingEntry [id=" + id + ", prepared_by_date="
				+ prepared_by_date + ", document_number=" + document_number
				+ ", original_invoice_number=" + original_invoice_number
				+ ", shipping_warehouse=" + shipping_warehouse + ", supplier="
				+ supplier + ", total_number=" + total_number
				+ ", total_money=" + total_money + ", remark=" + remark + "]";
	}
}
