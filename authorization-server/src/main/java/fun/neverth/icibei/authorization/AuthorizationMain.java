package fun.neverth.icibei.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * todo
 *
 * @author NeverTh
 * @date 2020/7/17 16:52
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "fun.neverth.icibei.authorization.provider")
public class AuthorizationMain {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationMain.class, args);
    }
}
