package br.com.udemy.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.udemy.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	Empresa findByCnpj(String cnpj); // Busca uma empresa pelo CNPJ.

}
