package demo.config.impl;

import demo.config.WebConfig;
import demo.dao.PathRepository;
import demo.dao.RolesPathRepository;
import demo.dao.RolesRepository;
import demo.entity.Path;
import demo.entity.Roles;
import demo.entity.RolesPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public class SystemConfigurerAdapter implements WebConfig {
    @Autowired
    private PathRepository pathRepository;
    @Autowired
    private RolesPathRepository rolesPathRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public void HttpConfigurerAdapter(HttpSecurity http)throws  Exception {

        List<Path> all = pathRepository.findAll();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.authorizeRequests();

        for (Path path:all ) {
            List<RolesPath> rolesList = rolesPathRepository.findRolesList(path.getId());
           StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("hasRole('");

            for (int i=0;i<rolesList.size();i++) {
                RolesPath rolesPath = rolesList.get(i);
                Roles r = rolesRepository.findOne(rolesPath.getRolesId());
               if(i==0){
                   stringBuffer.append(r.getName()+"')");
               }else {
                   stringBuffer.append("  or  hasRole('"+r.getName()+"')");
               }


            }
            expressionInterceptUrlRegistry.antMatchers(path.getPath()).access(stringBuffer.toString());
        }

    }
}
