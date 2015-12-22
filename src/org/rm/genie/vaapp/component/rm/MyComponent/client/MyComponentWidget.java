package org.rm.genie.vaapp.component.rm.MyComponent.client;


import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;

public class MyComponentWidget extends HTML
{

  public static final String CLASSNAME = "mycomponent";

  /**
   * @link #setElement()
   */
  public MyComponentWidget() {

    //setElement(DOM.createLabel());
    //setText("This is Anchor MyComponent");
    setHTML("<label>" + "qqqqwwwww" + "<label>");
    setStyleName(CLASSNAME);
  }

}

/*
public class MyComponentWidget extends Label {

  public static final String CLASSNAME = "mycomponent";

  public MyComponentWidget() {
    setText("This is MyComponent");
    setStyleName(CLASSNAME);
  }
}

 */
