package com.developpez.hikage.spring.i18n.service;


/**
 * class IMessageMngt :<br/>
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
public interface IMessageMngt {
	

	 /**
     * method getMessage(String pCle, String pLangue, String pPays) :<br/>
     * Getter d'un message dans le properties en fonction d'une clé 
     * et d'une localisation [langue, Pays].<br/>
     * <br/>
     *
     * @param pCle : String : Clé à rechercher dans un .properties.<br/>
     * @param pLangue : String : Langue comme fr, en, ...<br/>
     * @param pPays : String : Pays comme FR, US, ...<br/>
     * 
     * @return : String : Message (valeur) dans le properties.<br/>
     */
    String getMessage(String pCle, String pLangue, String pPays);

    
    
} // FIN DE L'INTERFACE IMessageMngt.--------------------------------------
