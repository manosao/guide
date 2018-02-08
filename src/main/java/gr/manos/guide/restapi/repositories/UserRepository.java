package gr.manos.guide.restapi.repositories;

import gr.manos.guide.restapi.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
//	@Query(value= "select 1", nativeQuery = true)
//  public String selectNativeQuery();
}
