package pchild.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * User: guibin
 * Date: 4/13/14
 * Time: 8:54 PM
 */
@Entity
@Table(name = "PCH_USER")
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createdDate;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
