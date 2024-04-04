package domain;

import java.util.UUID;

public class EmailRequest extends RequestMessage {

    private final String id;
    private final String sender;
    private final String reciever;
    private final String subject;


    public EmailRequest(String sender, String reciever, String subject, String message) {
        super(message);
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.reciever = reciever;
        this.subject = subject;
    }
}
