package com.ssh.jutem.edit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.jutem.edit.model.DeliveryOrder;
import com.ssh.jutem.edit.service.IDeliverOrderService;

public class DeliveryOrderAction extends  ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private DeliveryOrder orderBean;
	private IDeliverOrderService orderService;
	
	public String add()
	{
		return SUCCESS;
	}
	
	public String delete()
	{
		return SUCCESS;
	}
	
	public String modify()
	{
		return SUCCESS;
	}
	
	
	/*get(),set()*/
	public DeliveryOrder getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(DeliveryOrder orderBean) {
		this.orderBean = orderBean;
	}
	public IDeliverOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IDeliverOrderService orderService) {
		this.orderService = orderService;
	}
}
