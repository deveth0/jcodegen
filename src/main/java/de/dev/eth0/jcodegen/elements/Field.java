//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import org.apache.commons.lang3.StringUtils;

/**
 * A Field
 *
 * @author deveth0
 */
public class Field extends AbstractBasicElementWithModifier<Field> {

  private String mValue;

  /**
   * Constructor to generate a Field with a type and name
   *
   * @param pType
   * @param pName
   */
  public Field(String pType, String pName) {
    super(pType, pName);
  }

  /**
   * Constructor to generate a Field with a type and name
   *
   * @param pType
   * @param pName
   */
  public Field(Class pType, String pName) {
    super(pType, pName);
  }

  /**
   * Constructor to generate a Field with a type, a name and a value
   *
   * @param pType
   * @param pName
   * @param pValue
   */
  public Field(String pType, String pName, String pValue) {
    this(pType, pName);
    this.mValue = pValue;
  }

  /**
   * Constructor to generate a Field with a type, a name and a value
   *
   * @param pType
   * @param pName
   * @param pValue
   */
  public Field(Class pType, String pName, String pValue) {
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
