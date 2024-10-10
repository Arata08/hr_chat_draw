package com.cx.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String userpwd;

    /**
     * 
     */
    private Integer userage;

    /**
     * 
     */
    private String usersex;

    /**
     * 
     */
    private Integer isdel;

    public User(Integer id, String username, String userpwd, Integer userage, String usersex, Integer isdel) {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
        this.userage = userage;
        this.usersex = usersex;
        this.isdel = isdel;
    }

    public User(String username, String userpwd, Integer userage, String usersex) {
        this.username = username;
        this.userpwd = userpwd;
        this.userage = userage;
        this.usersex = usersex;
    }

    private static final long serialVersionUID = 1L;

    public User(String username, String userpwd, Integer userage, String usersex, Integer isdel) {
         this.username = username;
         this.userpwd = userpwd;
         this.userage = userage;
         this.usersex = usersex;
         this.isdel = isdel;

    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserpwd() == null ? other.getUserpwd() == null : this.getUserpwd().equals(other.getUserpwd()))
            && (this.getUserage() == null ? other.getUserage() == null : this.getUserage().equals(other.getUserage()))
            && (this.getUsersex() == null ? other.getUsersex() == null : this.getUsersex().equals(other.getUsersex()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserpwd() == null) ? 0 : getUserpwd().hashCode());
        result = prime * result + ((getUserage() == null) ? 0 : getUserage().hashCode());
        result = prime * result + ((getUsersex() == null) ? 0 : getUsersex().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", userpwd=").append(userpwd);
        sb.append(", userage=").append(userage);
        sb.append(", usersex=").append(usersex);
        sb.append(", isdel=").append(isdel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}