import java.util.Map;
import java.util.HashMap;

public class Solution {
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
    public int[] sortedSquares(int[] nums) {
        int zeroposition = 0, i, j, thisnum=0;
        int[] result = new int[nums.length];
        while (nums[zeroposition]<0){zeroposition++;}
        i = zeroposition;
        j = i-1;
        while(i<nums.length & j>=0){
            if ((0-nums[j])<nums[i]){
                result[thisnum] = nums[j]*nums[j];
                j-=1;
            }else{
                result[thisnum] = nums[i]*nums[i];
                i++;
            }
            thisnum++;
        }
        while (j>0){
            result[thisnum] = nums[j]*nums[j];
            j-=1;
            thisnum++;
        }
        while (i<nums.length){
            result[thisnum] = nums[i]*nums[i];
            i++;
            thisnum++;
        }
        return result;
    }
    private void exchange(int[] nums, int a,b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int i,j;
        while (k>nums.length){k=k-nums.length;}
        for (i=k; i<nums.length; i++){
            result[i] = nums[i-k];
        }
        for (j=nums.length-1; j>=nums.length-k; j--){
            result[k-(nums.length-j)] = nums[j];
        }
        for (i=0; i<nums.length; i++){
            nums[i] = result[i];
        }
    }
    //////////////////////////22ms and 54.9MB//////////////////////////////
    private static int nextzero(int[] nums, int thiszero){
        while (thiszero<nums.length){
            if(nums[thiszero]==0){break;}
            thiszero+=1;
        }
        return thiszero;
    }
    private static int nextnum(int[] nums, int thisnum){
        while (thisnum<nums.length){
            if(nums[thisnum]!=0){break;}
            thisnum+=1;
        }
        return thisnum;
    }
    public void moveZeroes(int[] nums) {
        int thiszero=0, thisnum=0, tempnum;
        thiszero = this.nextzero(nums, thiszero);
        thisnum = thiszero;
        thisnum = this.nextnum(nums, thisnum);
        while (thisnum<nums.length & thiszero<thisnum){
            nums[thiszero] = nums[thisnum];
            nums[thisnum] = 0;
            thiszero = this.nextzero(nums, thiszero);
            thisnum = this.nextnum(nums, thisnum); 
        }
    }
    ////////////////////////1ms and 43.6MB//////////////////////////////
    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int thisnum = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0){
                result[thisnum] = nums[i];
                thisnum+=1;
            }
        }
        for (int i=thisnum; i<nums.length; i++){
            nums[i]=0;
        }
        for (int i=0; i<thisnum; i++){
            nums[i] = result[i];
        }
    }
    //////////////////////5ms and 54.MB//////////////////////////////
    int thiszero, thisnum;
    private void nextzero(int[] nums){
        while (this.thiszero<nums.length){
            if(nums[this.thiszero]==0){break;}
            this.thiszero+=1;
        }
    }
    private void nextnum(int[] nums){
        while (this.thisnum<nums.length){
            if(nums[this.thisnum]!=0){break;}
            this.thisnum+=1;
        }
    }
    public void moveZeroes(int[] nums) {
        this.thiszero=0;
        this.nextzero(nums);
        this.thisnum = this.thiszero;
        this.nextnum(nums);
        while (this.thisnum<nums.length & this.thiszero<thisnum){
            nums[this.thiszero] = nums[this.thisnum];
            nums[this.thisnum] = 0;
            this.nextzero(nums);
            this.nextnum(nums); 
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        int head=0, tail=numbers.length-1;
        while (tail>head){
            while (numbers[head]+numbers[tail]<target & tail>head){
                head+=1;
            }
            if (numbers[head]+numbers[tail] == target){
                break;
            }else{
                tail-=1;
                head=0;
            }
        }
        return new int[]{head+1,tail+1};
    }
    private int bisearch(int[] numbers, int a, int b, int tar){
        if (numbers[a]>tar){return -1;}
        if (numbers[b]<tar){return -1;}
        int thisnum = a+(b-a)/2;
        if (numbers[thisnum] == tar){
            return thisnum;
        }else if (a==b){
            return -1;
        }else if (numbers[thisnum]>tar){
            return this.bisearch(numbers, a, (a<thisnum-1)? thisnum-1 : a, tar);
        }else{
            return this.bisearch(numbers, (thisnum+1<b)? thisnum+1 : b, b, tar);
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        int tar, head=0, tail=numbers.length-1;
        tar = target - numbers[tail];
        while (tail>0){
            head = this.bisearch(numbers,0,tail,tar);
            if (head!=-1){
                break;
            }else{
                tail-=1;
                tar = target - numbers[tail];
            }
        }
        return new int[]{head+1,tail+1};
    }
}


