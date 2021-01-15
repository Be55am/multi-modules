package goldminds.oauthsecurity.config;

import goldminds.oauthsecurity.controllers.OauthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Get the authentication Informations
 */
@Component
public class SecurityContext {

    private static final Logger logger = LoggerFactory.getLogger(SecurityContext.class);


    @Bean
    public Authentication getOidcUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Authentication Principal : " + authentication);
        return authentication;
    }
}
