package requiem.service;

import org.springframework.stereotype.Service;
import requiem.dao.Login;
import requiem.dao.LoginImpl;

import javax.annotation.Resource;

@Service("userLogin")
public class UserLoginImpl implements UserLogin{
    @Resource(name="loginFound")
    public Login userFound1;
    @Override
    public boolean login(String username,String password) {
        //数据库密码加密，解密
        String newName=username + "abc";
        String newPassword = password + "abc";
        //传给数据查询方法，并获取返回值
        if( userFound1.login(newName,newPassword)!=null){
            return true;
        }
        else{
            return false;
        }
    }
}
