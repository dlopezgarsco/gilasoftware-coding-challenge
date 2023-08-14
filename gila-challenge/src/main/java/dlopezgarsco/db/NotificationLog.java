package dlopezgarsco.db;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class NotificationLog {
    private Integer notificationLogId;
    private Integer notificationId;
    private Integer userId;
    private Integer channelId;
    private LocalDateTime timestamp;
    private Boolean success;

    @JsonProperty
    public Integer getNotificationLogId() {
        return notificationLogId;
    }

    @JsonProperty
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty
    public Integer getChannelId() {
        return channelId;
    }

    @JsonProperty
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public Integer getNotificationId() {
        return notificationId;
    }

    @JsonProperty
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty
    public void setNotificationLogId(Integer notificationLogId) {
        this.notificationLogId = notificationLogId;
    }

    @JsonProperty
    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    @JsonProperty
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @JsonProperty
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
