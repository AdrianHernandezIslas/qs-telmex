package com.telmex.demo.components;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.telmex.demo.dto.RowEstadoCuenta;
import com.telmex.demo.dto.excel.BookDto;
import com.telmex.demo.dto.excel.SheetDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExcelReaderService {


    private BookDto<SheetDto<RowEstadoCuenta>> book;


    public BookDto<SheetDto<RowEstadoCuenta>> getFileEstadoCuenta(File file){
        book = new BookDto();
        List<RowEstadoCuenta> rows = parseDataFile(file);
        //List<RowEstadoCuenta> rowsFilter = filterByValue("ABIERTA",rows);
        //System.out.println(rows.size() +" -------- "+rowsFilter.size());
        SheetDto<RowEstadoCuenta> sheet = new SheetDto();
        sheet.setRows(rows);
        book.setSheet(sheet);
        book.setNameFile(file.getName());
        return book;
    }

    private List<RowEstadoCuenta> filterByValue(String value,List<RowEstadoCuenta> rows){
        List<RowEstadoCuenta> filteredList;
        filteredList = rows.stream()
                .filter(employee -> {
                    boolean res =value.equals(employee.getPisaE());
                    return res;
                })
                .collect(Collectors.toList());
        return filteredList;
    }


    public List<RowEstadoCuenta> parseDataFile(File file) {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetIndex(0).build();
        return Poiji.fromExcel(file, RowEstadoCuenta.class, options);
    }
}
