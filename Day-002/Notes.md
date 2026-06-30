# Day 002 — 2D Arrays and Prefix Sums

## What is a 2D array?
A 2D array is an array of arrays — think of it as a grid or spreadsheet.
arr[i][j] means row i, column j. In Java, a 2D array is actually an array
where each element is itself a reference to another array (so rows can
even have different lengths — a "jagged array").

## Declaring and traversing

int[][] matrix = new int[3][4]; // 3 rows, 4 columns

for (int i = 0; i < matrix.length; i++) {        // rows
    for (int j = 0; j < matrix[i].length; j++) { // columns
        // process matrix[i][j]
    }
}

## Real-world analogy
A 2D array is like a parking garage. matrix.length is the number of
floors. matrix[i].length is the number of spots on floor i. To find
a car, you don't search the whole garage — you go to floor i, then
spot j directly.

## Prefix Sum — the core idea
A prefix sum array stores running totals so you can answer
"what is the sum from index i to j?" in O(1) instead of O(n).

Build:    prefix[i] = prefix[i-1] + arr[i]
Query:    sum(i, j) = prefix[j] - prefix[i-1]   (handle i=0 separately)

## Why this matters
Without prefix sums, answering Q range-sum queries on an array of
size n takes O(n*Q). With prefix sums: O(n) to build + O(1) per query
= O(n + Q). This is one of the most common interview optimizations.

## Time Complexity

| Operation                  | Without prefix sum | With prefix sum |
|-----------------------------|--------------------|------------------|
| Single range sum query       | O(n)                | O(1)             |
| Build prefix array           | -                   | O(n)             |
| Q queries total              | O(n*Q)              | O(n + Q)         |

## Space Complexity
O(n) extra space for the prefix array.

