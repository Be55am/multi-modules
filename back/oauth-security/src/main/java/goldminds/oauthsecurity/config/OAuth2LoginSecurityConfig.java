//package goldminds.oauthsecurity.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//
//import java.util.HashSet;
//import java.util.Set;
//
////Use this to make additional calls to the OP if you want more info than profile
//
//@Configuration
//public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        Set<String> googleScopes = new HashSet<>();
//        googleScopes.add(
//                "https://www.googleapis.com/auth/userinfo.phone");
//        googleScopes.add(
//                "https://www.googleapis.com/auth/userinfo.address");
//
//        OidcUserService googleUserService = new OidcUserService();
//        googleUserService.setAccessibleScopes(googleScopes);
//
//        http
//                .authorizeRequests(authorizeRequests -> authorizeRequests
//                        .anyRequest().authenticated())
//                .oauth2Login(oauthLogin -> oauthLogin
//                        .userInfoEndpoint()
//                        .oidcUserService(googleUserService));
//    }
//}
