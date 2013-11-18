package com.ssh.jutem.edit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Requisition_Material
{
	private int id;
	private int number;
	private MaterialsRequisition requisition;
	private Material material;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=(CascadeType.ALL))
	@JoinColumn(name="requisition_id")
	public MaterialsRequisition getRequisition() {
		return requisition;
	}
	public void setRequisition(MaterialsRequisition requisition) {
		this.requisition = requisition;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=(CascadeType.ALL))
	@JoinColumn(name="material_id")
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	@Override
	public String toString() {
		return "Requisition_Material [id=" + id + ", number=" + number + "]";
	}	
}
