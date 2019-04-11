package at.nacs.bew3reflection.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class SpecialAgent {
    private final HandshakeTranslator translator;
    private Scanner scanner = new Scanner(System.in);

    public void shakeHand() {
        Integer price = askPrice();
        System.out.println(translator.translateToMoves(price));
    }

    private Integer askPrice() {
        System.out.println("What is price of this device?");
        return scanner.nextInt();
    }
}
