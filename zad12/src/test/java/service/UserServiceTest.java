package service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Address;
import entities.Permission;
import entities.Person;
import entities.Role;
import entities.User;

public class UserServiceTest {
	
	@Test
	public void test(){
		List<User> users = new ArrayList<User>();
		
		User u1 = new User();
		u1.setName("user1");
		u1.setPassword("passworduser1");
		
		User u2 = new User();
		u2.setName("uuuser2");
		
		Person u1PersonDetails = new Person();
		u1PersonDetails.setAge(25);
		u1PersonDetails.setName("u1name");
		u1PersonDetails.setSurname("u1surname");
		
		Role u1Role = new Role();

		List<Permission> u1Permissions = new ArrayList<Permission>();
		Permission u1Permission1 = new Permission();
		u1Permission1.setName("write comment");
		Permission u1Permission2 = new Permission();
		u1Permission2.setName("read comment");
		
		u1Permissions.add(u1Permission1);
		u1Permissions.add(u1Permission2);
		
		u1Role.setPermissions(u1Permissions);
		u1PersonDetails.setRole(u1Role);
		
		Person u2PersonDetails = new Person();
		u2PersonDetails.setAge(20);
		u2PersonDetails.setName("u2name");
		u2PersonDetails.setSurname("u2surname");
		
		Role u2Role = new Role();

		List<Permission> u2Permissions = new ArrayList<Permission>();
		Permission u2Permission1 = new Permission();
		u2Permission1.setName("read comment");
		
		u2Permissions.add(u2Permission1);
		
		u2Role.setPermissions(u2Permissions);
		u2PersonDetails.setRole(u2Role);
		
		Address u1Address1 = new Address();
		Address u1Address2 = new Address();
		u1Address1.setCity("Gdansk");
		u1Address2.setCity("Sopot");
		List<Address> u1Addresses = new ArrayList<Address>();
		u1Addresses.add(u1Address1);
		u1Addresses.add(u1Address2);
		u1PersonDetails.setAddresses(u1Addresses);
		
		Address u2Address1 = new Address();
		u2Address1.setCity("Gdynia");
		List<Address> u2Addresses = new ArrayList<Address>();
		u2PersonDetails.setAddresses(u2Addresses);
		
		u1.setPersonDetails(u1PersonDetails);
		u2.setPersonDetails(u2PersonDetails);
		
		users.add(u1);
		users.add(u2);
		
		// TESTS
		UserService userService = new UserService(users);

		// #1
		List<User> usersWithAddressesCountMoreThan = userService.findUsersWithAddressesCountMoreThan(1);
		assertEquals(usersWithAddressesCountMoreThan.size(), 1);
		
		// #2
		assertEquals(userService.findOldestPerson(), u1PersonDetails);
		
		// #3
		assertEquals(userService.findUserWithLongestUsername(), u2);
		
		// #4
		assertEquals(userService.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(), "u1name u1surname, u2name u2surname");
		
		// #5
		List<String> test5 = new ArrayList<String>();
		test5.add(0, "read comment");
		test5.add(1, "read comment");
		test5.add(2, "write comment");
		assertEquals(userService.getSortedPermissionsOfUsersWithNameStartingWith("u"), test5);
		
	}
}
