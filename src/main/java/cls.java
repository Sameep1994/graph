import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cls {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);

        minimalHeaviestSetA(l);

    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        Collections.sort(arr);
        int n = arr.size();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr.get(i);
        }


        //max num of elements a can take
        int a_size = n/2;
        int a_sum=0;

        for(int i= n-1;i>=0;i--){

            if(a_sum>(sum-a_sum)){
                a_size=0;
            }

            if(a_size!=0){
                a.add(arr.get(i));
                a_sum+=arr.get(i);
                a_size--;
            }else{
                b.add(arr.get(i));
            }

        }

        for(Integer i: a){
            res.add(i);
        }
        Collections.sort(res);

        return res;
    }
}
