package org.rm.genie.vaapp.component;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;

import org.rm.genie.vaapp.IndexUI;
import org.rm.genie.vaapp.UserOnline;
import org.rm.genie.vaapp.backend.LoginService;
import org.rm.genie.vaapp.genie.shared.entity.um.Adult;
import org.rm.genie.vaapp.model.LoginForm;

public class LoginFormComponent extends CustomLayout {

  Button saveButton = new Button("Save");
  TextField loginName = new TextField();
  PasswordField password = new PasswordField();

  LoginForm loginform  = new LoginForm();

  BeanFieldGroup<LoginForm> formFieldBindings = BeanFieldGroup.bindFieldsBuffered(loginform, this);

  public LoginFormComponent() {
    setTemplateName("components/loginForm");
    saveButton.addClickListener(ClickListener);
    //saveButton.setDisableOnClick(true);
    saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

    //formFieldBindings = new BeanFieldGroup<>(LoginForm.class);

    loginName.setId("loginName");
    //loginField.addValidator(new StringLengthValidator("The name must be 1-10 letters (was {0})", 1, 10, false));
    //loginField.setStyleName("styyy");

    password.setId("password");
    //pwdField.setPrimaryStyleName("qqqaaa");

    addComponent(new UserOnline(), "userOnline");
    addComponent(loginName, "loginField");
    addComponent(password, "pwdField");
    addComponent(saveButton, "saveButton");
  }




  Button.ClickListener ClickListener = new Button.ClickListener()
  {
    public void buttonClick(Button.ClickEvent event)
    {
      try {
        formFieldBindings.commit();
        Adult user = LoginService.login(loginform); // Here we can save returned Adult as global system object
        if (user.getUserID() > 0)
          getUI().setWindowContent();
      } catch (FieldGroup.CommitException e) {
        e.printStackTrace();
      }
    }
  };

  @Override
  public IndexUI getUI() {
    return (IndexUI) super.getUI();
  }

}