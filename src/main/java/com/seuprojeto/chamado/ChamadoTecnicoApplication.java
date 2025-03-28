package com.seuprojeto.chamado;

import com.seuprojeto.chamado.model.Auditoria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChamadoTecnicoApplication extends Auditoria {

	public static void main(String[] args) {
		SpringApplication.run(ChamadoTecnicoApplication.class, args);
	}

}
