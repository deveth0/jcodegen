//$URL$
//$Id$
package de.dev.eth0.jcodegen.writer;

import org.apache.commons.lang.StringUtils;

/**
 * Helper class to format code
 *
 * @author deveth0
 */
public class CodeFormatter {

  private String mLineIndent = "  ";

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
    String ret = "";
    for (int i = 0; i < pCount; i++) {
      ret += mLineIndent;
    }
    return ret;
  }
}
