import Binfa.Binfa;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinfaTest {
    Binfa binfa = new Binfa();


    @Test
    public void processBitTest() {
        for (char c : "01111001001001000111".toCharArray()) {
            binfa.processBit(c);
        }


        assertEquals(4, binfa.getDepth(), 0.0);

        assertEquals(2.75, binfa.getAverage(), 0.001);

        assertEquals(0.957427, binfa.getMean(), 0.0001);
    }
}
