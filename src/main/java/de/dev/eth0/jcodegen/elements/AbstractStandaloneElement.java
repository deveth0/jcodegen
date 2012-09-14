//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements;

import de.dev.eth0.jcodegen.elements.interfaces.ComplexElement;
import de.dev.eth0.jcodegen.elements.interfaces.StandaloneElement;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

/**
 * An element whcih can be used as standalone (eg. class, interface or enum)
 * @author deveth0
 * @param <T> 
 */
public abstract class AbstractStandaloneElement<T extends AbstractStandaloneElement>
        extends AbstractBasicElementWithModifier<T> implements ComplexElement, StandaloneElement {

  private String mPackage;
  private String mHeader;
  private Set<String> mImplements = new LinkedHashSet<String>();
  private Set<Field> mFields = new LinkedHashSet<Field>();
  private Set<ComplexElement> mElements = new LinkedHashSet<ComplexElement>();

  public AbstractStandaloneElement(String pPackage, String pType, String pName) {
    this(pPackage, pType, pName, (String[])null);
  }

  public AbstractStandaloneElement(String pPackage, String pType, String pName, String... pImplements) {
    super(pType, pName);
    this.mPackage = pPackage;
    if (pImplements != null && pImplements.length > 0) {
      mImplements.addAll(Arrays.asList(pImplements));
    }
  }

  public AbstractStandaloneElement(String pPackage, java.lang.Class pType, String pName) {
    this(pPackage, pType, pName, (String[])null);
  }

  public AbstractStandaloneElement(String pPackage, java.lang.Class pType, String pName, String... pImplements) {
    super(pType, pName);
    this.mPackage = pPackage;
    if (pImplements != null && pImplements.length >0) {
      mImplements.addAll(Arrays.asList(pImplements));
    }
  }

  public T addField(Field pField) {
    mFields.add(pField);
    return (T)this;
  }

  public Field createField(String pType, String pName) {
    Field ret = new Field(pType, pName);
    mFields.add(ret);
    return ret;
  }

  public Field createField(java.lang.Class pType, String pName) {
    Field ret = new Field(pType, pName);
    mFields.add(ret);
    return ret;
  }

  public Field createField(java.lang.Class pType, String pName, String pValue) {
    Field ret = new Field(pType, pName, pValue);
    mFields.add(ret);
    return ret;
  }

  public Field createField(String pType, String pName, String pValue) {
    Field ret = new Field(pType, pName, pValue);
    this.mFields.add(ret);
    return ret;
  }

  public Set<Field> getFields() {
    return Collections.unmodifiableSet(mFields);
  }

  /**
   * adds an element (e.g. inline classes, methods, ...)
   *
   * @param pElement
   * @return
   */
  public T addElement(ComplexElement pElement) {
    this.mElements.add(pElement);
    return (T)this;
  }

  public Set<ComplexElement> getElements() {
    return Collections.unmodifiableSet(mElements);
  }

  public Set<String> getImplements() {
    return Collections.unmodifiableSet(mImplements);
  }

  public String getPackage() {
    return mPackage;
  }

  public void setCustomHeader(String pHeader) {
    mHeader = pHeader;
  }

  @Override
  public String toString() {
    StringBuilder pStringBuilder = new StringBuilder();
    if (StringUtils.isNotBlank(mHeader)) {
      pStringBuilder.append(mHeader);
      pStringBuilder.append("\n");
    }
    pStringBuilder.append("package ");
    pStringBuilder.append(mPackage);
    pStringBuilder.append(";\n\n");
    pStringBuilder.append(super.toString());
    return pStringBuilder.toString();
  }
}
