package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.MemberDao;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }
}
