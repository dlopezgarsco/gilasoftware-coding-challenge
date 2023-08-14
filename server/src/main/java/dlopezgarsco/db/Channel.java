package dlopezgarsco.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class Channel {
    private Integer channelId;
    private String name;

    @JsonProperty
    public Integer getChannelId() {
        return channelId;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equal(channelId, channel.channelId) && Objects.equal(name, channel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(channelId, name);
    }

    @JsonProperty
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
}
