package com.hpe.devops.api.role;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/roles", produces = { "application/json" })
public class RoleController {

	
	@Autowired
	private RoleRepository roleRepo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Role> allRoles() throws Exception {
		
		return roleRepo.findAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Role> addRole(@RequestBody Role reqRole) throws Exception {
		if (reqRole.getId() == -1) {
			reqRole.setId(new Date().getTime());
		}
		Role org = roleRepo.save(reqRole);
		
		return new ResponseEntity<Role>(org, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Role> updateRole(@RequestBody Role role) throws Exception {
		Role org = roleRepo.save(role);
		
		return new ResponseEntity<Role>(org, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteRole(@PathVariable Long id) throws Exception {
//		Role org = roleRepo.findById(id);
		roleRepo.delete(id);
		
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
}
