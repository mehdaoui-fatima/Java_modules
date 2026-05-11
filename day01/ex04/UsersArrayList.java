package ex04;

public class UsersArrayList implements UsersList {
    int capacity = 10;
    int size = 0;
    User users[] = new User[capacity];

    User[] resize(User users[]) {
        int new_capacity = capacity * 3 / 2;
        User tmp[] = new User[new_capacity];

        for (int i = 0; i < capacity; i++)
            tmp[i] = users[i];

        return tmp;
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            if (size == capacity)
                users = resize(users);
            users[size++] = user;
        }
    }

    @Override
    public User getUserById(int id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id)
                return users[i];
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(int index) {
        if (index >= 0 && index < size)
            return users[index];
        throw new UserNotFoundException();

    }

    @Override
    public int getUsersCount() {
        return size;
    }

}
