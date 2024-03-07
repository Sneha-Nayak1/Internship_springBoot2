package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User user=new User();
		user.setName("Sneha");
		user.setEmail("snehaberkala@gmail.com");
		
		UserProfile userProfile=new UserProfile();
		userProfile.setAddress("Mangalore");
		userProfile.setPhoneNumber("9988009876");
		userProfile.setGender(Gender.FEMALE);
		userProfile.setBirthDate(LocalDate.of(2003, 1, 10));
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
		
		
	}

}
