package com.telmex.demo.dto.mapper;

import com.telmex.demo.dto.RowEstadoCuenta;
import com.telmex.demo.entity.EstadoCuenta;
import com.telmex.demo.entity.EstadoCuentaDetalle;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EstadoCuentaDetalleMapper implements Mapper<Set<EstadoCuentaDetalle>, List<RowEstadoCuenta>> {

    private EstadoCuenta estadoCuenta;
    @Override
    public Set<EstadoCuentaDetalle> map(List<RowEstadoCuenta> listaOrigen) {
        Set<EstadoCuentaDetalle> listaFinal = new HashSet();
        EstadoCuentaDetalle detalle = null;
        for (RowEstadoCuenta row : listaOrigen) {
            detalle = new EstadoCuentaDetalle();
            detalle.setQuincena(row.getQuincena());
            detalle.setRubro(row.getRubro());
            detalle.setMaster(row.getMaster());
            detalle.setEstrategia(row.getEstrategia());
            detalle.setPromotor(row.getPromotor());
            detalle.setFolio(row.getFolio());
            detalle.setConfirmadas(row.getConfirmadas());
            detalle.setExpediente(row.getExpediente());
            detalle.setPagoBase(row.getPagoBase());
            detalle.setImporteBase(row.getImporteBase());
            detalle.setFechaIBase(row.getFechaIBase());
            detalle.setPagoPosteo(row.getPagoPosteo());
            detalle.setImportePosteo(row.getImportePosteo());
            detalle.setFechaIPosteo(row.getFechaIPosteo());
            detalle.setPisaE(row.getPisaE());
            detalle.setProcede2(row.getProcede2());
            detalle.setPago2(row.getPago2());
            detalle.setPagoBe(row.getPagoBe());
            detalle.setImporteBe(row.getImporteBe());
            detalle.setFechaIbe(row.getFechaIbe());
            detalle.setPagoBCom(row.getPagoBcm());
            detalle.setFechaIbCom(row.getFechaIbCom());
            detalle.setImporteBCom(row.getImporteBCom());
            detalle.setFechaIbCom(row.getFechaIbCom());
            detalle.setPagoBcl(row.getPagoBcl());
            detalle.setImporteBcl(row.getImporteBcl());
            detalle.setFechaIbcl(row.getFechaIbcl());
            detalle.setPagoBcm(row.getPagoBcm());
            detalle.setImporteBcm(row.getImporteBcm());
            detalle.setFechaIbcm(row.getFechaIbcm());
            detalle.setMesSol(row.getMesSol());
            detalle.setFecha(row.getFecha());
            detalle.setOsPago(row.getOsPago());
            detalle.setTelPago(row.getTelPago());
            detalle.setArea(row.getArea());
            detalle.setDivision(row.getDivision());
            detalle.setSubdireccion(row.getSubdireccion());
            detalle.setDifDias(row.getDifDias());
            detalle.setPagoTotal(row.getPagoTotal());
            detalle.setCantidad(row.getCantidad());
            detalle.setEmpresa(row.getEmpresa());
            detalle.setObservaciones(row.getObservaciones());
            detalle.setImporteOtros(row.getImporteOtros());
            detalle.setOtraCantidad(row.getOtraCantidad());
            detalle.setOtrosDias(row.getOtrosDias());
            detalle.setDias(row.getDias());
            detalle.setVentas(row.getVentas());
            detalle.setMesPisa(row.getMesPisa());
            detalle.setEstatus(row.getEstatus());
            detalle.setTipoLinea(row.getTipoLinea());
            detalle.setLineaContratada(row.getLineaContratada());
            detalle.setPaquete(row.getPaquete());
            detalle.setServicios(row.getServicios());
            detalle.setServicios2(row.getServicios2());
            detalle.setDuplicado(row.getDuplicado());
            detalle.setCatalogoEmpresasProyecto(row.getCatalogoEmpresasProyecto());
            detalle.setCatalogoEstrategiasProyecto(row.getCatalogoEstrategiasProyecto());
            detalle.setCatalogoEstrategiasEstatus(row.getCatalogoEstrategiasEstatus());
            detalle.setConcepton(row.getConcepton());
            detalle.setPagoBaseDescripcion(row.getPagoBaseDescripcion());
            detalle.setPagoBaseDescripcion(row.getPagoBaseDescripcion());
            detalle.setRango(row.getRango());
            detalle.setPorcentajeComision(row.getPorcentajeComision());
            detalle.setMes(row.getMes());
            detalle.setPorcentajeComisionTrans(row.getPorcentajeComisionTrans());
            detalle.setComision3(row.getComision3());
            detalle.setPagoPagoCliente(row.getPagoPagoCliente());
            detalle.setPagoPagoClienteDescripcion(row.getPagoPagoClienteDescripcion());
            detalle.setImportePagoCliente(row.getImportePagoCliente());
            detalle.setFechaPagoCliente(row.getFechaPagoCliente());
            detalle.setOsPagoConversion(row.getOsPagoConversion());
            detalle.setTelPagoConversion(row.getTelPagoConversion());
            detalle.setPisaEConversion(row.getPisaEConversion());
            detalle.setPagoPorta(row.getPagoPorta());
            detalle.setPagoBonoZf(row.getPagoBonoZf());
            detalle.setEsConversion(row.getEsConversion());
            detalle.setPagoNavegacion(row.getPagoNavegacion());
            detalle.setImporteNavegacion(row.getImporteNavegacion());
            detalle.setFechaNavegacion(row.getFechaNavegacion());
            detalle.setNavegaDwh(row.getNavegaDwh());
            detalle.setPagoChergeBk(row.getPagoChergeBk());
            detalle.setImporteChargeBk(row.getImporteChargeBk());
            detalle.setFechaIChergeBk(row.getFechaIChergeBk());
            detalle.setImporteChargeBkPgoCte(row.getImporteChargeBkPgoCte());
            detalle.setPagoChargeBkDescripcion(row.getPagoChargeBkDescripcion());
            detalle.setEstadoCuenta(estadoCuenta);
            listaFinal.add(detalle);
        }
        return listaFinal;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
}
