package domain;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Provider {

    private final String providerId;
    private final List<Account> accounts;
    private Boolean isActive;

    public Provider(List<Account> accounts) {
        this.providerId = UUID.randomUUID().toString();
        this.isActive = true;
        this.accounts = accounts;
    }

    public void setIsActive(Boolean isActive){
        this.isActive = isActive;
    }
}
