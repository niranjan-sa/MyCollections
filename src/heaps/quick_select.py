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
# it and greater elements to right
def partition(arr, l, r):
	
	x = arr[r]
	i = l
	for j in range(l, r):
		
		if arr[j] <= x:
			arr[i], arr[j] = arr[j], arr[i]
			i += 1
			
	arr[i], arr[r] = arr[r], arr[i]
	return i

# finds the kth position (of the sorted array)
# in a given unsorted array i.e this function
# can be used to find both kth largest and
# kth smallest element in the array.
# ASSUMPTION: all elements in arr[] are distinct
def kthSmallest(arr, l, r, k):

	# if k is smaller than number of
	# elements in array
	if (k > 0 and k <= r - l + 1):

		# Partition the array around last
		# element and get position of pivot
		# element in sorted array
		index = partition(arr, l, r)

		# if position is same as k
		if (index - l == k - 1):
			return arr[index]

		# If position is more, recur
		# for left subarray
		if (index - l > k - 1):
			return kthSmallest(arr, l, index - 1, k)

		# Else recur for right subarray
		return kthSmallest(arr, index + 1, r,
							k - index + l - 1)
	print("Index out of bound")

# Driver Code
arr = [ 10, 4, 5, 8, 6, 11, 26 ]
n = len(arr)
k = 3
print("K-th smallest element is ", end = "")
print(kthSmallest(arr, 0, n - 1, k))

# This code is contributed by Muskan Kalra.

