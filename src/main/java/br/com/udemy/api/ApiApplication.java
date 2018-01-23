package br.com.udemy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.udemy.api.entities.Empresa;
import br.com.udemy.api.repositories.EmpresaRepository;
import br.com.udemy.api.utils.SenhaUtils;

@SpringBootApplication
public class ApiApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private EmpresaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);
			
			String senhaEncoded = SenhaUtils.geraBCrypt("123");
			System.out.println("Senha encoded: " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.geraBCrypt("123");
			System.out.println("Senha encoded novamente: " + senhaEncoded);
			
			System.out.println("Senha válida: " + SenhaUtils.isValid("123", senhaEncoded));
			
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Udemy");
			empresa.setCnpj("12345678912345");
			
			this.repository.save(empresa);
			
			List<Empresa> empresas = repository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresaDB = repository.findOne(1L);
			if(empresaDB != null) {
				System.out.println("Empresa por ID: " + empresaDB);
				
				empresaDB.setRazaoSocial("Udemy Web");
				this.repository.save(empresaDB);
			}			
			
			Empresa empresaCNPJ = repository.findByCnpj("12345678912345");
			System.out.println("Empresa por ID: " + empresaCNPJ);
			
			this.repository.delete(empresaCNPJ);
			
			empresas = repository.findAll();
			System.out.println("Empresas " + empresas.size());
			
		};
	}
}
