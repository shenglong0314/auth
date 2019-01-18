package demo.dao;



import demo.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRolesRepository extends JpaRepository<UserRoles,Integer> {


    @Query(value = "SELECT * FROM user_roles WHERE userid=?1" , nativeQuery = true)
    List<UserRoles> findRolesByUserid(Integer userId);

}
