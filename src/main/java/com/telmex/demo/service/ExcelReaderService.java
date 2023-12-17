package com.telmex.demo.service;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.telmex.demo.dto.RowEstadoCuenta;
import com.telmex.demo.dto.excel.BookDto;
import com.telmex.demo.dto.excel.SheetDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ExcelReaderService {


    private BookDto<SheetDto<RowEstadoCuenta>> book;


    public BookDto<SheetDto<RowEstadoCuenta>> getFileEstadoCuenta(File file){
        book = new BookDto();
        List<RowEstadoCuenta> rows = parseDataFile(file);
        SheetDto<RowEstadoCuenta> sheet = new SheetDto();
        sheet.setRows(rows);
        book.setSheet(sheet);
        book.setNameFile(file.getName());
        return book;
    }


    public List<RowEstadoCuenta> parseDataFile(File file) {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetIndex(0).build();
        return Poiji.fromExcel(file, RowEstadoCuenta.class, options);
    }
}
