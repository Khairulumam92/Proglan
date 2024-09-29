import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testFindMax_PositiveNumbers() {
        // Pengujian angka 3 dari nilai a, b, dan c yang bernilai 1, 2, dan 3.
        int result = Main.findMax(1, 2, 3);
        assertEquals(3, result);
    }

    @Test
    public void testFindMax_NegativeNumbers() {
        // Pengujian angka -1 dari nilai a, b, dan c yang bernilai -1, -2, dan -3.
        int result = Main.findMax(-1, -2, -3);
        assertEquals(-1, result);
    }

    @Test
    public void testFindMax_ZeroAndPositiveNumbers() {
        // Pengujian angka 0 dari nilai a, b, dan c yang bernilai 0, 0, dan 1.
        int result = Main.findMax(0, 0, 1);
        assertEquals(1, result);
    }
}