package com.telmex.demo.constants;

import com.telmex.demo.entity.EstatusCarga;

public class EstadoCargaConstants {

    public static final EstatusCarga INICIADO = new EstatusCarga(1,"Iniciado lectura de archivo");
    public static final EstatusCarga PROCESANDO = new EstatusCarga(2,"Procesando archivo");
    public static final EstatusCarga FINALIZADO = new EstatusCarga(3,"Finalizada carga de archivo");
    public static final EstatusCarga FALLIDO = new EstatusCarga(4,"Fallido");
    public static final EstatusCarga ARCHIVO_NO_ENCONTRADO = new EstatusCarga(5,"Archivo No Encontrado");

}
