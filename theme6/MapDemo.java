import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class MapDemo {
    public static void main(String[] args) {
        Map<User, String> map = new HashMap<>();
        
        User u1 = new User(1, "Алексей");
        map.put(u1, "ADMIN");

        User u2 = new User(1, "Алексей");
        String role = map.get(u2);
        
        System.out.println("Роль пользователя: " + role);
    }
}