package gr.manos.guide.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="authorities")
@Data
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 4392708999333070523L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;

    @JsonIgnore
    String name;

    @Override
    public String getAuthority() {
        return name;
    }

}