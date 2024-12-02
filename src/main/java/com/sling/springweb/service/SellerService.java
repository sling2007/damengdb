package com.sling.springweb.service;

import com.sling.springweb.entity.Seller;
import com.sling.springweb.entity.YourTable;
import com.sling.springweb.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: sunling
 * Date: 2024/11/29 16:06
 * Description:
 **/

@Service
public class SellerService {


    @Autowired
    private SellerMapper sellerMapper;

    public Seller getSellerById(Long id) {
        return sellerMapper.getSellerById(id);
    }

    public Seller insertSeller(Seller seller) {
        sellerMapper.insertSeller(seller);
        return seller;
    }

    public List<YourTable> getYourTableById(Long id) {
        return sellerMapper.getYourTableById(id);
    }


    public List<Seller> getAllSellers() {
        List<Seller> sellerList = sellerMapper.getAllSellers();
        return sellerList;
    }

}
