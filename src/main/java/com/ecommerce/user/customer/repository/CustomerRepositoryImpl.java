package com.ecommerce.user.customer.repository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ecommerce.user.customer.model.Customer;
import com.ecommerce.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

//	private static final Map<Long, Customer> store = new HashMap<>();
//	private static long sequence = 0L;
	private final JdbcTemplate template;
	private final SimpleJdbcInsert jdbcInsert;
	
	public CustomerRepositoryImpl(DataSource datasource) {
		this.template = new JdbcTemplate(datasource);
		this.jdbcInsert = new SimpleJdbcInsert(datasource)
				.withTableName("CUSTOMER")
				.usingGeneratedKeyColumns("ID", "REG_ID");
	}
	
	@Override
	public Customer save(Customer customer) {
		customer.setLevel(User.Level.ONE);
		customer.setRegDate(ZonedDateTime.now());
//		StringBuilder sb = new StringBuilder();
//		sb.append("insert into customer(first_name, last_name, age, gender, cellphone, tel, email, street, city, zip, password, level, active, edit)");
//		sb.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		template.update(sb.toString(), 
//						customer.getFirstName(), customer.getLastName(), customer.getAge(), customer.getGender(), 
//						customer.getCellphone(), customer.getTel(), customer.getEmail(), 
//						customer.getStreet(), customer.getCity(), customer.getZip(), customer.getPassword(), 
//						customer.getLevel().toString(), customer.isActive(), customer.isEdit());
		
		jdbcInsert.execute(new BeanPropertySqlParameterSource(customer));
		
		return customer;
	}
	
	@Override
	public Customer findById(Long id) {
		String sql = "select * from customer where id = ?";
		return template.queryForObject(sql, customerRowMapper(), id);
	}
	
	@Override
	public List<Customer> findAll() {
		String sql = "select * from customer";
		return template.query(sql, customerRowMapper());
	}
	
	@Override
	public void update(Long id) {
	}
	
	@Override
	public void delete(Long id) {
	}
	
	private RowMapper<Customer> customerRowMapper() {
		return (rs, rowNum) -> {
			Customer customer = new Customer(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("gender").charAt(0), null, null, null, null, null, null, null, User.Level.valueOf(rs.getString("level")), false, false, null, null);
			return customer;
		};
	}
	
}
