import random
"""
Finding median in linear time :-) 
Reference - https://rcoh.me/posts/linear-time-median-finding/
Example - 

Consider the list below. We'd like to find the median.
l = [9,1,0,2,3,4,6,8,7,10,5]
len(l) == 11, so we're looking for the 6th smallest element
First, we must pick a pivot. We randomly select index 3.
The value at this index is 2.

Partitioning based on the pivot:
[1,0,2], [9,3,4,6,8,7,10,5]
We want the 6th element. 6-len(left) = 3, so we want
the third smallest element in the right array

We're now looking for third smallest element in the array below:
[9,3,4,6,8,7,10,5]
We pick an index at random to be our pivot.
We pick index 3, the value at which, l[3]=6

Partitioning based on the pivot:
[3,4,5,6] [9,7,10]
We want the 3rd smallest element, so we know it's the
3rd smallest element in the left array

We're now looking for the 3rd smallest in the array below:
[3,4,5,6]
We pick an index at random to be our pivot.
We pick index 1, the value at which, l[1]=4
Partitioning based on the pivot:
[3,4] [5,6]
We're looking for the item at index 3, so we know it's
the smallest in the right array.

We're now looking for the smallest element in the array below:
[5,6]

At this point, we can have a base case that chooses the larger
or smaller item based on the index.
We're looking for the smallest item, which is 5.
return 5
"""
# Python3 program of Quick Select

# Standard partition process of QuickSort().
# It considers the last element as pivot
# and moves all smaller element to left of
# it and greater elements to rightfrom random import randint
 
def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
 
 
# Partition using Lomuto partition scheme
def partition(nums, left, right, pIndex):
 
    # Pick `pIndex` as a pivot from the list
    pivot = nums[pIndex]
 
    # Move pivot to end
    swap(nums, pIndex, right)
 
    # elements less than the pivot will be pushed to the left of `pIndex`;
    # elements more than the pivot will be pushed to the right of `pIndex`;
    # equal elements can go either way
    pIndex = left
 
    # each time we find an element less than or equal to the pivot, `pIndex`
    # is incremented, and that element would be placed before the pivot.
    for i in range(left, right):
        if nums[i] <= pivot:
            swap(nums, i, pIndex)
            pIndex = pIndex + 1
 
    # Move pivot to its place
    swap(nums, pIndex, right)
 
    # return `pIndex` (index of the pivot element)
    return pIndex
 
 
# Returns the k'th smallest element in a list within `left…right`
# (i.e., left <= k <= right). The search space within the list is
# changing for each round – but the list is still the same size.
# Thus, `k` does not need to be updated with each round.
def quickSelect(nums, left, right, k):
 
    # If the list contains only one element, return that element
    if left == right:
        return nums[left]
 
    # select `pIndex` between left and right
    pIndex = randint(left, right)
 
    pIndex = partition(nums, left, right, pIndex)
 
    # The pivot is in its sorted position
    if k == pIndex:
        return nums[k]
 
    # if `k` is less than the pivot index
    elif k < pIndex:
        return quickSelect(nums, left, pIndex - 1, k)
 
    # if `k` is more than the pivot index
    else:
        return quickSelect(nums, pIndex + 1, right, k)
 
 
if __name__ == '__main__':
 
    nums = [7, 4, 6, 3, 9, 1]
    k = 2
 
    print('k\'th smallest element is', quickSelect(nums, 0, len(nums) - 1, k - 1))

