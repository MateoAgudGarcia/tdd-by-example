package springboot.course.exercise1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class Sum implements Expression{
    private Expression augmend;
    private Expression addmend;

    public Money reduce(Bank bank, String to){
        int amount = getAugmend().reduce(bank,to).getAmount()+ getAddmend().reduce(bank,to).getAmount();
        return new Money(amount,to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this,addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }

}
