package com.wechat.util;

import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Author: zhengyw
 * @Date: 2018/2/7 16:12
 * @Version: 1.0
 */
public class EmojiDealUtil extends EmojiParser{

    /**
     * 获取非表情字符串
     * @param input
     * @return
     */
    public static String getNonEmojiString(String input) {
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
        for (UnicodeCandidate candidate : replacements) {
            sb.append(input.substring(prev, candidate.getEmojiStartIndex()));
            prev = candidate.getFitzpatrickEndIndex();
        }
        return sb.append(input.substring(prev)).toString();
    }

    /**
     * 获取表情字符串
     * @param input
     * @return
     */
    public static String getEmojiUnicodeString(String input){
        EmojiTransformer transformer = new EmojiTransformer() {
            public String transform(UnicodeCandidate unicodeCandidate) {
                return unicodeCandidate.getEmoji().getHtmlHexadecimal();
            }
        };
        StringBuilder sb = new StringBuilder();
        List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
        for (UnicodeCandidate candidate : replacements) {
            sb.append(transformer.transform(candidate));
        }
        return  parseToUnicode(sb.toString());
    }

    public static String getUnicode(String source){
        String returnUniCode=null;
        String uniCodeTemp=null;
        for(int i=0;i<source.length();i++){
            uniCodeTemp = "\\u"+Integer.toHexString((int)source.charAt(i));
            returnUniCode=returnUniCode==null?uniCodeTemp:returnUniCode+uniCodeTemp;
        }
        return returnUniCode;
    }
    /**
     * 将字符串转换为html数据存入数据库
     * @param emoji 要转换的字符串，可以包含或不包括表情包
     * @return
     */
    public String changeEmojiToHtml(String emoji){
        if(StringUtils.isNotBlank(EmojiDealUtil.getEmojiUnicodeString(emoji))){
            String hexadecimal = EmojiParser.parseToHtmlHexadecimal(emoji);
            System.out.println(hexadecimal);
            /*String interactContent = EmojiParser.parseToUnicode(hexadecimal);
            System.out.println(interactContent);*/
            return hexadecimal;
        }else {
            return emoji;
        }
    }
    /**
     * 将表情包还原
     * @param string
     * @return
     */
    public String changeStrToEmoji(String string){
        return EmojiParser.parseToUnicode(string);
    }

    public static void main(String[] args) {
       if(StringUtils.isNotBlank(EmojiDealUtil.getEmojiUnicodeString("topicContentto腐败picContent腐败\uD83D\uDE0A"))){
            String hexadecimal = EmojiParser.parseToHtmlHexadecimal("☜L\uE022VE☞ ☜若☞");
//            String hexadecimal = EmojiParser.parseToHtmlHexadecimal("\uD83D\uDCAD");
            System.out.println(hexadecimal);
            System.out.println(EmojiParser.parseToUnicode(hexadecimal));
            String interactContent = EmojiParser.parseToUnicode("ZYW\uD83D\uDC7F\uD83D\uDE02\uD83D\uDE02");
            System.out.println(interactContent);
            System.out.println(EmojiParser.parseToAliases("ZYW\uD83D\uDC7F\uD83D\uDE02\uD83D\uDE02"));
            System.out.println(EmojiParser.parseToHtmlDecimal("ZYW\uD83D\uDC7F\uD83D\uDE02\uD83D\uDE02"));
            System.out.println(EmojiParser.parseToHtmlHexadecimal("ZYW\uD83D\uDC7F\uD83D\uDE02\uD83D\uDE02"));

        }
    }
}
