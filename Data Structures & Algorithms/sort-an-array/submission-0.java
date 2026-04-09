class Solution {
    public int[] sortArray(int[] nums) {
        // [5,1,1,2,0,0]
        
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        // base condition
        if (low >= high) return;

        // we first divide the array from mid
        int mid = (low + high) / 2;

        // left half
        mergeSort(nums, low, mid);

        // right half
        mergeSort(nums, mid + 1, high);

        // merge
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        // create temporary array
        List<Integer> temp = new ArrayList<>();

        int left = low; // pointer to the start of left array
        int right = mid + 1; // pointer to the start of right array


        // compare left and right array elements to see which one is smaller
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                ++left;
            } else {
                temp.add(nums[right]);
                ++right;
            }
        }

        // see if elements are left in left side array
        while (left <= mid) {
            temp.add(nums[left]);
            ++left;
        }

        // see if elements are left in right side array
        while (right <= high) {
            temp.add(nums[right]);
            ++right;
        }

        // copy elements from temp array to original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

    }
}