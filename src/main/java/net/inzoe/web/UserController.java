package net.inzoe.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.inzoe.domain.User;
import net.inzoe.domain.UserRepository;

@Controller
public class UserController {
	private List <User> users = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user/create")
	public String createUser(User user) {
		//users.add(user);
		System.out.println("user:"+user.toString());
		userRepository.save(user);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String userList(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "/list";
	}
}
