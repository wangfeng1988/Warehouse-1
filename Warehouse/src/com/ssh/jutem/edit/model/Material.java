package com.ssh.jutem.edit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Material 
{
	private Integer id;
	private String coding;	//货品编码
	private String name;	//货品名称
	private String specification;	//货品规格
	private String unit;	//单位
	private double warehousing_price;	//入库单价
	private double sales_price;		//销售单价
	private double amount;	//总数
	private double stock;	//现有库存
	private double money;	//入库价值=总数*入库单价
	private String remark;	//备注
	private WarehousingEntry entry;	
	private Set<Requisition_Material> requisition_material=new HashSet<Requisition_Material>();
	private Set<Delivery_Material> delivery_material=new HashSet<Delivery_Material>();
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCoding() {
		return coding;
	}
	public void setCoding(String coding) {
		this.coding = coding;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getWarehousing_price() {
		return warehousing_price;
	}
	public void setWarehousing_price(double warehousing_price) {
		this.warehousing_price = warehousing_price;
	}
	public double getSales_price() {
		return sales_price;
	}
	public void setSales_price(double sales_price) {
		this.sales_price = sales_price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=(CascadeType.ALL))
	@JoinColumn(name="entry_id")
	public WarehousingEntry getEntry() {
		return entry;
	}
	public void setEntry(WarehousingEntry entry) {
		this.entry = entry;
	}
	
	@OneToMany(mappedBy="material",cascade={CascadeType.ALL})
	public Set<Requisition_Material> getRequisition_material() {
		return requisition_material;
	}
	public void setRequisition_material(
			Set<Requisition_Material> requisition_material) {
		this.requisition_material = requisition_material;
	}
	@OneToMany(mappedBy="material",cascade={CascadeType.ALL})
	public Set<Delivery_Material> getDelivery_material() {
		return delivery_material;
	}
	public void setDelivery_material(Set<Delivery_Material> delivery_material) {
		this.delivery_material = delivery_material;
	}
	@Override
	public String toString() {
		return "Material [id=" + id + ", coding=" + coding + ", name=" + name
				+ ", specification=" + specification + ", unit=" + unit
				+ ", warehousing_price=" + warehousing_price + ", sales_price="
				+ sales_price + ", amount=" + amount + ", stock=" + stock
				+ ", money=" + money + ", remark=" + remark + "]";
	}
}
