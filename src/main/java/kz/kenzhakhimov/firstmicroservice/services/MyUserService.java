package kz.kenzhakhimov.firstmicroservice.services;

import kz.kenzhakhimov.firstmicroservice.dto.UsersDTO;
import kz.kenzhakhimov.firstmicroservice.entities.Users;
import kz.kenzhakhimov.firstmicroservice.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findAllByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return user;
    }
    public void register(UsersDTO usersDTO){
        Users checkUser = usersRepository.findAllByEmail(usersDTO.getEmail());
        if(checkUser == null){
            if(usersDTO.getPassword().equals(usersDTO.getRePassword())){
               Users user = new Users();
               user.setEmail(usersDTO.getEmail());
               user.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
               user.setAge(usersDTO.getAge());
               user.setFullName(usersDTO.getFullName());
               user.setPermissions(usersDTO.getPermissions());
               usersRepository.save(user);
            }
        }
    }
}
