package com.logicap.ecommerce.auth.service;


import com.logicap.ecommerce.auth.model.entity.UserEntity;
import com.logicap.ecommerce.auth.model.repository.RoleRepository;
import com.logicap.ecommerce.auth.model.repository.UserRepository;
import com.logicap.ecommerce.auth.model.request.AuthenticationRequest;
import com.logicap.ecommerce.auth.model.request.UserRequest;
import com.logicap.ecommerce.auth.model.response.AuthenticationResponse;
import com.logicap.ecommerce.auth.model.response.UserResponse;
import com.logicap.ecommerce.auth.security.JwtService;
import com.logicap.ecommerce.auth.security.RoleType;
import com.logicap.ecommerce.model.mapper.GenericMapper;
import com.logicap.ecommerce.service.implement.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsCustomService  {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final GenericMapper mapper;


    public UserResponse save(UserRequest userRequest) throws IOException {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setUsername(userRequest.getEmail());
        userEntity.setRoles(List.of(roleRepository.findByName(RoleType.ADMIN.getFullRoleName())));
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(userEntity);
        UserResponse result = mapper.map(userEntity, UserResponse.class);
        result.setToken(jwtService.generateToken(userEntity));

        //MAIL VALIDATION WHEN AN USER IS CREATED
       if (userEntity != null) {
            emailService.send(userEntity.getEmail());
        }
        return result;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
