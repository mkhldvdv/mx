package interview;

public class Main {

    public static void main(String[] args) {
        //check input
        if (args.length < 6) {
            System.out.println("Number of parameters should be exactly 6");
            System.exit(1);
        }

        int chessdeskSize = 0;
        int steps = 0;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        try {
            chessdeskSize = Integer.parseInt(args[0]);
            steps = Integer.parseInt(args[1]);
            startX = Integer.parseInt(args[2]);
            startY = Integer.parseInt(args[3]);
            endX = Integer.parseInt(args[4]);
            endY = Integer.parseInt(args[5]);
        } catch (NumberFormatException e) {
            System.out.println("All parameters should be numeric");
            System.exit(1);
        }

        if (isAnyNegative(chessdeskSize, steps, startX, startY, endX, endY)) {
            System.out.println("All parameters should be not negative");
            System.exit(1);
        }

        if (isAnyOutOfChessdesk(chessdeskSize, startX, startY, endX, endY)) {
            System.out.println("Start or end point is out of chessdesk");
            System.exit(1);
        }

        // initial state
        Point startPoint = new Point(startX, startY, null);
        Point endPoint = new Point(endX, endY, null);
        int[][] chessdesk = new int[chessdeskSize][chessdeskSize];

        // find solution if exists
        Solution solution = new Solution();
        solution.solution(chessdesk, startPoint, endPoint, steps);

        // draw the chessdesk
        System.out.println();
        drawChessdesk(chessdesk);

    }

    private static boolean isAnyOutOfChessdesk(int chessdeskSize, int startX, int startY, int endX, int endY) {
        return startX >= chessdeskSize || startY >= chessdeskSize || endX >= chessdeskSize || endY >= chessdeskSize;
    }

    private static boolean isAnyNegative(int chessdeskSize, int steps, int startX, int startY, int endX, int endY) {
        return chessdeskSize < 0 || steps < 0 || startX < 0 || startY < 0 || endX < 0 || endY < 0;
    }

    private static void drawChessdesk(int[][] chessdesk) {
        for (int i = 0; i < chessdesk.length; i++) {
            for (int j = 0; j < chessdesk.length; j++)
                System.out.print(chessdesk[i][j] + " ");
            System.out.println();
        }
    }
}