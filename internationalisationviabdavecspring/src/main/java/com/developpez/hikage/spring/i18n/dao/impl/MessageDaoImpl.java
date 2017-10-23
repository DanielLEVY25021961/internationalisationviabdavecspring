package com.developpez.hikage.spring.i18n.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.developpez.hikage.spring.i18n.dao.IMessageDao;


/**
 * class MessageDaoImpl :<br/>
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
public class MessageDaoImpl 
	extends JdbcDaoSupport implements IMessageDao {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MessageDaoImpl.class);
	
	// *************************METHODES************************************/	
	
	 /**
	 * method CONSTRUCTEUR MessageDaoImpl() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public MessageDaoImpl() {
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

		final JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		
		if (jdbcTemplate != null) {
			
			final List<String> result 
        	= jdbcTemplate.query(
        			"SELECT texte FROM messages WHERE `key` = ? AND langue = ? and pays = ?"
        				, new Object[]{pCle, pLangue, pPays}
        					, new SingleColumnRowMapper<String>(String.class));
        
	        if (result.size() == 1) {
	        	return result.get(0);
	        }
		}
                
        return null;
        
    } // Fin de getMessage.________________________________________________
	
	
	

    /**
     * {@inheritDoc}
     */
	@Override
    public String getMessage(
    		final String pCle
    			, final String pLangue) {
        
		final JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		
		if (jdbcTemplate != null) {
			
			final List<String> result 
				= jdbcTemplate.query(
					"SELECT texte FROM messages WHERE `key` = ? AND langue = ? and pays is null"
						, new Object[]{pCle, pLangue}
							, new SingleColumnRowMapper<String>(String.class));

	        if (result.size() == 1) {
	        	return result.get(0);
	        }

		}
        
        return null;
        
    } // Fin de getMessage.________________________________________________
	
	
	
} // FIN DE LA CLASSE MessageDaoImpl.----------------------------------------
