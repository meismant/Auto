package pages.interfaces;

/**
 * Created by mac-250 on 2/24/16.
 */
public interface LogInInterface extends BaseScreenInterface {
    public boolean isPageOpened();
    public LogInInterface fillEmailField(String email);
    public LogInInterface fillPasswordField(String password);
    public BaseScreenInterface pressLogInButton();
    public LogInInterface clearFields();
    public String getAlertTitle();
    public String getAlertMessage();
    public void pressAlertOkButton();
}
