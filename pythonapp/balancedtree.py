# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums) == 1:
            return TreeNode(nums[0])
        if len(nums) == 2:
            return TreeNode(nums[0], None, TreeNode(nums[1]))

        rooti = len(nums) // 2

        if rooti > 0:
            lhs = self.sortedArrayToBST(nums[0:rooti])
        else:
            lhs = None

        if rooti  < len(nums):
            rhs = self.sortedArrayToBST(nums[rooti+1:len(nums)])
        else:
            rhs = None
        
        root = TreeNode(nums[rooti], lhs, rhs)

        return root
        



