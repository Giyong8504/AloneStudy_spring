package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.MemberDao;

public class JpaMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao member = ctx.getBean(MemberDao.class);

        member.execute();

        ctx.close();
    }
}
