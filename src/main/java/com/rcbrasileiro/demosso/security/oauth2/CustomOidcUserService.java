package com.rcbrasileiro.demosso.security.oauth2;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.rcbrasileiro.demosso.domain.User;
import com.rcbrasileiro.demosso.security.dto.GoogleOAuth2UserInfo;
import com.rcbrasileiro.demosso.service.IUserService;

@Service
public class CustomOidcUserService extends OidcUserService {

	@Autowired
	private IUserService userService;

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		OidcUser oidcUser = super.loadUser(userRequest);
		Map<String, Object> attributes = oidcUser.getAttributes();
		GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo();
		userInfo.setEmail((String) attributes.get("email"));
		userInfo.setId((String) attributes.get("sub"));
		userInfo.setImageUrl((String) attributes.get("picture"));
		userInfo.setName((String) attributes.get("name"));
		updateUser(userInfo);

		return oidcUser;
	}

	private void updateUser(GoogleOAuth2UserInfo userInfo) {
		Optional<User> userOpt = this.userService.findByEmail(userInfo.getEmail());
		User user;
		if (!userOpt.isPresent()) {
			user = new User();
		} else {
			user = userOpt.get();
		}
		user.setEmail(userInfo.getEmail());
		user.setImageUrl(userInfo.getImageUrl());
		user.setName(userInfo.getName());
		user.setUserTypeGoogle();

		this.userService.save(user);
	}
}
