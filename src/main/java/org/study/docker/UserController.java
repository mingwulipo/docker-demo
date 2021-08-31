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
    public Object listUser() {
        List<User> users = Arrays.asList(new User(1, "Jack"), new User(2, "Bill"));
        log.info("/user/list = {}", users);
        return users;
    }

}
