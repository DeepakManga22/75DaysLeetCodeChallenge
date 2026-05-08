class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Build frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Count initial matches
        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {

            // If all 26 characters match
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(right) - 'a';
            s2Count[index]++;

            // Update matches after adding character
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            // Remove left character
            index = s2.charAt(left) - 'a';
            s2Count[index]--;

            // Update matches after removing character
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}