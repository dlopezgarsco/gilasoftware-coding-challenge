package dlopezgarsco.db;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notification {
    private Integer notificationId;
    private String message;
    private Integer categoryId;

    @JsonProperty
    public Integer getNotificationId() {
        return notificationId;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty
    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
