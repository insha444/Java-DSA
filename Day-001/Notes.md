# Day 001 — Arrays: The Foundation

## What is an array?
An array is a contiguous block of memory that stores elements of the same type.
a row of numbered boxes in a post office — Box 0, Box 1, Box 2...n
You can jump to any box instantly if you know its number (index).

## Key concepts

| Concept       | Meaning                          |
|---------------|----------------------------------|
| Index         | Position of element, starts at 0 |
| Length        | Total number of elements         |
| arr[i]        | Access element at index i        |
| arr.length    | Get size of array in Java        |

## Time Complexity

| Operation        | Time |
|------------------|------|
| Access arr[i]    | O(1) |
| Search (linear)  | O(n) |
| Insertion (end)  | O(1) |
| Insertion (mid)  | O(n) |
| Deletion (mid)   | O(n) |

## Space Complexity
O(n) — you store n elements.

## Real-world analogy
Seats in a classroom: Seat 0, Seat 1, ... Seat 59.
You can directly go to Seat 35 without checking every seat before it.
That is O(1) random access.

## Common mistakes
1. Using arr.length() instead of arr.length — arrays are not objects with methods
2. Accessing arr[arr.length] causes ArrayIndexOutOfBoundsException
3. Forgetting arrays are 0-indexed — first element is arr[0], not arr[1]

## Interview tips
- Always ask: "Can the array be empty?" and "Can it have duplicates?"
- Clarify if the array is sorted — it changes your approach completely
- For most array problems, try brute force first, then optimize