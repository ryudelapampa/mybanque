package fr.banque.mybanque.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import fr.banque.mybanque.services.UserService;

public class AppAuthProvider extends DaoAuthenticationProvider {
	/*
	 * On va créer plus tard UserService
	 */
	@Autowired
	UserService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		
		String name = auth.getName();
		String password = auth.getCredentials().toString();
		
		UserDetails user = userDetailsService.loadUserByUsername(name);
		if (user == null) {
			throw new BadCredentialsException("Username/Password does not match for "+ auth.getPrincipal());
		}
		 if (!user.getPassword().equals(password)) {
			 throw new BadCredentialsException("Username/Password does not match for "+ auth.getPrincipal());
		 }
		 return new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
