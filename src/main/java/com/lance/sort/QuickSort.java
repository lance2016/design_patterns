package com.lance.sort;

import java.util.stream.IntStream;

public class QuickSort {
    // 快速排序
    public void quickSort(int[] nums, int left, int r) {
        if (left >= r) {
            return;
        }
        int p = partition(nums, left, r);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, r);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while(i<j){
            while(i<j && nums[j]>=pivot){
                j--;
            }
            if(i<j){
                nums[i++] = nums[j];
            }
            while(i<j && nums[i]<pivot){
               i++;
            }
            if(i<j){
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        return i;
    }
    // test method quickSort in main method use a random array
    public static void main(String[] args) {
        int[] nums = IntStream.range(0, 10).map(i -> (int) (Math.random() * 100)).toArray();
        // print nums before sort
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
