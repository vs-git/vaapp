package org.rm.genie.vaapp.component.footers.items;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class ButtonAssignmentItem extends CssLayout
{

  public ButtonAssignmentItem(String imgType, String text)
  {
    Label pic = new Label();
    Label name = new Label(text);
    Label nameGradient = new Label("");
    setPrimaryStyleName("rm-button-assignment-item");
    addStyleName(imgType);
    //pic.setPrimaryStyleName(imgType);
    pic.addStyleName("icon");
    name.addStyleName("text");
    name.setContentMode(ContentMode.HTML);
    nameGradient.addStyleName("gradient");
    addComponents(pic, name, nameGradient);
  }
}
