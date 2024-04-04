import Exceptions.UnSupportedRequestTypeException;
import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CommunicationSystem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommunicationSystemTest {

    private CommunicationSystem communicationSystem;

    @BeforeEach
    public void setup() {
        communicationSystem = new CommunicationSystem();
    }

    @Test
    public void testAuthentication() {
        RequestMessage request = new EmailRequest("test", "test" , "1234", "sending sms");
        assertThrows(RuntimeException.class, () -> {
            communicationSystem.processRequest(request, null, null);
        });
        constructProvider();
        communicationSystem.processRequest(request, "user1", "password");
    }

    @Test
    public void addProvider() {
        Provider provider = new Provider(new ArrayList<>());
        String providerId = provider.getProviderId();
        communicationSystem.addProvider(provider);
        System.out.println(providerId);
        System.out.println(communicationSystem.getProvider(providerId).getProviderId());
        assert(provider.equals(communicationSystem.getProvider(providerId)));
    }

    @Test
    public void processRequestIfNoAccountIsProvided() {
        Provider provider = new Provider(new ArrayList<>());
        communicationSystem.addProvider(provider);
        assertThrows(RuntimeException.class, () -> communicationSystem.processRequest(new SMSRequest("2334", "this is my message"), "test", "test"));
    }

    @Test
    public void processRequest() {
        constructProvider();
    }

    public void constructProvider() {
        RequestMessage request = new EmailRequest("sender", "reciever", "Subject","This is dummy request");
        Channel channel = new Channel(RequestType.EMAIl_REQUEST,"this is new apiEndpoint");
        List<Channel> channelList = new ArrayList<>();
        channelList.add(channel);
        Account account = new Account(channelList);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        Provider provider = new Provider(accounts);

        communicationSystem.addProvider(provider);
        communicationSystem.processRequest(request, "test", "test");
    }

    @Test
    public void processIllegalRequest() {
        Provider provider = constructProvider2();
        RequestMessage request = new SandboxRequest("This is dummy request");
        assertThrows(UnSupportedRequestTypeException.class, () -> communicationSystem.processRequest(request, "test", "test"));
    }

    public Provider constructProvider2() {
        Channel channel = new Channel(RequestType.EMAIl_REQUEST,"this is new apiEndpoint");
        List<Channel> channelList = new ArrayList<>();
        channelList.add(channel);
        Account account = new Account(channelList);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        Provider provider = new Provider(accounts);

        return provider;
    }
}
