package repository;

import domain.Account;
import domain.Channel;
import domain.Provider;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProviderRepository {

    private final ChannelProvider channelProvider;

    private final HashMap<String, Provider> providerHashMap;

    public ProviderRepository() {
        this.providerHashMap = new HashMap<>();
        channelProvider = new ChannelProvider();
    }

    public void addProvider(Provider provider) {
        Set<Channel> supportedChannel = new HashSet<>();
        for(Account account: provider.getAccounts()) {
            supportedChannel.addAll(account.getSupportedChannel());
        }
        channelProvider.addChannelProvider(supportedChannel, provider.getProviderId());
        this.providerHashMap.putIfAbsent(provider.getProviderId(), provider);
    }

    public Provider getProvider(String providerId) {
        return providerHashMap.get(providerId);
    }

    public void updateProvider(Provider provider) {
        this.providerHashMap.put(provider.getProviderId(), provider);
    }

    public ChannelProvider getChannelProvider() {
        return channelProvider;
    }
}
