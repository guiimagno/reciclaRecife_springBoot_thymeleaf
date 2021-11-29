package br.com.recicla.recife.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.BatchSize;
import org.springframework.lang.NonNull;

@Entity
public class Recicla {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="nome")
	/*
	 * @Size(min=5, max=35)
	 * 
	 * @NotBlank(message="não pode ser vazio.")
	 */
	private String nome;
	
	@Column(name="cep")
	/*
	 * @Size(min=14, message="")
	 * 
	 * @NotBlank(message="não pode ser vazio.")
	 */
	private String cep;
	
	@Column(name="denuncia")
	/*
	 * @Size(min=5, max=255)
	 * 
	 * @NotBlank(message="não pode ser vazio.")
	 */
	private String denuncia;
	
	@Column(name="data")
	private LocalDate data;

	public Recicla() {}
	
	public Recicla(Long id, String nome, String cep, String denuncia, LocalDate data) {
		super();
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.denuncia = denuncia;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(String denuncia) {
		this.denuncia = denuncia;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, data, denuncia, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recicla other = (Recicla) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(data, other.data)
				&& Objects.equals(denuncia, other.denuncia) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

}
