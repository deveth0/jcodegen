//$URL$
//$Id$
package de.dev.eth0.jcodegen.writer;

import de.dev.eth0.jcodegen.elements.interfaces.StandaloneElement;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang.StringUtils;

/**
 * Class to write out standalone elements to a file
 *
 * @author deveth0
 */
public class FileWriter {

  /**
   * Options for the Filewriter
   */
  public enum Options {

    /**
     * Just writeout plain
     */
    PLAIN,
    /**
     * Try to format code
     */
    FORMATED
  }

  /**
   * Writes out the given Element to the target path
   * @param pPath
   * @param pElement
   * @throws IOException
   */
  public static void writeOut(String pPath, StandaloneElement pElement) throws IOException {
    writeOut(pPath, pElement, Options.PLAIN);
  }

  /**
   * Writes out the given Element to the target path and processes the given {@link Options}
   * @param pPath
   * @param pElement
   * @param pOption
   * @throws IOException
   */
  public static void writeOut(String pPath, StandaloneElement pElement, Options pOption) throws IOException {
    if (pElement == null || StringUtils.isBlank(pElement.getName()) || StringUtils.isBlank(pElement.getPackage())) {
      throw new IllegalArgumentException();
    }
    File f = new File(pPath + "/" + pElement.getPackage().replace('.', '/') + "/" + pElement.getName() + ".java");
    f.getParentFile().mkdirs();
    f.createNewFile();
    java.io.FileWriter writer = new java.io.FileWriter(f);

    String writeout;
    switch (pOption) {
      case FORMATED:
        CodeFormatter cf = new CodeFormatter();
        writeout = cf.format(pElement.toString());
        break;
      case PLAIN:
      default:
        writeout = pElement.toString();
    }

    writer.write(writeout);
    writer.close();
  }
}
