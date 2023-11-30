package com.example.tsl.model.cargos;

import org.springframework.stereotype.Service;

@Service
public class CargoMapper {

    public CargoDTO map(Cargo cargo) {
        CargoDTO dto = new CargoDTO();
        dto.setCargoNumber(cargo.getCargoNumber());
        dto.setPrice(cargo.getPrice());
        dto.setCurrency(cargo.getCurrency());
        dto.setLoadingDate(cargo.getLoadingDate());
        dto.setUnloadingDate(cargo.getUnloadingDate());
        dto.setLoadingAddress(cargo.getLoadingAddress());
        dto.setUnloadingAddress(cargo.getUnloadingAddress());
        dto.setGoods(cargo.getGoods());
        dto.setDescription(cargo.getDescription());
        return dto;
    }

    public Cargo map(CargoDTO cargoDTO) {
        Cargo cargo = new Cargo();
        cargo.setCargoNumber(cargoDTO.getCargoNumber());
        cargo.setPrice(cargoDTO.getPrice());
        cargo.setCurrency(cargoDTO.getCurrency());
        cargo.setLoadingDate(cargoDTO.getLoadingDate());
        cargo.setUnloadingDate(cargoDTO.getUnloadingDate());
        cargo.setLoadingAddress(cargoDTO.getLoadingAddress());
        cargo.setUnloadingAddress(cargoDTO.getUnloadingAddress());
        cargo.setGoods(cargoDTO.getGoods());
        cargo.setDescription(cargoDTO.getDescription());
        return cargo;
    }
}
