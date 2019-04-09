package validation;

public class LengthValidator implements Validator {

    private final Integer MINIMUN_LENGTH_OF_PASSWORD = 8;

    @Override
    public Boolean check(String password) {
        return password.length() > MINIMUN_LENGTH_OF_PASSWORD;
    }
}
