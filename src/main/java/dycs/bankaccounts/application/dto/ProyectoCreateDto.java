package dycs.bankaccounts.application.dto;

import java.math.BigDecimal;

public class ProyectoCreateDto {
	
	private long id;	
	private String nombre;
	private String pais;
	private String number;
	private BigDecimal balance;
	private long cliente_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(long cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
	
	

}
