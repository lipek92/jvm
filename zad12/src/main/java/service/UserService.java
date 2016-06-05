package service;

import entities.Person;
import entities.Role;
import entities.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class UserService implements UserServiceInterface {
	
	private List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public List<User> findUsersWithAddressesCountMoreThan(int numberOfAddresses) {
        List<User> result = users.stream()
        		.filter(user -> user.getPersonDetails().getAddresses().size() > numberOfAddresses)
        		.collect(Collectors.toList());
    	
    	return result;
    }

    public Person findOldestPerson() {
        return null;
    }

    public User findUserWithLongestUsername() {
        return null;
    }

    public String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18() {
        return null;
    }

    public List<String> getSortedPermissionsOfUsersWithNameStartingWith(String prefix) {
        return null;
    }

    public double getUsersAverageAge() {
        return 0;
    }

    public void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWith(String suffix) {

    }

    public Map<Role, List<User>> groupUsersByRole() {
        return null;
    }

    public Map<Boolean, List<User>> partitionUserByUnderAndOver18() {
        return null;
    }
}
