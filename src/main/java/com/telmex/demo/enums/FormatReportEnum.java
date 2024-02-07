package com.telmex.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum FormatReportEnum {
    PDF {
        @Override
        public String getFormat() {
            return "pdf";
        }
    },EXCEL {
        @Override
        public String getFormat() {
            return "xlsx";
        }
    };

    private static  Map<String,FormatReportEnum> enumMap = new HashMap(){{
        put("pdf",PDF);
        put("excel",EXCEL);
    }};

    public abstract String getFormat();

    public static FormatReportEnum getByName(String name){
        return enumMap.get(name);
    }
}
