package com.telmex.demo.dto;

import com.poiji.annotation.ExcelCell;
import com.telmex.demo.dto.excel.RowDto;
import lombok.Data;

import java.util.Date;
@Data
public class RowEstadoCuenta implements RowDto {
    @ExcelCell(0)
    private Date quincena;
    @ExcelCell(1)
    private String rubro;
    @ExcelCell(2)
    private Integer master;
    @ExcelCell(3)
    private Integer estrategia;
    @ExcelCell(4)
    private Integer promotor;
    @ExcelCell(5)
    private Integer folio;
    @ExcelCell(6)
    private Integer confirmadas;
    @ExcelCell(7)
    private Integer expediente;
    @ExcelCell(8)
    private Integer pagoBase;
    @ExcelCell(9)
    private Integer importeBase;
    @ExcelCell(10)
    private String fechaBase;
    @ExcelCell(11)
    private Integer pagoPosteo;
}
