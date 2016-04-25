package edu.njit.ProxyService.repository;

import edu.njit.ProxyService.models.LiveUsers;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by srinivaz on 4/24/16.
 */
public interface LiveUserRepository extends MongoRepository<LiveUsers,String> {

    public LiveUsers findByLiveNow(boolean liveNow);

    public LiveUsers findByUserId(String userId);

    public LiveUsers findByServiceType(String serviceType);


}
