package foo.bar.customer.dao.impl;


import foo.bar.customer.dao.CustomerDAO;
import foo.bar.customer.model.Customer;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCustomerDAO implements CustomerDAO {

    private final String INSERT_SQL = "INSERT INTO CUSTOMER " +
            "(NAME, AGE) VALUES (?, ?)";

    private final String GET_BY_ID_SQL = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

//    private DataSource dataSource;
//
//    public void setDataSource(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    @Override
//    public void insert(Customer customer) {
//        String sql = "INSERT INTO CUSTOMER " +
//                "(NAME, AGE) VALUES (?, ?)";
//        Connection conn = null;
//
//        try{
//            conn = dataSource.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//
////            ps.setInt(1, customer.getCustomID());
//            ps.setString(1, customer.getName());
//            ps.setInt(2, customer.getAge());
//
//            ps.executeUpdate();
//            ps.close();
//
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }finally{
//            if (conn != null){
//                try{
//                    conn.close();
//                }catch(SQLException e){}
//            }
//
//        }
//    }

//    @Override
//    public Customer findByID(int id) {
//
//        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
//
//        Connection conn = null;
//
//        try {
//            conn = dataSource.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            Customer customer = null;
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                customer = new Customer(
//                        rs.getInt("CUST_ID"),
//                        rs.getString("NAME"),
//                        rs.getInt("Age")
//                );
//            }
//            rs.close();
//            ps.close();
//            return customer;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {}
//            }
//        }
//    }




    private SimpleJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Customer customer) {
        jdbcTemplate.update(INSERT_SQL, customer.getName(), customer.getAge());

    }

    @Override
    public Customer findByID(int id) {
        return jdbcTemplate.queryForObject(
                GET_BY_ID_SQL,
                new ParameterizedRowMapper<Customer>() {
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Customer customer = new Customer(rs.getInt(1),rs.getString(2), rs.getInt(3));
                            return customer;
                        }
                }, id
        );
    }

}
