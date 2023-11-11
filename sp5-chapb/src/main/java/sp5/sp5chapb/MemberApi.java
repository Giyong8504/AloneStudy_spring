package sp5.sp5chapb;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberApi {

    private JdbcTemplate jdbcTemplate;

    @GetMapping("/members")
    public List<String> members() {
        return jdbcTemplate.queryForList(
                "SELECT email FROM member ORDER BY email",
                String.class);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
