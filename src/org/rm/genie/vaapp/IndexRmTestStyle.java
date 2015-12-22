package org.rm.genie.vaapp;

import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.rm.genie.vaapp.component.RmTabSheet;
import org.rm.genie.vaapp.genie.shared.entity.um.Adult;

public class IndexRmTestStyle extends UI
{

  Adult user = new Adult();

  @Override
  protected void init(VaadinRequest request) {
    setTheme("rmtest");

    CssLayout layout = new CssLayout();

    layout.addComponent(new RmTabSheet());

    setContent(layout);
  }




}
