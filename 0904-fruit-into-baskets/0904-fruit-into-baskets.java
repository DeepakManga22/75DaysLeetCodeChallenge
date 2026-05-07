class Solution {
    public int totalFruit(int[] fru) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int maxFru=0;
        for(int r=0;r<fru.length;r++){
            map.put(fru[r],map.getOrDefault(fru[r],0)+1);
            while(map.size()>2){
                map.put(fru[l],map.get(fru[l])-1);
                if(map.get(fru[l])==0){
                    map.remove(fru[l]);
                }
                l++;
            }
            maxFru=Math.max(maxFru,r-l+1);
        }
        return maxFru;
    }
}