/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        // Replace the following statement with your code
        return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}

		
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}

		return true;
	}

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
		if (arr.length == 0) {
			return -1;
		}

		// Iterate from the start (index 0) to find the first match.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ch) {
				return i;
			}
		}

		// Character not found.
		return -1;
	}

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
		if (arr.length == 0) {
			return -1;
		}
		
		// Note: Per problem instructions, we assume inputs are error-free,
		// so we assume fromIndex is a valid index, but we should not iterate past the end of the array.
		for (int i = fromIndex; i < arr.length; i++) {
			if (arr[i] == ch) {
				return i;
			}
		}

		// Character not found.
		return -1;
	}

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
		if (arr.length == 0) {
			return -1;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == ch) {
				return i;
			}
		}

		return -1;
	}

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        int len1 = arr1.length;
		int len2 = arr2.length;
		
		
		char[] result = new char[len1 + len2];

		// Copy elements of arr1 to the beginning of the result array.
		for (int i = 0; i < len1; i++) {
			result[i] = arr1[i];
		}

		// Copy elements of arr2 to the end of the result array, starting at index len1.
		for (int i = 0; i < len2; i++) {
			result[len1 + i] = arr2[i];
		}

		return result;
	}

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        int newLength = endIndex - beginIndex;

		char[] subArr = new char[newLength];

		for (int i = 0; i < newLength; i++) {
			subArr[i] = arr[beginIndex + i];
		}

		return subArr;
	}

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        int n = arr.length;
		// Handle empty array edge case: the hash value is zero.
		if (n == 0) {
			return 0;
		}

		long hash = 0;
		long powerOf7 = 1;

		for (int i = n - 1; i >= 0; i--) {
			// Cast arr[i] to long before multiplication to prevent overflow if the
			// intermediate result of the term exceeds the range of an int.
			hash += ((long)arr[i] * powerOf7);
			
			// Increment the power of 7 for the next iteration (i-1)
			powerOf7 *= 7;
		}

		return hash;
	}

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
// Since we assume inputs are non-empty and error-free,
		// we don't need to return -2 or check for null/empty.

		int len1 = str1.length();
		int len2 = str2.length();
		int minLen = Math.min(len1, len2);

		// Compare characters up to the length of the shorter string.
		for (int i = 0; i < minLen; i++) {
			char char1 = str1.charAt(i);
			char char2 = str2.charAt(i);

			if (char1 != char2) {
				// Rule 1: Strings differ at this position.
				// The comparison is based on the numeric Unicode values of the characters.
				if (char1 < char2) {
					return -1; // str1 is less than str2
				} else {
					return 1; // str1 is greater than str2
				}
			}
		}

		// All characters up to minLen match. Now, compare lengths.
		if (len1 < len2) {
			// Rule 2: str1 is shorter but is a prefix of str2.
			return -1;
		} else if (len1 > len2) {
			// Rule 2 (reverse): str2 is shorter and is a prefix of str1.
			return 1;
		} else {
			// Rule 3: Lengths are equal, and all characters matched.
			return 0;
		}

    }
}
