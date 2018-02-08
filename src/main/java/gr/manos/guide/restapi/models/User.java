package gr.manos.guide.restapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=4, max=45)
	private String username;
	
	@NotNull
	@Size(min=4)
	private String password;
	
	@CreatedDate
	@Column(name="created_at")
	private Date createdAt;
}
