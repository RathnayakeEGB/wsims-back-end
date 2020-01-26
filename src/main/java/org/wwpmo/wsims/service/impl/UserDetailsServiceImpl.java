package org.wwpmo.wsims.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.wwpmo.wsims.entities.Role;
import org.wwpmo.wsims.entities.User;
import org.wwpmo.wsims.models.ResponseObject;
import org.wwpmo.wsims.models.login.SignupRequest;
import org.wwpmo.wsims.repository.RoleRepository;
import org.wwpmo.wsims.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user =userRepository.findByUsername(username);
        return UserDetailsImpl.build(user);
    }

    public ResponseObject createNewUserAccout(SignupRequest sr) throws Exception{

        log.debug("Create New User With Roles..................");

        User user = new User();
        Set<String>roles = sr.getRoles();
        List<Role> roleList = roleRepository.findAll();
        Set<Role>list = new HashSet<>();
        roles.forEach(i->{
            Role role = getRole(i.toString(), roleList);
            list.add(role);
        });

        user.setRoles(list);
        user.setEmail(sr.getEmail());
        user.setUsername(sr.getUsername());
        user.setPassword(encoder.encode(sr.getPassword()));

        userRepository.save(user);
        log.debug("user Created.............................................");
        return  new ResponseObject(200,"OK");
    }

    private Role getRole(String roleName,List<Role>roleList){

        log.debug("Role Name "+roleName +"Role List .."+roleList);

        for (Role r:roleList) {
            if(r.getName().name().equals(roleName)){
                return r;
            }
        }
        throw new RuntimeException("Error Unkown Role Found....... Devoloper Create Exception.....");
    }

}