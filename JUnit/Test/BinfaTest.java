import Binfa.Binfa;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class BinfaTest {
    // példányosítunk egy binfát
    Binfa binfa = new Binfa();

    @ParameterizedTest
    @MethodSource("testMethod")
    public void binTreeProcessTest(String data, double expectedDepth, double expectedAverage, double expectedMean) {
        char[] input = data.toCharArray();

        // végigmegyünk az inputon és lefutattjuk a
        // processBit metódust minden elemen
        for (char c : input) {
            binfa.processBit(c);
        }

        // megnézzük egyezik e a mélység az elvárttal
        Assertions.assertEquals(expectedDepth, binfa.getDepth(), 0.0);

        // megnézzük egyezik e az átlag az elvárttal
        Assertions.assertEquals(expectedAverage, binfa.getAverage(), 0.001);

        // megnézzük egyezik e a medián az elvárttal
        Assertions.assertEquals(expectedMean, binfa.getMean(), 0.0001);
    }

    public static Stream<Arguments> testMethod() {
        return Stream.of(Arguments.of("0011100101010010100",4,3.0,1.0),
                Arguments.of("00101110111001",4.0,2.333,1.5275),
                Arguments.of("011110111110",3.0,2.25,0.9574),
                Arguments.of("111111111111101110",4,4.0,0.0),
                Arguments.of("0101010101010101010101110101010",5.0,3.666,1.5275));
    }

}
