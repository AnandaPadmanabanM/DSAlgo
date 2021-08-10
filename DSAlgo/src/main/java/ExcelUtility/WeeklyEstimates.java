package ExcelUtility;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WeeklyEstimates {


	public static void main(String[] args) throws FileNotFoundException, IOException   
	{   

		try {
			Workbook wb = WorkbookFactory.create(new File(System.getProperty("user.dir")+"\\Excel\\Input\\Test1.xls"));
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator(); 
			int editColumns =5;
			//Get Week Detail from Data sheet
			int activeSheetIndex = wb.getNumberOfSheets();
			Sheet s1 = wb.getSheet("Data");
			Row row = s1.getRow(1);
			Cell cell= row.getCell(1);
			String week = cell.getStringCellValue();
			
			//Find number of weeks
			int a=0,length=week.length()-1;
			String digit="";
			while(Character.isDigit(week.charAt(length))) {
				a = Character.isDigit(week.charAt(length)) ? Character.getNumericValue(week.charAt(length)):1;
				digit= week.substring(length);
				length--;
			}
			a=Integer.parseInt(digit);
			int b=a;
			a= 2+(editColumns*(a-1));
			System.out.println("Consolidated (on week"+(b-1)+")");
			//Clone Last week Consolidated Sheet
			int sheetIndex = wb.getSheetIndex("Consolidated (on week"+(b-1)+")");
			wb.cloneSheet(sheetIndex);
			wb.setSheetName(activeSheetIndex, "Consolidated (on "+week+" )");

			//Copy Excel Values Within Sheets
			Sheet s2 = wb.getSheet("Consolidated (on "+week+" )");
			int rowCount = s2.getLastRowNum();
			int noOfColumns = s2.getRow(0).getLastCellNum();
			DataFormatter formatter = new DataFormatter(); 
			for (int i = 0; i<=rowCount; i++) {
				for(int j=a; j<noOfColumns;j++) {			
					Row row1 = s2.getRow(i);
					Cell cell1= row1.getCell(j);
					CellStyle style = wb.createCellStyle();  
					style.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  

					if (cell1.getCellType() == CellType.FORMULA) {
						switch (evaluator.evaluateFormulaCell(cell1)) {
						case BOOLEAN:
							s2.getRow(i).createCell(j+editColumns).setCellValue(cell1.getBooleanCellValue());
							break;
						case NUMERIC:
							s2.getRow(i).createCell(j+editColumns).setCellValue(cell1.getNumericCellValue());
							break;
						case STRING:
							s2.getRow(i).createCell(j+editColumns).setCellValue(cell1.getStringCellValue());
							break;
						}
					}
					else {
						String value = formatter.formatCellValue(cell1);
						Cell cell2 = s2.getRow(i).createCell(j+editColumns);
						cell2.setCellValue(value);
						style.setWrapText(true);
						style.setAlignment(HorizontalAlignment.CENTER);
						style.setVerticalAlignment(VerticalAlignment.CENTER);
						cell2.setCellStyle(style);
						if(i==0 && j==a) {
							s2.addMergedRegion(new CellRangeAddress(0,0,j+editColumns,j+editColumns+4));  	
						}
					}
				}
			}
			
			Sheet s3 = wb.getSheet(week);
			copyExcelBetweenSheets(s3,s2,a,week);
			FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Output\\Test2.xls");
			wb.write(out);
			wb.close();
			findDifferenceBetweenValues("Consolidated (on "+week+" )",a,editColumns);
			System.out.println("Done!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void copyExcelBetweenSheets(Sheet s1, Sheet s2, int a, String week) {
		int rowCount = s1.getLastRowNum();
		int noOfColumns = s1.getRow(1).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		s2.getRow(0).getCell(a).setCellValue(week);
		for (int i = 1; i<rowCount+1; i++) {			
			for(int j=2; j<noOfColumns;j++) {			
				Row row = s1.getRow(i);
				Cell cell= row.getCell(j);
				String value = formatter.formatCellValue(cell);
				s2.getRow(i+1).getCell(j+(a-2)).setCellType(CellType.NUMERIC);
				s2.getRow(i+1).getCell(j+(a-2)).setCellValue(value);
			}
		}
	}

	public static void findDifferenceBetweenValues(String sheetName,int a , int b) {

		try {  
			FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\Output\\Test2.xls");
			HSSFWorkbook wb1 = new HSSFWorkbook(in);
			Sheet s1 = wb1.getSheet(sheetName);
			int rowCount = s1.getLastRowNum();
			int noOfColumns = s1.getRow(1).getLastCellNum();
			DataFormatter formatter = new DataFormatter(); 
			for (int i = 2; i<=rowCount; i++) {
				for(int j=a; j<noOfColumns-b;j++) {			
					Row row1 = s1.getRow(i);
					Cell cell1= row1.getCell(j); 
					String value1 = formatter.formatCellValue(cell1);
					Cell cell2= row1.getCell(j+b);
					String value2 = formatter.formatCellValue(cell2);	
					int diff=Integer.parseInt(value2)-Integer.parseInt(value1);
					s1.getRow(i).createCell(j+b).setCellType(CellType.NUMERIC);
					s1.getRow(i).createCell(j+b).setCellValue(diff);
					System.out.println(diff);
				}
			}
			FileOutputStream out1 = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Output\\Test2.xls");
			wb1.write(out1);
			wb1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

