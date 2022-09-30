package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping; // include PUT request
import org.springframework.web.bind.annotation.PostMapping; // include Post request
import org.springframework.web.bind.annotation.DeleteMapping; // include Delete request
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin; // include Cross origin settings
// 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody; // We actually dont need this becuz RestController has included it
import org.springframework.web.bind.annotation.RequestBody;

import pojo.PutBody;

@CrossOrigin(origins = { "http://localhost:8080", "http://192.168.1.186" })
@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "{'hi':'heelo'}";
	}

	// E.g. /nice_try?id=6&name=what the heck
	@CrossOrigin(origins = { "http://localhost:8080" })
	@GetMapping("/nice_try")
	public String path1(@RequestParam(value = "id") int idGet, @RequestParam String name) {
		// the line break is not working for this kind of return. It is treated as space
		return "inside nice try&#10;" + "the id is " + idGet + "&#10;and the name is " + name;
	}

	@PutMapping("/putExample")
	public String path2(@RequestBody PutBody bodyPut) {
		// PutBody is a POJO class for this put request body which only contains a key
		// called bodyPut
		// String boot will convert the JSON to POJO for us, such that we can get the
		// request body
		System.out.println("\n...Triggering Put controller...\n");
		return "The put body is " + bodyPut.getbodyPut();
	}

	@PutMapping("/putExampleWithJSONReturn")
	public PutBody path3(@RequestBody PutBody bodyPut) {
		// PutBody is a POJO class for this put request body which only contains a key
		// called bodyPut
		// String boot will convert the JSON to POJO for us, such that we can get the
		// request body
		System.out.println("\n...Triggering Put controller JSON return ...\n");
		return bodyPut;
	}

}