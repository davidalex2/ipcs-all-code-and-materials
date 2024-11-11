package com.algoriant.UserDetail;

import com.algoriant.UserDetail.model.UserModel;
import com.algoriant.UserDetail.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public  void saveCustomer(){
        try{
            UserModel customer = new UserModel();
            customer.setFirstName("Raj");
            customer.setLastName("Kumar");
            customer.setAddress("Villupuram");
            customer.setEmail("raj@gmail.com");
            customer.setPhoneNo(97876987L);
            UserModel customer1 = userRepository.save(customer);
            assertThat(customer1).isNotNull();
            assertThat(customer1.getUserId()).isGreaterThan(0);
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveSupplier method",th);
        }
    }
    @Test
    public void getAllCustomer(){
        try{
            UserModel customer = new UserModel();
            customer.setFirstName("Raj");
            customer.setLastName("Kumar");
            customer.setAddress("Villupuram");
            customer.setEmail("raj@gmail.com");
            customer.setPhoneNo(97876987L);
            userRepository.save(customer);
            UserModel customer1 = new UserModel();
            customer1.setFirstName("Raj");
            customer1.setLastName("Kumar");
            customer1.setAddress("Villupuram");
            customer1.setEmail("raj@gmail.com");
            customer1.setPhoneNo(97876987L);
            userRepository.save(customer1);
            List<UserModel> customerList = (List<UserModel>) userRepository.findAll();
            assertThat(customerList).isNotNull();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getAllCustomer method",th);
        }
    }
    @Test
    public void getCustomerById(){
        try{
            UserModel customer = new UserModel();
            customer.setFirstName("Raj");
            customer.setLastName("Kumar");
            customer.setAddress("Villupuram");
            customer.setEmail("raj@gmail.com");
            customer.setPhoneNo(97876987L);
            userRepository.save(customer);
            UserModel customer1 = userRepository.findById(customer.getUserId()).get();
            assertThat(customer1).isNotNull();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getCustomerById method",th);
        }
    }
    @Test
    public void deleteCustomer(){
        try{
            UserModel customer = new UserModel();
            customer.setFirstName("Raj");
            customer.setLastName("Kumar");
            customer.setAddress("Villupuram");
            customer.setEmail("raj@gmail.com");
            customer.setPhoneNo(97876987L);
            userRepository.save(customer);
            userRepository.deleteById(customer.getUserId());
            Optional<UserModel> optionalCustomer = userRepository.findById(customer.getUserId());
            assertThat(optionalCustomer).isEmpty();
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteCustomer method",th);
        }
    }
}
