//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import org.apache.commons.lang.StringUtils;

/**
 * A Field
 *
 * @author deveth0
 */
public class Field extends AbstractBasicElementWithModifier<Field> {

  private String mValue;

  public Field(String pType, String pName) {
    super(pType, pName);
  }

  public Field(java.lang.Class pType, String pName) {
    super(pType, pName);
  }

  public Field(String pType, String pName, String pValue) {
    this(pType, pName);
    this.mValue = pValue;
  }

  public Field(java.lang.Class pType, String pName, String pValue) {
    this(pType, pName);
    this.mValue = pValue;
  }

  @Override
  protected void printOutElementContent(StringBuilder pStringBuilder) {
    if (StringUtils.isNotBlank(mValue)) {
      pStringBuilder.append(" = ");
      pStringBuilder.append(mValue);
    }
    pStringBuilder.append(";\n");
  }
}
