class Solution {
  
  /*
  Time - O(N)
  Space - O(N) if output array is considered.
  */
    ArrayDeque<Integer> dq = new ArrayDeque();
	int []ans;

	public void cleanDQ(ArrayDeque<Integer> dq, int []nums, int i, int k) {
		if(!dq.isEmpty() && i - dq.getFirst() == k) {
			dq.removeFirst();
		}

		while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length <= 1) return nums;
		int n = nums.length;
		ans = new int[n - k + 1];
		int max_val = Integer.MIN_VALUE;

		for(int i = 0; i < k; i++) {
			cleanDQ(dq, nums, i, k);
			dq.addLast(i);
			if(nums[i] > max_val) max_val = nums[i];
		}

		ans[0] = max_val;

		for(int i = k; i < n; i++) {
			cleanDQ(dq, nums, i, k);
			dq.addLast(i);
			ans[i - k + 1] = nums[dq.getFirst()];
		}
		return ans;
    }
}
