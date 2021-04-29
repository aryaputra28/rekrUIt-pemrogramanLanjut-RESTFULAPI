package com.advprog2021.b15.rekrUIt.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.advprog2021.b15.rekrUIt.model.UserModel;
import com.advprog2021.b15.rekrUIt.repository.UserModelRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserModelRepository userModelRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //switch (user.getUserRole()){
        //    case PENDAFTAR:
        //        return new PendaftarModel(user);
        //    case REKRUTER:
        //        return new RekruterModel(user);
        //}
        return userModelRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
    }


    public void registerUser(UserModel userModel) {
        boolean userExists = userModelRepository.findByEmail(userModel.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());

        userModel.setPassword(encodedPassword);

        userModelRepository.save(userModel);
    }
}