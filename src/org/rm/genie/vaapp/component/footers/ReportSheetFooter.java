package org.rm.genie.vaapp.component.footers;

import com.vaadin.ui.CssLayout;
import org.rm.genie.vaapp.component.ImgTypes;
import org.rm.genie.vaapp.component.footers.items.ButtonAssignmentItem;

public class ReportSheetFooter extends CssLayout
{
  public ReportSheetFooter()
  {
    ButtonAssignmentItem b1 = new ButtonAssignmentItem(ImgTypes.ASSIGN_CHECKMARK_GAME, "Assign<br>Checkmark Game");
    ButtonAssignmentItem b2 = new ButtonAssignmentItem(ImgTypes.ASSIGN_STAAR_PRACTICE, "Assign<br>STAAR Practice");
    ButtonAssignmentItem b3 = new ButtonAssignmentItem(ImgTypes.ASSIGN_STAAR_R_MODULE, "Assign<br>STAAR Readiness Module 11111 22222");
    ButtonAssignmentItem b4 = new ButtonAssignmentItem(ImgTypes.UNASSIGN_STAAR_R_MODULE, "Unassign<br>STAAR Readiness Module 1111 22222");

    /*CssLayout lay = new CssLayout();
    lay.addComponents();
    lay.setPrimaryStyleName("rm-sheet-footer-after");
*/
    setPrimaryStyleName("rm-sheet-footer");
    addComponents(b1, b2, b3, b4/*, lay*/);
  }
}
