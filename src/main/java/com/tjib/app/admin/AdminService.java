package com.tjib.app.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public List<Admin> getAllAdmins() {
		List<Admin> admins = new ArrayList<>();
		repository.findAll().forEach(admins::add);
		return admins;
	}

	public Admin getAdmin(String id) {
		return repository.findById(id).get();
	}

	public void addAdmin(Admin admin) {
		repository.save(admin);
	}

	public void updateAdmin(String id, Admin admin) {
		repository.save(admin);
	}

	public void deleteAdmin(String id) {
		repository.deleteById(id);
	}

	public void deleteAllAdmins() {
		repository.deleteAll();
	}

}
