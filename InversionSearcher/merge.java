
public class FirstTask {
    public static int countOfInversion(int numbers[]){
        
        int countLeft,countRight,countMerge;
        int middle=numbers.length/2;
        int k;
        if (numbers.length<=1){

            return 0;
        }
        
        int left[]=new int[middle];
        int right[]=new int [numbers.length-middle];
     
        for (k=0;k<middle;k++){
            left[k]=numbers[k];
        }

        for (k=0;k<right.length;k++){
            right[k]=numbers[middle+k];
        }
       
        countLeft=countOfInversion(left);
        countRight=countOfInversion(right);
   
        int[] sorted=new int[numbers.length];
        countMerge=mergeAndCount(left,right,sorted);

        for (k=0;k<numbers.length;k++){
            numbers[k]=sorted[k];
        }

        return(countLeft+countRight+countMerge);
    }
  
    private static int mergeAndCount(int left[],int right[],int result[]){
        int count=0,a=0,b=0,k=0;

        while((a<left.length)&&(b<right.length)){

            if(left[a]<right[b]){
                result[k]=left[a++];

            }
            else{

                result[k]=right[b++];
                count+=left.length-a;
            }
            k++;
        }


        while (a < left.length)
        {
            result[k++] = left[a++];
        }
        while (b < right.length)
        {
            result[k++] = right[b++];
        }

        return count;
    }
    public static void main(String[] args) {
        int[] Test1 = {1, 2, 3, 4, 5, 6}; //0
        int[] Test2 = {6, 5, 4, 3, 2, 1}; //15
        int[] Test3 = {9, 6, 5, 4, 10, 7,8}; //10
        System.out.println(countOfInversion(Test1));
        System.out.println(countOfInversion(Test2));
        System.out.println(countOfInversion(Test3));

    }
}
