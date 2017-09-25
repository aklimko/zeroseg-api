package pl.adamklimko.zeroseg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MessageRead {
    @Id @JsonIgnore
    private String name;
    private Integer latestReadId;

    public MessageRead() {
        this.name = "last_read";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLatestReadId() {
        return latestReadId;
    }

    public void setLatestReadId(Integer latestReadId) {
        this.latestReadId = latestReadId;
    }
}
