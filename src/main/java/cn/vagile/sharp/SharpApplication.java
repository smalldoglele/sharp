package cn.vagile.sharp;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.vagile.sharp.mapper")
public class SharpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharpApplication.class, args);
	}

}
