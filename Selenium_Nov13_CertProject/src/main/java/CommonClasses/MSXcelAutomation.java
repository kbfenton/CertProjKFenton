package CommonClasses;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class MSXcelAutomation {

		public String getExcelData(String sheetname, int rowNum, int cellNum) throws Exception {

			// It stores the path of the Test Data file
			File filepath = new File(Constants.testDataSheetPath);

			// FileInputStream is meant for reading streams of data.
			FileInputStream fis = new FileInputStream(filepath);

			// Open Work book in a read mode.
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Get the control of sheet
			XSSFSheet sheet = workbook.getSheet(sheetname);

			// get the control of the row
			XSSFRow row = sheet.getRow(rowNum);

			// Get the data from desired cell of the current row
			String data = row.getCell(cellNum).getStringCellValue();

			System.out.println("Data from Test data sheet is = " + data);

			return data;

		}

		public void setExcelData(String sheetname, int rowNum, int cellNum, String data) throws Exception {

			// It stores the path of the Test Data file
			File filepath = new File(Constants.testDataSheetPath);

			// FileInputStream is meant for reading streams of data.
			FileInputStream fis = new FileInputStream(filepath);

			// Open Work book in a read mode.
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Get the control of sheet
			XSSFSheet sheet = workbook.getSheet(sheetname);

			// get the control of the row
			XSSFRow row = sheet.getRow(rowNum);

			// create a cell at the end of the row or at 5th position
			XSSFCell cell = row.createCell(cellNum);

			FileOutputStream fos = new FileOutputStream(filepath);

			cell.setCellValue(data);

			workbook.write(fos);

			workbook.close();
		}

	}
