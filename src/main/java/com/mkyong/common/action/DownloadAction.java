package com.mkyong.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DownloadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4987696053423300106L;
	private InputStream fileInputStream;
	  
	public InputStream getFileInputStream() {
	 
		return fileInputStream;
	   
	}

	public String execute() throws Exception {
		
		File excelFile = new File("C://temp//test.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(excelFile);
		WritableSheet writablesheet1 = workbook.createSheet("VoicePlan", 0);
	    Label label1 = new Label(0, 0, "Emp_Name");
	    Label label2 = new Label(1, 0, "Emp_FName");
	    Label label3 = new Label(2, 0, "Emp_Salary");
	    writablesheet1.addCell(label1);
	    writablesheet1.addCell(label2);
	    writablesheet1.addCell(label3);
	    workbook.write();
	    workbook.close();
	    
		fileInputStream = new FileInputStream(excelFile);

	    return SUCCESS;
	  
	}

	
}