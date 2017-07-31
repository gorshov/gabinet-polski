package by.gabinet.polski.entity.enumiration;

/**
 * Created by Александр Горшов on 11.07.2017  14:53.
 */
public enum Role {
    ADMIN("ADMIN"), USER("USER"), BLOCKED("BLOCKED"), STUDENT("STUDENT"), TEACHER("TEACHER");

    String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
