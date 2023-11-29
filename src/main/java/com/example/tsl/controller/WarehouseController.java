package com.example.tsl.controller;

import com.example.tsl.model.address.AddressDTO;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.service.CustomerService;
import com.example.tsl.model.warehousing.goods.Goods;
import com.example.tsl.model.warehousing.goods.GoodsDTO;
import com.example.tsl.model.warehousing.order.WarehouseOrder;
import com.example.tsl.model.warehousing.order.WarehouseOrderDTO;
import com.example.tsl.model.warehousing.service.GoodsService;
import com.example.tsl.model.warehousing.service.WarehouseOrderService;
import com.example.tsl.model.warehousing.service.WarehouseService;
import com.example.tsl.model.warehousing.warehouse.Warehouse;
import com.example.tsl.model.warehousing.warehouse.WarehouseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final GoodsService goodsService;
    private final WarehouseOrderService warehouseOrderService;
    private final CustomerService customerService;

    public WarehouseController(WarehouseService warehouseService, GoodsService goodsService, WarehouseOrderService warehouseOrderService, CustomerService customerService) {
        this.warehouseService = warehouseService;
        this.goodsService = goodsService;
        this.warehouseOrderService = warehouseOrderService;
        this.customerService = customerService;
    }

    @GetMapping()
    public String warehousesForm(Model model){
        List<Warehouse> allWarehouses = warehouseService.findAll();
        model.addAttribute("allWarehouses", allWarehouses);
        return "warehouse/warehouses";
    }

    @GetMapping("/goods")
    public String goodsForm(Model model){
        List<Goods> allGoods = goodsService.findAll();
        model.addAttribute("allGoods", allGoods);
        return "warehouse/goods";
    }

    @GetMapping("/orders")
    public String warehouseOrdersForm(Model model){
        List<WarehouseOrder> allOrders = warehouseOrderService.findAll();
        model.addAttribute("allOrders", allOrders);
        return "warehouse/orders";
    }

    @GetMapping("/create-warehouse")
    public String warehouseCreateFrom(){
        return "warehouse/create-warehouse";
    }

    @PostMapping("/add-warehouse")
    public String addWarehouse(@ModelAttribute WarehouseDTO warehouseDTO, @ModelAttribute AddressDTO addressDTO){
        warehouseService.addWarehouse(warehouseDTO, addressDTO);
        return "redirect:/warehouses";
    }

    @GetMapping("/add-goods")
    public String addGoodsCreateForm(){
        return "warehouse/add-goods";
    }

    @PostMapping("/add-goods")
    public String addGoods(@ModelAttribute GoodsDTO goodsDTO){
        goodsService.addGoods(goodsDTO);
        return "redirect:/warehouses/goods";
    }

    @GetMapping("/create-order")
    public String createOrderForm(Model model){
        List<Warehouse> allWarehouses = warehouseService.findAll();
        List<Customer> allCustomers = customerService.findAll();
        List<Goods> allFreeGoods = goodsService.findAllFreeGoods();
        model.addAttribute("allWarehouses", allWarehouses);
        model.addAttribute("allCustomers", allCustomers);
        model.addAttribute("allFreeGoods", allFreeGoods);
        return "warehouse/create-order";
    }

    @PostMapping("/create-order")
    public String createOrder(@ModelAttribute WarehouseOrderDTO warehouseOrderDTO,
                              @RequestParam("warehouseId") Long warehouseId,
                              @RequestParam("customerId") Long customerId,
                              @RequestParam("selectedGoodsIds") List<Long> selectedGoodsIds){
        warehouseOrderService.createOrder(warehouseOrderDTO, warehouseId, customerId, selectedGoodsIds);
        return "redirect:/warehouses/orders";
    }
}
