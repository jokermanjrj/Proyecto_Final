package com.proyecto.services;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.proyecto.entities.Alumno;
import com.proyecto.entities.Tarea;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

@Service
public class ReportService {

	public void exportReport(List<Alumno> alumno, String nombre) throws JRException, FileNotFoundException {
		
		File file = ResourceUtils.getFile("classpath:AlumnosClase.jrxml");
		JasperDesign jd = JRXmlLoader.load(file);
		JasperReport jr = JasperCompileManager.compileReport(jd);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alumno);

		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("nombreClase", nombre);
		
		 System.out.println(map.get("nombreClase"));
		 System.out.println(map.size());
		JasperPrint jp = JasperFillManager.fillReport(jr, map, dataSource);
		map.clear();
		JFrame frame = new JFrame(nombre);
		JRViewer viewer = new JRViewer(jp);
		frame.add(viewer);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(900, 700));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
       
	}
	
public void ReportTarea(List<Tarea> tarea) throws JRException, FileNotFoundException {
		
		File file = ResourceUtils.getFile("classpath:reporteTareas.jrxml");
		JasperDesign jd = JRXmlLoader.load(file);
		JasperReport jr = JasperCompileManager.compileReport(jd);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(tarea);
		JasperPrint jp = JasperFillManager.fillReport(jr, null, dataSource);

		JFrame frame = new JFrame("Resumen de tareas");
		JRViewer viewer = new JRViewer(jp);
		frame.add(viewer);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension(900, 700));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
	}
}
