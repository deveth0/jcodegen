//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.Field;
import de.dev.eth0.jcodegen.constants.Modifier;
import junit.framework.TestCase;

/**
 *
 * @author deveth0
 */
public class FieldTest extends TestCase {

  public void testPrintOut() {
    Field field = new Field("myClass", "myName");
    field.addModifier(Modifier.PRIVATE);
    field.addModifier(Modifier.FINAL);
    assertEquals("private final myClass myName;\n", field.toString());
    field.addModifier(Modifier.STATIC);
    assertEquals("private final static myClass myName;\n", field.toString());
    field.addCommentLine("Test comment");
    assertEquals("/**\n* Test comment\n*/\nprivate final static myClass myName;\n", field.toString());
  }
}
