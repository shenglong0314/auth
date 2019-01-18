package demo.dao;


import demo.entity.RolesPath;
import demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RolesPathRepository extends JpaRepository<RolesPath,Integer> {
    @Query(value = "select  *  from roles_path where pathid=?1",nativeQuery = true)
    public List<RolesPath> findRolesList(Integer pathid);

}
