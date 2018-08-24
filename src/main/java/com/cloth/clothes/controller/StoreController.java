package com.cloth.clothes.controller;

import com.cloth.clothes.bean.*;
import com.cloth.clothes.dao.StoreDao;
import com.cloth.clothes.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/store")
public class StoreController extends BaseController {
    @Autowired
    StoreDao mStoreDao;
    @Autowired
    UserDao mUserDao;

    @PostMapping("/goInStore")
    @ResponseBody
    public BaseResponse goInStore(@RequestBody Clothes clothes) {
        try {
            if (clothes.getId() == 0) {
                mStoreDao.inStore(clothes);
                return success(null);
            } else {
                mStoreDao.modifyStore(clothes);
                return success(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return faild(e.getMessage());
        }
    }

    @GetMapping("/getClothes")
    @ResponseBody
    public BaseResponse<ClothesList> getClothes(@RequestParam(required = false) String uid,
                                                @RequestParam(required = false) long number,
                                                @RequestParam(required = false) long pager) {
        User user = mUserDao.findUserById(uid);
        long start = (pager - 1) * number;
        List<Clothes> clothes = mStoreDao.getClothes(start, start + number);
        List<Clothes> result = new ArrayList<>(clothes);
        if (user.getRole() != 1) {
            result = clothes.stream()
                    .map(clothes1 -> {
                        clothes1.setCost(0);
                        return clothes1;
                    })
                    .collect(Collectors.toList());
        }
        ClothesList clothesList = new ClothesList();
        clothesList.setClothes(result);
        return success(clothesList);
    }

    @GetMapping("/getClothDetails")
    @ResponseBody
    public BaseResponse<ClothdetailList> getClothDetails(String sid, @RequestParam(required = false) String cid) {
        ClothdetailList clothdetailList = new ClothdetailList();
        List<Clothdetail> mClothdetails = mStoreDao.findClothdetail(sid, cid);
        clothdetailList.setClothdetails(mClothdetails);
        return success(clothdetailList);
    }
}
