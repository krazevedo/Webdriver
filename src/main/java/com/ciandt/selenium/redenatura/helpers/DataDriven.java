package com.ciandt.selenium.redenatura.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataDriven {
	 public Properties obj;
	    
		public void lerArquivo() throws IOException {

			//Create Object of Properties Class.
			obj = new Properties();   
			//Create Object of FileInputStream Class. Pass file path.
			File file = new File("src\\main\\resources\\painel.properties");
			FileInputStream fileInput = null;
			fileInput = new FileInputStream(file);
			//Pass object reference objfile to load method of Properties object.
			obj.load(fileInput); 
		}
		
		public Properties getProperties(){
			return obj;
		}
}
