package com.telmex.demo.dto;

import com.poiji.annotation.ExcelCell;
import com.telmex.demo.constants.ArchivoContants;
import com.telmex.demo.dto.excel.RowDto;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

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
    private Double pagoBase;
    @ExcelCell(9)
    private Double importeBase;
    @ExcelCell(10)
    private Date fechaIBase;
    @ExcelCell(11)
    private Integer pagoPosteo;
    @ExcelCell(12)
    private Double importePosteo;
    @ExcelCell(13)
    private Date fechaIPosteo;
    @ExcelCell(14)
    private String pisaE;
    @ExcelCell(15)
    private String procede2;
    @ExcelCell(16)
    private String pago2;
    @ExcelCell(17)
    private Integer pagoBe;
    @ExcelCell(18)
    private Double importeBe;
    @ExcelCell(19)
    private Date fechaIbe;
    @ExcelCell(20)
    private Double pagoBCom;
    @ExcelCell(21)
    private Double importeBCom;
    @ExcelCell(22)
    private Date fechaIbCom;
    @ExcelCell(23)
    private Double pagoBcl;
    @ExcelCell(24)
    private Double importeBcl;
    @ExcelCell(25)
    private Date fechaIbcl;
    @ExcelCell(26)
    private Double pagoBcm;
    @ExcelCell(27)
    private Double importeBcm;
    @ExcelCell(28)
    private Date fechaIbcm;
    @ExcelCell(29)
    private String mesSol;
    @ExcelCell(30)
    private String fecha;
    @ExcelCell(31)
    private Integer osPago;
    @ExcelCell(32)
    private String telPago;
    @ExcelCell(33)
    private String area;
    @ExcelCell(34)
    private String division;
    @ExcelCell(35)
    private String subdireccion;
    @ExcelCell(36)
    private Integer difDias;
    @ExcelCell(37)
    private Double pagoTotal;
    @ExcelCell(38)
    private Double cantidad;
    @ExcelCell(39)
    private String empresa;
    @ExcelCell(40)
    private String observaciones;
    @ExcelCell(41)
    private Double importeOtros;
    @ExcelCell(42)
    private Date fechaIotros;
    @ExcelCell(43)
    private String pagoOtros;
    @ExcelCell(44)
    private Double otraCantidad;
    @ExcelCell(45)
    private String otrosDias;
    @ExcelCell(46)
    private String otrasVentas;
    @ExcelCell(47)
    private String dias;
    @ExcelCell(48)
    private String ventas;
    @ExcelCell(49)
    private String mesPisa;
    @ExcelCell(50)
    private String estatus;
    @ExcelCell(51)
    private String tipoLinea;
    @ExcelCell(52)
    private String lineaContratada;
    @ExcelCell(53)
    private String paquete;
    @ExcelCell(54)
    private String servicios;
    @ExcelCell(55)
    private String servicios2;
    @ExcelCell(56)
    private String duplicado;
    @ExcelCell(57)
    private String catalogoEmpresasProyecto;
    @ExcelCell(58)
    private String catalogoEstrategiasProyecto;
    @ExcelCell(59)
    private String catalogoEstrategiasEstatus;
    @ExcelCell(60)
    private String concepton;
    @ExcelCell(61)
    private String pagoBaseDescripcion;
    @ExcelCell(62)
    private String pagoPosteoDescripcion;
    @ExcelCell(63)
    private String rango;
    @ExcelCell(64)
    private String porcentajeComision;
    @ExcelCell(65)
    private String mes;
    @ExcelCell(66)
    private String porcentajeComisionTrans;
    @ExcelCell(67)
    private String comision3;
    @ExcelCell(68)
    private Integer pagoPagoCliente;
    @ExcelCell(69)
    private String pagoPagoClienteDescripcion;
    @ExcelCell(70)
    private Double importePagoCliente;
    @ExcelCell(71)
    private Date fechaPagoCliente;
    @ExcelCell(72)
    private String osPagoConversion;
    @ExcelCell(73)
    private String telPagoConversion;
    @ExcelCell(74)
    private String pisaEConversion;
    @ExcelCell(75)
    private String pagoPorta;
    @ExcelCell(76)
    private Integer pagoBonoZf;
    @ExcelCell(77)
    private String esConversion;
    @ExcelCell(78)
    private Integer pagoNavegacion;
    @ExcelCell(79)
    private Double importeNavegacion;
    @ExcelCell(80)
    private Date fechaNavegacion;
    @ExcelCell(81)
    private Integer navegaDwh;
    @ExcelCell(82)
    private String pagoChergeBk;
    @ExcelCell(83)
    private Double importeChargeBk;
    @ExcelCell(84)
    private Date fechaIChergeBk;
    @ExcelCell(85)
    private Integer importeChargeBkPgoCte;
    @ExcelCell(86)
    private String pagoChargeBkDescripcion;

    public Date getQuincena() {
        return quincena;
    }

    public void setQuincena(Date quincena) {
        this.quincena = quincena;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public Integer getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Integer estrategia) {
        this.estrategia = estrategia;
    }

    public Integer getPromotor() {
        return promotor;
    }

    public void setPromotor(Integer promotor) {
        this.promotor = promotor;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getConfirmadas() {
        return confirmadas;
    }

    public void setConfirmadas(Integer confirmadas) {
        this.confirmadas = confirmadas;
    }

    public Integer getExpediente() {
        return expediente;
    }

    public void setExpediente(Integer expediente) {
        this.expediente = expediente;
    }

    public Double getPagoBase() {
        return pagoBase;
    }

    public void setPagoBase(Double pagoBase) {
        this.pagoBase = pagoBase;
    }

    public Double getImporteBase() {
        return importeBase;
    }

    public void setImporteBase(Double importeBase) {
        this.importeBase = importeBase;
    }

    public Date getFechaIBase() {
        return fechaIBase;
    }

    public void setFechaIBase(Date fechaIBase) {
        this.fechaIBase = fechaIBase;
    }

    public Integer getPagoPosteo() {
        return pagoPosteo;
    }

    public void setPagoPosteo(Integer pagoPosteo) {
        this.pagoPosteo = pagoPosteo;
    }

    public Double getImportePosteo() {
        return importePosteo;
    }

    public void setImportePosteo(Double importePosteo) {
        this.importePosteo = importePosteo;
    }

    public Date getFechaIPosteo() {
        return fechaIPosteo;
    }

    public void setFechaIPosteo(Date fechaIPosteo) {
        this.fechaIPosteo = fechaIPosteo;
    }

    public String getPisaE() {
        return pisaE;
    }

    public void setPisaE(String pisaE) {
        this.pisaE = pisaE;
    }

    public String getProcede2() {
        return procede2;
    }

    public void setProcede2(String procede2) {
        this.procede2 = procede2;
    }

    public String getPago2() {
        return pago2;
    }

    public void setPago2(String pago2) {
        this.pago2 = pago2;
    }

    public Integer getPagoBe() {
        return pagoBe;
    }

    public void setPagoBe(Integer pagoBe) {
        this.pagoBe = pagoBe;
    }

    public Double getImporteBe() {
        return importeBe;
    }

    public void setImporteBe(Double importeBe) {
        this.importeBe = importeBe;
    }

    public Date getFechaIbe() {
        return fechaIbe;
    }

    public void setFechaIbe(Date fechaIbe) {
        this.fechaIbe = fechaIbe;
    }

    public Double getPagoBCom() {
        return pagoBCom;
    }

    public void setPagoBCom(Double pagoBCom) {
        this.pagoBCom = pagoBCom;
    }

    public Double getImporteBCom() {
        return importeBCom;
    }

    public void setImporteBCom(Double importeBCom) {
        this.importeBCom = importeBCom;
    }

    public Date getFechaIbCom() {
        return fechaIbCom;
    }

    public void setFechaIbCom(Date fechaIbCom) {
        this.fechaIbCom = fechaIbCom;
    }

    public Double getPagoBcl() {
        return pagoBcl;
    }

    public void setPagoBcl(Double pagoBcl) {
        this.pagoBcl = pagoBcl;
    }

    public Double getImporteBcl() {
        return importeBcl;
    }

    public void setImporteBcl(Double importeBcl) {
        this.importeBcl = importeBcl;
    }

    public Date getFechaIbcl() {
        return fechaIbcl;
    }

    public void setFechaIbcl(Date fechaIbcl) {
        this.fechaIbcl = fechaIbcl;
    }

    public Double getPagoBcm() {
        return pagoBcm;
    }

    public void setPagoBcm(Double pagoBcm) {
        this.pagoBcm = pagoBcm;
    }

    public Double getImporteBcm() {
        return importeBcm;
    }

    public void setImporteBcm(Double importeBcm) {
        this.importeBcm = importeBcm;
    }

    public Date getFechaIbcm() {
        return fechaIbcm;
    }

    public void setFechaIbcm(Date fechaIbcm) {
        this.fechaIbcm = fechaIbcm;
    }

    public String getMesSol() {
        return mesSol;
    }

    public void setMesSol(String mesSol) {
        this.mesSol = mesSol;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getOsPago() {
        return osPago;
    }

    public void setOsPago(Integer osPago) {
        this.osPago = osPago;
    }

    public String getTelPago() {
        return telPago;
    }

    public void setTelPago(String telPago) {
        this.telPago = telPago;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSubdireccion() {
        return subdireccion;
    }

    public void setSubdireccion(String subdireccion) {
        this.subdireccion = subdireccion;
    }

    public Integer getDifDias() {
        return difDias;
    }

    public void setDifDias(Integer difDias) {
        this.difDias = difDias;
    }

    public Double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getImporteOtros() {
        return importeOtros;
    }

    public void setImporteOtros(Double importeOtros) {
        this.importeOtros = importeOtros;
    }

    public Date getFechaIotros() {
        return fechaIotros;
    }

    public void setFechaIotros(Date fechaIotros) {
        this.fechaIotros = fechaIotros;
    }

    public String getPagoOtros() {
        return pagoOtros;
    }

    public void setPagoOtros(String pagoOtros) {
        this.pagoOtros = pagoOtros;
    }

    public Double getOtraCantidad() {
        return otraCantidad;
    }

    public void setOtraCantidad(Double otraCantidad) {
        this.otraCantidad = otraCantidad;
    }

    public String getOtrosDias() {
        return otrosDias;
    }

    public void setOtrosDias(String otrosDias) {
        this.otrosDias = otrosDias;
    }

    public String getOtrasVentas() {
        return otrasVentas;
    }

    public void setOtrasVentas(String otrasVentas) {
        this.otrasVentas = otrasVentas;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    public String getMesPisa() {
        return mesPisa;
    }

    public void setMesPisa(String mesPisa) {
        this.mesPisa = mesPisa;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTipoLinea() {
        return tipoLinea;
    }

    public void setTipoLinea(String tipoLinea) {
        this.tipoLinea = tipoLinea;
    }

    public String getLineaContratada() {
        return lineaContratada;
    }

    public void setLineaContratada(String lineaContratada) {
        this.lineaContratada = lineaContratada;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getServicios2() {
        return servicios2;
    }

    public void setServicios2(String servicios2) {
        this.servicios2 = servicios2;
    }

    public String getDuplicado() {
        return duplicado;
    }

    public void setDuplicado(String duplicado) {
        this.duplicado = duplicado;
    }

    public String getCatalogoEmpresasProyecto() {
        return catalogoEmpresasProyecto;
    }

    public void setCatalogoEmpresasProyecto(String catalogoEmpresasProyecto) {
        this.catalogoEmpresasProyecto = catalogoEmpresasProyecto;
    }

    public String getCatalogoEstrategiasProyecto() {
        return catalogoEstrategiasProyecto;
    }

    public void setCatalogoEstrategiasProyecto(String catalogoEstrategiasProyecto) {
        this.catalogoEstrategiasProyecto = catalogoEstrategiasProyecto;
    }

    public String getCatalogoEstrategiasEstatus() {
        return catalogoEstrategiasEstatus;
    }

    public void setCatalogoEstrategiasEstatus(String catalogoEstrategiasEstatus) {
        this.catalogoEstrategiasEstatus = catalogoEstrategiasEstatus;
    }

    public String getConcepton() {
        return concepton;
    }

    public void setConcepton(String concepton) {
        this.concepton = concepton;
    }

    public String getPagoBaseDescripcion() {
        return pagoBaseDescripcion;
    }

    public void setPagoBaseDescripcion(String pagoBaseDescripcion) {
        this.pagoBaseDescripcion = pagoBaseDescripcion;
    }

    public String getPagoPosteoDescripcion() {
        return pagoPosteoDescripcion;
    }

    public void setPagoPosteoDescripcion(String pagoPosteoDescripcion) {
        this.pagoPosteoDescripcion = pagoPosteoDescripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(String porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getPorcentajeComisionTrans() {
        return porcentajeComisionTrans;
    }

    public void setPorcentajeComisionTrans(String porcentajeComisionTrans) {
        this.porcentajeComisionTrans = porcentajeComisionTrans;
    }

    public String getComision3() {
        return comision3;
    }

    public void setComision3(String comision3) {
        this.comision3 = comision3;
    }

    public Integer getPagoPagoCliente() {
        return pagoPagoCliente;
    }

    public void setPagoPagoCliente(Integer pagoPagoCliente) {
        this.pagoPagoCliente = pagoPagoCliente;
    }

    public String getPagoPagoClienteDescripcion() {
        return pagoPagoClienteDescripcion;
    }

    public void setPagoPagoClienteDescripcion(String pagoPagoClienteDescripcion) {
        this.pagoPagoClienteDescripcion = pagoPagoClienteDescripcion;
    }

    public Double getImportePagoCliente() {
        return importePagoCliente;
    }

    public void setImportePagoCliente(Double importePagoCliente) {
        this.importePagoCliente = importePagoCliente;
    }

    public Date getFechaPagoCliente() {
        return fechaPagoCliente;
    }

    public void setFechaPagoCliente(Date fechaPagoCliente) {
        this.fechaPagoCliente = fechaPagoCliente;
    }

    public String getOsPagoConversion() {
        return osPagoConversion;
    }

    public void setOsPagoConversion(String osPagoConversion) {
        this.osPagoConversion = osPagoConversion;
    }

    public String getTelPagoConversion() {
        return telPagoConversion;
    }

    public void setTelPagoConversion(String telPagoConversion) {
        this.telPagoConversion = telPagoConversion;
    }

    public String getPisaEConversion() {
        return pisaEConversion;
    }

    public void setPisaEConversion(String pisaEConversion) {
        this.pisaEConversion = pisaEConversion;
    }

    public String getPagoPorta() {
        return pagoPorta;
    }

    public void setPagoPorta(String pagoPorta) {
        this.pagoPorta = pagoPorta;
    }

    public Integer getPagoBonoZf() {
        return pagoBonoZf;
    }

    public void setPagoBonoZf(Integer pagoBonoZf) {
        this.pagoBonoZf = pagoBonoZf;
    }

    public String getEsConversion() {
        return esConversion;
    }

    public void setEsConversion(String esConversion) {
        this.esConversion = esConversion;
    }

    public Integer getPagoNavegacion() {
        return pagoNavegacion;
    }

    public void setPagoNavegacion(Integer pagoNavegacion) {
        this.pagoNavegacion = pagoNavegacion;
    }

    public Double getImporteNavegacion() {
        return importeNavegacion;
    }

    public void setImporteNavegacion(Double importeNavegacion) {
        this.importeNavegacion = importeNavegacion;
    }

    public Date getFechaNavegacion() {
        return fechaNavegacion;
    }

    public void setFechaNavegacion(Date fechaNavegacion) {
        this.fechaNavegacion = fechaNavegacion;
    }

    public Integer getNavegaDwh() {
        return navegaDwh;
    }

    public void setNavegaDwh(Integer navegaDwh) {
        this.navegaDwh = navegaDwh;
    }

    public String getPagoChergeBk() {
        return pagoChergeBk;
    }

    public void setPagoChergeBk(String pagoChergeBk) {
        this.pagoChergeBk = pagoChergeBk;
    }

    public Double getImporteChargeBk() {
        return importeChargeBk;
    }

    public void setImporteChargeBk(Double importeChargeBk) {
        this.importeChargeBk = importeChargeBk;
    }

    public Date getFechaIChergeBk() {
        return fechaIChergeBk;
    }

    public void setFechaIChergeBk(Date fechaIChergeBk) {
        this.fechaIChergeBk = fechaIChergeBk;
    }

    public Integer getImporteChargeBkPgoCte() {
        return importeChargeBkPgoCte;
    }

    public void setImporteChargeBkPgoCte(Integer importeChargeBkPgoCte) {
        this.importeChargeBkPgoCte = importeChargeBkPgoCte;
    }

    public String getPagoChargeBkDescripcion() {
        return pagoChargeBkDescripcion;
    }

    public void setPagoChargeBkDescripcion(String pagoChargeBkDescripcion) {
        this.pagoChargeBkDescripcion = pagoChargeBkDescripcion;
    }

}
