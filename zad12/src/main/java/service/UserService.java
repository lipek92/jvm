package service;

import entities.Permission;
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
    	List<String> result = users.stream()
    			.filter(user -> user.getName().startsWith(prefix))
    			.map(user -> user.getPersonDetails().getRole().getPermissions())
    			.flatMap(permission -> permission.stream())
    			.map(permission -> permission.getName())
    			.sorted()
    			.collect(Collectors.toList());
        return result;
    }

    public double getUsersAverageAge() {
        double result = users.stream()
        		.mapToDouble(user -> user.getPersonDetails().getAge())
        		.average()
        		.getAsDouble();
    	return result;
    }

    public void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWith(String suffix) {
    	users.stream()
    	.filter(user -> user.getPersonDetails().getSurname().endsWith(suffix))
    	.map(user -> user.getPersonDetails().getRole().getPermissions())
    	.flatMap(permission -> permission.stream())
    	.map(permission -> permission.getName().toUpperCase())
    	.forEach(System.out::println);
    }

    public Map<Role, List<User>> groupUsersByRole() {
    	Map<Role, List<User>> result = users.stream()
    			.collect(Collectors.groupingBy(user -> user.getPersonDetails().getRole()));
        return result;
    }

    public Map<Boolean, List<User>> partitionUserByUnderAndOver18() {
        return null;
    }
}
