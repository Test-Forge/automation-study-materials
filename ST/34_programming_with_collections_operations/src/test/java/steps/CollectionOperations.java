package steps;

import steps.User;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionOperations {
    public void performOperations(Collection<User> users, String collectionType) {
        long startTime, endTime;

        if (!(users instanceof SortedSet)) {
            startTime = System.nanoTime();
            List<User> sortedUsers = new ArrayList<>(users);
            sortedUsers.sort(Comparator.comparing(User::getFirstName));
            endTime = System.nanoTime();
            System.out.println("Sorting " + collectionType + " take " + (endTime - startTime) + " nanoseconds");
        }

        String nameToFilter = "FirstName10";
        startTime = System.nanoTime();
        List<User> filteredUsers = users.stream().filter(u -> u.getFirstName().equals(nameToFilter)).collect(Collectors.toList());
        endTime = System.nanoTime();
        System.out.println("Filtration " + collectionType + " take " + (endTime - startTime) + " nanoseconds");

        if (users instanceof Map) {
            Map<Long, User> userMap = (Map<Long, User>) users;
            Long idToFind = 10L;
            startTime = System.nanoTime();
            User user = userMap.get(idToFind);
            endTime = System.nanoTime();
            if (user != null) {
                System.out.println("Finding in " + collectionType + " take " + (endTime - startTime) + " nanoseconds");
            }
        }

        Long idToRemove = 5L;
        startTime = System.nanoTime();
        users.removeIf(u -> u.getId().equals(idToRemove));
        endTime = System.nanoTime();
        System.out.println("Deletion in " + collectionType + " take " + (endTime - startTime) + " nanoseconds");
    }

    public void performOperations(Map<Long, User> users, String collectionType) {
        performOperations((Collection<User>) users.values(), collectionType);
    }
}

