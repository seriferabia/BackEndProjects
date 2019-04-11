package at.nacs.bew3reflection.logic;

import at.nacs.bew3reflection.domain.HandshakeMoves;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class HandshakeTranslator {
    private final HandshakeMoves moves;

    public List<String> translateToMoves(Integer number) {
        return Stream.of(number.toString().split(""))
                .mapToInt(Integer::valueOf)
                .boxed()
                .filter(e -> moves.getMoves().containsKey(e))
                .map(e -> moves.getMoves().get(e))
                .collect(Collectors.toList());
    }
}
