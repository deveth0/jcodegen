//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.constants.Modifier;
import de.dev.eth0.jcodegen.elements.interfaces.ComplexElement;
import de.dev.eth0.jcodegen.elements.interfaces.StandaloneElement;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

/**
 * An Enumeration (can be used in classes or stand alone)
 *
 * @author deveth0
 */
public class Enumeration extends AbstractStandaloneElement<Enumeration> implements ComplexElement, StandaloneElement {

  private final Set<EnumerationEntry> mEntries = new LinkedHashSet<EnumerationEntry>();

  /**
   * Basic constructor
   *
   * @param pName
   */
  public Enumeration(String pName) {
    this(null, pName);
  }

  /**
   * Constructor to allow stand alone enumerations with a packagename
   *
   * @param pName
   * @param pPackage
   */
  public Enumeration(String pPackage, String pName) {
    super(pPackage, "enum", pName);
  }

  public Enumeration addEntry(EnumerationEntry pEntry) {
    if (pEntry != null) {
      mEntries.add(pEntry);
    }
    return this;
  }

  public Set<EnumerationEntry> getEntries() {
    return Collections.unmodifiableSet(mEntries);
  }

  @Override
  public String toString() {
    if (StringUtils.isNotBlank(getPackage())) {
      return super.toString();
    }
    else {
      StringBuilder sb = new StringBuilder(super.toString());
      for (Modifier mod : getModifier()) {
        sb.append(mod);
        sb.append(" ");
      }
      if (StringUtils.isNotBlank(getType())) {
        sb.append(getType());
        sb.append(" ");
      }
      sb.append(getName());
      printOutElementContent(sb);
      return sb.toString();
    }
  }

  @Override
  protected void printOutElementContent(StringBuilder pStringBuilder) {
    pStringBuilder.append(" ");
    if (!getImplements().isEmpty()) {
      pStringBuilder.append("implements ");
      pStringBuilder.append(getCommaSeperated(getImplements()));
    }
    pStringBuilder.append("{\n\n");
    if (!mEntries.isEmpty()) {
      int count = mEntries.size();
      for (EnumerationEntry entry : mEntries) {
        pStringBuilder.append(entry);
        if (--count > 0) {
          pStringBuilder.append(",\n");
        }
      }
      pStringBuilder.append(";\n");
    }
    pStringBuilder.append("\n");
    for (Field field : getFields()) {
      pStringBuilder.append(field.toString());
    }
    pStringBuilder.append("\n");
    for (ComplexElement elem : getElements()) {
      pStringBuilder.append(elem);
      pStringBuilder.append("\n");
    }
    pStringBuilder.append("}");
  }
}
