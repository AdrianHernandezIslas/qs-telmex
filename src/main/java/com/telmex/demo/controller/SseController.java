package com.telmex.demo.controller;

import com.telmex.demo.components.SpeakerPublisher;
import com.telmex.demo.components.SpeechListener;
import com.telmex.demo.entity.UserSession;
import com.telmex.demo.models.SpeechEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/sse")
public class SseController extends BaseController {
    @Autowired
    private SpeechListener speechListener;

    @Autowired
    private SpeakerPublisher speakerPublisher;

    @GetMapping("/listen")
    public SseEmitter listen(Principal principal) throws IOException {
        final SseEmitter sseEmitter = new SseEmitter();
        UserSession session = getSession(principal);
        sseEmitter.send("hello, start to speak");
        speechListener.addSseEmitters(session.getIdSesion(), sseEmitter);
        //sseEmitter.onCompletion(() -> speechListener.remove(CLIENT_ID));

        return sseEmitter;

    }

    @GetMapping("/public")
    public void publisher(Principal principal){
        UserSession session = getSession(principal);
        speakerPublisher.speak(new SpeechEvent(this,session,session.getIdSesion()));
    }
}
