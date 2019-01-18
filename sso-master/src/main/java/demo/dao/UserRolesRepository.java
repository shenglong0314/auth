package demo.dao;


import demo.entity.RolesPath;
import demo.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRolesRepository extends JpaRepository<UserRoles,Integer> {



}
