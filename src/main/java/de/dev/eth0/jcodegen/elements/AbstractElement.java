//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import java.util.Collection;

/**
 *
 * @author deveth0
 */
public abstract class AbstractElement {

  /**
   * Returns the collection as comma seperated list (a, b, c, d)
   *
   * @param pToAdd
   * @return
   */
  public String getCommaSeperated(Collection pToAdd) {
    StringBuilder sb = new StringBuilder();
    int count = pToAdd.size();
    for (Object obj : pToAdd) {
      if (obj != null) {
        sb.append(obj.toString());
        if (--count > 0) {
          sb.append(",");
        }
        sb.append(" ");
      }
    }
    return sb.toString();
  }
}
