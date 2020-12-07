import Binfa.Binfa;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinfaTest {
    // példányosítunk egy binfát
    Binfa binfa = new Binfa();

    @Test
    public void binTreeProcessTest() {
        char[] input = "0011100101010010100".toCharArray();

        // végigmegyünk az inputon és lefutattjuk a
        // processBit metódust minden elemen
        for (char c : input) {
            binfa.processBit(c);
        }

        // megnézzük egyezik e a mélység az elvárttal
        assertEquals(4, binfa.getDepth(), 0.0);

        // megnézzük egyezik e az átlag az elvárttal
        assertEquals(3.0, binfa.getAverage(), 0.001);

        // megnézzük egyezik e a medián az elvárttal
        assertEquals(1.0, binfa.getMean(), 0.0001);
    }
}
