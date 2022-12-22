package com.framework.test;


import org.testng.annotations.Test;

import com.framework.base.BaseUI;

public class test extends BaseUI {
	
	@Test
	public void testOne() {
		
		//invoking browser
		invokeBrowser("Chrome");
		
		//open amazon India
		openURL("https://www.amazon.in/");
		
		//hamburger click
		click("/html/body/div[1]/header/div/div[5]/div[1]/a/span");
		
		wait(30);
		
		//click tv appliances and electronics 
		click("/html/body/div[3]/div[2]/div/ul[1]/li[17]/a");
		
		//then click Television category
		click("/html/body/div[3]/div[2]/div/ul[9]/li[3]/a");
		
		//then select brand as Samsung
		click("/html/body/div[1]/div[2]/div[2]/div[3]/div/div/div[24]/ul/li[3]/span/a/div/label/i");
		
		//Next two lines sort by High to Low
		clickID("a-autoid-0-announce");
		clickID("s-result-sort-select_2");
		
		//click on the second search result
		click("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div[2]/div[1]/h2/a/span");
		
		//switch window
		SwitchtoNextWin();
		
		//check if the Required text is present or not and Print on console
		checkIfTextPresent("About this item");
		
		//quit the browser
		quitBrowser();
	}
}
