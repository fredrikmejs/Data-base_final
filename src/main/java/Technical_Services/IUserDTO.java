package Technical_Services;

public interface IUserDTO {
    int getUserId();

    void setUserId(int id);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getRole();

    void setRole(String role);

    boolean isAdmin();

    void setAdmin(boolean isAdmin);
}


