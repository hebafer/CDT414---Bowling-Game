/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import org.junit.Test;
import junit.framework.TestCase;

/** BowlingGame Score calculator test cases 
 *  
 */	 
public class BowlingGameTest extends TestCase {
        
	/** test01 
	 * 	
	 *  If no game is provided, score should be -1 (error)   
	 */
	@Test
	public void test01() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        bowlingGame.getScore();
        assertEquals(94, bowlingGame.getScore());
    }
	@Test
	public void test02() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        bowlingGame.getScore();
        assertEquals(112, bowlingGame.getScore());
    }
	@Test
	public void test03() {
        BowlingGame bowlingGame = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        bowlingGame.getScore();
        assertEquals(88, bowlingGame.getScore());
    }
	@Test
	public void test04() {
        BowlingGame bowlingGame = new BowlingGame("[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        bowlingGame.getScore();
        assertEquals(98, bowlingGame.getScore());
    }
	@Test
	public void test05() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        bowlingGame.getScore();
        assertEquals(103, bowlingGame.getScore());
    }
	@Test
	public void test06() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
        bowlingGame.getScore();
        assertEquals(90, bowlingGame.getScore());
    }
	@Test
	public void test07() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
        bowlingGame.getScore();
        assertEquals(92, bowlingGame.getScore());
    }
	@Test
	public void test08() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]");
        bowlingGame.getScore();
        assertEquals(93, bowlingGame.getScore());
    }
	@Test
	public void test09() {
        BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
        bowlingGame.getScore();
        assertEquals(300, bowlingGame.getScore());
    }
}