package my.database.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Sushakov
 * Date: 12/28/2018
 * Time: 15:53
 **/
@SuppressWarnings("all")
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASS")
    private String pass;
    @Column(name = "LOCKED")
    private boolean locked;
    @Column(name = "ROLE")
    private Integer role;

    public Account() {
    }

    public Account(String login, String pass, boolean locked, int role) {
        this.login = login;
        this.pass = pass;
        this.locked = locked;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", locked=" + locked +
                ", role=" + role +
                '}';
    }
}
