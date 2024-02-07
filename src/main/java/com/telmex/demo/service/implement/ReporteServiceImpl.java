package com.telmex.demo.service.implement;

import com.telmex.demo.components.JasperReports;
import com.telmex.demo.dto.ReportResponseDTO;
import com.telmex.demo.enums.FormatReportEnum;
import com.telmex.demo.service.ReporteService;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.telmex.demo.constants.ReporteConstants.*;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private JasperReports jasperReports;

    @Override
    public ReportResponseDTO getComisionesCalculadas(OutputStream outputStream, String formatFile, Optional<String> idEstadoCuenta, Optional<String> pagoConcepto, Optional<String> idTipoEmpleado) throws JRException, SQLException, IOException {
        try {
            FormatReportEnum e = FormatReportEnum.getByName(formatFile);
            Map<String,Object> params = new HashMap();
            params.put("idEstadoCuenta",idEstadoCuenta.orElse("%%"));
            params.put("pagoConcepto",pagoConcepto.orElse("%%"));
            params.put("idTipoEmpleado",idTipoEmpleado.orElse("%%"));
            JRAbstractExporter exporter = jasperReports.exportReport(COMISIONES_CALCULADAS_LAYOUT,params,outputStream, e);
            String fileName = getNameFile(COMISIONES_CALCULADAS_LAYOUT,e);
            return new ReportResponseDTO(exporter,fileName,e);
        } catch (Exception e) {
            throw e;
        }
    }

    private String getNameFile(String name,FormatReportEnum format){
        return name.concat("_").concat(String.valueOf(new Date().getTime())).concat(".").concat(format.getFormat());
    }
}
