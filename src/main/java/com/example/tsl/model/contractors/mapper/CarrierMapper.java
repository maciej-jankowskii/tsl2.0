package com.example.tsl.model.contractors.mapper;

import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.contractors.carrier.CarrierDTO;
import org.springframework.stereotype.Service;

@Service
public class CarrierMapper {

    public Carrier map(CarrierDTO carrierDTO) {
        Carrier carrier = new Carrier();
        carrier.setFullName(carrierDTO.getFullName());
        carrier.setShortName(carrierDTO.getShortName());
        carrier.setVatNumber(carrierDTO.getVatNumber());
        carrier.setDescription(carrierDTO.getDescription());
        carrier.setTermOfPayment(carrierDTO.getTermOfPayment());
        carrier.setBalance(carrierDTO.getBalance());
        carrier.setInsuranceExpirationDate(carrierDTO.getInsuranceExpirationDate());
        carrier.setLicenceExpirationDate(carrierDTO.getLicenceExpirationDate());
        return carrier;
    }

    public CarrierDTO map(Carrier carrier) {
        CarrierDTO dto = new CarrierDTO();
        dto.setFullName(carrier.getFullName());
        dto.setShortName(carrier.getShortName());
        dto.setVatNumber(carrier.getVatNumber());
        dto.setDescription(carrier.getDescription());
        dto.setTermOfPayment(carrier.getTermOfPayment());
        dto.setBalance(carrier.getBalance());
        dto.setInsuranceExpirationDate(carrier.getInsuranceExpirationDate());
        dto.setLicenceExpirationDate(carrier.getLicenceExpirationDate());
        return dto;
    }

}
