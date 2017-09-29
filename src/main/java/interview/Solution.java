package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mikhail.davydov on 29.09.2017.
 */
public class Solution {

    private List<Point> points = new ArrayList<Point>();
    private List<Point> pointsNextStep;

    public boolean solution(int[][] chessdesk, Point startPoint, Point endPoint, int steps) {
        chessdesk[startPoint.getX()][startPoint.getY()] = 1;
        points.add(startPoint);
        // check if endpoint is startpoint
        if (isEndpoint(startPoint, endPoint)) {
            drawShortestWay(startPoint, chessdesk);
            return true;
        }
        while (steps > 0) {
            for (Point point : points) {
                if (findSolution(point, endPoint, chessdesk)) return true;
            }
            points = pointsNextStep;
            steps--;
        }
        System.out.println("No solution has been found");
        return false;
    }

    private boolean findSolution(Point point, Point endPoint, int[][] chessdesk) {
        // points for next step
        pointsNextStep = new ArrayList<Point>();

        // knight's moves
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // collecting points for next step
        for (int i = 0; i < xMove.length; i++) {
            int xPoint = point.getX() + xMove[i];
            int yPoint = point.getY() + yMove[i];
            if (isPointValid(chessdesk.length, xPoint, yPoint)) {
                chessdesk[xPoint][yPoint] = 1;
                Point nextPoint = new Point(xPoint, yPoint, point);
                // check endpoint
                if (isEndpoint(nextPoint, endPoint)) {
                    drawShortestWay(nextPoint, chessdesk);
                    return true;
                }
                pointsNextStep.add(nextPoint);
            }
        }
        return false;
    }

    private boolean isPointValid(int size, int xPoint, int yPoint) {
        return xPoint >= 0 && yPoint >= 0 && xPoint < size && yPoint < size;
    }

    private boolean isEndpoint(Point point, Point endPoint) {
        return endPoint.getX() == point.getX() && endPoint.getY() == point.getY();
    }

    private void drawShortestWay(Point point, int[][] chessdesk) {
        Stack<Point> stack = new Stack<Point>();
        System.out.println("The shortest way is:");
        while (point.getPrevious() != null) {
            chessdesk[point.getX()][point.getY()] = 2;
            stack.push(point);
            point = point.getPrevious();
        }
        chessdesk[point.getX()][point.getY()] = 2;
        stack.push(point);
        while (!stack.empty()) {
            Point point1 = stack.pop();
            if (stack.isEmpty()) {
                System.out.println("[" + point1.getX() + "," + point1.getY() + "]");
            } else {
                System.out.print("[" + point1.getX() + "," + point1.getY() + "]->");
            }
        }
    }
}
