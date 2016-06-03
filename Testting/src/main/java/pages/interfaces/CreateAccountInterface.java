package pages.interfaces;

/**
 * Created by mac-250 on 2/29/16.
 */
public interface CreateAccountInterface extends BaseScreenInterface {
    public CreateAccountInterface fillEmailField(String email);
    public CreateAccountInterface fillPasswordField(String password);
    public CreateAccountInterface fillReenterPasswordField(String password);
    public CreateAccountInterface fillPhoneNumberField(String phoneNumber);

    public HomeInterface pressCreateAccountButton();

}
