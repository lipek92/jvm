package service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Address;
import entities.Person;
import entities.User;

public class UserServiceTest {
	
	@Test
	public void test(){
		List<User> users = new ArrayList<User>();
		
		User u1 = new User();
		User u2 = new User();
		u1.setName("user1");
		u1.setPassword("passworduser1");
		
		Person u1PersonDeatils = new Person();
		Person u2PersonDetails = new Person();
		
		Address u1Address1 = new Address();
		Address u1Address2 = new Address();
		u1Address1.setCity("Gdansk");
		u1Address2.setCity("Sopot");
		List<Address> u1Addresses = new ArrayList<Address>();
		u1Addresses.add(u1Address1);
		u1Addresses.add(u1Address2);
		u1PersonDeatils.setAddresses(u1Addresses);
		
		Address u2Address1 = new Address();
		u2Address1.setCity("Gdynia");
		List<Address> u2Addresses = new ArrayList<Address>();
		u2PersonDetails.setAddresses(u2Addresses);
		
		u1.setPersonDetails(u1PersonDeatils);
		u2.setPersonDetails(u2PersonDetails);
		
		users.add(u1);
		users.add(u2);
		
		// TESTS
		UserService userService = new UserService(users);

		// #1
		List<User> usersWithAddressesCountMoreThan = userService.findUsersWithAddressesCountMoreThan(1);
		assertEquals(usersWithAddressesCountMoreThan.size(), 1);
		
	}
}
