class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor = image[sr][sc];
        
        // If the starting pixel already has the target color
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    public void dfs(int[][] image, int r, int c, int originalColor, int color) {
        
        // Check boundaries
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return;
        }

        // Process only pixels with original color
        if (image[r][c] != originalColor) {
            return;
        }

        // Change color
        image[r][c] = color;

        // Visit all 4 directions
        dfs(image, r + 1, c, originalColor, color); // Down
        dfs(image, r - 1, c, originalColor, color); // Up
        dfs(image, r, c + 1, originalColor, color); // Right
        dfs(image, r, c - 1, originalColor, color); // Left
    }
}