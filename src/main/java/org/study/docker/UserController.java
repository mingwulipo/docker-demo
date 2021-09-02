package org.study.docker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @desc: TODO
 * @author: lipo
 * @date: 2019-09-20 18:38
 * @version: v1.0
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * http://localhost:8080/user/list
     * @return
     */
    @RequestMapping("list")
    public Object list() {
        List<User> users = Arrays.asList(new User(1, "Jack"), new User(2, "Bill"));
        log.info("/user/list = {}", users);
        return users;
    }

    /**
     * http://localhost:8080/user/get
     * @return
     */
    //@RequestMapping("get")
    public Object get(Integer id) {
        log.info("/user/get | id = {}", id);
        User user = null;
        switch (id) {
            case 1: user = new User(1, "lidawei");break;
            case 2: user = new User(2, "wangxiaoming");break;
            case 3: user = new User(3, "zhangxiaohong");break;
            case 4: user = new User(4, "zhouxiaolu");break;
            case 5: user = new User(5, "wangdalu");break;
            case 6: user = new User(6, "libingbing");break;
            default:break;
        }
        log.info("/user/get | user = {}", user);
        return user;
    }

}
