package edu.home.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Roles")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Role implements Serializable {
    @Id
    private String id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Authoritie> authorities;
}
