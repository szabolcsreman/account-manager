package edu.ing.accountmanager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ing.accountmanager.exception.AccountMngrBusinessException;
import edu.ing.accountmanager.model.AuthenticationRequest;
import edu.ing.accountmanager.model.AuthenticationResponse;
import edu.ing.accountmanager.service.impl.CustomUserDetailsServie;
import edu.ing.accountmanager.util.JwtUtil;

@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LogManager.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsServie userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws AccountMngrBusinessException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			LOGGER.error("Incorrect username or password");
			throw new AccountMngrBusinessException("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);

		AuthenticationResponse response = new AuthenticationResponse(jwtToken);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("POST /authenticate Response: {}", response);
		}
		return ResponseEntity.ok(response);
	}
}
