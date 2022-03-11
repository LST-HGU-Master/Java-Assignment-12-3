import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

public class TestDNA {

    @Test
    public void testGetDistance()
    {
        // action
        DNA dna = new DNA();
        dna.str = "AAAAGT";

        // assertion
        assertEquals(4, dna.getLevenshteinDistance("AACTGTGA"));
        assertEquals(9, dna.getLevenshteinDistance("AACTGTGAGGGAA"));
    }
}
