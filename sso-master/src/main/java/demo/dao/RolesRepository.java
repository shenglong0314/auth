package demo.dao;


import demo.entity.Roles;
import demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RolesRepository extends JpaRepository<Roles,Integer> {



}
