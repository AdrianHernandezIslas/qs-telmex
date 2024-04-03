package com.telmex.demo.service;

import com.telmex.demo.dto.ReportResponseDTO;
import com.telmex.demo.enums.FormatReportEnum;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Optional;

public interface ReporteService {

    ReportResponseDTO getComisionesCalculadas(OutputStream outputStream, String formatFile, Optional<String> idEstadoCuenta, Optional<String> pagoConcepto, Optional<String> idTipoEmpleado) throws JRException, SQLException, IOException;
}
