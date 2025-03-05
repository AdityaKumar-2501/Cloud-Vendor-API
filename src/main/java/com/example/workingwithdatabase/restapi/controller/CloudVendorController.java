package com.example.workingwithdatabase.restapi.controller;

import com.example.workingwithdatabase.restapi.model.CloudVendor;
import com.example.workingwithdatabase.restapi.response.ResponseHandler;
import com.example.workingwithdatabase.restapi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
    
    @GetMapping
    public List<CloudVendor> getAllCloudVendor(){
        return cloudVendorService.getAllCloudVendor();
    }
    
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendor(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder(
                "Requested Vendor details are given here",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId)
        );
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cd){
        cloudVendorService.createCloudVendor(cd);
        return "Successfully created cloud vendor";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cd){
        cloudVendorService.updateCloudVendor(cd);
        return "Successfully updated cloud vendor";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Successfully deleted the cloud vendor";
    }
}
