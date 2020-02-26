package com.ui.companyName.projectName.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class cls){
		
		if(root){
			  
			return Logger.getLogger(cls);
		}
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src"+"\\main"+"\\java"+"\\resource"+"\\configFile"+"\\log4J.properties");
		root = true ;
		
		return Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
	
		
		Logger log  = LoggerHelper.getLogger(LoggerHelper.class);
		
		log.info("Log is configured");
		log.info("Log is configured");
		log.info("Log is configured");
		
	}

}
