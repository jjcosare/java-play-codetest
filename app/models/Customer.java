package models;

import java.time.OffsetDateTime;
/**
 * Created by jjcosare on 6/6/15.
 */
public class Customer {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(OffsetDateTime duetime) {
        this.duetime = duetime;
    }

    public OffsetDateTime getJointime() {
        return jointime;
    }

    public void setJointime(OffsetDateTime jointime) {
        this.jointime = jointime;
    }

    private long id;
    private String name;
    private OffsetDateTime duetime;
    private OffsetDateTime jointime;

}
