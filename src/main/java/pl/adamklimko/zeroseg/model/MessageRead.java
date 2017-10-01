package pl.adamklimko.zeroseg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MessageRead {
    @Id @JsonIgnore
    private String name;
    private Integer lastReadId;

    public MessageRead() {
        this.name = "last_read";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLastReadId() {
        return lastReadId;
    }

    public void setLastReadId(Integer lastReadId) {
        this.lastReadId = lastReadId;
    }
}
