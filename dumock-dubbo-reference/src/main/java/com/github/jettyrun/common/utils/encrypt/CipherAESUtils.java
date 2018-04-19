
package com.github.jettyrun.common.utils.encrypt;

import com.github.jettyrun.common.utils.type.StringUtils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



/**
 *
 */
public class CipherAESUtils {

  private String charset = "GBK";
  private SecretKey sk;
  /**
   * AES加密解密算法
   */
  private static final String ALGORITHM = "AES";

  /**
   * AES 秘钥
   */
  private String key;

  /**
   * 初始化AES 上下文
   * @param mode
   */
  private void init(int mode) {
    byte[] keybyte = getKeyByStr(key);
    KeyGenerator keygen=null;
    try{
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
      secureRandom.setSeed(keybyte);
      keygen = KeyGenerator.getInstance(ALGORITHM);
      keygen.init(128, secureRandom);
    }catch (Exception e){
      throw new RuntimeException("初始化keygen失败",e);
    }
    sk = keygen.generateKey();
  }

  /**
   * @param src 加密前数据字节
   * @return
   * @description: AES加密实现
   */
  private byte[] encryptMode(byte[] src) {
    try {
      Cipher cip = Cipher.getInstance(ALGORITHM);
      cip.init(Cipher.ENCRYPT_MODE, sk);
      return cip.doFinal(src);
    } catch (Exception e3) {
      throw new RuntimeException("加密前数据字节",e3);
    }
  }

  /**
   * @param content 加密前数据
   * @return
   * @description: AES加密算法入口
   */
  public String encrypt4Aes(String content) {
    try {
      byte[] src = content.getBytes(charset);
      // 加密
      byte[] bytOut = encryptMode(src);
      return base64encode(bytOut);
    } catch (Exception e3) {
      throw new RuntimeException("加密前数据",e3);
    }

  }

  private byte[] decryptMode(byte[] src) {
    try {
      Cipher cip = Cipher.getInstance(ALGORITHM);
      cip.init(Cipher.DECRYPT_MODE, sk);
      return cip.doFinal(src);
    }catch (Exception e3) {
      throw new RuntimeException("加密前数据",e3);
    }
  }

  private byte[] decrypt4Aes(String contentbase64) {
    try {
      byte[] src = base64decode(contentbase64);
      return decryptMode(src);
    } catch (Exception e3) {
      throw new RuntimeException("加密前数据",e3);
    }
  }

  /**
   * AES算法解密入口
   */
  private String decrypt4Aes2Str(String contentbase64) {
    String result = null;
    try {
      byte[] dst = decrypt4Aes(contentbase64);
      if (null != dst) {
        result = new String(dst, charset);
      }
    }  catch (Exception e3) {
      throw new RuntimeException("解密数据",e3);
    }
    return result;
  }



  private static byte[] getKeyByStr(String str) {
    byte[] bRet = new byte[str.length() / 2];
    for (int i = 0; i < str.length() / 2; i++) {
      Integer itg =
          new Integer(16 * getChrInt(str.charAt(2 * i)) + getChrInt(str.charAt(2 * i + 1)));
      bRet[i] = itg.byteValue();
    }
    return bRet;
  }

  private static int getChrInt(char chr) {
    int iRet = 0;
    if (chr == "0".charAt(0)) iRet = 0;
    if (chr == "1".charAt(0)) iRet = 1;
    if (chr == "2".charAt(0)) iRet = 2;
    if (chr == "3".charAt(0)) iRet = 3;
    if (chr == "4".charAt(0)) iRet = 4;
    if (chr == "5".charAt(0)) iRet = 5;
    if (chr == "6".charAt(0)) iRet = 6;
    if (chr == "7".charAt(0)) iRet = 7;
    if (chr == "8".charAt(0)) iRet = 8;
    if (chr == "9".charAt(0)) iRet = 9;
    if (chr == "A".charAt(0)) iRet = 10;
    if (chr == "B".charAt(0)) iRet = 11;
    if (chr == "C".charAt(0)) iRet = 12;
    if (chr == "D".charAt(0)) iRet = 13;
    if (chr == "E".charAt(0)) iRet = 14;
    if (chr == "F".charAt(0)) iRet = 15;
    return iRet;

  }

  private static String encodeHex(byte[] bytes) {
    StringBuilder buf = new StringBuilder(bytes.length * 2);
    int i;

    for (i = 0; i < bytes.length; i++) {
      if (((int) bytes[i] & 0xff) < 0x10) {
        buf.append("0");
      }
      buf.append(Long.toString((int) bytes[i] & 0xff, 16));
    }
    return buf.toString();
  }



  // 将 s 进行 BASE64 编码
  @SuppressWarnings("restriction")
  private static String base64encode(byte[] src) {
    if (src == null) {
      return null;
    }
    return (new sun.misc.BASE64Encoder()).encode(src);
  }

  // 将 BASE64 编码的字符串 s 进行解码
  @SuppressWarnings("restriction")
  private static byte[] base64decode(String s) {
    if (s == null) {
      return null;
    }
    sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    try {
      return decoder.decodeBuffer(s);
    }  catch (Exception e3) {
      throw new RuntimeException("加密前数据",e3);
    }
  }

  /**
   * 获取加密字符串
   * 
   * @param str 传入要加密的字符串
   * @return String
   */
  public static String getEncrypt4Aes(String str) {
    return getEncrypt4Aes(str,"E64313FD3B98FE5EBCAB7F23ADF94CBDCA294DC5DEF1368E");
  }

  /**
   * 获取解密字符串
   * 
   * @param str 传入要解密的字符串
   * @return String
   */
  public static String getDecrypt4Aes2Str(String str) {
    return getDecrypt4Aes2Str(str, "E64313FD3B98FE5EBCAB7F23ADF94CBDCA294DC5DEF1368E");
  }

  /**
   * 获取加密字符串
   * 
   * @param str 传入要加密的字符串
   * @return String
   */
  public static String getEncrypt4Aes(String str, String privateKey) {
    if (StringUtils.isBlank(str)) {
      return str;
    }
    CipherAESUtils cipherAESUtils = new CipherAESUtils();
    cipherAESUtils.setKey(privateKey);
    try {
      cipherAESUtils.init(Cipher.ENCRYPT_MODE);
    } catch(Exception e){
      throw new RuntimeException("加密失败",e);
    }

    String beforeStr = str;
    return cipherAESUtils.encrypt4Aes(beforeStr);
  }

  /**
   * 获取解密字符串
   * 
   * @param str 传入要解密的字符串
   * @return String
   */
  public static String getDecrypt4Aes2Str(String str, String privateKey) {
    if (StringUtils.isBlank(str)) {
      return str;
    }
    CipherAESUtils cipherAESUtils = new CipherAESUtils();
    cipherAESUtils.setKey(privateKey);
    try {
      cipherAESUtils.init(Cipher.DECRYPT_MODE);
    } catch(Exception e){
      throw new RuntimeException("解密失败",e);
    }
    String encrypt3des = str;
    return cipherAESUtils.decrypt4Aes2Str(encrypt3des);
  }

  private String getKey() {
    return key;
  }

  private void setKey(String key) {
    this.key = key;
  }

  private String getCharset() {
    return charset;
  }

  private void setCharset(String charset) {
    this.charset = charset;
  }



}
