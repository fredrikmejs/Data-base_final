package Tecnical_Services;

import java.util.List;

public interface IUserDTO {
    String getUserId();

    void setUserId(String word);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getRoles();

    void setRoles(String role);

    boolean isAdmin();

    void setAdmin(boolean isAdmin);
}


