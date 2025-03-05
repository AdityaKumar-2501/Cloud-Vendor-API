package com.example.workingwithdatabase.restapi.repository;

import com.example.workingwithdatabase.restapi.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
