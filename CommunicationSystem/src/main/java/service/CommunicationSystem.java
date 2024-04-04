package service;

import Exceptions.UnSupportedRequestTypeException;
import authentication.Authentication;
import domain.*;
import lombok.SneakyThrows;
import repository.ChannelProvider;
import repository.ProviderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CommunicationSystem {

    private final ProviderRepository providerRepository;
    private final Authentication authentication;
    ProviderService providerService;

    public CommunicationSystem() {
        this.providerRepository = new ProviderRepository();
        this.authentication = new Authentication();
        this.providerService = new ProviderService();
    }

    public void addProvider(Provider provider) {
        providerRepository.addProvider(provider);
    }

    public Provider getProvider(String providerId) {
        return providerRepository.getProvider(providerId);
    }

    public void updateStatus(String providerId, Boolean isActive) {
        Provider provider = getProvider(providerId);
        provider.setIsActive(isActive);
    }

    public void updateProvider(Provider provider) {
        providerRepository.updateProvider(provider);
    }

    @SneakyThrows
    public void processRequest(RequestMessage request, String username, String password) {
        authentication.authenticate(username, password);
        /*
            1. Find the type of request
            2. Process that request through one of the channel Provider

         */
        Set<String> providerIdsBasedOnRequest = providerRepository.getChannelProvider().getProviderIdsBasedOnRequest(findTypeOfRequest(request));
        String selectedChannelProviderId = getRandomString(providerIdsBasedOnRequest);
        Provider provider = getProvider(selectedChannelProviderId);
        List<Account> accounts = provider.getAccounts();
        List<Channel> channelsInProvider = getAllAvailableChannel(accounts);

        if(channelsInProvider.isEmpty()) {
            throw new RuntimeException("No Channel Available to process the request");
        }

        providerService.sendRequest(provider, channelsInProvider.get(0), request);

    }

    private RequestType findTypeOfRequest(RequestMessage request) {
        if(request instanceof EmailRequest)
            return RequestType.EMAIl_REQUEST;
        else if(request instanceof SMSRequest)
            return RequestType.SMS_REQUEST;
        throw new UnSupportedRequestTypeException("Unsupported Request Type");
    }

    private List<Channel> getAllAvailableChannel(List<Account> accounts) {
        List<Channel> availableChannels = new ArrayList<>();
        for(Account account: accounts) {
            availableChannels.addAll(account.getSupportedChannel());
        }
        return availableChannels;
    }

    private String getRandomString(Set<String> channelSet) {
        if(channelSet == null || channelSet.isEmpty()) {
            throw new RuntimeException("Channel set is empty");
        }
        List<String> channelList = new ArrayList<>(channelSet);
        Random rand = new Random();
        return channelList.get(rand.nextInt(channelList.size()));

    }
}
