package domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Channel {

    private final String channelId;
    private final RequestType requestType;
    private final String apiEndPoint;

    public Channel(RequestType requestType, String apiEndPoint) {
        this.channelId = UUID.randomUUID().toString();
        this.requestType = requestType;
        this.apiEndPoint = apiEndPoint;
    }
}
