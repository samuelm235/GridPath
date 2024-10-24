public class GridPath 
{
    private int[][] grid;
    public GridPath(int[][] values)
    {
        grid = values;
    }
    public String toString()
    {
        String s = "";
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                s += grid[row][col] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public Location getNextLoc(int row, int col)
     {
        int below = Integer.MAX_VALUE; //default both as max value
        if (row < grid.length - 1) below = grid[row + 1][col]; //test to see if out of bounds
        int right = Integer.MAX_VALUE;
        if (col < grid[0].length - 1) right = grid[row][col + 1];
        if (below < right) return new Location(row + 1, col); //if it is out of bounds, the other will always be smaller
        return new Location(row, col + 1);
 
    }

    /**
     * Computes and returns the sum of all values on a path through grid, as
     * described in
     * part (b)
     * Preconditions: row is a valid row index and col is a valid column index in
     * grid.
     * row and col do not specify the element in the last row and last column of
     * grid.
     */
    public int sumPath(int row, int col) {
        int sum = grid[row][col];
        int new_row = row;
        int new_col = col;
        while(!(row == grid.length && col == grid[0].length))
        {
            getNextLoc(new_row, new_col);
            sum =sum + getNextLoc(row, col);
        }
        return 0;
        /* to be implemented in part (b) */ }
}
