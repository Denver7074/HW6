import com.ibm.icu.text.RuleBasedNumberFormat;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.Integer.parseInt;
public class HoweWork {
    //Посчитать факториал вводимого числа из консоли, при этом код должен быть максимально оптимизированным.
    public int factorial(int number){
        String[] mass = String.valueOf(number).split("");
        List<Integer> list = List.of(number);
        int sum = 1;
        for (int i = 0; i < mass.length; i++){
            sum = sum * Integer.parseInt(mass[i]);
        }
        return sum;
    }

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
    //(-40 до 40)
    public String randomNumber(int start, int end, int size){
        double[] mass = new double[size];
        double scale = Math.pow(10, 1);
        double max = mass[0];
        double min = mass[0];
        for (int i = 0; i < size; i++){
            mass[i] = Math.ceil(((Math.random()*((end - start))) + start)*scale)/scale;
        }
        for (int i = 0; i < mass.length; i++){
            if (max < mass[i]){
                max = mass[i];
            }
            if (min > mass[i]){
                min = mass[i];
            }
        }
        return Arrays.toString(mass) + "\nMax: " + max +"\nMin: " + min;
    }
    //Лучшее время забега задача № 14.2 (есть только один победитель)
    public String run(double[] time){
        double bestTime = time[0];
        int number = 1;
        for (int i = 0; i < time.length; i++){
            if (bestTime > time[i]){
                bestTime = time[i];
                number = i + 1;
            }
        }
        return "The best time: " + bestTime + "\nWinner number: " + number;
    }


    //Дана строка вида:
    //AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
    //Необходимо получить строку вида:
    //A4B3C2XYZD4E3F3A6B28
    //которая строится путем подсчета количества последовательных символов.
    //На печать выводится буква + его количество, кроме единицы
    public String line(String text){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        List.of(text.split("")).forEach(e->map.merge(e,1,(prev,one)->prev+one));
        String result = "";
        ArrayList<Integer> values = new ArrayList<>(map.values());
        List<String> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++){
            result = result + keys.get(i);
            if (values.get(i) != 1){
                result = result + values.get(i);
            }
        }
        return result;
    }
//    Даны даты заезда и отъезда каждого гостя.
//    Для каждого гостя дата заезда строго раньше даты отъезда
//    (то есть каждый гость останавливается хотя бы на одну ночь).
//    В пределах одного дня считается, что сначала старые гости выезжают,
//    а затем въезжают новые. Найти максимальное число постояльцев,
//    которые одновременно проживали в гостинице (считаем,
//    что измерение количества постояльцев происходит в конце дня).
//    sample = [ (1, 2), (1, 3), (2, 4), (2, 3), ]
//    public String[] maxPerson(String[] date){
//        for (int i = 0; i < date.length; i++){
//
//        }
//    }
    //    Необходимо получить последовательность отрезков непрерывных чисел из массива.
    //    Пример [1, 5, 6, 8, 4, 9] -> [1-1, 4-6, 8-9]
    public String sequence(Integer[] mass){
        String text = "";
        List<Integer> list = List.of(mass).stream().sorted().toList();
        for (int i = 0; i < list.size(); i++){
            text = text + list.get(i);
            if (i != list.size()-1 && list.get(i + 1) - list.get(i) > 1){
                text = text + " ";
            }
        }
        String[] t = text.split(" ");
        for (int i = 0; i < t.length; i++){
            if (t[i].length() == 1){
                t[i] = (t[i].charAt(0) + "-" + t[i].charAt(0)).trim();
            }
            if (t[i].length() >= 2){
                t[i] = (t[i].charAt(0) + "-" + t[i].charAt(t[i].length()-1)).trim();
            }
        }
        return Arrays.toString(t);
    }
    //статистические методы
    public String statistic(BigInteger[] mass){
        List<BigInteger> list = Arrays.asList(mass);
        BigInteger max = list.stream().max(BigInteger::compareTo).get();
        BigInteger min = list.stream().min(BigInteger::compareTo).get();
        return "\nMax: " + max + "\nMin: " + min;
    }
}

