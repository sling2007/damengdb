package com.sling.springweb.controller;

import com.sling.springweb.entity.Seller;
import com.sling.springweb.entity.YourTable;
import com.sling.springweb.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: sunling
 * Date: 2024/11/29 16:10
 * Description:
 **/
@RestController
@RequestMapping("/user")
public class SellerController {

    @Autowired
    private SellerService userService;

    @GetMapping("/{id}")
    public Seller getUserById(@PathVariable Long id) {
        return userService.getSellerById(id);
    }

    @GetMapping("/list")
    public List<Seller> getUsers() {
        return userService.getAllSellers();
    }


    @GetMapping("/yourtable/{id}")
    public List<YourTable> getUsers(@PathVariable Long id) {
        return userService.getYourTableById(id);
    }


    @PostMapping()
    public Seller getUserById(@RequestBody Seller seller) {
        return userService.insertSeller(seller);
    }

}
