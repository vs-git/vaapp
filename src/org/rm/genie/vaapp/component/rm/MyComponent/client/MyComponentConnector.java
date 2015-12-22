package org.rm.genie.vaapp.component.rm.MyComponent.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.rm.genie.vaapp.component.rm.MyComponent.MyComponent;


@Connect(MyComponent.class)
public class MyComponentConnector extends AbstractComponentConnector {
  @Override
  protected Widget createWidget() {
    return GWT.create(MyComponentWidget.class);
  }

  /*
  @Override
  public MyComponentWidget getWidget() {
    return (MyComponentWidget) super.getWidget();
  }*/
}
