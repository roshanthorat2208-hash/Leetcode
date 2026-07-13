class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
         int n = times.length;

        for (int i = 0; i < n; i++) {
            times[i] = new int[]{
                times[i][0],
                times[i][1],
                i
            };
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available =
                new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            available.offer(i);

        PriorityQueue<int[]> occupied =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]
                );

        for (int[] friend : times) {

            int arrive = friend[0];
            int leave = friend[1];
            int index = friend[2];

            while (!occupied.isEmpty()
                    && occupied.peek()[0] <= arrive) {

                available.offer(
                        occupied.poll()[1]
                );
            }

            int chair = available.poll();

            if (index == targetFriend)
                return chair;

            occupied.offer(new int[]{
                    leave,
                    chair
            });
        }

        return -1;
    }
}
