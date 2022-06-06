package com.generation.casaDasMudas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	// Criando chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Usar long minusculo em tudo
	private long idCategoria;

	@NotBlank
	@Size(min = 0, max = 255)
	private String tipoCategoria;
	@NotBlank
	@Size(min = 0, max = 255)
	private String tamanhoCategoria;
	@NotBlank
	private boolean alimenticiaCategoria;

	// Criando Getters and setters
	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public String getTamanhoCategoria() {
		return tamanhoCategoria;
	}

	public void setTamanhoCategoria(String tamanhoCategoria) {
		this.tamanhoCategoria = tamanhoCategoria;
	}

	public boolean isAlimenticiaCategoria() {
		return alimenticiaCategoria;
	}

	public void setAlimenticiaCategoria(boolean alimenticiaCategoria) {
		this.alimenticiaCategoria = alimenticiaCategoria;
	}

}