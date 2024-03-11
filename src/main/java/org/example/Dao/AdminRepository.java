package org.example.Dao;

import org.example.Entity.Admin;

public interface AdminRepository extends CrudUtil<Admin>{
    Admin getData();
}
