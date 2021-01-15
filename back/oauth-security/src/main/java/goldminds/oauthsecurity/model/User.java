package goldminds.oauthsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public abstract class User {

    private Long id;

    private String name;

    private String email;

    private String imageUrl;

    private Boolean emailVerified = false;
    @JsonIgnore
    private String password;

    private AuthProvider provider;

    private String providerId;

    private Role roles

}
