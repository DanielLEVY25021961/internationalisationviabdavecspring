package com.developpez.hikage.spring.i18n;

import java.text.MessageFormat;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractMessageSource;

import com.developpez.hikage.spring.i18n.service.IMessageMngt;


/**
 * class DatabaseMessageSource :<br/>
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
public class DatabaseMessageSource extends AbstractMessageSource {

	// ************************ATTRIBUTS************************************/
	
    /**
     * messageMngt : IMessageMngt :<br/>
     * Service chargé de gérer les messages (valeurs) 
     * dans les .properties.<br/>
     */
    private IMessageMngt messageMngt;
    

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(DatabaseMessageSource.class);

	
	// *************************METHODES************************************/
	  
    
	
	 /**
	 * method CONSTRUCTEUR DatabaseMessageSource() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DatabaseMessageSource() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
    /**
     * {@inheritDoc}
     */
	@Override
    protected MessageFormat resolveCode(
    		final String pCle
    			, final Locale pLocale) {
    	
        // Utilisation du service pour récuperer le message traduit
        final String message 
        	= this.messageMngt.getMessage(
        			pCle, pLocale.getLanguage(), pLocale.getCountry());
        
        // Et renvoie de celui-ci sous la bonne forme
        return createMessageFormat(message, pLocale);

    } // Fin de resolveCode(....)._________________________________________
    
    
    
	/**
	 * method getMessageMngt() :<br/>
	 * Getter du Service chargé de gérer les messages (valeurs) 
	 * dans les .properties.<br/>
	 * <br/>
	 *
	 * @return messageMngt : IMessageMngt.<br/>
	 */
	public final IMessageMngt getMessageMngt() {
		return this.messageMngt;
	} // Fin de getMessageMngt().__________________________________________

	
	
	/**
	 * method setMessageMngt(
	 * IMessageMngt pMessageMngt) :<br/>
	 * Setter du Service chargé de gérer les messages (valeurs) 
	 * dans les .properties.<br/>
	 * <br/>
	 *
	 * @param pMessageMngt : IMessageMngt : 
	 * valeur à passer à this.messageMngt.<br/>
	 */
	public final void setMessageMngt(
			final IMessageMngt pMessageMngt) {
        this.messageMngt = pMessageMngt;
    } // Fin de setMessageMngt(
	 // IMessageMngt pMessageMngt).________________________________________

	

}
