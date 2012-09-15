//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

/**
 * A single parameter
 *
 * @author deveth0
 */
public class Parameter {

  private final String mType;
  private final String mName;

  /**
   * Constructor to create a Parameter with the given name and type
   *
   * @param pName
   * @param pType
   */
  public Parameter(String pType, String pName) {
    this.mType = pType;
    this.mName = pName;
  }

  /**
   * Constructor to create a Parameter with the given name and type
   *
   * @param pName
   * @param pType
   */
  public Parameter(Class pType, String pName) {
    this.mType = pType.getSimpleName();
    this.mName = pName;
  }

  /**
   * Returns the type of the parameter
   *
   * @return
   */
  public String getType() {
    return mType;
  }

  /**
   * Returns the name of he parameter
   *
   * @return
   */
  public String getName() {
    return mName;
  }

  @Override
  public String toString() {
    return mType + " " + mName;
  }
}
