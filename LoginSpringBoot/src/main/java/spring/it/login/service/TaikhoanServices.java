package spring.it.login.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import spring.it.login.entity.Taikhoan;
import spring.it.login.responsitory.TaikhoanReponsitory;
@Service
public class TaikhoanServices implements UserDetailsService {
 
	@Autowired
	private TaikhoanReponsitory repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Taikhoan taikhoan=repo.findByUsername(username)
				  .orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return User.builder()
				.username(taikhoan.getUsername())
				.password(taikhoan.getPassword())
				.build();
	}

}
