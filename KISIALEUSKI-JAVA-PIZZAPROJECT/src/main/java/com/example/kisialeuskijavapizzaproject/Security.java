//package com.example.kisialeuskijavapizzaproject;
//
//import com.example.kisialeuskijavapizzaproject.entity.PersonSecurity;
//import com.example.kisialeuskijavapizzaproject.entity.Status;
//import com.example.kisialeuskijavapizzaproject.repositaries.PersonSecurityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class Security {
//    @Autowired
//    private PersonSecurityRepository personSecurityRepository;
/////get-all-cafes /get-cafe/{id} /get-all-pizzas /get-pizza/{id} /get-all-person /get-person/{id}
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        LogoutConfigurer<HttpSecurity> logout = http.authorizeHttpRequests()
//                .requestMatchers("/get-all-orders", "/get-order/{id}","/get-all-person","/get-person/{id}","/delete-person/{id}","/add-person").authenticated()
//                .requestMatchers("/add-order","/update-Order/{id}","/updatePayOrder","/updateDeliverOrder").hasRole(String.valueOf(Status.USER))
//                .requestMatchers("/persons-pizzas/{id}","/persons-cafes/{id}","/persons-money/{id}","/count_of_orders/{id}""/get-earnings-table","/get-cafe-pizza/{id}/{pizzaId}","/get-earnings-cafe/{id}","/delete-cafe/{id}","/add-сafe","/update-cafe/{id}","/delete-order/{id}","/update_count",
//"/update-pizzas/{id}").hasRole(String.valueOf(Status.ADMIN))
//                .anyRequest("/get-all-cafes", "/get-cafe/{id}","/get-all-pizzas", "/get-pizza/{id}" ).permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .logout();
//
//        return http.build();
//    }
//
//
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        List<PersonSecurity> personSecurities = personSecurityRepository.findAll();
//        List<UserDetails> users = new ArrayList<>();
//        for (PersonSecurity personSecurity : personSecurities) {
//            UserDetails userDetails = User
//                    .withUsername(personSecurity.getLogin())
//                    .password(personSecurity.getPassword())
//                    .roles(String.valueOf(personSecurity.getStatus()))
//                    .build();
//                        users.add(userDetails);
//        }
//
//
//        return new InMemoryUserDetailsManager(users);
//    }
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//
//}
