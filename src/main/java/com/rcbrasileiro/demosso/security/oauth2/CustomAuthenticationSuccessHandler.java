package com.rcbrasileiro.demosso.security.oauth2;

import static com.rcbrasileiro.demosso.common.Constants.TOKEN_PARAM;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.rcbrasileiro.demosso.config.FrontEndConfig;
import com.rcbrasileiro.demosso.domain.User;
import com.rcbrasileiro.demosso.service.IUserService;
import com.rcbrasileiro.demosso.util.JwtTokenUtil;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private IUserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private FrontEndConfig frontEndConfig;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		if (response.isCommitted()) {
			return;
		}
		DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
		Map<String, Object> attributes = oidcUser.getAttributes();
		String email = (String) attributes.get("email");
		Optional<User> userOpt = this.userService.findByEmail(email);
		String token = jwtTokenUtil.generateToken(userOpt.get());
		String redirectionUrl = UriComponentsBuilder.fromUriString(frontEndConfig.getUrl()).queryParam(TOKEN_PARAM, token).build()
				.toUriString();
		getRedirectStrategy().sendRedirect(request, response, redirectionUrl);
	}
}