package lecture4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionAlgorithms {
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list = Arrays.asList(args); // [Aba, baba, Ceba]
    Collections.reverse(list); // [Ceba, baba, Aba]
    Collections.shuffle(list); // [baba, Ceba, Aba]
    Collections.sort(list); // [Aba, Ceba, baba]
    Collections.sort(list, String.CASE_INSENSITIVE_ORDER); // [Aba, baba, Ceba]
    list.sort(String.CASE_INSENSITIVE_ORDER); // [Aba, baba, Ceba]
    Collections.max(list); // baba
    Collections.max(list, String.CASE_INSENSITIVE_ORDER); // Ceba
    Collections.fill(list, "temp"); // [temp, temp, temp]
  }
}
