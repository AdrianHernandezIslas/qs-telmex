package com.telmex.demo.service;

import com.telmex.demo.entity.EstadoCuenta;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface ArchivoService {

    EstadoCuenta procesarArchivoEstadoCuenta(LocalDate fechaArchivo);
}
