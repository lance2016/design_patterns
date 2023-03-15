package com.lance.sort;

import java.util.stream.IntStream;

public class QuickSort2 {
    // 三路快排
    public void quickSort(int []nums, int left, int right){
        if(left>=right){
            return;
        }
        int lt = left;
        int gt = right;
        int i = left+1;
        int pivot = nums[left];
        while(i<=gt) {
            if (nums[i] < pivot) {
                swap(nums, i++, lt++);
            }else if(nums[i]>pivot){
                swap(nums, i, gt--);
            }else{
                i++;
            }
        }
        quickSort(nums, left, lt-1);
        quickSort(nums, gt+1, right);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // test method quickSort
    public static void main(String[] args) {
        int[] nums = IntStream.range(0, 10).map(i -> (int) (Math.random() * 100)).toArray();
        // print nums before sort
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        QuickSort2 quickSort = new QuickSort2();
        quickSort.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }







}

