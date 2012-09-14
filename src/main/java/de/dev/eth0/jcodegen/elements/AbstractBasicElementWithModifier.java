//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.interfaces.ElementWithModifier;
import de.dev.eth0.jcodegen.constants.Modifier;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

/**
 * Abstract Element with modifier and comment
 *
 * @param <T> 
 * @author deveth0
 */
public abstract class AbstractBasicElementWithModifier<T extends AbstractBasicElementWithModifier>
        extends AbstractBasicElementWithComments<T> implements ElementWithModifier {

  private Set<Modifier> mModifier = new LinkedHashSet<Modifier>();
  private final String mName;
  private final String mType;

  public AbstractBasicElementWithModifier(String pType, String pName) {
    this.mName = pName;
    this.mType = pType;
  }

  public AbstractBasicElementWithModifier(java.lang.Class pType, String pName) {
    this.mType = pType.getSimpleName();
    this.mName = pName;
  }

  @Override
  public T addModifier(Modifier pModifier) {
    mModifier.add(pModifier);
    return (T)this;
  }

  public Set<Modifier> getModifier() {
    return Collections.unmodifiableSet(mModifier);
  }

  public String getName() {
    return mName;
  }

  public String getType() {
    return mType;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    for (Modifier mod : getModifier()) {
      sb.append(mod);
      sb.append(" ");
    }
    if (StringUtils.isNotBlank(mType)) {
      sb.append(mType);
      sb.append(" ");
    }
    sb.append(mName);
    printOutElementContent(sb);
    return sb.toString();
  }

  /**
   * Prints out element specific content. Usually this is after the comments and modifiers.
   *
   * @param pStringBuilder
   */
  protected abstract void printOutElementContent(StringBuilder pStringBuilder);
}
