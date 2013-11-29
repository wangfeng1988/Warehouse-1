package com.ssh.jutem.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class CheckTimer extends Timer
{
	public CheckTimer()
	{
	      Calendar calendar = Calendar.getInstance();  
	      calendar.set(Calendar.HOUR_OF_DAY, 1); //凌晨1点  
	      calendar.set(Calendar.MINUTE, 0);  
	      calendar.set(Calendar.SECOND, 0); 
	      date=calendar.getTime();
	}
	
	public Date getDate() {
		return date;
	}
	public long getPeriod() {
		return period;
	}

	private Date date;
	private long period=1000*60*60*24;//每天24小时检查一次
}
