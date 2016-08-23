package com.hpe.devops.api.role;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

		List<Role> findByOrganizationId(String OrganizationId);
}
