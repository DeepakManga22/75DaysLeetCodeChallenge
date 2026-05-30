import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        // Pacific: top row and left column
        for (int i = 0; i < m; i++) {
            pacQ.offer(new int[]{i, 0});
            pacific[i][0] = true;

            atlQ.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }

        // Atlantic: bottom row and right column
        for (int j = 0; j < n; j++) {
            pacQ.offer(new int[]{0, j});
            pacific[0][j] = true;

            atlQ.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacQ, pacific);
        bfs(heights, atlQ, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (visited[nr][nc])
                    continue;

                if (heights[nr][nc] < heights[r][c])
                    continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}