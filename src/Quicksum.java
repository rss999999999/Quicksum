/*
For this problem, you will implement a checksum algorithm called Quicksum. A Quicksum packet allows only uppercase letters and spaces. It always begins and ends with an uppercase letter.

        Otherwise, spaces and uppercase letters can occur in any combination, including consecutive spaces.

        A Quicksum is the sum of the products of each character’s position in the packet times the character’s value. A space has a value of zero, while letters have a value equal to their position in the alphabet.

        So, A = 1, B = 2, etc., through Z = 26. Here are example Quicksum calculations for the packets “ACM” and “A C M”:


        ACM
        1 × 1 + 2 × 3 + 3 × 13 = 46

        A C M
        1 x 1 + 3 x 3 + 5 * 13 = 75
        When the packet doesn't have only uppercase letters and spaces or just spaces the result to quicksum have to be zero (0).


        AbqTH #5 = 0
*/

public class Quicksum {
    public int quicksum(String packet){
        int sum = 0;
        //This line starts a for loop that iterates over the characters in the packet string.
        //For example, if the packet string is equal to "ABC", then the value of packet.length() would be 3.
        for (int i = 0; i < packet.length(); i++) {
            //This line checks if the character at index i is a space. If it is, the continue statement skips the rest of the loop and goes to the next iteration.
            if (packet.charAt(i) == ' ') {
                continue;
            }
            //This line checks if the character at index i is not an uppercase letter. If it is not, the method returns 0.
            if (packet.charAt(i) < 'A' || packet.charAt(i) > 'Z') {
                return 0;
            }
            //This line adds the product of the character’s position in the packet times the character’s value to the sum variable.
            sum += (i + 1) * (packet.charAt(i) - 'A' + 1);
            //For example, if the packet string is equal to "ABC" and the current character is 'B', then the quicksum of the current character would be calculated as follows:
            //sum = (i + 1) * (packet.charAt(i) - 'A' + 1)
            //sum = 2 * (66 - 65 + 1)
            //sum = 2 * 2
            //sum = 4
        }
        return sum;
    }
}