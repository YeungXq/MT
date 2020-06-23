package com.mt.customer.dao;

import com.mt.customer.pojo.CustomerListDTO;
import com.mt.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerDao {
    /**
     * 搜索所有用户信息
     */
    List<CustomerListDTO> listAllCustomer();

    /**
     * 通过id查询用户
     */
    Customer getCustomerById(@Param("customerId") String customerId);

    /**
     * 通过用户名查询用户
     */
    Customer getCustomerByName(@Param("customerName") String customerName);

    /**
     * 通过手机查询用户
     */
    Customer getCustomerByPhone(@Param("phone") String phone);

    /**
     * 新增用户
     */
    boolean insertCustomer(@Param("customer") Customer customer);

    /**
     * 更新用户信息
     */
    boolean updateCustomer(@Param("customer") Customer customer);


    /**
    * 获取管理员影院id
    * */
    Integer getCinemaId(String customerId);
}
