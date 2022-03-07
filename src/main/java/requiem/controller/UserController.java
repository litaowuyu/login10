package requiem.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import requiem.dao.User;
import requiem.service.UserLogin;
import requiem.service.UserLoginImpl;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@Controller("userController")
public class UserController {

    @Resource
    public UserLogin userLoginImpl;
    @RequestMapping("/login")
    public String login() {
      return "login";
    }
    @RequestMapping("/loginDo")
    @ResponseBody
    public Map<String, Object> loginDo(@RequestBody User user) {
        Map<String, Object> reponseBody = new HashMap<String, Object>();
//        System.out.println(user.getUsername()+"   "+user.getPassword());
        if (userLoginImpl.login(user.getUsername(), user.getPassword())) {
            reponseBody.put("code", "0");
            reponseBody.put("message", "登陆成功！");
            reponseBody.put("result", "");
        } else {
            reponseBody.put("code", "1");
            reponseBody.put("message", "账号错误！");
            reponseBody.put("result", "");
        }
        return reponseBody;
    }

}
