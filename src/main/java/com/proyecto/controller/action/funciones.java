package com.proyecto.controller.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.proyecto.entities.Clase;
import com.proyecto.services.ClaseService;

public class funciones {
	Clase clase ;
	ClaseService claseService;
	
	public void subirArchivo(File fileUpload) throws FileNotFoundException {
		Scanner sc = new Scanner(fileUpload, "UTF8");
		sc.useDelimiter(",");
		String nombre;
		while (sc.hasNext()) {
			nombre = sc.next();
			System.out.print(nombre);
			clase = new Clase();
			this.clase.setNombre_clase(nombre);
			this.claseService.create(clase);

		}
		sc.close();
	}

}
