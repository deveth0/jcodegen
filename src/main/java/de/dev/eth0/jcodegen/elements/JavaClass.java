//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.interfaces.ComplexElement;
import org.apache.commons.lang.StringUtils;

/**
 * A class
 *
 * @author deveth0
 */
public class JavaClass extends AbstractStandaloneElement<JavaClass> implements ComplexElement {

  private String mExtends;

  public JavaClass(String pPackage, String pName) {
    this(pPackage, pName, null, (String[])null);
  }

  public JavaClass(String pPackage, String pName, String pExtends) {
    this(pPackage, pName);
    this.mExtends = pExtends;
  }

  public JavaClass(String pPackage, String pName, String pExtends, String... pImplements) {
    super(pPackage, "class", pName, pImplements);
    this.mExtends = pExtends;
  }

  @Override
  protected void printOutElementContent(StringBuilder pStringBuilder) {
    pStringBuilder.append(" ");
    if (StringUtils.isNotBlank(mExtends)) {
      pStringBuilder.append("extends ");
      pStringBuilder.append(mExtends);
      pStringBuilder.append(" ");
    }
    if (!getImplements().isEmpty()) {
      pStringBuilder.append("implements ");
      pStringBuilder.append(getCommaSeperated(getImplements()));
    }
    pStringBuilder.append("{\n\n");
    for (Field field : getFields()) {
      pStringBuilder.append(field.toString());
    }
    pStringBuilder.append("\n");
    for (ComplexElement elem : getElements()) {
      pStringBuilder.append(elem.toString());
      pStringBuilder.append("\n");
    }
    pStringBuilder.append("}\n");
  }
}
