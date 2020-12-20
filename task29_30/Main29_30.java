package task29_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main29_30 {
    public static void main(String[] args) {
        StreamSplit str = new StreamSplit();
        str.run();
    }

    public static class StreamSplit {
        public void run() {
            InputStreamReader streamReader = new InputStreamReader((System.in));
            BufferedReader reader = new BufferedReader(streamReader);
            Comparator<Map.Entry<String, Long>> KeyComp = Map.Entry.comparingByKey(),
                    WordComp = Map.Entry.comparingByValue(Comparator.reverseOrder());

            Stream<String> stream = reader.lines();
            stream.map(String::toLowerCase)
                    .flatMap(s->stream(s.split("\\W+")))
                    .collect(groupingBy(t->t, counting()))
                    .entrySet()
                    .stream()
                    .sorted(WordComp.thenComparing(KeyComp))
                    .map(k -> k.getKey()).limit(10)
                    .forEach(System.out::println);
        }
    }
}