package demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRoles {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userid;
    private Integer rolesid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRolesid() {
        return rolesid;
    }

    public void setRolesid(Integer rolesid) {
        this.rolesid = rolesid;
    }
}
