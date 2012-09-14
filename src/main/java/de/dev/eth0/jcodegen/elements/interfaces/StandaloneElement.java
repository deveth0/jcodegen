//$URL$
//$Id$
package de.dev.eth0.jcodegen.elements.interfaces;

/**
 * Element with a name and package which are required values for a standalone element (e.g. a class or a enum)
 *
 * @author deveth0
 */
public interface StandaloneElement {

  /**
   * Returns the name of the element
   *
   * @return
   */
  String getName();

  /**
   * Returns the package of the element
   *
   * @return
   */
  String getPackage();
  
  /**
   * Sets a custom header entry which is displayed above the package
   * @param pHeader 
   */
  void setCustomHeader(String pHeader);
         
}
