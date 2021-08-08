package ExcelUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WeeklyEstimates {
	public static void main(String[] args) throws FileNotFoundException, IOException   
	{   
		System.out.println(System.getProperty("user.dir"));
//		File f= new File("C:\\Users\\91956\\Desktop\\Test1.xls");		
//		HSSFWorkbook workbook = new HSSFWorkbook();
		Workbook wb = WorkbookFactory.create(new File(System.getProperty("user.dir")+"\\Excel\\Input\\Test1.xls"));
		wb.cloneSheet(0);
		int activeSheetIndex = wb.getNumberOfSheets();
		wb.setSheetName(activeSheetIndex-1, "Consolidated (on week4)");
		Sheet s = wb.getSheet("Consolidated (on week4)");
		int noOfColumns = s.getRow(0).getLastCellNum();
		System.out.println(noOfColumns);
		Row row = s.createRow(20);
		Cell cell= row.createCell(1);
		cell.setCellValue("admin");	
		FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Output\\Test2.xls");
        wb.write(out);
        wb.close();

		System.out.println("Done");
	}   


}

