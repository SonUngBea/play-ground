package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by woongs on 2017. 12. 15..
 */
@Controller
public class HelloController {
	@RequestMapping(value = "/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/calendar")
	public String index() {
		return "/calendar/calendar";
	}
}
