package spring.it.login.responsitory;
import org.springframework.data.jpa.repository.JpaRepository;

import spring.it.login.entity.Taikhoan;

import java.util.Optional;



public interface TaikhoanReponsitory extends JpaRepository<Taikhoan, Long> {
	Optional<Taikhoan> findByUsername(String username);

}
