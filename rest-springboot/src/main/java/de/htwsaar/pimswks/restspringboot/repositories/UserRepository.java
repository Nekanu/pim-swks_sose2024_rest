package de.htwsaar.pimswks.restspringboot.repositories;

import de.htwsaar.pimswks.restspringboot.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<User, Long> {
}
