package io.github.sjx233.modoffabric;

import java.util.regex.Pattern;

public enum Of {
  ;
  private static final Pattern PATTERN = Pattern.compile("\\b(\\w+) of (?:the |an? )?(\\w+)\\b");

  public static String transform(String str) {
    return PATTERN.matcher(str).replaceAll("$2 $1");
  }
}
