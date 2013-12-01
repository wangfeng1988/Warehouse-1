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
public class MaterialsRequisitionCollectDetail
{
	private int id;
	private String maked_year_month;
	private String requisition_unit;
	private double total_money;
	private String remark;
	private Set<MaterialsRequisition> requisitions=new HashSet<MaterialsRequisition>();
	
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
	public String getRequisition_unit() {
		return requisition_unit;
	}
	public void setRequisition_unit(String requisition_unit) {
		this.requisition_unit = requisition_unit;
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
	@JoinColumn(name = "requisitioncollectdetail_id")
	public Set<MaterialsRequisition> getRequisitions() {
		return requisitions;
	}
	public void setRequisitions(Set<MaterialsRequisition> requisitions) {
		this.requisitions = requisitions;
	}
	
	@Override
	public String toString() {
		return "MaterialsRequisitionCollectDetail [id=" + id
				+ ", maked_year_month=" + maked_year_month
				+ ", requisition_unit=" + requisition_unit + ", total_money="
				+ total_money + ", remark=" + remark + "]";
	}
}
