package steps;

import steps.User;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class UserCollectionGenerator {
    private static final int MAX_STRING_LENGTH = 10;

    public Set<User> generateUserHashSet(int numberOfUsers) {
        return generateUserCollection(new HashSet<>(), numberOfUsers);
    }

    public Set<User> generateUserTreeSet(int numberOfUsers) {
        return generateUserCollection(new TreeSet<>(Comparator.comparingLong(User::getId)), numberOfUsers);
    }

    public List<User> generateUserArrayList(int numberOfUsers) {
        return generateUserCollection(new ArrayList<>(), numberOfUsers);
    }

    public List<User> generateUserLinkedList(int numberOfUsers) {
        return generateUserCollection(new LinkedList<>(), numberOfUsers);
    }

    public Map<Long, User> generateUserHashMap(int numberOfUsers) {
        return generateUserMap(new HashMap<>(), numberOfUsers);
    }

    public Map<Long, User> generateUserTreeMap(int numberOfUsers) {
        return generateUserMap(new TreeMap<>(), numberOfUsers);
    }

    private <C extends Collection<User>> C generateUserCollection(C collection, int numberOfUsers) {
        for (int i = 1; i <= numberOfUsers; i++) {
            collection.add(generateUser((long) i));
        }
        return collection;
    }

    private <M extends Map<Long, User>> M generateUserMap(M map, int numberOfUsers) {
        for (int i = 1; i <= numberOfUsers; i++) {
            User user = generateUser((long) i);
            map.put(user.getId(), user);
        }
        return map;
    }

    private User generateUser(Long id) {
        // Генерация случайных данных
        return new User(id,
                generateRandomString(),
                generateRandomString(),
                generateRandomString() + "@example.com",
                generateRandomString(),
                generateRandomString());
    }

    private String generateRandomString() {
        int leftLimit = 97; // ASCII code for 'a'
        int rightLimit = 122; // ASCII code for 'z'
        int targetStringLength = ThreadLocalRandom.current().nextInt(1, MAX_STRING_LENGTH + 1);
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        UserCollectionGenerator generator = new UserCollectionGenerator();
        Set<User> userHashSet = generator.generateUserHashSet(25);
        Set<User> userTreeSet = generator.generateUserTreeSet(25);
        List<User> userArrayList = generator.generateUserArrayList(25);
        List<User> userLinkedList = generator.generateUserLinkedList(25);
        Map<Long, User> userHashMap = generator.generateUserHashMap(25);
        Map<Long, User> userTreeMap = generator.generateUserTreeMap(25);

        CollectionOperations operations = new CollectionOperations();
        operations.performOperations(userHashSet, "HashSet");
        operations.performOperations(userTreeSet, "TreeSet");
        operations.performOperations(userArrayList, "ArrayList");
        operations.performOperations(userLinkedList, "LinkedList");
        operations.performOperations(userHashMap, "HashMap");
        operations.performOperations(userTreeMap, "TreeMap");
    }
}
