import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220707)
 *  注意）このテストコードは DNAクラスに課題12-1のコード と getLevenshteinDistance()が定義されるまでエラーとなる
 */
public class TestDNA {

    @Test
    public void testGetDistance()
    {
        // action
        DNA dna = new DNA();
        dna.str = "AAAAGT";

        // assertion
        assertEquals(4, dna.getLevenshteinDistance("AACTGTGA"),"getLevenshteinDistance()の出力が不正です!1");
        assertEquals(9, dna.getLevenshteinDistance("AACTGTGAGGGAA"),"getLevenshteinDistance()の出力が不正です!2");
    }

    @Test
    public void testGetDistancePrint1()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos;
        StandardInputStream in = new StandardInputStream();
        System.setIn(in);
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        
        // action
        DNA dna = new DNA();
        dna.str = "AAGT";
        dna.getLevenshteinDistance("AACTGA");
        // undo the binding in System
        System.setOut(originalOut);
        
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);
        try {
            assertTrue(prints[0].contains(" 0  1  2  3  4  5  6"), "int型二次元配列dの初期化が疑似コードと異なります!");
            assertTrue(prints[1].contains(" 1  0  0  0  0  0  0"),"int型二次元配列dの初期化が疑似コードと異なります!");
            assertTrue(prints[2].contains(" 2  0  0  0  0  0  0"),"int型二次元配列dの初期化が疑似コードと異なります!");
            assertTrue(prints[3].contains(" 3  0  0  0  0  0  0"),"int型二次元配列dの初期化が疑似コードと異なります!");
            assertTrue(prints[4].contains(" 4  0  0  0  0  0  0"),"int型二次元配列dの初期化が疑似コードと異なります!");
            assertEquals("", prints[5],"int型二次元配列dの初期化表示の直下に改行以外の文字があります!");
        } catch (ArrayIndexOutOfBoundsException excpt) {
                fail("DNA.getLevenshteinDistance()のprint出力が不足しています!");
        }
    }

    @Test
    public void testGetDistancePrint2()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos;
        StandardInputStream in = new StandardInputStream();
        System.setIn(in);
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        
        // action
        DNA dna = new DNA();
        dna.str = "AAGT";
        dna.getLevenshteinDistance("AACTGA");
        // undo the binding in System
        System.setOut(originalOut);
        
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);
        try {
            assertTrue(prints[6].contains(" 0  1  2  3  4  5  6"),"d[i][j]の計算に間違いがあります!");
            assertTrue(prints[7].contains(" 1  0  1  2  3  4  5"),"d[i][j]の計算に間違いがあります!");
            assertTrue(prints[8].contains(" 2  1  0  1  2  3  4"),"d[i][j]の計算に間違いがあります!");
            assertTrue(prints[9].contains(" 3  2  1  1  2  2  3"),"d[i][j]の計算に間違いがあります!");
            assertTrue(prints[10].contains(" 4  3  2  2  1  2  3"),"d[i][j]の計算に間違いがあります!");
        } catch (ArrayIndexOutOfBoundsException excpt) {
                fail("DNA.getLevenshteinDistance()のprint出力が不足しています!");
        }
    }
}
