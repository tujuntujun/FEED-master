package com.ruoyi.web.controller.transmessage;

public class HexToString {
    public static String hexStr2Str(String hexStr)
    {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;

        for (int i = 0; i < bytes.length; i++)
        {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

/*    public static void main(String[] args){
*//*        String strs[] = {"61","62"};
        for (int i = 0; i < strs.length; i++) {*//*
        System.out.println(HexToString.hexStr2Str("61"));
        }*/

}
