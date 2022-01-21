package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Subject;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {

        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }
    public Admin saveAdmin(Admin admin){

        return adminRepository.save(admin);
    }
    public void deleteById(String id){

        adminRepository.deleteById(id);
    }
    public void updateSubject(Admin admin){

        adminRepository.save(admin);
    }
}
