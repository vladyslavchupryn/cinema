package ua.pp.chuprin.web100.cinema.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping(value = "/")
	public String index() {
		return "index/index";
	}

	@RequestMapping(value = "/setup")
	public String setup() {
		return "index/setup";
	}

}
