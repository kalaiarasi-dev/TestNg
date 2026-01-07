package com.app.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelRead {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(excel_reuse(0,1));
		driver.findElement(By.id("password")).sendKeys(excel_reuse(1,1));
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("location")).sendKeys(excel_reuse(2, 1));
		driver.findElement(By.id("hotels")).sendKeys(excel_reuse(3,1));
		driver.findElement(By.id("room_type")).sendKeys(excel_reuse(4, 1));
		driver.findElement(By.id("room_nos")).sendKeys(excel_reuse(5, 1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('datepick_in').value='26/12/2025';");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('datepick_out').value='28/12/2025';");
		driver.findElement(By.name("adult_room")).sendKeys(excel_reuse(8, 1));
		driver.findElement(By.name("child_room")).sendKeys(excel_reuse(9, 1));
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("continue"))).click();
		WebElement f=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("first_name")));
		f.sendKeys(excel_reuse(10, 1));
		driver.findElement(By.name("last_name")).sendKeys(excel_reuse(11, 1));
		driver.findElement(By.name("address")).sendKeys(excel_reuse(12, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("cc_num")).sendKeys(excel_reuse(13, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("cc_type")).sendKeys(excel_reuse(14, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("cc_exp_month")).sendKeys(excel_reuse(15, 1));
		Thread.sleep(1000);
		driver.findElement(By.name("cc_exp_year")).sendKeys(excel_reuse(16, 1));
		driver.findElement(By.name("cc_cvv")).sendKeys(excel_reuse(17, 1));
		driver.findElement(By.xpath("//input[@type='button']")).click();
		WebElement orderno = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("order_no")));
		Object ordernumbervalue = js.executeScript("return arguments[0].getAttribute('value')", orderno);
		js.executeScript("arguments[0].scrollIntoView(true)", orderno);
		System.out.println("The order number is = "+ordernumbervalue);
		
	}

	public static void exceltest() {

		try {
			File f = new File("D:\\2025\\Testing\\Selenium\\Project Class\\Test_Dec\\src\\test\\resources\\Test.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < physicalNumberOfRows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					Cell cell = row.getCell(j);
					// System.out.println(cell);
					int cellType = cell.getCellType();
					// binary language - 0 = number and date , 1 = String value
					if (cellType == 1) {
						String stringCellValue = cell.getStringCellValue();
						System.out.println(stringCellValue);

					} else if (cellType == 0) {
						if (DateUtil.isCellDateFormatted(cell)) {
							Date dateCellValue = cell.getDateCellValue();
							// System.out.println(dateCellValue);
							SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
							String format = sm.format(dateCellValue);
							System.out.println(format);
						} else {
							double numericCellValue = cell.getNumericCellValue();
							long l = (long) numericCellValue;
							String valueOf = String.valueOf(l);
							System.out.println(valueOf);

						}

					}
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String excel_reuse(int i, int j) {
		String value = null;
		try {
			File f = new File("D:\\2025\\Testing\\Selenium\\Project Class\\Test_Dec\\src\\test\\resources\\Test.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");

			Row row = sheet.getRow(i);

			Cell cell = row.getCell(j);
			// System.out.println(cell);
			int cellType = cell.getCellType();
			// binary language - 0 = number and date , 1 = String value
			if (cellType == 1) {
				value = cell.getStringCellValue();
				System.out.println(value);

			} else if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					// System.out.println(dateCellValue);
					SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
					value = sm.format(dateCellValue);
					System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
					System.out.println(value);

				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

}
