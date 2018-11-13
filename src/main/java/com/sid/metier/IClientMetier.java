package com.sid.metier;

import java.util.List;

import com.sid.entities.Client;

public interface IClientMetier {
	
	public Client saveClient(Client c); 
	public List<Client> listClient();

}
