package com.telmex.demo.controller;

import com.telmex.demo.components.JasperReports;
import com.telmex.demo.dto.ReportResponseDTO;
import com.telmex.demo.enums.FormatReportEnum;
import com.telmex.demo.service.ReporteService;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/reporte")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("comision-calculada")
    public void getComisionesCalculadas(HttpServletResponse response,
                                        @RequestParam(required = false) String idEstadoCuenta,
                                        @RequestParam(required = false) String conceptoPago,
                                        @RequestParam(required = false) String idTipoEmpleado) throws IOException, JRException, SQLException {
        ReportResponseDTO report =  reporteService.getComisionesCalculadas(response.getOutputStream(),
                "excel",
                Optional.ofNullable(idEstadoCuenta),
                Optional.ofNullable(conceptoPago),
                Optional.ofNullable(idTipoEmpleado));
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=".concat(report.getFileName()));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        report.getJrExporter().exportReport();
    }
}