package edu.home.common.create;
import edu.home.model.Role;
public class InfoRole {
    public Role createGuest(){
        Role role = new Role();
        role.setId("GUEST");
        role.setName("Guests");
        return role;
    }
}
