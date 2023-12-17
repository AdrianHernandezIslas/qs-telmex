package com.telmex.demo.dto.excel;

import com.telmex.demo.dto.excel.RowDto;

import java.util.List;

public class SheetDto<T extends RowDto> {

    private List<T> rows;


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "SheetDto{" +
                "rows=" + rows +
                '}';
    }
}
