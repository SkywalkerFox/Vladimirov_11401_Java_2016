package ru.kpfu.itis.PAVEL_VLADIMIROV.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.Activities;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.UserRepository;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.ActivitiesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Павел on 28.04.2016.
 */
public class AuthProviderImpl implements AuthenticationProvider {

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivitiesService activitiesService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        String password = authentication.getCredentials().toString();
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("invalid password");
        }
//        if (!password.equals(user.getPassword())) {
//            throw new BadCredentialsException("invalid password");
//        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        if (user.getRole().equals("ROLE_USER")) {
            Activities activity = new Activities();
            activity.setUserId(user.getId());
            activity.setType("login");
            activity.setDescription("Пользователь " + user.getFirstName() + " " + user.getLastName() + " вошел в систему");
            try {
                activity.setDate(new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(new Date()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            activitiesService.add(activity);
        }

        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
