class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for(int num: nums){
            freqCount.put(num, freqCount.getOrDefault(num,0) + 1);
        }
        for(Map.Entry<Integer, Integer> record: freqCount.entrySet()){
            freq[record.getValue()].add(record.getKey());
        }

        int[] res = new int[k];
        int i = 0, j = nums.length;
        while(i < k){
            for(int l = 0; l < freq[j].size(); l++){
                res[i++] = freq[j].get(l);
            }
            j--;
        }
        return res;
    }
}
