import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.format("Java version: %s%n", getJavaVersion());

        String bn1 = "1", bn2 = "01";
        System.out.format("%s%n", addBinary(bn1, bn2));

        /*
        test #2:
            addBinary("1000110", "110111")
            expected return: "1111101"
         */
        bn1 = "1000110";
        bn2 = "110111";
        System.out.format("%s%n", addBinary(bn1, bn2));

        System.out.format("%s%n", addBinary("1011", "1100"));

    }

    private static String addBinary(String n1, String n2) {

        ArrayList<String> lst1 = new ArrayList<String>(Arrays.asList(n1.split("")));
        ArrayList<String> lst2 = new ArrayList<String>(Arrays.asList(n2.split("")));

        // pad shorter of the two with leading "0"'s
        int diff = 0;
        if (n1.length() > n2.length()) {
            // pad n2 with leading "0"
            diff = n1.length() - n2.length();
            for (int i = 0; i < diff; i++) {
                lst2.add(0, "0");
            }
        } else if (n1.length() < n2.length()) {
            // pad n1 with leading "0
            diff = n2.length() - n1.length();
            for (int i = 0; i < diff; i++) {
                lst1.add(0, "0");
            }
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;

        // Perform bit-by-bit addition from right to left
        for (int i = lst1.size() - 1; i >= 0; i--) {

            int bit1 = Integer.parseInt(lst1.get(i));
            int bit2 = Integer.parseInt(lst2.get(i));

            int sum = bit1 + bit2 + carry;

            carry = sum / 2; // Calculate new carry
            result.append(sum % 2); // Append result bit
        }

        // If there's a carry left, append it
        if (carry != 0) {
            result.append(carry);
        }

        // Reverse the result to get the correct binary sum
        return result.reverse().toString();
    }

    /**
     * get the java version that is running the current program
     *
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion() {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }

}
