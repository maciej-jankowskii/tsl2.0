package com.example.tsl.model.warehousing.mapper;

import com.example.tsl.enums.TypeOfGoods;
import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.goods.GoodsDTO;
import org.springframework.stereotype.Service;

@Service
public class GoodsMapper {
    public Goods map(GoodsDTO dto) {
        Goods goods = new Goods();
        goods.setTypeOfGoods(TypeOfGoods.valueOf(dto.getTypeOfGoods()));
        goods.setName(dto.getName());
        goods.setLabel(dto.getLabel());
        goods.setDescription(dto.getDescription());
        goods.setQuantity(dto.getQuantity());
        goods.setRequiredArea(dto.getRequiredArea());
        goods.setAssignedToOrder(dto.getAssignedToOrder());
        return goods;
    }

    public GoodsDTO map(Goods goods) {
        GoodsDTO dto = new GoodsDTO();
        dto.setName(goods.getName());
        dto.setDescription(goods.getDescription());
        dto.setQuantity(goods.getQuantity());
        dto.setLabel(goods.getLabel());
        dto.setTypeOfGoods(String.valueOf(goods.getTypeOfGoods()));
        dto.setRequiredArea(goods.getRequiredArea());
        dto.setAssignedToOrder(goods.getAssignedToOrder());
        return dto;
    }
}
