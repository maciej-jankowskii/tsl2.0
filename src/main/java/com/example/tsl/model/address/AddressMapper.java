package com.example.tsl.model.address;

import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
    public Address map(AddressDTO addressDTO) {
        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setStreet(addressDTO.getStreet());
        address.setHomeNo(addressDTO.getHomeNo());
        address.setFlatNo(addressDTO.getFlatNo());
        return address;
    }

    public AddressDTO map(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setCountry(address.getCountry());
        dto.setCity(address.getCity());
        dto.setStreet(address.getStreet());
        dto.setPostalCode(address.getPostalCode());
        dto.setHomeNo(address.getHomeNo());
        dto.setFlatNo(address.getFlatNo());
        return dto;
    }
}
