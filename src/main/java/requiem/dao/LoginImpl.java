package requiem.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("loginFound")
public class LoginImpl implements Login{
    @Resource
    public User user;
    @Resource
    JdbcTemplate jdbcTemplate;
    @Override
    //从数据库中选择登录者的所有信息
    public User login(String username, String password) {
       String sql = "SELECT * FROM customer WHERE name = ? ";
       RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
       //获取单条数据用queryForObject，多组数据用query
        return (User) jdbcTemplate.queryForObject(sql,rowMapper,username);
    }
}
