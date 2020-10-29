import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testGutterGame() throws Exception{
        rollMany(20, 0);
        Assertions.assertEquals(0, bowlingGame.score());
    }

    @Test
    void testAllOnes() {
        rollMany(20, 1);
        Assertions.assertEquals(20, bowlingGame.score());
    }

    @Test
    public void testOneSpare() throws Exception{
        rollSpare();
        bowlingGame.roll(3);
        rollMany(17,0);
        Assertions.assertEquals(16,bowlingGame.score());
    }

    @Test
    void testOnStrike() {
        rollStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        bowlingGame.roll(0);
        rollMany(16,0);
        Assertions.assertEquals(24,bowlingGame.score());

    }

    @Test
    void testPerfectGame() throws Exception {
        rollMany(12,10);
        Assertions.assertEquals(300,bowlingGame.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.roll(pins);
        }
    }

    private void rollSpare(){
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    private void rollStrike(){
        bowlingGame.roll(10);
    }
}
