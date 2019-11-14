/**
 * Check is one string is one edit away from another
 * Edit: replace, insert, delete
 */

public class OneEditAway {

    public static void main(String[] args) {
        System.out.println(isOneEditAway("bob", "bub")); // true
        System.out.println(isOneEditAway("boob", "bob")); // true
        System.out.println(isOneEditAway("zoo", "zook")); // true
        System.out.println(isOneEditAway("pale", "bale")); // true
        System.out.println(isOneEditAway("pale", "bae")); // false
    }

    static boolean isOneEditAway(String str1, String str2) {
        // Replace?
        if (str1.length() == str2.length())
            return isOneReplaceAway(str1, str2);
        // Delete?
        if (str1.length() - str2.length() == 1)
            return isOneDeleteAway(str1, str2);
        // Insert? (Reverse of delete)
        if (str2.length() - str1.length() == 1)
            return isOneDeleteAway(str2, str1);
        return false;
    }

    // Str1 and Str2 one replace away
    static boolean isOneReplaceAway(String str1, String str2) {
        boolean diff = false;
        // Cycle str1
        for (int idx = 0; idx < str1.length(); idx++) {
            // If another char found 2 times return false
            if (str1.charAt(idx) != str2.charAt(idx)) {
                if (diff)
                    return false;
                diff = true;
            }
        }
        // If one char diff - return false
        return diff;
    }

    // Str2 is one delete away from Str1
    static boolean isOneDeleteAway(String str1, String str2) {
        // Idx in long str - str1
        int idx1 = 0;
        // Cycle short str - str2
        for (int idx = 0; idx < str2.length(); idx++) {
            // If another char jump to next char in long str
            if (str2.charAt(idx) != str1.charAt(idx1)) {
                idx1++;
                // Not the same char after jump - return false
                if (str2.charAt(idx) != str1.charAt(idx1))
                    return false;
            }
            // Move along str1
            idx1++;
        }
        return true;
    }

}
