package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM member", Integer.class);
        return count;
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
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) {
                // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO MEMBER(email, password, name, regDate) values (?, ?, ?, ?)");
                // 인덱스 파라미터 값 설정
                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
                // 생성한 PreparedStatement 객체 리턴
                return pstmt;
            }
        });

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
}