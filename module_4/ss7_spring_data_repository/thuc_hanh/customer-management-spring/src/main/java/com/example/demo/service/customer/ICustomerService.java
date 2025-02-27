package com.example.demo.service.customer;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
