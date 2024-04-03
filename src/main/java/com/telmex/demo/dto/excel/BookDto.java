package com.telmex.demo.dto.excel;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;


public class BookDto<T extends SheetDto>{
    private List<T> sheets;
    private String nameFile;

    public BookDto(){
        sheets = new LinkedList();
    }

    public List<T> getSheets() {
        return sheets;
    }

    public void setSheets(List<T> sheets) {
        this.sheets = sheets;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setSheet(T sheet){
        sheets.add(sheet);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "sheets=" + sheets +
                ", nameFile='" + nameFile + '\'' +
                '}';
    }
}
