package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;

@Controller//se encarga de coordinar y gestionar la ejecución de tareas necesarias para responder a las solicitudes de la aplicación
//El controlador procesaría la solicitud, llamaría al modelo de la aplicación para recuperar la lista de productos y luego la enviaría a la vista de la aplicación para que se muestre al usuario.

public class ClienteController {
	
	@Autowired
	@Qualifier("clienteDaoJpa")// si hay varias inyecciones de dependencia debemos especificar cada una, asi spring sabra a cual nos referimos, en este caso esta se llama clienteJpa
	private IClienteDao clienteDao;//IClienteDao quiere decir que implementamos la interfaz la interfaz se llama asi
     
	@RequestMapping(value="listar", method = RequestMethod.GET)//podriamos usar el getMApping estaria exactamente igual de bien, es solo para variar
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	
	
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model ){// podriamos usar Model que seria exactamente lo mismo, pero para variar vamos a usar Map
	
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
	return "form";
	
	
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:listar"; // esto quiere decir que redirige a listar


	}


}
