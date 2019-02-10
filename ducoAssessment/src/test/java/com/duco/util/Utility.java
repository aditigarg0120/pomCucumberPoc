package com.duco.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.duco.base.Base;

/**
 * @author Aditi Garg
 *
 * Version 0.1
 */
public class Utility extends Base {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	// Method to take screenshot in the folder "/screenshots/<current_date>/"
	public static void takeScreenshotAtEndOfTest(String screenshotname) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		LocalDate localDate = LocalDate.now();
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + dtf.format(localDate) + "/" + screenshotname
				+ System.currentTimeMillis() + ".png"));

	}
}