package com.telmex.demo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@Data
@EqualsAndHashCode(of={"listenerId"},callSuper=false)
public class SpeechEvent<T> extends ApplicationEvent {
    private static final long serialVersionUID = -8816184314176294891L;

    private final T message;
    private final long listenerId;

    public SpeechEvent(Object source, T message, long listenerId) {
        super(source);
        this.message = message;
        this.listenerId = listenerId;
    }
}
