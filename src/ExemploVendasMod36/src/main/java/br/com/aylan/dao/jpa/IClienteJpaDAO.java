/**
 * 
 */
package br.com.aylan.dao.jpa;

import br.com.aylan.dao.generic.jpa.IGenericJapDAO;
import br.com.aylan.domain.jpa.Persistente;

/**
 * @author aylan
 *
 */
public interface IClienteJpaDAO<T extends Persistente> extends IGenericJapDAO<T, Long>{

}
