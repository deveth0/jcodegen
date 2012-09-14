//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.constants.Modifier;

/**
 * a Constructor
 *
 * @author deveth0
 */
public class Constructor extends Method {

  public Constructor(String pName) {
    this(pName, Modifier.PUBLIC);
  }

  public Constructor(String pName, Parameter... pParameters) {
    this(pName, Modifier.PUBLIC, pParameters);
  }

  public Constructor(String pName, Modifier pModifier) {
    super((String)null, pName);
    this.addModifier(pModifier);
  }

  public Constructor(String pName, Modifier pModifier, Parameter... pParameters) {
    super((String)null, pName, pParameters);
    this.addModifier(pModifier);
  }
}