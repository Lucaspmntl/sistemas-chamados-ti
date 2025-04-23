package com.seuprojeto.chamado;

import com.seuprojeto.chamado.model.LogAuditoria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChamadoTecnicoApplication extends LogAuditoria {

	public static void main(String[] args) {
		SpringApplication.run(ChamadoTecnicoApplication.class, args);
	}

}
