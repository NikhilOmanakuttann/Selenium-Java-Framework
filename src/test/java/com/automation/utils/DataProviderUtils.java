package com.automation.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "excelData")
    public Object[][] getUsers() {

        return ExcelUtils.getExcelData("testdata.xlsx", "Sheet1");
    }
}