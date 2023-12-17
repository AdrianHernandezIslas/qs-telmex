package com.telmex.demo.constants;

import java.text.SimpleDateFormat;

public class ArchivoContants {
    private final static String PATTERN_DATE = "yyyy-MM-dd";
    public final static String NAME_FILE_PREFIX ="EdoCta-";
    public final static String EXTENSION_FILE = ".xlsx";
    public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN_DATE);
}
