//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.interfaces.ComplexElement;
import de.dev.eth0.jcodegen.elements.interfaces.StandaloneElement;

/**
 * An Interface (NOT IMPLEMENTED YET!)
 *
 * @author deveth0
 */
public class Interface extends AbstractBasicElementWithModifier<JavaClass> implements ComplexElement, StandaloneElement {

  private String mPackage;
  private String mExtends;
  private String mHeader;

  public Interface(String pPackage, String pName) {
    super("interface", pName);
    this.mPackage = pPackage;
  }

  public Interface(String pPackage, String pName, String pExtends) {
    this(pPackage, pName);
    this.mExtends = pExtends;
  }

  @Override
  protected void printOutElementContent(StringBuilder pStringBuilder) {
    pStringBuilder.append("interface");
  }

  public String getPackage() {
    return mPackage;
  }

  public void setCustomHeader(String pHeader) {
    mHeader = pHeader;
  }
}
