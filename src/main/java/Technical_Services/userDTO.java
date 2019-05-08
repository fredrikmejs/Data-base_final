package Technical_Services;


public class userDTO implements IUserDTO {

        private String	userId;
        private String userName;
        private String password;
        private String role;
        private boolean isAdmin;

        public userDTO(String userName, String password, String role, boolean isAdmin) {
            this.userName = userName;
            this.password = password;
            this.isAdmin = isAdmin;
            this.role = role;

        }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public void setUsername(String username) {
    this.userName = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
    this.password = password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
    this.role = role;
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
    }
}
