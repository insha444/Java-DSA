public class ArrayBasics {

    // Print all elements of an array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Find the largest element
    // Approach: assume first element is largest, compare with the rest
    public static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    // Find the second largest element
    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int second  = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                second  = largest;
                largest = arr[i];
            } else if (arr[i] > second && arr[i] != largest) {
                second = arr[i];
            }
        }
        return second;
    }

    // Check if array is sorted in ascending order
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Reverse an array in place using two pointers
    public static void reverse(int[] arr) {
        int left  = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp    = arr[left];
            arr[left]   = arr[right];
            arr[right]  = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};

        System.out.print("Array: ");
        printArray(arr);

        System.out.println("Largest: "       + findLargest(arr));
        System.out.println("Second Largest: " + findSecondLargest(arr));
        System.out.println("Is Sorted: "      + isSorted(arr));

        reverse(arr);
        System.out.print("Reversed: ");
        printArray(arr);
    }
}