package io.github.sjx233.modoffabric;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public enum Of {
  ;
  private static final Pattern PHRASE_PATTERN = Pattern.compile("\\b\\S+(?: of (?:the |an? )?\\S+)+\\b");
  private static final Pattern OF_PATTERN = Pattern.compile(" of (?:the |an? )?");
  private static final Joiner SPACE_JOINER = Joiner.on(' ');

  public static String transform(String str) {
    return PHRASE_PATTERN.matcher(str).replaceAll(match -> SPACE_JOINER.join(Lists.reverse(Arrays.asList(OF_PATTERN.split(match.group())))));
  }
}
