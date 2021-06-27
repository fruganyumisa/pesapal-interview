package tz.co.pesapal.interview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tz.co.pesapal.interview.beans.Admin;
import tz.co.pesapal.interview.repositories.AdminRepository;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    //@Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Admin saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Admin findAdminByUsername(String username) {
        return adminRepository.findAdminByUsername(username);
    }

    @Override
    public Admin findAdminById(String id) throws Exception {
        //return adminRepository.findAdminById(id);
        return adminRepository.findById(id).orElseThrow(() ->
                new Exception("Could not find Admin with this id"));
    }
}
