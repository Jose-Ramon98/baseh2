package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll(); //Cliente es la clase entity(pq asi se llama su package) que esta mapeada a la bd
	//findAll retornar todos los datos, creo q que significa que cualquier clase que use esto public List<Cliente> finAll(); significa que esta mapeada a esta interfaz

	public void save(Cliente cliente);
}