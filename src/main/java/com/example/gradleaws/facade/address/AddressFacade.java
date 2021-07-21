package com.example.gradleaws.facade.address;

import com.example.gradleaws.annotations.Facade;
import com.example.gradleaws.controller.address.models.AddressResponseModel;
import com.example.gradleaws.converter.AddressConverter;
import com.example.gradleaws.service.address.AddressService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class AddressFacade {

    private final AddressService addressService;
    private final AddressConverter addressConverter;

    public AddressFacade(AddressService addressService, AddressConverter addressConverter) {
        this.addressService = addressService;
        this.addressConverter = addressConverter;
    }

    public AddressResponseModel getById(Long id){
        AddressDTO byId = addressService.getById(id);
        return addressConverter.responseFromAddressDataObj(byId);
    }

    public ArrayList<AddressResponseModel> getAll(){
        ArrayList<AddressDTO> all = addressService.getAll();
        List<AddressResponseModel> collect = all.stream()
                .map(each -> addressConverter.responseFromAddressDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<AddressResponseModel>) collect;
    }
}
