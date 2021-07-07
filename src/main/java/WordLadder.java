import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String start = "toon";
        List<String> list = new ArrayList<>();
        list.add("poon");
        list.add("plea");
        list.add("plee");
        list.add("same");
        list.add("poie");
        list.add("plie");
        list.add("poin");

        System.out.println(ladderLength(start,"plea",list));
    }

    private static int ladderLength(String start, String end, List<String> list) {
        //adding all the items of dictonary in hashset
        Set<String> hs = new HashSet(list);
        if(!hs.contains(end))
            return -1;
        Queue<String> q = new LinkedList<>();
        int ladderlen=0;
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            ladderlen += 1;
            //take the first element out of queue
        //    for (int j = 0; j < size; j++) {
                char[] curr = q.poll().toCharArray();
                for (int pos = 0; pos < curr.length; pos++) {
                    //storing the value of char that is going to be manipulated and searched with
                    char temp = curr[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curr[pos] = c;
                        if (String.valueOf(curr).equals(end)) {
                            return ladderlen + 1;
                        }
                        if (!hs.contains(String.valueOf(curr))) {
                            continue;
                        }
                        //if a value exists we remove from dictonary and add to queue
                        hs.remove(String.valueOf(curr));
                        q.add(String.valueOf(curr));
                    }
                    //restoring the value to start with initial string for next position
                    /*eg is start was plea for pos 0 by end if it was zlea for pos 1 we replace z by p and again start with plea*/
                    curr[pos] = temp;
                }
            }
      //  }
        return -1;
    }
}
