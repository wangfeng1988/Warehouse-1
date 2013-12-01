package com.ssh.jutem.util;


import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.junit.BeforeClass;
import org.junit.Test;


public class CreateEntryCollectTest
{
	@BeforeClass
	public static void BeforeClass()
	{
		mytimer=new Timer();
		mycreate=new CreateCollectAndDetail();
		
	}

	@Test
	public void test1()
	{
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.HOUR_OF_DAY, 1);   
        calendar.set(Calendar.MINUTE, 0);  
        calendar.set(Calendar.SECOND, 0); 
        Date date=calendar.getTime();
        
		mytimer.schedule(mycreate, date, 10*1000);

	}
	
	private static CreateCollectAndDetail mycreate;
	private static Timer mytimer;
}
