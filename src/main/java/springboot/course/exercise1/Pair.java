package springboot.course.exercise1;

import  lombok.AllArgsConstructor;
import java.util.Objects;

@AllArgsConstructor
public class Pair {
    private final String from;
    private final String to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
