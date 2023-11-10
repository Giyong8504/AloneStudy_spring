package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Member;
import spring.MemberDao;

import java.util.List;

public class MainProfile {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(MemberConfig.class, DsDevConfig.class, DsRealConfig.class);
        context.refresh();

        MemberDao dao = context.getBean(MemberDao.class);

        List<Member> members = dao.selectAll();
        members.forEach(m -> System.out.println(m.getEmail()));

        context.close();
    }
}
