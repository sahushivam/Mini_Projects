package domain;

import lombok.Getter;

@Getter
public abstract class RequestMessage {

    private final String message;

    public RequestMessage(String message) {
        this.message = message;
    }
}
