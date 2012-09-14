//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.Constructor;
import de.dev.eth0.jcodegen.elements.Parameter;
import de.dev.eth0.jcodegen.elements.Enumeration;
import de.dev.eth0.jcodegen.elements.EnumerationEntry;
import de.dev.eth0.jcodegen.constants.Modifier;
import junit.framework.TestCase;

/**
 *
 * @author deveth0
 */
public class ClassEnumerationTest extends TestCase {

  public ClassEnumerationTest(String mTestName) {
    super(mTestName);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test of toString method, of class ClassEnumeration.
   */
  public void testToString() {
    Enumeration classEnum = new Enumeration("de.dev.eth0.test", "myEnum");
    classEnum.addModifier(Modifier.PUBLIC);
    classEnum.addEntry(new EnumerationEntry("foo"));
    classEnum.addEntry(new EnumerationEntry("bar"));
    classEnum.addEntry(new EnumerationEntry("bar", "in1", "in2"));
    classEnum.addElement(new Constructor("myEnum", new Parameter("String", "pName")));
    classEnum.addElement(new Constructor("myEnum", new Parameter("String", "pName"), new Parameter("String", "pType")));
    System.out.println(classEnum);
  }
}
