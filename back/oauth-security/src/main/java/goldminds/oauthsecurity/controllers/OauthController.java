package goldminds.oauthsecurity.controllers;

import goldminds.oauthsecurity.config.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {

    @Autowired
    private SecurityContext securityContext;

    private static final Logger logger = LoggerFactory.getLogger(OauthController.class);


    @GetMapping("/oidc-principal")
    public OidcUser getOidcUserPrincipal(@AuthenticationPrincipal OidcUser principal) {
        logger.info("principal" + principal);
        securityContext.getOidcUser();
        return principal;
    }
}
