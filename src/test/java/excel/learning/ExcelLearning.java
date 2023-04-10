package excel.learning;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLearning {
	
	@Test
	public void excelLearning() throws IOException {
		
		String projPath = System.getProperty("user.dir");
		System.out.println(projPath);
		
		XSSFWorkbook  workBook = new XSSFWorkbook(projPath+"/excel/keyword.xlsx");
		XSSFSheet workSheet = workBook.getSheetAt(0);
		int rowCount = workSheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		String keyword ;
		int result ;
		for(int i=1; i<rowCount; i++) {
			keyword = workSheet.getRow(i).getCell(0).getStringCellValue();
			result = (int) workSheet.getRow(i).getCell(1).getNumericCellValue();
			System.out.println(keyword+"\t \t"+result);
		}
		workBook.close();
	}
	

}
