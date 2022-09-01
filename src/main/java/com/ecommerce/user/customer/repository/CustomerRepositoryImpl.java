package com.ecommerce.user.customer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	public CustomerRepositoryImpl(DataSource datasource) {
		this.template = new JdbcTemplate(datasource);
	}
	
	@Override
	public Customer save(Customer customer) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into customer(id, first_name, last_name, age, gender, celphone, tel, email, street, city, zip, password, level, active, edit, reg_id)");
		sb.append("values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		template.update(sb.toString(), customer.getId());
		
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
//		return template.query(sql);
		return null;
	}
	
	@Override
	public void update(Long id) {
	}
	
	@Override
	public void delete(Long id) {
	}
	
	private RowMapper<Customer> customerRowMapper() {
		return (rs, rowNum) -> {
			Customer customer = new Customer(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"), rs.getString("gender").charAt(0), null, null, null, null, null, null, null, User.Level.valueOf(rs.getString("level")), false, false);
			return customer;
		};
	}
	
}
