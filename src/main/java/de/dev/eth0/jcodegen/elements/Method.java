//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.constants.Modifier;
import de.dev.eth0.jcodegen.elements.interfaces.ComplexElement;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * a Method
 *
 * @author deveth0
 */
public class Method extends AbstractBasicElementWithModifier<Method> implements ComplexElement {

  private final Set<Parameter> mParameter = new LinkedHashSet<Parameter>();
  private final Set<String> mContent = new LinkedHashSet<String>();

  public Method(Class pType, String pName) {
    super(pType, pName);
  }

  public Method(String pType, String pName) {
    super(pType, pName);
  }

  public Method(Class pType, String pName, Parameter... pParameters) {
    this(pType, pName);
    this.mParameter.addAll(Arrays.asList(pParameters));
  }

  public Method(String pType, String pName, Parameter... pParameters) {
    this(pType, pName);
    this.mParameter.addAll(Arrays.asList(pParameters));
  }

  public static Method getGetterMethod(String pType, String pName) {
    Method ret = new Method(pType, "get" + pName);
    ret.addContent("return " + pName + ";");
    ret.addModifier(Modifier.PUBLIC);
    ret.addCommentLine("Returns the value of "+pName);
    ret.addCommentLine("@return "+pName);
    return ret;
  }

  public static Method getGetterMethod(Class pClass, String pName) {
    return Method.getGetterMethod(pClass.getSimpleName(), pName);
  }

  public static Method getGetterMethod(Field pField) {
    return Method.getGetterMethod(pField.getType(), pField.getName());
  }

  public Method addParameter(Parameter pParameter) {
    mParameter.add(pParameter);
    return this;
  }

  public Set<Parameter> getParameters() {
    return mParameter;
  }

  public Method addContent(String pContent) {
    mContent.add(pContent);
    return this;
  }

  public Method addContent(String... pContent) {
    mContent.addAll(Arrays.asList(pContent));
    return this;
  }

  @Override
  protected void printOutElementContent(StringBuilder pStringBuilder) {
    pStringBuilder.append("(");
    int count = mParameter.size();
    for (Parameter parameter : mParameter) {
      pStringBuilder.append(parameter.toString());
      if (--count > 0) {
        pStringBuilder.append(", ");
      }
    }
    pStringBuilder.append(")");
    // if content is available, this is a normal method, otherwise it's a interface declaration
    if (!mContent.isEmpty()) {
      pStringBuilder.append(" {\n");
      for (String line : mContent) {
        pStringBuilder.append(line);
        pStringBuilder.append("\n");
      }
      pStringBuilder.append("}\n");
    }
    else {
      pStringBuilder.append(";\n");
    }
  }
}
