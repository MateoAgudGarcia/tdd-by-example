package springboot.course.exercise1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Money implements Expression {
    protected int amount;
    protected String currency;

    protected String currency(){
        return currency;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return getAmount() == money.getAmount() && getCurrency().equals(money.getCurrency());
    }

    @Override
    public Money reduce(Bank bank, String to){
        return new Money(amount/bank.rate(this.getCurrency(),to), to);
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(getAmount() * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addend){
        return new Sum(this,addend);
    }

}
