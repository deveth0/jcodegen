//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements.interfaces;

import de.dev.eth0.jcodegen.constants.Modifier;
import java.util.Set;

/**
 * Interface for Elements which use modifieres (e.g. public or private)
 * @author deveth0
 */
public interface ElementWithModifier {

  /**
   * Adds a modifier
   *
   * @param pModifier
   * @return the element (this)
   */
  ElementWithModifier addModifier(Modifier pModifier);

  /**
   * returns an unmodifable set with all modifiers
   *
   * @return set with modifiers
   */
  Set<Modifier> getModifier();
}
