package org.rm.genie.vaapp.component.headers;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class ReportSheetHeader extends CssLayout
{
  Label pic1 = new Label();
  Label pic2 = new Label();
  Label pic3 = new Label();
  Label title = new Label();
  public ReportSheetHeader()
  {
    setPrimaryStyleName("rm-sheet-header");
    title.setCaption("STAAR Readiness Report");
    pic1.setPrimaryStyleName("rm-icon-tabl");
    pic2.setPrimaryStyleName("rm-icon-arr");
    pic3.setPrimaryStyleName("rm-icon-filter");
    pic1.addStyleName("icon");
    pic2.addStyleName("icon");
    pic3.addStyleName("icon");
    addComponents(pic1, pic2, title, pic3);
  }
}
