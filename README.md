# 🌄 2210. Count Hills and Valleys in an Array

You are given a 0-indexed integer array `nums`. An index `i` is part of a **hill** in `nums` if the **closest non-equal neighbors** of `i` are smaller than `nums[i]`. Similarly, an index `i` is part of a **valley** in `nums` if the closest non-equal neighbors of `i` are larger than `nums[i]`.

Adjacent indices `i` and `j` are part of the same hill or valley if `nums[i] == nums[j]`.

> Note: An index must have a **non-equal neighbor on both sides** to be considered part of a hill or valley.

---

## 🧪 Examples

### Example 1:
**Input:**  
`nums = [2, 4, 1, 1, 6, 5]`  
**Output:**  
`3`  

**Explanation:**
- Index 1 → Hill: 4 > 2 and 4 > 1  
- Index 2 and 3 → Valley: 1 < 4 and 1 < 6  
- Index 4 → Hill: 6 > 1 and 6 > 5  

Total: 3 hills/valleys

---

### Example 2:
**Input:**  
`nums = [6, 6, 5, 5, 4, 1]`  
**Output:**  
`0`  

**Explanation:**
- No element has both left and right **non-equal** neighbors satisfying hill or valley conditions.

---

## 💡 Approach

1. Iterate through the array with a pointer `i`.
2. Skip over duplicate consecutive elements, as they are part of the same hill/valley.
3. For each valid index `i`, check its previous and next non-equal neighbors (`a` and `b`).
4. If the current number is **greater than both neighbors**, it's a hill.  
   If it's **less than both**, it's a valley.
5. Move `i` to the next distinct value and repeat.

---

## ✅ Java Code

```java
class Solution {
    public int countHillValley(int[] nums) {
        int i = 1;
        int ans = 0;
        while (i < nums.length) {
            int a = i - 1;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            if (i == nums.length - 1) break;
            int b = i + 1;
            if ((nums[b] < nums[i] && nums[i] > nums[a]) || 
                (nums[b] > nums[i] && nums[i] < nums[a])) {
                ans++;
            }
            i = b;
        }
        return ans;
    }
}
```
🧠 Complexity Analysis
Time Complexity: O(n)
We traverse the array once, skipping over equal values.

Space Complexity: O(1)
No extra space used.
