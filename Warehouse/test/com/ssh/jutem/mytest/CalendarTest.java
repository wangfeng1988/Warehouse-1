package com.ssh.jutem.mytest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;



public class CalendarTest 
{
	@Test
	public void Test()
	{

		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
		
	}
}
