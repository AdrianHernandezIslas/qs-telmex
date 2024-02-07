package com.telmex.demo.dto;

import com.telmex.demo.enums.FormatReportEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JRAbstractExporter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponseDTO {
    private JRAbstractExporter jrExporter;
    private String fileName;
    private FormatReportEnum formatReportEnum;
}
