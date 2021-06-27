package tz.co.pesapal.interview.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tz.co.pesapal.interview.beans.Admin;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findAdminByUsername(String username);
    Admin findAdminById(String id);

}
