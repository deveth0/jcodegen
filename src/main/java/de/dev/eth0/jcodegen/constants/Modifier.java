//$URL$
//$Id$
package de.dev.eth0.jcodegen.constants;

/**
 * Enumeration with modifiers
 *
 * @author deveth0
 */
public enum Modifier {

  /**
   *
   */
  PUBLIC,
  /**
   *
   */
  PROTECTED,
  /**
   *
   */
  PRIVATE,
  /**
   *
   */
  ABSTRACT,
  /**
   *
   */
  STATIC,
  /**
   *
   */
  FINAL,
  /**
   *
   */
  TRANSIENT,
  /**
   *
   */
  VOLATILE,
  /**
   *
   */
  SYNCHRONIZED,
  /**
   *
   */
  NATIVE,
  /**
   *
   */
  STRICTFP,
  /**
   *
   */
  INTERFACE;

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
