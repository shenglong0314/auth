package demo.dao;


import demo.entity.Path;
import demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PathRepository extends JpaRepository<Path,Integer> {



}
