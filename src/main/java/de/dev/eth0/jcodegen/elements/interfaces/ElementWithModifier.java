//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements.interfaces;

import de.dev.eth0.jcodegen.constants.Modifier;
import java.util.Set;

/**
 *
 * @author deveth0
 */
public interface ElementWithModifier {

  /**
   * Adds a modifier
   *
   * @param pModifier
   * @return 
   */
  ElementWithModifier addModifier(Modifier pModifier);

  /**
   * returns an unmodifable set with all modifiers
   *
   * @return set with modifiers
   */
  Set<Modifier> getModifier();
}
