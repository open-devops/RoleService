package com.hpe.devops.api.role;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles", produces = { "application/json" })
public class RoleController {

	@Autowired
	private RoleRepository roleRepo;
	
	@RequestMapping(value="/organization/{organizationId}", method = RequestMethod.GET)
	public List<Role> getRolesByOrgId(@PathVariable String organizationId ) throws Exception {
		
		return roleRepo.findByOrganizationId(organizationId);
	}
	
	@RequestMapping(value="/{roleId}",  method = RequestMethod.GET)
	public Role getRoleById(@PathVariable String roleId) throws Exception {
		
		return roleRepo.findOne(roleId);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Role> addRole(@RequestBody Role reqRole) throws Exception {
		
		reqRole.setId(UUID.randomUUID().toString());
		
		Role org = roleRepo.save(reqRole);
		
		return new ResponseEntity<Role>(org, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Role> updateRole(@RequestBody Role role) throws Exception {
		Role org = roleRepo.save(role);
		
		return new ResponseEntity<Role>(org, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Role> deleteRole(@PathVariable String id) throws Exception {

		Role role = this.getRoleById(id);
		
		roleRepo.delete(id);
		
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
}
