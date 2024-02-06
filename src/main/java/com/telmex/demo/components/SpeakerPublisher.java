package com.telmex.demo.components;

import com.telmex.demo.models.SpeechEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpeakerPublisher {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void speak(SpeechEvent event){
        eventPublisher.publishEvent(event);
    }
}
