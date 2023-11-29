package com.example.tsl.model.warehousing.repository;

import com.example.tsl.model.warehousing.goods.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends CrudRepository<Goods, Long> {
    List<Goods> findAll();
    List<Goods> findAllByAssignedToOrderIsFalse();
    List<Goods> findAllByIdIn(List<Long> ids);
    Boolean existsByLabelAndAssignedToOrderFalse(String label);
}
