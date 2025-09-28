package spring.it.login.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "taikhoan")
public class Taikhoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false ,name = "username")
	private String username;
	@Column(name = "password",nullable = false)
	private String password;
	
	public Taikhoan() {
		super();
	}

	public Taikhoan(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
