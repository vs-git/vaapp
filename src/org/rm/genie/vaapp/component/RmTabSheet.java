package org.rm.genie.vaapp.component;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import org.rm.genie.vaapp.component.footers.ReportSheetFooter;
import org.rm.genie.vaapp.component.headers.ReportSheetHeader;

public class RmTabSheet extends TabSheet
{


  public RmTabSheet()
  {
    // Create the first tab
    CssLayout tab1 = new CssLayout();
    tab1.addComponent(new Label("logo"));
    addTab(tab1, null);





    CssLayout tab2 = new CssLayout();
    tab2.addStyleName("rm-tabsheet-layout");
    //tab2.setCaptionAsHtml(true);//не работает, походу баг
    tab2.setCaption("STAAR Readiness Report"); //"STAAR <br/>Readiness Report"
    //tab2.setSizeUndefined(); //не работает, вычисление ширины идет при генерации и устанавливается в аттрибуте style
    tab2.addComponent(new ReportSheetHeader());

    CssLayout content = new CssLayout();
    content.setPrimaryStyleName("rm-tabsheet-content");
    Label lbl = new Label("11111111<br>22222222<br>3333333<br>4444444<br>5555555<br>66666666<br>777777<br><br><br><br><br><br><br><br><br><br><br>11111111<br>2222222<br>3333333<br>4444444");
    lbl.setContentMode(ContentMode.HTML);
    content.addComponent(lbl);
    tab2.addComponent(content);

    tab2.addComponent(new ReportSheetFooter());
    addTab(tab2);
    getTab(tab2).setClosable(true);
    getTab(tab2).setStyleName("rm-sheet-label");

    //tabsheet.getTab(tab2).setCaption("STAAR<br/>Readiness Report");





    CssLayout tab3 = new CssLayout();
    tab3.addComponent(new Label("Class Management Sheet Content"));
    tab3.setCaption("Class Management");
    addTab(tab3);
    getTab(tab3).setClosable(true);
    getTab(tab3).setStyleName("rm-sheet-label");

    getTab(0).setEnabled(false);

    /*
    TabSheet ts = new TabSheet();
    ts.setCaption("TabSheet - no <u>html</u> in tab captions");
    ts.setCaptionAsHtml(true);
    ts.addTab(new Label(), "<font color='red'>red</font>");
    ts.addTab(new Label(), "<font color='blue'>blue</font>");
    layout.addComponent(ts);
*/
  }
}
