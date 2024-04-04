package repository;

import domain.Channel;
import domain.RequestMessage;
import domain.RequestType;

import java.util.*;

public class ChannelProvider {

    private final Map<RequestType, Set<String>> requestToProviderIdsMap;

    public ChannelProvider() {
        this.requestToProviderIdsMap = new HashMap<>();
    }

    public void addChannelProvider(Set<Channel> channels, String providerId) {
        for(Channel channel: channels) {
            RequestType requestType = channel.getRequestType();

            if(requestToProviderIdsMap.get(requestType) == null) {
                Set <String> providerIDList = new HashSet<>();
                providerIDList.add(providerId);
                requestToProviderIdsMap.put(requestType, providerIDList);
                System.out.println("Successfully add one Channel Provider with id " + providerId);
            } else {
                Set<String> providerIdList = requestToProviderIdsMap.get(requestType);
                providerIdList.add(providerId);
            }
        }
    }

    public Set<String> getProviderIdsBasedOnRequest(RequestType requestType) {
        return requestToProviderIdsMap.get(requestType);
    }
}
