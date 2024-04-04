package domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Account {

    private final List<Channel> supportedChannel;

    public Account(List<Channel> supportedChannel) {
        this.supportedChannel = supportedChannel;
    }
}
