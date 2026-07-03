# Day 004 — Two Pointers: Classic Array Problems

## Why these problems matter
These 4 problems appear in TCS, Infosys, Wipro, and nearly every
placement exam. They are not just practice — learn them cold.

## Problem 1: Best Time to Buy and Sell Stock
Given an array where arr[i] is the price on day i, find the maximum
profit you can make by buying on one day and selling on a later day.

Key insight: you want to buy at the lowest price seen so far, and
sell at the highest price after that buy point. One pass is enough.

Pattern:
- Track minPrice seen so far
- At each day, profit = currentPrice - minPrice
- Track maxProfit seen so far

Time: O(n)   Space: O(1)

## Problem 2: Trapping Rain Water
Given an array of bar heights, find how much water can be trapped
after raining.

Key insight: water above any bar i is determined by:
    min(maxLeft[i], maxRight[i]) - height[i]

Two approaches:
1. Prefix/suffix arrays: O(n) time, O(n) space
2. Two pointers: O(n) time, O(1) space — preferred in interviews

Two pointer logic:
- left pointer starts at 0, right at n-1
- Track leftMax and rightMax
- If height[left] < height[right]:
    water += leftMax - height[left], move left++
  Else:
    water += rightMax - height[right], move right--

## Problem 3: Move Zeros to End
Move all zeros to the end while maintaining relative order of
non-zero elements. Must be done in place.

Two pointer pattern:
- left pointer tracks where to place next non-zero element
- right pointer scans the array
- When right finds a non-zero, swap with left, advance both

Time: O(n)   Space: O(1)

## Problem 4: Container With Most Water
Given n vertical lines, find two lines that together with the x-axis
forms a container that holds the most water.

Two pointer logic:
- Start left=0, right=n-1 (widest container)
- Area = min(height[left], height[right]) * (right - left)
- Always move the pointer with the SHORTER line inward
  (moving the taller one can only decrease area — width decreases
  and height is still bounded by the shorter line)

Time: O(n)   Space: O(1)

