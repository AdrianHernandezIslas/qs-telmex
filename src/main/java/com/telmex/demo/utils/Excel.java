package com.telmex.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.telmex.demo.model.Chargeback;

public class Excel {

	public List<Chargeback> readFile(InputStream inp) throws EncryptedDocumentException, IOException {
		List<Chargeback> comisiones = new ArrayList<Chargeback>();
		
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);

		int iRow = 2;
		Row row = sheet.getRow(iRow);
		while (row != null) {
			
			Chargeback comision = new Chargeback();
			
			Cell cell1 = row.getCell(1);
			String value;
			if(cell1.getCellType() == CellType.NUMERIC) {
			    value = NumberToTextConverter.toText(cell1.getNumericCellValue());
			} else if(cell1.getCellType() == CellType.ERROR) {
			    value = "";
			} else {
				value = cell1.getStringCellValue();
			}
			comision.setClave(value);
			//System.out.println(value);
			
			
			Cell cell2 = row.getCell(2);
			String value2 = cell2.getStringCellValue();
			comision.setNombrePromotor(value2);
			//System.out.println(value2);
			
			
			Cell cell3 = row.getCell(3);
			Double value3 = cell3.getNumericCellValue();
			comision.setAnticipo(value3);
			//System.out.println(value3);
			
			
			Cell cell4 = row.getCell(4);
			Double value4 = cell4.getNumericCellValue();
			comision.setMontoDescuento(value4);
			//System.out.println(value4);
			
			comisiones.add(comision);
			iRow++;
			row = sheet.getRow(iRow);
			//System.out.println("____________________________________________________________");
		}
		
		return comisiones;
	}
}
