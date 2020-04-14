package util;

/**
 * @author dunant
 */
public class StringUtil {
    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if (str==null || "".equals(str.trim())){
            return true;
        }else {return false;}
    }


    public static boolean isEmmpty(char[] str){
        if (str==null || "".equals(str)){
            return true;
        }else {return false;}
    }


}
