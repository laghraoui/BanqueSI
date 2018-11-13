package com.sid.metier;

import java.io.Serializable;
import java.util.List;

import com.sid.entities.Operationn;

public class PageOperation implements Serializable{
	
	private List<Operationn> operations;
	private int page;
	private int nombreOperations;
	private int totalOperations;
	private int totalPages;
	public List<Operationn> getOperations() {
		return operations;
	}
	public void setOperations(List<Operationn> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public int getTotalOperations() {
		return totalOperations;
	}
	public void setTotalOperations(int totalOperations) {
		this.totalOperations = totalOperations;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
}
