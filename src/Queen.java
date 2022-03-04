public class Queen {
    public String[][] solution (int n)
    {
        String[][] board = new String[n][n];
        int total = n * n;
        board[0][0] = "Q";
        for (int r = 1; r < board.length; r++)
        {
            board[r][0] = "*";
            board[0][r] = "*";
            board[r + 1][r + 1] = "*";
            total -= 3;
        }
        int row = 0;
        int column = 0;
        while (total != 0)
        {
            for (int t = 0; t < board.length; t++)
            {
                int lowest = n * n;

                int current = 0;
                for (int k = 0; k < board[0].length; k++)
                {
                    if (!(board[t][k].equals("Q") || board[t][k].equals("*")))
                    {
                        for (int r = 0; r < board.length; r++)
                        {
                            if (!board[r][0].equals("*") || !board[r][0].equals("Q"))
                            {
                                current++;
                            }
                            if (!board[0][r].equals("*") || !board[0][r].equals("Q"))
                            {
                                current++;
                            }
                            if (!board[r + 1][r + 1].equals("*") || !board[r + 1][r + 1].equals("Q"))
                            {
                                current++;
                            }
                        }
                    }
                    if (current < lowest)
                    {
                        row = t;
                        column = k;
                        lowest = current;
                    }
                }
            }
            board[row][column] = "Q";
            for (int h = 1; h < board.length; h++)
            {
                board[row + h][0] = "*";
                board[0][column + h] = "*";
                board[row + 1][column + 1] = "*";
                total -= 3;
            }
        }
        return board;
    }
}
