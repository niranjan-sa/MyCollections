"""
Find the maximum sub array sum in an array with -ve +ve elements.
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
