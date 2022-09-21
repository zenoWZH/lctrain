import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ma = new HashMap<Character, Integer>();
        int i,j,t;
        char thischar;
        for (i=0; i < magazine.length(); i++){
            thischar = magazine.charAt(i);
            if (!ma.containsKey(thischar)){
                ma.put(thischar, 1);
            }else{
                t = ma.get(thischar);
                ma.remove(thischar);
                ma.put(thischar, t+1);
            }
        }

        for (j=0; j< ransomNote.length(); j++){
            thischar = ransomNote.charAt(j);
            if (!ma.containsKey(thischar)){
                return false;
            }else{
                t = ma.get(thischar);
                if (t==0){
                    return false;
                }
                ma.remove(thischar);
                ma.put(thischar, t-1);
            }
        }
        return true;
    }
}