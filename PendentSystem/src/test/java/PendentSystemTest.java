import domain.Tag;
import domain.TagType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import repository.EntityRepository;
import repository.TagRepository;
import service.PendentServiceImpl;

import java.util.Arrays;
import java.util.HashMap;

public class PendentSystemTest {

    private EntityRepository entityRepo = new EntityRepository(new HashMap<>());
    private TagRepository CTagRepo = new TagRepository();
    private PendentServiceImpl pendentService = new PendentServiceImpl(entityRepo, CTagRepo
    );

    @Test
    public void testFlow() {
        Tag UPITag = new Tag("UPI", TagType.INSTRUMENT);
        Tag WalletTag = new Tag("Wallet", TagType.INSTRUMENT);

        Tag BangaloreTag = new Tag("Bangalore", TagType.CITY);
        Tag JaipurTag = new Tag("Jaipur", TagType.CITY);
        Tag MysoreTag = new Tag("Mysore", TagType.CITY);

        Tag KarnatakaTag = new Tag("Karnataka", TagType.STATE);
        Tag RajasthanTag = new Tag("Rajasthan", TagType.STATE);

        pendentService.startTracking("1112", Arrays.asList(UPITag, KarnatakaTag, BangaloreTag));
        pendentService.startTracking("2451", Arrays.asList(UPITag, KarnatakaTag, MysoreTag));
        pendentService.startTracking("3421", Arrays.asList(UPITag, RajasthanTag, JaipurTag));
        pendentService.startTracking("1221", Arrays.asList(WalletTag, KarnatakaTag, BangaloreTag));

        assert pendentService.getCounts(Arrays.asList(UPITag)) == 3;
        assert pendentService.getCounts(Arrays.asList(UPITag, KarnatakaTag)) == 2;
        assert pendentService.getCounts(Arrays.asList(UPITag, KarnatakaTag, BangaloreTag)) == 1 ;

        assert pendentService.getCounts(Arrays.asList(BangaloreTag)) == 0;
    }

}
