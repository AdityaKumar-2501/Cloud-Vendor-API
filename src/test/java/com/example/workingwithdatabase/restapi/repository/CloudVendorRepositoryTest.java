package com.example.workingwithdatabase.restapi.repository;

import com.example.workingwithdatabase.restapi.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Google","USA","7894561230");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // test case SUCCESS
    @Test
    void testFindByVendorName_found(){
        List<CloudVendor> cloudVendorsList = cloudVendorRepository.findByVendorName("Google");
        assertThat(cloudVendorsList.getFirst().getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorsList.getFirst().getVendorAddress()).isEqualTo("USA");
    }

    // test case FAILURE
    @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendor> cloudVendorsList = cloudVendorRepository.findByVendorName("AWS");
        assertThat(cloudVendorsList.isEmpty()).isTrue();
    }
}
