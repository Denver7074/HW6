import com.ibm.icu.text.RuleBasedNumberFormat;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.Integer.parseInt;
public class HoweWork {
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

