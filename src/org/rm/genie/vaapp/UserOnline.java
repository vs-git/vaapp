package org.rm.genie.vaapp;

import com.vaadin.ui.*;
import org.rm.genie.vaapp.backend.UserOnlineService;
import org.rm.genie.vaapp.genie.shared.entity.Pair;
import org.rm.genie.vaapp.genie.shared.entity.RMDate;

import java.util.HashMap;

public class UserOnline extends HorizontalLayout
{
  Label text = new Label("Population");

  public UserOnline() {

    HashMap<String, Object> p = UserOnlineService.userOnline();
    String num = Integer.toString((int) p.get("left"));
    addComponent(text);
    addComponent(new Label(num));
  }
}
