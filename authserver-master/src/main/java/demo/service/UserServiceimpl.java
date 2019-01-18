package demo.service;

import demo.dao.RolesRepository;
import demo.dao.UserRepository;
import demo.dao.UserRolesRepository;
import demo.entity.Roles;
import demo.entity.User;
import demo.entity.UserRoles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceimpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;
    @Autowired
    private RolesRepository rolesRepository;


    Log log = LogFactory.getLog(this.getClass());
   @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String s) {
        User user = userRepository.findUserByName(s);
        List<UserRoles> rolesByUserid = userRolesRepository.findRolesByUserid(user.getId());
        for (UserRoles ur:rolesByUserid ) {
            Roles r = rolesRepository.findOne(ur.getRolesid());
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+r.getName());

            user.getAuthorities().add(simpleGrantedAuthority);
        }
        return user;

    }
}
