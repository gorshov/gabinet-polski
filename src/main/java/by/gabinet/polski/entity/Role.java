package by.gabinet.polski.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Александр Горшов on 01.08.2017  10:29.
 */
@ToString(exclude = "users")
@Data
@Table(name = "ROLE")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "ROLE")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    @Builder
    public Role(String role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Role role1 = (Role) o;

        if (id != null ? !id.equals(role1.id) : role1.id != null) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }


}
