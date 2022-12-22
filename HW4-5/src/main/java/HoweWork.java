import com.ibm.icu.text.RuleBasedNumberFormat;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.Integer.parseInt;
public class HoweWork {
   //    Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
//    Надо вернуть [1, 2, 2, 3] (порядок неважен)
//    Сложность алгоритма: худшее n^2, лучшее 2n
    public List<Integer> mass(Integer[] m, Integer[] n){
        Map<Integer,Integer> map = new HashMap<>();
        Stream.concat(Arrays.asList(m).stream(),Arrays.asList(n).stream()).sorted().forEach(e->map.merge(e,1,(prev,one)->prev+one));
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        for (Integer v : map.values()){
            if (v % 2 == 0){
                for (int i = 0; i < v/2; i++){
                    result.add(new ArrayList<>(map.keySet()).get(count));
                }
            }
            count ++;
        }
        return result;
    }
}

