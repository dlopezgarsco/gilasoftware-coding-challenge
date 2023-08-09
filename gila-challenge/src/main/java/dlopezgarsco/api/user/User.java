package dlopezgarsco.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import dlopezgarsco.api.category.Category;
import dlopezgarsco.api.channel.Channel;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;

public class User {
    private final Integer id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private List<Category> categories;
    private List<Channel> channels;

    public User(
            @ColumnName("id") Integer id,
            @ColumnName("name") String name,
            @ColumnName("email") String email,
            @ColumnName("phone_number") String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(
            Integer id,
            String name,
            String email,
            String phoneNumber,
            List<Category> categories,
            List<Channel> channels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.categories = categories;
        this.channels = channels;
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

    public List<Category> getCategories() {
        return categories;
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
