package org.cap.controller;

import javax.servlet.http.HttpSession;

import org.cap.service.IUserService;
import org.cap.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

	private IUserService service;

	public IUserService getService() {
		return service;
	}

	@Autowired
	public void setService(IUserService service) {
		this.service = service;
	}
	
	private Employee appUser;
	
	@Autowired
	public Employee getAppUser() {
		return appUser;
	}
	
	public void setAppUser(Employee user) {
		this.appUser=user;
	}
	
	@GetMapping("/input")
	public ModelAndView employeeInput() {
		return new ModelAndView("employeeinput");
	}
	
	
	@GetMapping("/logincheck")
	public RedirectView loginCheck(@RequestParam("id") int id, @RequestParam("name") String name){
		appUser.setId(id);
		appUser.setName(name);
		if(service.credentialsCorrect(id, name)) {
			System.out.println("id" + id+ "name "+name);
			return new RedirectView("/home");
		}else {
			return new RedirectView("/input");
		}
	}
	
	@GetMapping("/home")
	public Object home() {
			if(appUser.getId()==0) {
				return new RedirectView("/input");
			}
			
			ModelAndView mv = new ModelAndView("home","user",appUser);
			return mv;
		}


	@PostMapping("/employeedetails")
	public ModelAndView employeeDetails(@RequestParam("id") int id, @RequestParam("name") String name) {
		boolean correct = service.credentialsCorrect(id, name);
        System.out.println("id "+id +" "+"name "+name +"   "+correct);
		if (correct) {
			Employee employee = service.findById(id);
			ModelAndView mv = new ModelAndView("employeedetails", "employee", employee);
			return mv;
		} else {
			return new ModelAndView("employeeinput");
		}
	}
}
