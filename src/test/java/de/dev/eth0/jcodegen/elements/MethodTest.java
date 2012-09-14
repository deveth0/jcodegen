//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.Method;
import de.dev.eth0.jcodegen.constants.Modifier;
import junit.framework.TestCase;

/**
 *
 * @author deveth0
 */
public class MethodTest extends TestCase {

  public void testPrintOut() {
    Method method = new Method("myClass", "myMethodName");
    method.addModifier(Modifier.PUBLIC);
    assertEquals("public myClass myMethodName();\n", method.toString());
    method.addContent("int i = 0;");
    assertEquals("public myClass myMethodName() {\nint i = 0;\n}\n", method.toString());
  }
}
