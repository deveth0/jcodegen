//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.Field;
import de.dev.eth0.jcodegen.elements.JavaClass;
import de.dev.eth0.jcodegen.constants.Modifier;
import junit.framework.TestCase;

/**
 *
 * @author deveth0
 */
public class ClassTest extends TestCase {

  protected static final String PACKAGE = "de.dev.eth0.codegenerator.test";
  protected static final String NAME = "TestClass";
  protected static final String EXTENDS = "AbstractElement";
  protected static final String[] IMPLEMENTS = {"Class1", "Class2"};
  protected Field mField1;
  protected Field mField2;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    mField1 = new Field("mTest", "String");
    mField1.addModifier(Modifier.PUBLIC);
    mField2 = new Field("mTest2", "Field");
    mField2.addModifier(Modifier.PRIVATE);
    mField2.addModifier(Modifier.STATIC);
    mField2.addModifier(Modifier.FINAL);
  }

  public void testClass() {
    JavaClass clazz = new JavaClass(PACKAGE, NAME);
    clazz.addModifier(Modifier.PUBLIC);
    assertEquals("package " + PACKAGE + ";\n\n"
            + "public class " + NAME + " {\n"
            + "\n\n}\n", clazz.toString());
  }

  public void testClassWithExtends() {
    JavaClass clazz = new JavaClass(PACKAGE, NAME, EXTENDS);
    clazz.addModifier(Modifier.PUBLIC);
    assertEquals("package " + PACKAGE + ";\n\n"
            + "public class " + NAME + " extends " + EXTENDS + " {\n"
            + "\n\n}\n", clazz.toString());
  }

  public void testClassWithImplements() {
    JavaClass clazz = new JavaClass(PACKAGE, NAME, null, IMPLEMENTS);
    clazz.addModifier(Modifier.PUBLIC);
    assertEquals("package " + PACKAGE + ";\n\n"
            + "public class " + NAME + " implements "
            + IMPLEMENTS[0] + ", " + IMPLEMENTS[1] + " {\n"
            + "\n\n}\n", clazz.toString());
  }

  public void testClassWithExtendsAndImplements() {
    JavaClass clazz = new JavaClass(PACKAGE, NAME, EXTENDS, IMPLEMENTS);
    clazz.addModifier(Modifier.PUBLIC);
    assertEquals("package " + PACKAGE + ";\n\n"
            + "public class " + NAME + " extends " + EXTENDS + " implements "
            + IMPLEMENTS[0] + ", " + IMPLEMENTS[1] + " {\n"
            + "\n\n}\n", clazz.toString());
  }

  public void testClassWithFields() {
    JavaClass clazz = new JavaClass(PACKAGE, NAME);
    clazz.addModifier(Modifier.PUBLIC);
    clazz.addField(mField1);
    clazz.addField(mField2);
    assertEquals("package " + PACKAGE + ";\n\n"
            + "public class " + NAME + " {\n\n"
            + mField1.toString() + mField2.toString()
            + "\n}\n", clazz.toString());
  }
}
