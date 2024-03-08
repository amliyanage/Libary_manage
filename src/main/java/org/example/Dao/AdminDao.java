package org.example.Dao;

import org.example.Entity.Admin;

public interface AdminDao extends CrudUtil<Admin>{
    Admin getData(int Id);
}
