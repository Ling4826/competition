package win.FloodFill;

import java.util.ArrayList;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ArrayList<int[]> queue = new ArrayList<>();
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image; // No need to fill if the color is the same
        }
        image[sr][sc] = color;
        queue.add(new int[] { sr, sc });
        while (!queue.isEmpty()) {
            int[] current = queue.remove(0);
            int x = current[0];
            int y = current[1];
            if (x - 1 >= 0) {
                if (originalColor == image[x - 1][y]) {
                    image[x - 1][y] = color;
                    queue.add(new int[] { x - 1, y });
                }
            }
            if (x + 1 < image.length) {
                if (originalColor == image[x + 1][y]) {
                    image[x + 1][y] = color;
                    queue.add(new int[] { x + 1, y });
                }
            }

            if (y - 1 >= 0) {
                if (originalColor == image[x][y - 1]) {
                    image[x][y - 1] = color;
                    queue.add(new int[] { x, y - 1 });
                }
            }
            if (y + 1 < image[0].length) {

                if (originalColor == image[x][y + 1]) {
                    image[x][y + 1] = color;
                    queue.add(new int[] { x, y + 1 });
                }
            }
        }
        return image;
    }
}