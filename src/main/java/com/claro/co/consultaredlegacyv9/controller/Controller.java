package com.claro.co.consultaredlegacyv9.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.claro.co.consultaredlegacyv9.dto.Query;
import com.claro.co.consultaredlegacyv9.dto.Url;
import com.claro.co.consultaredlegacyv9.dto.User;
import com.claro.co.consultaredlegacyv9.services.CallbackComandoslService;
import com.claro.co.consultaredlegacyv9.services.ConsultaService;
import com.claro.co.consultaredlegacyv9.services.ModifyUrlService;
import com.claro.co.consultaredlegacyv9.util.CallbackRequest;
import com.claro.co.consultaredlegacyv9.util.ResponseGeneric;
import com.claro.co.consultaredlegacyv9.util.Rol;

@RestController
@CrossOrigin
public class Controller {
    
    @Autowired
	ConsultaService service;

	@Autowired
	CallbackComandoslService callbackComandoService;
	
	@Autowired
	ModifyUrlService serviceUrlPropertie;

	@Value("${spring.security.user.name}")
	String username;

	@Value("${spring.security.user.password}")
	String password;

	@Value("${spring.security.userqa}")
	String userqa;

	@Value("${spring.security.useradm}")
	String userAdmin;

	@GetMapping("/**/{path:[^.]*}")
	public void handleFoo(HttpServletResponse response) throws IOException {
		response.sendRedirect("/consulta-red");
	}

	@PostMapping("/loginAutorizator")
	public ResponseEntity<Object> login(@Validated @RequestBody User user) {

		if (user.getUserName().equals(username) && user.getPassword().equals(password)
				|| userqa.split(",")[0].equals(user.getUserName()) && userqa.split(",")[1].equals(user.getPassword())) {
			user.setRol(Rol.USER.toString());
			user.setValidate(true);

		} else if (userAdmin.split(",")[0].equals(user.getUserName())
				&& userAdmin.split(",")[1].equals(user.getPassword())) {
			user.setRol(Rol.ADMIN.toString());
			user.setValidate(true);
		} else {
			user.setRol("");

		}
		user.setPassword("");
		return ResponseEntity.ok(user);

	}

	@PostMapping("/consultPlatform")
	public ResponseEntity<Object> consult(@Validated @RequestBody Query query) {
		return ResponseEntity.ok(service.find(query));

	}
	
	@PostMapping("/modifyUrl")
	public ResponseEntity<Object> modify(@Validated @RequestBody Url url) {
		return ResponseEntity.ok(serviceUrlPropertie.modifyUrlPropertie(url));

	}
	
	@GetMapping("/getUrls")
	public ResponseEntity<Object> getUrls() {
		return ResponseEntity.ok(serviceUrlPropertie.getUrls());

	}
	@PostMapping("/callback")
	public ResponseEntity<ResponseGeneric> callback(@RequestBody CallbackRequest request) {
		return ResponseEntity.ok(callbackComandoService.getCallbackComando(request));

	}
	
	@PostMapping("/commandLegacy")
	public ResponseEntity<ResponseGeneric> commandLegacy(@RequestBody CallbackRequest request) {
		return ResponseEntity.ok(callbackComandoService.getCommandLegacy(request));

	}
	
}