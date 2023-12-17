package com.telmex.demo.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;

public interface ArchivoService {

    void procesarArchivoEstadoCuenta(Date fechaArchivo);
}
