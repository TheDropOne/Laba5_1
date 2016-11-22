import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kuryakov on 22-Nov-16.
 */
public class Runner {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[^\\*]?\\*[^\\*]+\\*[^\\*]?");
        String source = "*Wikipedia* is a free online encyclopedia that *allows* its users to edit almost any article.\n" +
                "Wikipedia is the largest and most popular general reference work on the Internet\n" +
                "and is ranked among the *ten most popular* websites. Wikipedia is owned by the nonprofit Wikimedia Foundation.\n" +
                "Wikipedia was launched on January 15, 2001, by Jimmy Wales and Larry Sanger.\n" +
                "Sanger *coined its* name, a *portmanteau* of wiki and encyclopedia. It was only in the English language initially,\n" +
                "but it quickly***developed similar versions *in other languages** which differ in content and in editing practices.\n" +
                "With 5,265,049 articles, English Wikipedia is the largest out of more than 290 versions of encyclopedias on Wikipedia.\n" +
                "Overall, Wikipedia consists of more than 40 *million articles in more* than* **250 different languages\n" +
                "and as of February 2*014*, it had 18 billion *page* views and *nearly* 500 million unique visitors each month.";
        Matcher matcher = pattern.matcher(source);
        while(matcher.find()){
            System.out.println(matcher.group());    
        }
    }

    private static String readStringFromFile(String path) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(new File(path)));
            String tempString = br.readLine();
            while (tempString != null) {
                sb.append(tempString);
                tempString = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Reading from file successfully failed. IOException");
        } finally {
            try {
                br.close();
            } catch (IOException | NullPointerException ex) {
                System.out.println("Stream didn't closed or not exists. Reading from file failed. ");
            }
        }
        return sb.toString();
    }
}
