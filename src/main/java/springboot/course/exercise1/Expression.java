package springboot.course.exercise1;

public interface Expression {
    Money reduce(Bank bank, String to);

    abstract Expression plus(Expression addend);

    Expression times(int multiplier);
}
