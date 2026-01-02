/**
 * 
 */
package br.com.aylan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author aylan
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
	ProdutoServiceTest.class, ProdutoDAOTest.class,
	VendaDAOTest.class})
public class AllTests {

}
