package verification;

import logic.Verifier;

public class PasswordVerifier {

    private Verifier verifier = new Verifier();

    public Boolean verify(String password) {
        return verifier.isOkay(password);
    }
}
