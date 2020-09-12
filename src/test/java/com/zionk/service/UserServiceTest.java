package com.zionk.service;
import com.zionk.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

        @Autowired
        private UserService userService;
        @Test
        public void queryById() {
            User user = userService.queryById(8l);
            System.out.println("user="+user);
        }

        @Test
        public void saveUser() {
            User user = new User();
            user.setUserName("tset");
            user.setName("test");
            user.setAge(18);
            user.setPassword("12345");
            user.setSex(1);
            user.setCreated(new Date());
            userService.saveUser(user);
        }
    }

