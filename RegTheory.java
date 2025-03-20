package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式实现的原理
 */
public class RegTheory {
    public static void main(String[] args) {
        String content ="a11c8abc abCy ll";
        String regStr1 ="abc";
        //不区分大小写
        String regStr2 ="[abc]";
        Pattern pattern = Pattern.compile(regStr2);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()) {
            System.out.println("找到:>"+ matcher.group(0));
        }
    }
    public static void main2(String[] args) {
        String content ="abc$(abc(123(";
        //匹配(
        String regStr = "\\.";
        Pattern patter = Pattern.compile(regStr);
        Matcher matcher=patter.matcher(content);
        while(matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }
    public static void main1(String[] args) {
        String content ="中国近代史：1911 年 10 月 10 日（武昌起义）," +
                    "1949 年 10 月 1 日（中华人民共和国成立）";
        //匹配所有的四个数字
        //1.\\d表示任意一个数字
        String regStr ="\\d\\d\\d\\d";
        //2.创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);
        //3.创建一个匹配器
        Matcher matcher= pattern.matcher(content);
        //4.开始匹配
        while(matcher.find()) {
            System.out.println("找到: "+matcher.group(0));
        }
    }
}
