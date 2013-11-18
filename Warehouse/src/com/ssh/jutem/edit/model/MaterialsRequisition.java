package com.ssh.jutem.edit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MaterialsRequisition 
{
	private int id;
	private String prepared_by_date;
	private Integer document_number;
	private Integer original_invoice_number;
	private String shipping_warehouse;
	private String requisition_unit;
	private double total_number;
	private double total_money;
	private String remark;	
	private Set<Requisition_Material> requisition_material=new HashSet<Requisition_Material>();
	
	@Id
	@GeneratedValue
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
	public Integer getOriginal_invoice_number() {
		return original_invoice_number;
	}
	public void setOriginal_invoice_number(Integer original_invoice_number) {
		this.original_invoice_number = original_invoice_number;
	}
	public String getShipping_warehouse() {
		return shipping_warehouse;
	}
	public void setShipping_warehouse(String shipping_warehouse) {
		this.shipping_warehouse = shipping_warehouse;
	}
	public String getRequisition_unit() {
		return requisition_unit;
	}
	public void setRequisition_unit(String requisition_unit) {
		this.requisition_unit = requisition_unit;
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
	
	@OneToMany(mappedBy="requisition",cascade={CascadeType.ALL})
	public Set<Requisition_Material> getRequisition_material() {
		return requisition_material;
	}
	public void setRequisition_material(
			Set<Requisition_Material> requisition_material) {
		this.requisition_material = requisition_material;
	}
	
	@Override
	public String toString() {
		return "MaterialsRequisition [id=" + id + ", prepared_by_date="
				+ prepared_by_date + ", document_number=" + document_number
				+ ", original_invoice_number=" + original_invoice_number
				+ ", shipping_warehouse=" + shipping_warehouse
				+ ", requisition_unit=" + requisition_unit + ", total_number="
				+ total_number + ", total_money=" + total_money + ", remark="
				+ remark + "]";
	}
}
