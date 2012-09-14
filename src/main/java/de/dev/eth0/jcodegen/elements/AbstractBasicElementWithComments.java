//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract Class for all elements with comments. those are printed out
 *
 * @param <T>
 * @author deveth0
 */
public abstract class AbstractBasicElementWithComments<T extends AbstractBasicElementWithComments> extends AbstractElement {

  private List<String> mComment = new ArrayList<String>();

  /**
   * Add a single line of comment
   *
   * @param pComment
   * @return 
   */
  public T addCommentLine(String pComment) {
    mComment.add(pComment);
    return (T)this;
  }

  /**
   * Returns all lines of comment as unmodifiable List
   *
   * @return
   */
  public List<String> getComments() {
    return Collections.unmodifiableList(mComment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (!mComment.isEmpty()) {
      sb.append("/**\n");
      for (String comment : mComment) {
        sb.append("* ");
        sb.append(comment);
        sb.append("\n");
      }
      sb.append("*/\n");
    }
    return sb.toString();
  }
}
