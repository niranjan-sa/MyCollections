"""
Find the maximum sub array sum in an array with -ve +ve elements.

Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
"""

def kadane(nums):
  curr, maxs = None, None
  for x in nums:
    cur = x + max(cur, 0)
    maxs = max(maxs, cur)
    
  return maxs

# another version of kadane algo
def kadane2(nums):
  curr, maxs = 0, float('MIN')
  for x in nums:
    curr += x
    maxs = max(maxs, curr)
    if curr < 0:
      curr = 0
