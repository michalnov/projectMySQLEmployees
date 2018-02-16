package sk.akademiasovy.projectmysqlemployees.db;

public class ObjEmployee {
    private String firstName;
    private String lastName;
    private String id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String createString()
    {
        String swap = "{\"name\":\"";
        swap = swap + this.firstName + " " + this.lastName;
        swap = swap + "\",\"id\":\"";
        swap = swap + this.id;
        swap = swap + "\"}";
        return swap;
    }
}
