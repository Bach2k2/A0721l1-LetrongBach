package com.example.demo.formatter;

import com.example.demo.model.Province;
import com.example.demo.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    @Autowired
    private IProvinceService provinceService;

    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Optional<Province> optionalProvince=provinceService.findById(Long.parseLong(text));
        return optionalProvince.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[ "+object.getId()+", "+object.getName()+"]";
    }
}
