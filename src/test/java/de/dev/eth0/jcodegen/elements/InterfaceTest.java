//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.Interface;
import org.junit.Test;

/**
 *
 * @author deveth0
 */
public class InterfaceTest {
  
  public InterfaceTest() {
  }
  

  /**
   * Test of printOutElementContent method, of class Interface.
   */
  @Test
  public void testPrintOutElementContent() {
    Interface interf = new Interface("de.dev.eth0.test", "myInterface");
    System.out.println(interf.toString());
  }
}
