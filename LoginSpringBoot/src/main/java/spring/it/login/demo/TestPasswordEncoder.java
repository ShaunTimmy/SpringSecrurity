package spring.it.login.demo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class TestPasswordEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 String hash = encoder.encode("2909");
	        System.out.println(hash);

	}

}
