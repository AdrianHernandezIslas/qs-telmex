package com.telmex.demo.components;

import com.telmex.demo.enums.FormatReportEnum;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import static com.telmex.demo.constants.ReporteConstants.PATH_TEMPLATE_REPORTS;
import static com.telmex.demo.constants.ReporteConstants.FORMAT_TEMPLATE_JASPER;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Map;

@Component
public class JasperReports {

        @Autowired
        private DataSource dataSource;

        public JRAbstractExporter exportReport(String nameFile, Map<String, Object> parameters, OutputStream outputStream, FormatReportEnum formatFile) throws JRException, SQLException, IOException {
                JRAbstractExporter exporter = getExporter(formatFile);
                SimpleReportExportConfiguration configuration =  getExportConfiguration(formatFile);
                return exportTo(nameFile,parameters,outputStream,exporter,configuration);
        }

        public JRAbstractExporter exportTo(String nameFile, Map<String, Object> parameters, OutputStream outputStream,JRAbstractExporter exporter,SimpleReportExportConfiguration configuration) throws IOException, JRException, SQLException {
                String pathFile = PATH_TEMPLATE_REPORTS.concat(nameFile).concat(FORMAT_TEMPLATE_JASPER);
                File file = ResourceUtils.getFile(pathFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource.getConnection());
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                exporter.setConfiguration(configuration);
                return exporter;
        }

        private JRAbstractExporter getExporter(FormatReportEnum formatFile){
                JRAbstractExporter exporter = null;
                switch (formatFile){
                        case PDF:
                                exporter = new JRPdfExporter();
                                break;
                        case EXCEL:
                                exporter = new JRXlsxExporter();
                                break;
                }
                return exporter;
        }

        private SimpleReportExportConfiguration getExportConfiguration(FormatReportEnum formatFile){
                SimpleReportExportConfiguration configuration = null;
                switch (formatFile){
                        case PDF:
                                configuration = new SimplePdfReportConfiguration();
                                break;
                        case EXCEL:
                                SimpleXlsxReportConfiguration ee = new SimpleXlsxReportConfiguration();
                                ee.setRemoveEmptySpaceBetweenRows(true);
                                configuration = ee;
                                break;
                }
                return configuration;
        }
}
