package cn.vagile.sharp;

import cn.vagile.sharp.bean.entity.User;
import cn.vagile.sharp.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SharpApplicationTests {
	@Autowired
	UserMapper userMapper;
	//@Test
	public void contextLoads() {
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(1,userList.size());
		userList.forEach(System.out::println);
	}

}
