package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.MemberDao;

@Configuration
@EnableTransactionManagement
public class AppCtx {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
        ds.setUsername("spring5");
        ds.setPassword("spring5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true); // 유휴 커넥션 검사
        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 30); // 최소 유휴 시간 3분
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기
        return ds;
    }

    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager(());
        tm.setDataSource(dataSource());
        return tm;
    }
}