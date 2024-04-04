package domain;

import java.util.UUID;

public class SMSRequest extends RequestMessage {

    private final String id;
    private final String number;

    public SMSRequest(String number, String message) {
        super(message);
        this.id = UUID.randomUUID().toString();
        this.number = number;
    }
}
