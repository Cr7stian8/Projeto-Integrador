package com.generation.casaDasMudas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotNull
	@Size(min=5,max=100)
	private String nomeProduto;

	@NotNull
	private Double valorProduto;
	
	@NotNull
	private Long qtdProduto;
	
	@NotNull
	@Size(min=5,max=500)
	private String descProduto;
	
	@NotNull
	@Size(min=5,max=500)
	private String imgProduto;
	
	@NotNull
	@Size(min=5,max=500)
	private String enderecoProduto;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Long getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Long qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public String getImgProduto() {
		return imgProduto;
	}

	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}

	public String getEnderecoProduto() {
		return enderecoProduto;
	}

	public void setEnderecoProduto(String enderecoProduto) {
		this.enderecoProduto = enderecoProduto;
	}
	
	//private Long idUsuario;
	
	//private Long idCategoria;
	
	
	
	
}
