//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.constants.Modifier;

/**
 * A constructor. This is mainly a extended method
 *
 * @author deveth0
 */
public class Constructor extends Method {

  /**
   * Constructor for a public constructor
   *
   * @param pName
   */
  public Constructor(String pName) {
    this(pName, Modifier.PUBLIC);
  }

  /**
   * Constructor for a public constructor with the given parameters
   *
   * @param pName
   * @param pParameters
   */
  public Constructor(String pName, Parameter... pParameters) {
    this(pName, Modifier.PUBLIC, pParameters);
  }

  /**
   * Constructor with a given modifier
   *
   * @param pName
   * @param pModifier
   */
  public Constructor(String pName, Modifier pModifier) {
    super((String) null, pName);
    this.addModifier(pModifier);
  }

  /**
   * Constructor for a constructor with the given modifier and parameters
   *
   * @param pName
   * @param pModifier
   * @param pParameters
   */
  public Constructor(String pName, Modifier pModifier, Parameter... pParameters) {
    super((String) null, pName, pParameters);
    this.addModifier(pModifier);
  }
}