package arrays;

public class OneAway {
    public boolean oneEditAway(String first, String second) {
        if(first.length() == second.length())
            return oneEditReplace(first, second);
        else if(first.length() + 1 == second.length())
            return oneEditInsert(first, second);
        else
            return oneEditInsert(second, first);
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(foundDifference)
                    return false;
                foundDifference = true;
            }
        }

        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        // idea here is we're going to scan both strings.
        // if we skip over one of the bigger string's character and they're still equal, then it's just an insertion away.
        // if we find another difference after skipping over one of the bigger string's character, then there's too many edits

        while(index1 < s1.length() && index2 < s2.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if(index1 != index2)
                    return false;

                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.println("Pale & ple are one edit away: " + oneAway.oneEditAway("pale", "ple"));
    }
}
