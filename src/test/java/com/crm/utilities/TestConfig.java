package com.crm.utilities;

public class TestConfig {

	public static String server = "smtp.gmail.com";
	public static String from = "corporate@way2automation.com";
	public static String password = "Selenium@123";
	public static String[] to = { "seleniumcoaching@gmail.com", "trainer@way2automation.com" };
	public static String subject = "Test Report";

	public static String messageBody = "TestMessage";
	public static String attachmentPath = "f:\\screenshot\\error.jpg";
	public static String attachmentName = "error.jpg";

	// SQL DATABASE DETAILS
	public static String driver = "net.sourceforge.jtds.jdbc.Driver";
	public static String dbConnectionUrl = "jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval";
	public static String dbUserName = "sa";
	public static String dbPassword = "$ql$!!1";

	// MYSQL DATABASE DETAILS
	public static String mysqldriver = "com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/18thaug2018";

	// All Files Location/Path

	public static String ServiceFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\Corporate_Spread_Template_prod_SS.xlsx";
	public static String DocUpload = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\DocUpload.jpg";
	public static String LargeServiceFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\Corporate_Spread_Template_prod_LS.xlsx";
	public static String SmallManufacturingFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\Corporate_Spread_Template_prod_SM.xlsx";
	public static String LargeManufacturingFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\Corporate_Spread_Template_prod_LM.xlsx";
	public static String TraderFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\Corporate_Spread_Template_prod_Trader.xlsx";
	public static String NBFCFilePath = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\excel\\New_NBFC_Spread_Template_Final_vF_3.2.xlsx";

}
