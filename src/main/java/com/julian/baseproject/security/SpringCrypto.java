package com.julian.baseproject.security;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class SpringCrypto {

  private static final String SALT = "2fa9ecbb0a3388a9";
  private static final String SAFE_STRING = "ff95f85b2e5d6d7a7421c74d1078049a6bb7a0adb4c36aa3fbf23fb";

  private SpringCrypto() {
    throw new IllegalStateException("This should not be implemented.");
  }

  public static String encrypt(String textToEncrypt) {
    if (textToEncrypt == null) {
      throw new IllegalStateException("Text to encrypt cannot be null.");
    } else {
      TextEncryptor encryptor = Encryptors.text(
          "ff95f85b2e5d6d7a7421c74d1078049a6bb7a0adb4c36aa3fbf23fb", "2fa9ecbb0a3388a9");
      return encryptor.encrypt(textToEncrypt);
    }
  }

  public static String decrypt(String encryptedText) {
    if (encryptedText == null) {
      throw new IllegalStateException("Text to decrypt cannot be null.");
    } else {
      TextEncryptor decryptor = Encryptors.text(
          "ff95f85b2e5d6d7a7421c74d1078049a6bb7a0adb4c36aa3fbf23fb", "2fa9ecbb0a3388a9");
      return decryptor.decrypt(encryptedText);
    }
  }
}