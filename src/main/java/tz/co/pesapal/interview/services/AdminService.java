package tz.co.pesapal.interview.services;

import tz.co.pesapal.interview.beans.Admin;

/**
 * @project interview
 * @Author frances on 16/06/2021
 * For Softnet Technologies Limited
 * +255745470673
 */
public interface AdminService {
    public Admin saveAdmin(Admin admin);
    public Admin findAdminByUsername(String username);
    public Admin findAdminById(String id) throws Exception;

}
