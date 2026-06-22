class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer>map =new HashMap<>();
     for(int num :nums) {
        map.put(num,map.getOrDefault(num,0)+1);
     }
     List<Integer>[]freq=new ArrayList[nums.length+1];
      for(int key:map.keySet()){
        int count=map.get(key);
        if(freq[count]==null){
            freq[count]=new ArrayList<>();
        }
        freq[count].add(key);
      }
      int []ans=new int[k];
      int idx=0;
      for(int i=freq.length-1;i>=0&&idx<k;i--){
        if(freq[i] != null) {
          for(int num:freq[i]){
            ans[idx++] = num; 
        if(idx == k) 
          break;
      }
    }
  }
  return ans;
 }
}