class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0)
                continue;

            boolean forward = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {

                slow = next(nums, slow, forward);
                fast = next(nums, fast, forward);

                if (fast != -1)
                    fast = next(nums, fast, forward);

                if (slow == -1 || fast == -1)
                    break;

                if (slow == fast)
                    return true;
            }

            // Mark only nodes in the current direction
            int curr = i;
            while (true) {

                if ((nums[curr] > 0) != forward)
                    break;

                int next = ((curr + nums[curr]) % n + n) % n;

                nums[curr] = 0;

                if (next == curr)
                    break;

                curr = next;
            }
        }

        return false;
    }

    private int next(int[] nums, int curr, boolean forward) {

        if ((nums[curr] > 0) != forward)
            return -1;

        int n = nums.length;
        int next = ((curr + nums[curr]) % n + n) % n;

        if (next == curr)
            return -1;

        return next;
    }
        
}
