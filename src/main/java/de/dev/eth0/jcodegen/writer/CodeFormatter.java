//$URL$
//$Id$
package de.dev.eth0.jcodegen.writer;

import org.apache.commons.lang3.StringUtils;

/**
 * Helper class to format code. Basically it counts the opening and closing brackets and adds blank spaces before the code
 *
 * @author deveth0
 */
public class CodeFormatter {

  private String mLineIndent = "  ";

  /**
   * Sets the number of blank spaces in front of the code. Default: 2
   * @param pCount 
   */
  public void setLineIndent(int pCount) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pCount; i++) {
      sb.append(" ");
    }
    mLineIndent = sb.toString();
  }

  /**
   * Returns the given code in a formated version
   * @param pUnformatedCode
   * @return formated code
   */
  public String format(String pUnformatedCode) {
    if (StringUtils.isBlank(pUnformatedCode)) {
      throw new IllegalArgumentException();
    }
    // Split up code in multiple lines and process those
    String[] lines = pUnformatedCode.split("\n");

    String[] formated = new String[lines.length];
    // We have to count all "{" for line indent
    int countBracket = 0;
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      countBracket -= StringUtils.countMatches(line, "}");
      formated[i] = getIndent(countBracket) + line;
      countBracket += StringUtils.countMatches(line, "{");
    }
    return StringUtils.join(formated, "\n");
  }

  private String getIndent(int pCount) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pCount; i++) {
      sb.append(mLineIndent);
    }
    return sb.toString();
  }
}
