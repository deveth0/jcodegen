//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * An entry for an enumeration
 */
public class EnumerationEntry extends AbstractBasicElementWithComments<EnumerationEntry> {

  private final List<Object> mParameters = new ArrayList<Object>();
  private final String mName;

  public EnumerationEntry(String pName) {
    this.mName = pName;
  }

  public EnumerationEntry(String pName, Object... pParameters) {
    this(pName);
    this.mParameters.addAll(Arrays.asList(pParameters));
  }

  /**
   * Adds a single parameter
   *
   * @param pParameter
   * @return
   */
  public EnumerationEntry addParameter(Object pParameter) {
    if (pParameter != null) {
      mParameters.add(pParameter);
    }
    return this;
  }

  public EnumerationEntry addParameter(String pParameter) {
    if (pParameter != null) {
      mParameters.add("\"" + pParameter + "\"");
    }
    return this;
  }

  public List<Object> getParameters() {
    return Collections.unmodifiableList(mParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append(mName.toUpperCase());
    if (!mParameters.isEmpty()) {
      sb.append("(");
      int count = mParameters.size();
      for (Object param : mParameters) {
        sb.append(param.toString());
        if (--count > 0) {
          sb.append(", ");
        }
      }
      sb.append(")");
    }
    return sb.toString();
  }
}
