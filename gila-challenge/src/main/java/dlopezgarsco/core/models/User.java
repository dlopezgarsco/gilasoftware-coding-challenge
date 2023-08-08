package dlopezgarsco.core.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class User {
    private final Integer id;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public User(Integer id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
//         TODO: normally I'd use classes to create these fields with a regex validator
//         but since the data is mocked and cannot be inserted I might skip it.
        this.email = email ;
        this.phoneNumber = phoneNumber;
    }


    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id) && Objects.equal(name, user.name) && Objects.equal(email, user.email) && Objects.equal(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, email, phoneNumber);
    }
}
