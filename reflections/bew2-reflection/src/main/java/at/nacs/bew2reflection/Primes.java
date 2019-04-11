package at.nacs.bew2reflection;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Primes {
    public Boolean isPrime(Integer number) {
        if (number < 2) {
            return false;
        }
        return IntStream.range(2, number)
                .allMatch(e -> number % e != 0);
    }
}
