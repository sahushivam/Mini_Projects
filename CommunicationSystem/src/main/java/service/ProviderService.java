package service;

import domain.Channel;
import domain.Provider;
import domain.RequestMessage;

public class ProviderService {

    public Boolean sendRequest(Provider provider, Channel channel, RequestMessage request) {
        System.out.println(provider.getProviderId() + "Provider Id , Channel " + channel.getChannelId() + " message " + request.getMessage());
        return true; //true and false based on if request goes through
    }
}
