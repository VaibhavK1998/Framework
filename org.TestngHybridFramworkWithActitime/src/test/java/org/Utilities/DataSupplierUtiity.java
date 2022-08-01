package org.Utilities;

import org.testng.annotations.DataProvider;

public class DataSupplierUtiity {
	@DataProvider(name="logindataOrangeHrm")
	public static String [][] logindataOrangeHrm() {
		String[][] data1= {{"Admin","admin123"},{"@45678","admin12"},{"chlchaiyyachaiyyachiyyachaiyyaa","admin123"},
				
				{"administrator","78767234"}};
				
		     return data1;
		
	}


	@DataProvider(name="ActitimeLogin")
	public static Object[][] ActitimeLogin(){

		Object[][] logdata = new Object[4][2];// 4 is row 2 is column
		logdata[0][0]= "admin";
		logdata[0][1]= "manager";

		logdata[1][0]="admin";
		logdata[1][1]="manaaager";		

		logdata[2][0]= "admin123";
		logdata[2][1]=	"manager";

		logdata[3][0]= "adimnnnn";	
		logdata[3][1]="man@344"	;
		
		return logdata;	
}
}
