package ru.job4j.ex;

import java.util.Arrays;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        return Arrays.stream(users)
                .filter(user -> user.getUsername().equals(login))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pe", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e);
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
    }
}
