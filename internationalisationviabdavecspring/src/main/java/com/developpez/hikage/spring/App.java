package com.developpez.hikage.spring;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * class App :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 août 2017
 *
 */
public final class App {
	
	
	
	
	 /**
	 * method CONSTRUCTEUR App() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	private App() {
		super();
	}
	
    /**
     * method main(
     * final String[] pArgs) :<br/>
     * .<br/>
     * <br/>
     *
     * @param pArgs : String[] :  .<br/>
     */
    public static void main(
    		final String[] pArgs) {

        ApplicationContext applicationContext = null;
        
        
		try {
			
			applicationContext 
				= new ClassPathXmlApplicationContext("applicationContext.xml");
			
			System.out.println("HelloWorld en français de France : " + applicationContext.getMessage("helloWorld", null, Locale.FRANCE));
	        System.out.println("HelloWorld en Belge : " + applicationContext.getMessage("helloWorld", null, new Locale("fr", "BE")));
	        System.out.println("HelloWorld Italie : " + applicationContext.getMessage("helloWorld", null, Locale.ITALY));
						
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        

    }
}
