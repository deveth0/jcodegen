//$URL$
//$Id$
package de.dev.eth0.jcodegen.writer;

import de.dev.eth0.jcodegen.writer.CodeFormatter;
import de.dev.eth0.jcodegen.constants.Modifier;
import de.dev.eth0.jcodegen.elements.ClassTest;
import de.dev.eth0.jcodegen.elements.Class;
import de.dev.eth0.jcodegen.elements.Method;
import org.junit.Test;

/**
 *
 * @author amuthmann
 */
public class CodeFormatterTest extends ClassTest {

  public CodeFormatterTest() {
  }

  /**
   * Test of format method, of class CodeFormatter.
   */
  @Test
  public void testFormat() {
    Class clazz = new Class(PACKAGE, NAME);
    clazz.addModifier(Modifier.PUBLIC);
    clazz.addField(mField1);
    clazz.addField(mField2);
    clazz.addElement(new Method(NAME, NAME).addContent(PACKAGE));
    CodeFormatter instance = new CodeFormatter();
    String result = instance.format(clazz.toString());
    System.out.println(result);
  }
}
