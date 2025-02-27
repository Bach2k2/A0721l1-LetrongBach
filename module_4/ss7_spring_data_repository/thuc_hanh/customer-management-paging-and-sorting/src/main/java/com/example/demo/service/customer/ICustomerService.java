package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstName,Pageable pageable);
}
