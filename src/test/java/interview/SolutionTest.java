package interview;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mikhail.davydov on 29.09.2017.
 */
public class SolutionTest {

    @Test
    public void solutionValidTest() {
        // init
        int n = 8;
        int steps = 3;
        int startX = 0;
        int startY = 0;
        int endX = 5;
        int endY = 4;
        Point startPoint = new Point(startX, startY, null);
        Point endPoint = new Point(endX, endY, null);
        int[][] chessdesk = new int[n][n];

        //
        Solution solution = new Solution();
        Assert.assertTrue(solution.solution(chessdesk, startPoint, endPoint, steps));
    }

    @Test
    public void solutionInvalidTest() {
        // init
        int n = 8;
        int steps = 3;
        int startX = 0;
        int startY = 0;
        int endX = 5;
        int endY = 5;
        Point startPoint = new Point(startX, startY, null);
        Point endPoint = new Point(endX, endY, null);
        int[][] chessdesk = new int[n][n];

        //
        Solution solution = new Solution();
        Assert.assertFalse(solution.solution(chessdesk, startPoint, endPoint, steps));
    }

}
