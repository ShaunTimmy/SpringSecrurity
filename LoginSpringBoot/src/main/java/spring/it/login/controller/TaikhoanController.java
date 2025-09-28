package spring.it.login.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spring.it.login.entity.Taikhoan;
import spring.it.login.responsitory.*;
@Controller
public class TaikhoanController {
	@Autowired
    private TaikhoanReponsitory repo;

    @Autowired
    private BCryptPasswordEncoder encoder;
	
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("taikhoan", new Taikhoan());
        return "register"; // file register.html
    }

	 @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	
	 @PostMapping("/register")
	 public String register(@ModelAttribute Taikhoan tk) {
	     tk.setPassword(encoder.encode(tk.getPassword()));
	     repo.save(tk);
	     return "redirect:/login";
	 }

	    @GetMapping("/home")
	    public String home() {
	        return "home";
	    }
	  

}
