public class SlidingWindowBasics {

    // Maximum sum of any subarray of size k
    public static int maxSumSubarray(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array smaller than window size");
        }

        // Build the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window: remove leftmost, add new rightmost
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // First negative number in every window of size k
    public static int[] firstNegativeInWindow(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        java.util.LinkedList<Integer> negatives = new java.util.LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negatives.addLast(i);
            }

            // Remove indices that have fallen out of the window
            if (!negatives.isEmpty() && negatives.peekFirst() <= i - k) {
                negatives.pollFirst();
            }

            if (i >= k - 1) {
                result[i - k + 1] = negatives.isEmpty() ? 0 : arr[negatives.peekFirst()];
            }
        }

        return result;
    }

    // Two pointers: check if a sorted array has a pair with given sum
    public static boolean hasPairWithSum(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left < right) {
            int sum = sortedArr[left] + sortedArr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;       // need a bigger sum, move left pointer right
            } else {
                right--;      // need a smaller sum, move right pointer left
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println("Max sum subarray of size 3: " + maxSumSubarray(arr, 3));

        int[] arr2 = {-8, 2, 3, -6, 10};
        System.out.println("First negative in each window of size 2:");
        int[] result = firstNegativeInWindow(arr2, 2);
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] sorted = {1, 3, 5, 7, 9, 11};
        System.out.println("Pair with sum 14 exists: " + hasPairWithSum(sorted, 14));
        System.out.println("Pair with sum 4 exists: " + hasPairWithSum(sorted, 4));
    }
}