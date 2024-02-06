package com.telmex.demo.controller;

import com.telmex.demo.components.SpeakerPublisher;
import com.telmex.demo.components.SpeechListener;
import com.telmex.demo.models.SpeechEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/sse")
public class SseController {

    private final int CLIENT_ID = 1;
    @Autowired
    private SpeechListener speechListener;

    @Autowired
    private SpeakerPublisher speakerPublisher;

    @GetMapping("/listen")
    public SseEmitter listen() throws IOException {
        final SseEmitter sseEmitter = new SseEmitter();

        sseEmitter.send("hello, start to speak");
        speechListener.addSseEmitters(CLIENT_ID, sseEmitter);
        //sseEmitter.onCompletion(() -> speechListener.remove(CLIENT_ID));

        return sseEmitter;

    }

    @GetMapping("/public")
    public void publisher(){
        speakerPublisher.speak(new SpeechEvent<String>(this,"Holi",CLIENT_ID));
    }
}
