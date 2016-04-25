package edu.njit.ProxyService.repository;

import edu.njit.ProxyService.models.ProxyNeed;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by srinivaz on 4/24/16.
 */
public interface ProxyNeedRepository extends MongoRepository<ProxyNeed,String> {

    public ProxyNeed findByNeed(boolean need);


}
