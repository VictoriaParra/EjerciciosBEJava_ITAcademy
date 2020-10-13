package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootInitialDemo.dto.UserResponseDto;
import springBootInitialDemo.service.IUserService;

@RestController
@RequestMapping("/v1")
public class InitialController {

	private final IUserService userService;

	@Autowired
	public InitialController(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/test")
	public String helloGradle() {
		return "Hello Gradle!";
	}

	/*
	 * Crear una petición GET con dirección a "/" que como respuesta devuelva un
	 * "HELLO WORLD"
	 */
	@GetMapping("/")
	public String helloWorld() {
		return "HELLO WORLD";
	}

	/*
	 * Modificar la petición anterior para que acepte una variable por path, que
	 * sigua un nombre, construyendo "Hello, <NOMBRE>"
	 */
	@GetMapping("/{nombre}")
	public String helloWorld(@PathVariable String nombre) {
		return "Hello, " + nombre;
	}

	// @PutMapping(value ="", consumes = {"application/json"})
	@GetMapping("/user/{uuid}")
	public ResponseEntity<UserResponseDto> updatePrescription(@PathVariable(name = "uuid") String user)
			throws Exception {

		UserResponseDto userResponseDto = userService.getUser("pp");

		System.out.println(userResponseDto.getName());
		System.out.println(userResponseDto.getSurname());
		System.out.println(userResponseDto.getGender());

		return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

	}

}
