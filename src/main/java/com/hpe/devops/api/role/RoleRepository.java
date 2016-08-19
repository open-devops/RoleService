package com.hpe.devops.api.role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Long> {

	Role findById(Long id);
}
