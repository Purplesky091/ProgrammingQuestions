package recursion;

public class PaintFill {
    enum Color {Red, Blue, Green, Yellow, White, Black};

    boolean fillPaint(Color[][] screen, int row, int col, Color newColor) {
        if(screen[row][col] == newColor)
            return false;
        return fillPaint(screen, row, col, screen[row][col], newColor);
    }

    boolean fillPaint(Color[][] screen, int row, int col,  Color oldColor, Color newColor) {
        if(row < 0 || col < 0 || row >= screen.length || col >= screen[0].length)
            return false;

        if(screen[row][col] == oldColor) {
            screen[row][col] = newColor;
            fillPaint(screen, row + 1, col, oldColor, newColor);
            fillPaint(screen, row - 1, col, oldColor, newColor);
            fillPaint(screen, row, col + 1, oldColor, newColor);
            fillPaint(screen, row, col - 1, oldColor, newColor);
        }

        return true;
    }

}
