package workshopmongo.workshopmongo.dto;

import java.io.Serializable;

import workshopmongo.workshopmongo.domain.User;

public class UserDTO implements Serializable {
    
    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
