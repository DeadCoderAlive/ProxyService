package edu.njit.ProxyService.repository;

import edu.njit.ProxyService.models.CachedWebPages;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by srinivaz on 4/24/16.
 */
public interface CachedWebPagesRepository extends MongoRepository<CachedWebPages,String> {


}
