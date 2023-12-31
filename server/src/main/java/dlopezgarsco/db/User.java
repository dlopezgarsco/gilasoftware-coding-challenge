package dlopezgarsco.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.jdbi.v3.core.mapper.Nested;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer userId;
    private String name;
    private String email;
    private String phoneNumber;

    @Nested
    private Set<Category> categories = new HashSet<>();
    @Nested
    private Set<Channel> channels = new HashSet<>();

    @JsonProperty
    public Integer getUserId() {
        return userId;
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
                "id=" + userId +
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
        return Objects.equal(userId, user.userId) && Objects.equal(name, user.name) && Objects.equal(email, user.email) && Objects.equal(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, name, email, phoneNumber);
    }

    @JsonProperty
    public Set<Category> getCategories() {
        return categories;
    }

    @JsonProperty
    public Set<Channel> getChannels() {
        return channels;
    }

    @JsonProperty
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty
    public void setChannels(Set<Channel> channels) {
        this.channels = channels;
    }
}
