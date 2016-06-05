package service;

import entities.Person;
import entities.Role;
import entities.User;

import java.util.List;
import java.util.Map;
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
        Person result = users.stream()
        		.map(user -> user.getPersonDetails())
        		.max((p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()))
        		.get();
    	return result;
    }

    public User findUserWithLongestUsername() {
    	User result = users.stream()
    			.max((u1,u2) -> Integer.compare(u1.getName().length(), u2.getName().length()))
    			.get();
    	return result;
    }

    public String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18() {
        String result = users.stream()
        		.filter(user -> user.getPersonDetails().getAge() > 18)
        		.map(user -> user.getPersonDetails().getName() + " " + user.getPersonDetails().getSurname())
        		.collect(Collectors.joining(", "));
    	return result;
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
