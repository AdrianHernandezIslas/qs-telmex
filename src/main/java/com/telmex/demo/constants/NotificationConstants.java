package com.telmex.demo.constants;

import com.telmex.demo.entity.Notificacion;
import com.telmex.demo.enums.PrioridadNotificacionEnum;
import com.telmex.demo.enums.TipoNotificacionEnum;

public class NotificationConstants {
    public static final Notificacion.NotificacionBuilder INFO = Notificacion.builder().tipo(TipoNotificacionEnum.INFORMACION).prioridad(PrioridadNotificacionEnum.BAJA).leido(false);
    public static final Notificacion.NotificacionBuilder ERROR = Notificacion.builder().tipo(TipoNotificacionEnum.ALERTA).prioridad(PrioridadNotificacionEnum.MEDIA).leido(false);
}
