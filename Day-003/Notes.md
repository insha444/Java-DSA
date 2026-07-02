# Day 003 — Sliding Window (Fixed Size) and Two Pointers

## What is sliding window?
Instead of recalculating a result from scratch for every possible
window of size k, you "slide" the window by one position: remove
the element leaving the window, add the element entering it.
This turns an O(n*k) brute force into O(n).

## Real-world analogy
Imagine looking through a train window of fixed width as the train
moves. You don't re-look at the whole landscape each second — you
just see one new thing appear on the right and one thing disappear
on the left. Everything else you already saw stays in view.

## Fixed-size sliding window — the pattern

1. Build the first window of size k (sum, count, max, etc.)
2. Slide one step at a time:
   - Remove the element leaving the window (leftmost)
   - Add the element entering the window (new rightmost)
3. Update your answer at each step

## Two Pointers — the idea
Two pointers move through a structure (often from both ends, or
both from the start at different speeds) to avoid nested loops.
Sliding window is actually a special case of two pointers where
both pointers only move forward.

## When to recognize these patterns in interviews
- "Maximum/minimum sum subarray of size k" -> fixed sliding window
- "Longest/shortest subarray satisfying a condition" -> variable
  sliding window (we'll cover this on Day 11-12)
- "Pair with given sum in sorted array" -> two pointers from both ends
- "Remove duplicates in place" -> two pointers, same direction

## Time Complexity
Sliding window (fixed size k): O(n) — each element is added once
and removed once, regardless of k.

Brute force (recompute every window): O(n*k)

## Space Complexity
O(1) extra space typically — you maintain a running sum/count,
not a new array each time.

