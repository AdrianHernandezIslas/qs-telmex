package com.telmex.demo.components;

import com.telmex.demo.models.SpeechEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

@Component
public class SpeechListener {

    /**
     * The list of the objects of SseEmitter.
     * The key of the map stands for submissionId.
     * The value of the map is the corresponding SseEmitter object.
     */
    private static Map<Long, SseEmitter> sseEmitters = new Hashtable();
    @EventListener
    public void submissionEventHandler(SpeechEvent event) {
        long listenerId = event.getListenerId();
        SseEmitter sseEmitter = sseEmitters.get(listenerId);

        if (sseEmitter == null) {
            //logger.warn(String.format("CANNOT get the SseEmitter for listener #%d.", listenerId));
            return;
        }
        try {
            sseEmitter.send(event.getMessage(), MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            sseEmitter.complete();
            sseEmitters.remove(listenerId);
           // logger.warn(e.getMessage());
        }
    }

    public void addSseEmitters(long submissionId, SseEmitter sseEmitter) {
        sseEmitters.put(submissionId, sseEmitter);
    }

    public void remove(Integer listenerId) {
        sseEmitters.remove(listenerId);
    }
}
