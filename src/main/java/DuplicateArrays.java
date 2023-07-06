import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 6, 2, 3, 2, 2, 2};
        System.out.println(duplicateNumbers(arr));
    }

    public static List<Integer> duplicateNumbers(int[] arr) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if (!numberMap.containsKey(arr[i])) numberMap.put(arr[i], 1);
            else numberMap.put(arr[i], numberMap.get(arr[i]) + 1);
        }

        List<Integer> result = numberMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        return result;
    }
}
