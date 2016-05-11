import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16-5-11.
 */
public class Eratosthenes {

    private static List<Integer> cal(int m){
        List<Integer> list = new ArrayList<>();
        Integer a[] = new Integer[m+1];
        for(int i=0;i<a.length;i++){
            a[i] = i;
        }
        a[1] = 0;
        for (int i=2;i<Math.sqrt(m);i++){
            for (int j = i+1;j<=m;j++){
                if(a[j]!=0&&a[j]%i==0){
                    a[j]=0;
                }
            }
        }

        for (int i=0;i<=m;i++){
            if (a[i]!=0){
                list.add(a[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = cal(1000000);
        for (int i:list){
            System.out.println(i);
        }
    }
}
