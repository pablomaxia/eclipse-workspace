package ejercicio05_interrumpir_varios_hilos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Marco con lámina y botones
public class MarcoRebote extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private LaminaPelota lamina;
	
	//Ahora creo por ejemplo tres hilos
	
	private Thread t1,t2,t3;
	
	private JButton arranca1,arranca2,arranca3,detener1,detener2,detener3;
	
	
		public MarcoRebote(){
			
			setBounds(600,300,400,350);
			
			setTitle ("Rebotes");
			
			lamina=new LaminaPelota();
			
			add(lamina, BorderLayout.CENTER);
			
			JPanel laminaBotones=new JPanel();
			
			//creamos el primer botón y lo dejamos a la escucha 
			arranca1=new JButton("Hilo1");
			
			arranca1.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					comienza_el_juego(evento);
				}
				
			});
			
			laminaBotones.add(arranca1);
			
			//creamos el primer botón y lo dejamos a la escucha 
			arranca2=new JButton("Hilo2");
			
			arranca2.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					comienza_el_juego(evento);
				}
				
			});
			
			laminaBotones.add(arranca2);
			
			//creamos el primer botón y lo dejamos a la escucha 
			arranca3=new JButton("Hilo3");
			
			arranca3.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					comienza_el_juego(evento);
				}
				
			});
			
			laminaBotones.add(arranca3);
			
			/**********************botones Detener******************************/
			
			//creamos el primer botón y lo dejamos a la escucha 
			detener1=new JButton("detener Hilo1");
			
			detener1.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					detener(evento);
				}
				
			});
			
			laminaBotones.add(detener1);
			
			
			detener2=new JButton(" detener Hilo2");
			
			detener2.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					detener(evento);
				}
				
			});
			
			laminaBotones.add(detener2);
			
			
			//creamos el primer botón y lo dejamos a la escucha 
			detener3=new JButton("detener Hilo3");
			
			detener3.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent evento){
					
					detener(evento);
				}
				
			});
			
			laminaBotones.add(detener3);
			
			
			
			
			
			
//			ponerBoton(laminaBotones, "Salir", new ActionListener(){
//				
//				public void actionPerformed(ActionEvent evento){
//					
//					System.exit(0);
//					
//				}
//				
//			});
//			
			
//			/******************************************************************/
//			/*Añadimos un botón Detener para interrumpir un hilo en ejecución*/
//			
//			ponerBoton(laminaBotones, "Detener", new ActionListener(){
//				
//				public void actionPerformed(ActionEvent evento){
//					
//					detener();
//					
//				}
//				
//			});
//			/*****************************************************************/
			
			
			add(laminaBotones, BorderLayout.SOUTH);
		}
		
		
//		//Ponemos botones
//		
//		public void ponerBoton(Container c, String titulo, ActionListener oyente){
//			
//			JButton boton=new JButton(titulo);
//			
//			c.add(boton);
//			
//			boton.addActionListener(oyente);
//			
//		}
		
		
		//Permite pasarle por parámetro el botón que se ha pulsado.
		
		public void comienza_el_juego (ActionEvent e ){
									
				Pelota pelota=new Pelota();
				lamina.add(pelota);
				
				Runnable r= new PelotaHilos(pelota,lamina);
				
				
				if(e.getSource().equals(arranca1)) {
					t1=new Thread(r);
					t1.start();
				}else if(e.getSource().equals(arranca2)) {
					t2=new Thread(r);
					t2.start();
				}else if (e.getSource().equals(arranca3)) {
					t3=new Thread(r);
					t3.start();
				}
				
		}
		
		/******************************************************************/
		public void detener(ActionEvent e) {
			if(e.getSource().equals(detener1)) {
				t1.interrupt();
			}else if(e.getSource().equals(detener2)) {
				t2.interrupt();
			}else if (e.getSource().equals(detener3)) {
				t3.interrupt();
			}
					
		}
		/******************************************************************/
	}

