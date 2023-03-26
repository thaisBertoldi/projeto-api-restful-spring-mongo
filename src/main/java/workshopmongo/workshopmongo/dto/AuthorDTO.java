package workshopmongo.workshopmongo.dto;

import java.io.Serializable;

import workshopmongo.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
    
    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
