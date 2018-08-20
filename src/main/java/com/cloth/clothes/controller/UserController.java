package com.cloth.clothes.controller;

import com.cloth.clothes.bean.BaseResponse;
import com.cloth.clothes.bean.User;
import com.cloth.clothes.bean.UserRequest;
import com.cloth.clothes.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserDao mUserDao;

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse<User> login(@RequestBody UserRequest userRequest) {
        BaseResponse<User> baseResponse;
        User user = mUserDao.findUserByName(userRequest.getUserName());
        if (user == null) {
            baseResponse = faild("用户不存在！");
        } else if (!user.getPass().equals(userRequest.getPass())) {
            baseResponse = faild("密码错误！");
        } else {
            user.setPass(null);
            baseResponse = success(user);
        }
        return baseResponse;
    }
}
