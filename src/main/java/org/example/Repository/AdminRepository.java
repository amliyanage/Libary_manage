package org.example.Repository;

import org.example.Entity.Admin;

public interface AdminRepository extends CrudUtil<Admin>{
    Admin getData();

    Admin CheckEmail(String email);
}
