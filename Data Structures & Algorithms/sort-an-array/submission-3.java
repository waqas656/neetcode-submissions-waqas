class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        // get pivot final position
        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot - 1);

        quickSort(arr, pivot + 1, high);
    }

    int partition(int[] arr, int low, int high) {
        int next = low;
        int pivot = high;

        for (int i=low; i<high; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[next];
                arr[next] = arr[i];
                arr[i] = temp;

                ++next;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[next];
        arr[next] = temp;

        return next;
    }

}