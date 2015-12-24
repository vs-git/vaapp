package org.rm.genie.vaapp;

import com.vaadin.server.VaadinService;
import org.rm.genie.vaapp.backend.LoginService;
import org.rm.genie.vaapp.component.LoginFormComponent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.rm.genie.vaapp.component.TestPrepReportRequestComponent;
import org.rm.genie.vaapp.component.TestPrepReportResponseComponent;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportResponse;
import org.rm.genie.vaapp.genie.shared.entity.um.Adult;
import org.rm.genie.vaapp.model.LoginForm;
import org.rm.genie.vaapp.util.DataMapping;
import org.rm.genie.vaapp.util.VHttpRequest;

import org.apache.http.cookie.Cookie;

public class IndexUI extends UI {
  //Grid contactList = new Grid(); //??????????!!!
  //Link link = new Link("RM City", new ExternalResource("http://rmcity.org/genie"));
  //MyComponent mc = new MyComponent();
  Adult user = new Adult();

  @Override
  protected void init(VaadinRequest request) {
    setTheme("default");

    setTableSheet();//setWindowContent()
  }

  public void setWindowContent()
  {
//System.out.println("VHttpRequest.getCookie(\"l\"): "+VHttpRequest.getCookie("l"));
    if (VHttpRequest.getCookie("l") != null)
      user = LoginService.loginFromSession(user);

    Layout la;
    if (user.getUserID() > 0)
      setMainWindow();
    else
      setLoginWindow();
  }

  protected void setLoginWindow() {

    CustomLayout content = new CustomLayout("layout");

    content.addComponent(new LoginFormComponent(), "content");
/*
    try {
      TestPrepReportResponse TPResponse = DataMapping.getFakeTPResponse();
      content.addComponent(new TestPrepReportResponseComponent(TPResponse), "content");
    } catch (Exception e) {
      e.printStackTrace();
    }
*/
    setContent(content);
  }

  protected void setMainWindow() {
    CustomLayout content = new CustomLayout("layout");

    content.addComponent(new TestPrepReportRequestComponent(), "content");
    setContent(content);
  }

  protected  void setTableSheet() {
    CssLayout layout = new CssLayout();
    TabSheet tabsheet = new TabSheet();
    layout.addComponent(tabsheet);

    tabsheet.setTabCaptionsAsHtml(true);

    VerticalLayout tab1 = new VerticalLayout();
    tab1.addComponent(new Label("Mercury tab content"));
    tab1.setCaptionAsHtml(true);
    tabsheet.addTab(tab1, "<div>Mercury</div>");

    VerticalLayout tab2 = new VerticalLayout();
    tab2.addComponent(new Label("Venus tab content"));
    tab2.setCaptionAsHtml(true);
    tab2.setCaption("<div>Venus</div>");
    tabsheet.addTab(tab2);

    setContent(layout);
  }

  protected  void setTableSheet2() {
    CssLayout layout = new CssLayout();


    //getLayout().setSpacing(true);
    TabSheet ts = new TabSheet();
    ts.setCaption("TabSheet - no <u>html</u> in tab captions");
    ts.setCaptionAsHtml(true);
    ts.addTab(new Label(), "<font color='red'>red</font>");
    ts.addTab(new Label(), "<font color='blue'>blue</font>");
    layout.addComponent(ts);

    ts = new TabSheet();
    ts.setCaption("TabSheet - <b>html</b> in tab captions");
    ts.setCaptionAsHtml(false);
    ts.setTabCaptionsAsHtml(true);
    ts.addTab(new Label(), "<font color='red'>red</font>");
    ts.addTab(new Label(), "<font color='blue'>blue</font>");
    layout.addComponent(ts);

    Accordion acc = new Accordion();
    acc.setCaption("Accordion - no <u>html</u> in tab captions");
    acc.setCaptionAsHtml(true);
    acc.addTab(new Label(), "<font color='red'>red</font>");
    acc.addTab(new Label(), "<font color='blue'>blue</font>");
    layout.addComponent(acc);

    acc = new Accordion();
    acc.setCaption("Accordion - <b>html</b> in tab captions");
    acc.setCaptionAsHtml(false);
    acc.setTabCaptionsAsHtml(true);
    acc.addTab(new Label(), "<font color='red'>red</font>");
    acc.addTab(new Label(), "<font color='blue'>blue</font>");
    layout.addComponent(acc);


    setContent(layout);
  }

}

/**
 * Created by vstebakov on 24.11.2015.

public class VaadinGenieApp extends UI
{
  //@Override
  public void init(VaadinRequest request)
  {
    for ( Cookie c : request.getCookies())
    {
      System.out.println(c.getName() + "=>" + c.getValue() );
    }


    //FormLayout form = new FormLayout(new TextField("Login"), new PasswordField());

    VerticalLayout layout = new VerticalLayout();
    setContent(layout);
    layout.addComponent(new Label("Hello, Genie 2 world!"));

    //layout.addComponent(form);
  }
}*/
