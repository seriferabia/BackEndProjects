package at.nacs.bew2reflection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {
    private final Primes primes;

    public int sumPrimes(Integer amount) {
        return IntStream.iterate(2, n -> n + 1)
                .filter(primes::isPrime)
                .limit(amount)
                .sum();
    }
}
