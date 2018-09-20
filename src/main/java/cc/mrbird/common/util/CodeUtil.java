package cc.mrbird.common.util;

import java.util.Stack;

/**
 * @author Yxy
 * @date 2018/9/7 18:20
 */
public class CodeUtil {

    private static final String C_CODES_STRING = "123456789ABCDEFGHJKMNPQRSTUVWXYZ";
    /***
     * 将10进制转换为任意进制
     *
     * @param intVal
     * @param base   <=42
     * @return
     */
    public static String int2CodeString(long intVal, int base) {

        int w_code_len = C_CODES_STRING.length();
        if (base > w_code_len) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> s = new Stack<String>();
        while (intVal != 0) {
            s.push(C_CODES_STRING.charAt((int) (intVal % base)) + "");
            intVal /= base;
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        if (sb.length() == 5) {
            sb.insert(0, "L");
        }
        return sb.length() == 0 ? null : sb.toString();
    }

    /***
     * 任何进制转换,
     *
     * @param s
     * @param srcBase  s的进制
     * @param destBase 要转换为的进制
     * @return
     */
    public static String baseConvert(String s, int srcBase, int destBase) {
        if (srcBase == destBase) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (destBase != 10) {//目标进制不是十进制 先转化为十进制
            s = baseConvert(s, srcBase, 10);
        } else {
            long n = 0;
            for (int i = len - 1; i >= 0; i--) {
                n += C_CODES_STRING.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
            }
            return String.valueOf(n);
        }
        return int2CodeString(Integer.valueOf(s), destBase);
    }

    //通过id获得邀请码
    public static String getCodeById(Long id){
        return int2CodeString(id,32);
    }

    //通过邀请码获得用户id
    public static Long getIdByCode(String code){
        code = code.toUpperCase();
        if (code.startsWith("L")) {
            code = code.substring(1);
        }
        return Long.valueOf(baseConvert(code,32,10));
    }

    public static void main(String[]args){
        Long laj74U = getIdByCode("LM3D94");
        System.out.println(laj74U);
    }

}
