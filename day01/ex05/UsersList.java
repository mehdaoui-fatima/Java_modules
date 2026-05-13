package ex05;

public interface UsersList {
    /**
     * Adds a new user to the list.
     */
    void addUser(User user);

    /**
     * Retrieves a user from the list based on their ID.
     */
    User getUserById(int id);

    /**
     * Retrieves a user from the list based on their index.
     */
    User getUserByIndex(int index);

    /**
     * Returns the total number of users currently in the list.
     */
    int getUsersCount();

}