public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
// Handle the empty string edge case
        if (str.isEmpty()) {
            return "";
        }
        
        String newStr = "";
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                char lowerCh = (char)(ch + ('a' - 'A'));
                newStr += lowerCh;
            } else {
                newStr += ch;
            }
        }
        
        return newStr;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        if (len2 == 0) {
            return true;
        }

        if (len2 > len1) {
            return false;
        }
        for (int i = 0; i <= len1 - len2; i++) {
            boolean match = true;
            
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    match = false;
                    break; 
                }
            }
            
            if (match) {
                return true;
            }
        }

        return false;
    }
}
