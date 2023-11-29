package com.example.tsl.model.warehousing.service;

import com.example.tsl.exceptions.NonUniqueLabelsException;
import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.goods.GoodsDTO;
import com.example.tsl.model.warehousing.mapper.GoodsMapper;
import com.example.tsl.model.warehousing.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final GoodsMapper goodsMapper;

    public GoodsService(GoodsRepository goodsRepository, GoodsMapper goodsMapper) {
        this.goodsRepository = goodsRepository;
        this.goodsMapper = goodsMapper;
    }

    public List<Goods> findAll(){
        return goodsRepository.findAll();
    }

    public List<Goods> findAllFreeGoods(){
        return goodsRepository.findAllByAssignedToOrderIsFalse();
    }
    @Transactional
    public GoodsDTO addGoods(GoodsDTO goodsDTO){
        Goods goods = goodsMapper.map(goodsDTO);
        goods.setAssignedToOrder(false);

        if (goodsRepository.existsByLabelAndAssignedToOrderFalse(goods.getLabel())) {
            throw new NonUniqueLabelsException("Label must be unique among unassigned goods");
        }

        Goods saved = goodsRepository.save(goods);
        return goodsMapper.map(saved);
    }
}
