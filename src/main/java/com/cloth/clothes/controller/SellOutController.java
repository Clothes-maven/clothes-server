package com.cloth.clothes.controller;

import com.cloth.clothes.bean.*;
import com.cloth.clothes.dao.SellOutDao;
import com.cloth.clothes.dao.StoreDao;
import com.cloth.clothes.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/sellout")
public class SellOutController extends BaseController {
    @Autowired
    SellOutDao mSellOutDao;
    @Autowired
    StoreDao mStoreDao;
    @Autowired
    UserDao mUserDao;

    @GetMapping("/findByDate")
    @ResponseBody
    public BaseResponse<SellOutList> findByData(String time) {
        if (time.isEmpty()) {
            return faild("时间不能为空！");
        }
        String startTime = time + " 00:00:00";
        String endTime = time + " 23:59:59";
        SellOutList sellOutList = new SellOutList();
        sellOutList.setSellOuts(mSellOutDao.findSellOutByData(startTime, endTime));
        return success(sellOutList);
    }

    @PostMapping("/sell")
    @ResponseBody
    public BaseResponse sell(@RequestBody SellOutRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        int stock = mStoreDao.clothesNumber(request.getClothesId());
        User user = mUserDao.findUserById(request.getUserId());
        if (stock < request.getNumber()) {
            return faild("售出失败，库存不足！");
        }
        if (user == null) {
            return faild("用户不存在！");
        }
        mStoreDao.outStore(request.getClothesId(), stock - request.getNumber());
        mSellOutDao.insterSellOut(request.getClothesId(), request.getSell(), request.getUserId(), request.getNumber(), sdf.format(d));
        return success(null);
    }
}
