/*
  IP address e.g 192.168.1.1. If the Dots are not entered, then there could be several combinations of IP addresseses given a 
   String
   Rules : If a o appears it can only be the First decimal ( decimal being any number betwenn 0 and 255)
         so 0.10.34.11 is valid. but not 01.23.10.34
         Performance O(1) since the number of IP addresses is constant and is Math,pow(2,32) and so  time complex is O(1)
*/

package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.EpiTestComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class ValidIpAddresses {
  @EpiTest(testDataFile = "valid_ip_addresses.tsv")

  public static List<String> getValidIpAddress(String s) {

    List<String> result = new ArrayList<>();
    for (int i = 1; i < 4 && i < s.length(); ++i) {
      final String first = s.substring(0, i);
      if (isValidPart(first)) {
        for (int j = 1; i + j < s.length() && j < 4; ++j) {
          final String second = s.substring(i, i + j);
          if (isValidPart(second)) {
            for (int k = 1; i + j + k < s.length() && k < 4; ++k) {
              final String third = s.substring(i + j, i + j + k);
              final String fourth = s.substring(i + j + k);
              if (isValidPart(third) && isValidPart(fourth)) {
                result.add(first + "." + second + "." + third + "." + fourth);
              }
            }
          }
        }
      }
    }
    return result;
  }

  private static boolean isValidPart(String s) {
    if (s.length() > 3) {
      return false;
    }
    // "00", "000", "01", etc. are not valid, but "0" is valid.
    if (s.startsWith("0") && s.length() > 1) {
      return false;
    }
    int val = Integer.parseInt(s);
    return val <= 255 && val >= 0;
  }

  @EpiTestComparator
  public static BiPredicate<List<String>, List<String>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ValidIpAddresses.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
