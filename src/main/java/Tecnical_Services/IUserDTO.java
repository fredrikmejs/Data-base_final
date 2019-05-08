package Tecnical_Services;

import java.util.List;

public interface IUserDTO {
    String getUserId();

    void setUserId(String id);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getRole();

    void setRole(String role);

    boolean isAdmin();

    void setAdmin(boolean isAdmin);
}


