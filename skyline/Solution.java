package win.skyline;

import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[] { b[0], -b[2] });
            events.add(new int[] { b[1], b[2] });
        }

        events.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(0);
        int prevMax = 0;

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                heap.add(-h);
            } else {
                heap.remove(h);
            }

            int currMax = heap.peek();
            if (currMax != prevMax) {
                List<Integer> point = new ArrayList<>();
                point.add(x);
                point.add(currMax);
                result.add(point);

                prevMax = currMax;
            }
        }

        return result;
    }
}
