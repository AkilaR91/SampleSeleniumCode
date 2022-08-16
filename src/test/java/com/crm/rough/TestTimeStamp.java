package com.crm.rough;

import java.text.DateFormat;
import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		
		Date d= new Date();
		String df=DateFormat.getDateInstance().format(d);
		System.out.println(df);
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(screenshotName);
		System.out.println(d);

	}

}
