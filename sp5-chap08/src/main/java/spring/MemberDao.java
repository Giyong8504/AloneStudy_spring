package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "SELECT * FROM member WHERE email = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getTimestamp("regDate").toLocalDateTime());
                        member.setId(rs.getLong("id"));
                        return member;
                    }
                },
                email);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {

    }

    public void update(Member member) {

    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("SELECT * FROM member",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getTimestamp("regDate").toLocalDateTime());
                        member.setId(rs.getLong("id"));
                        return member;
                    }
                });
        return results;
}