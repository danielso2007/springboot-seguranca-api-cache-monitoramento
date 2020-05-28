package br.com.forum.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.forum.config.Constants;
import br.com.forum.controller.IMainController;

@Controller
@CrossOrigin(origins = "*")
public class MainController implements IMainController {
	
	@RequestMapping(Constants.ROOT_URL + Constants.V1)
	@ResponseBody
	@Override
	public String root() {
		return "Versão 1.0 da API.";
	}

}
