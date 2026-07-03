public class ClassicArrayProblems {

    // Problem 1: Best time to buy and sell stock
    // One pass: track minimum price and maximum profit seen so far
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];      // found a better buy day
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // Problem 2: Trapping rain water — two pointer O(1) space
    public static int trapRainWater(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];   // update left max
                } else {
                    water += leftMax - height[left]; // trap water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // update right max
                } else {
                    water += rightMax - height[right]; // trap water
                }
                right--;
            }
        }
        return water;
    }

    // Problem 3: Move zeros to end — in place, maintain order
    public static void moveZeros(int[] arr) {
        int left = 0; // position to place next non-zero element

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
        }
    }

    // Problem 4: Container with most water
    public static int maxWaterContainer(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxWater = Math.max(maxWater, h * width);

            // move the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        // Stock
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit: " + maxProfit(prices)); // 5

        // Rain water
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trapRainWater(height)); // 6

        // Move zeros
        int[] arr = {0, 1, 0, 3, 12};
        moveZeros(arr);
        System.out.print("After moving zeros: ");
        for (int x : arr) System.out.print(x + " "); // 1 3 12 0 0
        System.out.println();

        // Container
        int[] h2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max water container: " + maxWaterContainer(h2)); // 49
    }
}