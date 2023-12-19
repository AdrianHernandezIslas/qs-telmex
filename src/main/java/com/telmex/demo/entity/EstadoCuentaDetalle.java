package com.telmex.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telmex.demo.constants.ArchivoContants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "LYTESTADOCUENTADETALLE")
public class EstadoCuentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer idEstadoCuentaDetalle;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="idEstadoCuenta", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private EstadoCuenta estadoCuenta;
    private Date quincena;
    private String rubro;
    private Integer master;
    private Integer estrategia;
    private Integer promotor;
    private Integer folio;
    private Integer confirmadas;
    private Integer expediente;
    private Double pagoBase;
    private Double importeBase;
    private Date fechaIBase;
    private Integer pagoPosteo;
    private Double importePosteo;
    private Date fechaIPosteo;
    private String pisaE;
    private String procede2;
    private String pago2;
    private Integer pagoBe;
    private Double importeBe;
    private Date fechaIbe;
    private Double pagoBCom;
    private Double importeBCom;
    private Date fechaIbCom;
    private Double pagoBcl;
    private Double importeBcl;
    private Date fechaIbcl;
    private Double pagoBcm;
    private Double importeBcm;
    private Date fechaIbcm;
    private String mesSol;
    private String fecha;
    private Integer osPago;
    private String telPago;
    private String area;
    private String division;
    private String subdireccion;
    private Integer difDias;
    private Double pagoTotal;
    private Double cantidad;
    private String empresa;
    private String observaciones;
    private Double importeOtros;
    private Date fechaIotros;
    private String pagoOtros;
    private Double otraCantidad;
    private String otrosDias;
    private String otrasVentas;
    private String dias;
    private String ventas;
    private String mesPisa;
    private String estatus;
    private String tipoLinea;
    private String lineaContratada;
    private String paquete;
    private String servicios;
    private String servicios2;
    private String duplicado;
    private String catalogoEmpresasProyecto;
    private String catalogoEstrategiasProyecto;
    private String catalogoEstrategiasEstatus;
    private String concepton;
    private String pagoBaseDescripcion;
    private String pagoPosteoDescripcion;
    private String rango;
    private String porcentajeComision;
    private String mes;
    private String porcentajeComisionTrans;
    private String comision3;
    private Integer pagoPagoCliente;
    private String pagoPagoClienteDescripcion;
    private Double importePagoCliente;
    private Date fechaPagoCliente;
    private String osPagoConversion;
    private String telPagoConversion;
    private String pisaEConversion;
    private String pagoPorta;
    private Integer pagoBonoZf;
    private String esConversion;
    private Integer pagoNavegacion;
    private Double importeNavegacion;
    private Date fechaNavegacion;
    private Integer navegaDwh;
    private String pagoChergeBk;
    private Double importeChargeBk;
    private Date fechaIChergeBk;
    private Integer importeChargeBkPgoCte;
    private String pagoChargeBkDescripcion;


    public Integer getIdEstadoCuentaDetalle() {
        return idEstadoCuentaDetalle;
    }

    public void setIdEstadoCuentaDetalle(Integer idEstadoCuentaDetalle) {
        this.idEstadoCuentaDetalle = idEstadoCuentaDetalle;
    }

    public EstadoCuenta getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append("(").append(getValueSql(quincena));
        sb.append(", ").append(getValueSql(rubro));
        sb.append(", ").append(getValueSql(master));
        sb.append(", ").append(getValueSql(estrategia));
        sb.append(", ").append(getValueSql(promotor));
        sb.append(", ").append(getValueSql(folio));
        sb.append(", ").append(getValueSql(confirmadas));
        sb.append(", ").append(getValueSql(expediente));
        sb.append(", ").append(getValueSql(pagoBase));
        sb.append(", ").append(getValueSql(importeBase));
        sb.append(", ").append(getValueSql(fechaIBase));
        sb.append(", ").append(getValueSql(pagoPosteo));
        sb.append(", ").append(getValueSql(importePosteo));
        sb.append(", ").append(getValueSql(fechaIPosteo));
        sb.append(", ").append(getValueSql(pisaE));
        sb.append(", ").append(getValueSql(procede2));
        sb.append(", ").append(getValueSql(pago2));
        sb.append(", ").append(getValueSql(pagoBe));
        sb.append(", ").append(getValueSql(importeBe));
        sb.append(", ").append(getValueSql(fechaIbe));
        sb.append(", ").append(getValueSql(pagoBCom));
        sb.append(", ").append(getValueSql(importeBCom));
        sb.append(", ").append(getValueSql(fechaIbCom));
        sb.append(", ").append(getValueSql(pagoBcl));
        sb.append(", ").append(getValueSql(importeBcl));
        sb.append(", ").append(getValueSql(fechaIbcl));
        sb.append(", ").append(getValueSql(pagoBcm));
        sb.append(",").append(getValueSql(importeBcm));
        sb.append(", ").append(getValueSql(fechaIbcm));
        sb.append(", ").append(getValueSql(mesSol));
        sb.append(", ").append(getValueSql(fecha));
        sb.append(", ").append(getValueSql(osPago));
        sb.append(", ").append(getValueSql(telPago));
        sb.append(", ").append(getValueSql(area));
        sb.append(", ").append(getValueSql(division));
        sb.append(", ").append(getValueSql(subdireccion));
        sb.append(", ").append(getValueSql(difDias));
        sb.append(", ").append(getValueSql(pagoTotal));
        sb.append(", ").append(getValueSql(cantidad));
        sb.append(", ").append(getValueSql(empresa));
        sb.append(", ").append(getValueSql(observaciones));
        sb.append(", ").append(getValueSql(importeOtros));
        sb.append(", ").append(getValueSql(fechaIotros));
        sb.append(", ").append(getValueSql(pagoOtros));
        sb.append(", ").append(getValueSql(otraCantidad));
        sb.append(", ").append(getValueSql(otrosDias));
        sb.append(", ").append(getValueSql(otrasVentas));
        sb.append(", ").append(getValueSql(dias));
        sb.append(", ").append(getValueSql(ventas));
        sb.append(", ").append(getValueSql(mesPisa));
        sb.append(", ").append(getValueSql(estatus));
        sb.append(", ").append(getValueSql(tipoLinea));
        sb.append(", ").append(getValueSql(lineaContratada));
        sb.append(", ").append(getValueSql(paquete));
        sb.append(", ").append(getValueSql(servicios));
        sb.append(", ").append(getValueSql(servicios2));
        sb.append(", ").append(getValueSql(duplicado));
        sb.append(", ").append(getValueSql(catalogoEmpresasProyecto));
        sb.append(", ").append(getValueSql(catalogoEstrategiasProyecto));
        sb.append(", ").append(getValueSql(catalogoEstrategiasEstatus));
        sb.append(", ").append(getValueSql(concepton));
        sb.append(", ").append(getValueSql(pagoBaseDescripcion));
        sb.append(", ").append(getValueSql(pagoPosteoDescripcion));
        sb.append(", ").append(getValueSql(rango));
        sb.append(", ").append(getValueSql(porcentajeComision));
        sb.append(", ").append(getValueSql(mes));
        sb.append(", ").append(getValueSql(porcentajeComisionTrans));
        sb.append(", ").append(getValueSql(comision3));
        sb.append(", ").append(getValueSql(pagoPagoCliente));
        sb.append(", ").append(getValueSql(pagoPagoClienteDescripcion));
        sb.append(", ").append(getValueSql(importePagoCliente));
        sb.append(", ").append(getValueSql(fechaPagoCliente));
        sb.append(", ").append(getValueSql(osPagoConversion));
        sb.append(", ").append(getValueSql(telPagoConversion));
        sb.append(", ").append(getValueSql(pisaEConversion));
        sb.append(", ").append(getValueSql(pagoPorta));
        sb.append(", ").append(getValueSql(pagoBonoZf));
        sb.append(", ").append(getValueSql(esConversion));
        sb.append(", ").append(getValueSql(pagoNavegacion));
        sb.append(", ").append(getValueSql(importeNavegacion));
        sb.append(", ").append(getValueSql(fechaNavegacion));
        sb.append(", ").append(getValueSql(navegaDwh));
        sb.append(", ").append(getValueSql(pagoChergeBk));
        sb.append(", ").append(getValueSql(importeChargeBk));
        sb.append(", ").append(getValueSql(fechaIChergeBk));
        sb.append(", ").append(getValueSql(importeChargeBkPgoCte));
        sb.append(", ").append(getValueSql(pagoChargeBkDescripcion));
        sb.append(')');
        return sb.toString();
    }

    private String getValueSql(Object value){
        String newValue = null;
        if(Optional.ofNullable(value).isPresent()){
            if(  (value instanceof Double || value instanceof Integer)){
                newValue = value.toString();
            }else if(value instanceof Date){
                LocalDate date = Instant.ofEpochMilli(((Date)value).getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                newValue = ArchivoContants.DATE_FORMAT.format(date);
            }else if(value instanceof String){
                newValue = value.toString();
            }
            newValue = "'"+newValue+"'";
        }

        return newValue;
    }
}
