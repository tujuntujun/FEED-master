package com.ruoyi.web.controller.transmessage;



public class StringToHex {

    public static String str2HexStr(String str)
    {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++)
        {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {

/*        String strs[] = {"abc","bcd"};

        for (int i = 0; i < strs.length; i++) {
            String aaa = StringToHex.str2HexStr(strs[i]);
            System.out.println(aaa);
        }*/

        System.out.println(StringToHex.str2HexStr("01"));
    }
}
