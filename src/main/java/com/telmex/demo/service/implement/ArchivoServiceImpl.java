package com.telmex.demo.service.implement;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.telmex.demo.constants.ArchivoContants;
import com.telmex.demo.dto.RowEstadoCuenta;
import com.telmex.demo.dto.excel.BookDto;
import com.telmex.demo.dto.excel.SheetDto;
import com.telmex.demo.service.ArchivoService;
import com.telmex.demo.service.ExcelReaderService;
import com.telmex.demo.service.external.sftp.FtpService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private FtpService ftpService;
    @Autowired
    private ExcelReaderService excelReaderService;

    @Override
    public void procesarArchivoEstadoCuenta(Date fechaArchivo) {
        try {
            String pathFile = getNameFile(fechaArchivo);
            ftpService.getFile(pathFile);
            File file = ResourceUtils.getFile("classpath:" + pathFile);
            BookDto<SheetDto<RowEstadoCuenta>> book = excelReaderService.getFileEstadoCuenta(file);
            System.out.println(book);
            ftpService.chanelExit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }




    private String getNameFile(Date fechaArchivo) {
        String fecha = ArchivoContants.DATE_FORMAT.format(fechaArchivo);
        return ArchivoContants.NAME_FILE_PREFIX + fecha + ArchivoContants.EXTENSION_FILE;
    }
}
