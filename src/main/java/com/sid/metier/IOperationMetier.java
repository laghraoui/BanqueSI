package com.sid.metier;

public interface IOperationMetier {
	
	public boolean verser(String code, double montant, Long codeEmp);
	public boolean retirer(String code, double montant, Long codeEmp);
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp);
	public PageOperation getOperation(String codeCompte, int page, int size);
}
