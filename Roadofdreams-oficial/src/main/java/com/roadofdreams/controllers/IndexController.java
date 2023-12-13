package com.roadofdreams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class IndexController {
@GetMapping("/home")
public String home() {
	return "index";
}
@Controller
public class Destino {
@GetMapping("/destino")
public String destino() {
	return "destino";
}

@Controller
public class Forms {
@GetMapping("/forms")
public String forms() {
	return "forms";
}

@Controller
public class Loading{
@GetMapping("/loading")
public String loading() {
	return "loading";
}

@Controller
public class Promo{
@GetMapping("/promo")
public String promo() {
	return "promo";
}












}
}
}
}
}


