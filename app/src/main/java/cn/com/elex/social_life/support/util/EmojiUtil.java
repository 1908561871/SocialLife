package cn.com.elex.social_life.support.util;

/**
 * Created by zhangweibo on 2015/11/12.
 */
public class EmojiUtil {

    public static final int INT = 2;

   /* public static String UnicodeToGBK2(String s) {
        String[] k = s.split(";");
        String rs = "";
        for (int i = 0; i < k.length; i++) {
            int strIndex = k.indexOf("&#");
            String newstr = k;
            if (strIndex > -1) {
                String kstr = "";
                if (strIndex > 0) {
                    kstr = newstr.substring(0, strIndex);
                    rs += kstr;
                    newstr = newstr.substring(strIndex);
                }
                int m = Integer.parseInt(newstr.replace("&#", ""));
                char c = (char) m;
                rs += c;
            } else {
                rs += k;
            }
        }
        return rs;
    }
*/


    public static String FilterHtml(String str) {
        str = str.replaceAll("<(?!br|img)[^>]+>", "").trim();
        return str;
    }
}
