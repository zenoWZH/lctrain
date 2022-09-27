class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zerocounter = 0
        for i in range(len(nums)):
            thisnum = nums.pop(0)
            if thisnum == 0:
                zerocounter+=1
            else:
                nums.append(thisnum)
        for i in range(zerocounter):
            nums.append(0)
        