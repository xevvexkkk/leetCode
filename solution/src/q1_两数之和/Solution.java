package q1_两数之和;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     for(int i=0 ; i<nums.length ; i++){
    //         for(int j=i+1 ; j<nums.length ; j++){
    //             if(nums[i] + nums[j] == target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     throw new IllegalArgumentException("no match result");
    // }

    // public int[] twoSum(int[] nums, int target) {
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i=0 ; i<nums.length ; i++){
    //         map.put(nums[i],i);
    //     }
    //     for(int i=0 ; i<nums.length ; i++){
    //         if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
    //             return new int[]{i,map.get(target - nums[i])};
    //         }
    //     }
    //     throw new IllegalArgumentException("no match result");
    // }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no match result");
    }
}