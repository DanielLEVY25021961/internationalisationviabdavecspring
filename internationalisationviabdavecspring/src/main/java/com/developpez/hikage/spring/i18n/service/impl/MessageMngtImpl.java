package com.developpez.hikage.spring.i18n.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.developpez.hikage.spring.i18n.dao.IMessageDao;
import com.developpez.hikage.spring.i18n.service.IMessageMngt;


/**
 * class MessageMngtImpl :<br/>
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
public class MessageMngtImpl implements IMessageMngt {
	
	// ************************ATTRIBUTS************************************/

    /**
     * langueDefaut : String :<br/>
     * Langue par défaut ("fr").<br/>
     */
    private String langueDefaut = "fr";

    
    /**
     * messageDao : IMessageDao :<br/>
     * DAO pour les messages à chercher dans le properties.<br/>
     */
    private IMessageDao messageDao;

    
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MessageMngtImpl.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR MessageMngtImpl() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public MessageMngtImpl() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
    public final String getMessage(
    		final String pCle
    		, final String pLangue
    			, final String pPays) {

    	String message = null;
    	
        // Si un message pour la locale complète existe
        message = this.messageDao.getMessage(pCle, pLangue, pPays);
        
        // On le renvoie
        if (message != null) {
        	return message;
        }

        // Sinon on cherche un message basé sur la langue uniquement
        message = this.messageDao.getMessage(pCle, pLangue);
        
        // Et on le retourne si il y en a un
        if (message != null) {
        	return message;
        }

        // Sinon on cherche un message dans la langue par defaut
        message = this.messageDao.getMessage(pCle, this.langueDefaut);
        
     // Et on le retourne si il y en a un
        if (message != null) {
        	return message;
        }

        // Si le message n'existe pas on renvoit une chaine spéciale
        return "???" + pCle + "???";
        
    } // Fin de getMessage(....).__________________________________________
    
 
     
	/**
	 * method getLangueDefaut() :<br/>
	 * Getter de la Langue par défaut ("fr").<br/>
	 * <br/>
	 *
	 * @return langueDefaut : String.<br/>
	 */
	public final String getLangueDefaut() {
		return this.langueDefaut;
	} // Fin de getLangueDefaut()._________________________________________



    /**
     * method setLangueDefaut(
     * String pLangueDefaut) :<br/>
     * Setter de la Langue par défaut ("fr").<br/>
     * <br/>
     *
     * @param pLangueDefaut : String : 
     * valeur à passer à this.langueDefaut.<br/>
     */
    public final void setLangueDefaut(
    		final String pLangueDefaut) {
        this.langueDefaut = pLangueDefaut;
    } // Fin de setLangueDefaut(
    // String pLangueDefaut).______________________________________________
    
    
    
    /**
     * method getMessageDao() :<br/>
     * Getter du DAO pour les messages à chercher dans le properties.<br/>
     * <br/>
     *
     * @return : IMessageDao : this.messageDao.<br/>
     */
    public IMessageDao getMessageDao() {
        return this.messageDao;
    } // Fin de getMessageDao().___________________________________________
    
    

    /**
     * method setMessageDao(
     * IMessageDao pMessageDao) :<br/>
     * Setter du DAO pour les messages à chercher dans le properties.<br/>
     * <br/>
     *
     * @param pMessageDao : IMessageDao : 
     * valeur à passer à this.messageDao.<br/>
     */
    public void setMessageDao(
    		final IMessageDao pMessageDao) {
        this.messageDao = pMessageDao;
    } // Fin de setMessageDao(
    // IMessageDao pMessageDao).___________________________________________

}
