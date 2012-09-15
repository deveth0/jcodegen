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

  public Parameter(String pType, String pName) {
    this.mType = pType;
    this.mName = pName;
  }

  public Parameter(Class pType, String pName) {
    this.mType = pType.getSimpleName();
    this.mName = pName;
  }

  public String getType() {
    return mType;
  }

  public String getName() {
    return mName;
  }

  @Override
  public String toString() {
    return mType + " " + mName;
  }
}
