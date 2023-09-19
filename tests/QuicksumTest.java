import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.Random;

public class QuicksumTest {
    public static final char[] VALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();
    public static final char[] INVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789\\#\\$\\%\\&\\/\\(\\)\\=\\* ".toCharArray();

    public int solution(String packet){
        int result = 0;
        if(packet.matches("^[A-Z ]+$")){
            char[] packetArray = packet.toCharArray();
            for(int i = 0; i < packetArray.length; i++){
                if((int)packetArray[i] != 32) {
                    result += ((int)packetArray[i] - 64) * ( i + 1 );
                }
            }
        }
        return result;
    }

    @Test
    public void testQuicksumBasic() {
        Quicksum quicksumObject = new Quicksum();
        assertEquals(46,quicksumObject.quicksum("ACM"));
        assertEquals(650,quicksumObject.quicksum("MID CENTRAL"));
        assertEquals(15,quicksumObject.quicksum("BBC"));
        assertEquals(0,quicksumObject.quicksum("???"));
        assertEquals(0,quicksumObject.quicksum("axg"));
        assertEquals(0,quicksumObject.quicksum("234 234 WEF ASDF AAA 554211 ???? "));
        assertEquals(75,quicksumObject.quicksum("A C M"));
        assertEquals(6201,quicksumObject.quicksum("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals(12051,quicksumObject.quicksum("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"));
        assertEquals(848640,quicksumObject.quicksum("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"));
        assertEquals(33,quicksumObject.quicksum("Z     A"));
        assertEquals(0,quicksumObject.quicksum("12312 123 123 asd asd 123 $$$$/()="));
        assertEquals(0,quicksumObject.quicksum("As"));
        assertEquals(0,quicksumObject.quicksum("         "));

    }

    @Test
    public void testQuicksumRandom() {
        Quicksum quicksumObject = new Quicksum();
        String packet = "";
        for(int i = 1; i <= 100; i++){
            packet = (i % 2 == 0) ? validInput() : invalidInput();
            assertEquals(solution(packet),quicksumObject.quicksum(packet));
        }
    }

    public String validInput(){
        String text = "";
        Random randomGenerator = new Random();
        for(int i = 1; i <= randomGenerator.nextInt(100); i++){
            text += VALID[randomGenerator.nextInt(VALID.length)];
        }
        return text;
    }

    public String invalidInput(){
        String text = "";
        Random randomGenerator = new Random();
        for(int i = 1; i <= randomGenerator.nextInt(100); i++){
            text += INVALID[randomGenerator.nextInt(INVALID.length)];
        }
        return text;
    }
}