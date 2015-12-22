package org.rm.genie.vaapp.component;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import org.rm.genie.vaapp.backend.TestPrepReportService;
import org.rm.genie.vaapp.converter.DateField2RMDateConverter;
import org.rm.genie.vaapp.genie.shared.entity.RMDate;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportRequest;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportResponse;
import org.rm.genie.vaapp.util.DataMapping;

public class TestPrepReportRequestComponent extends VerticalLayout
{

  Button saveButton = new Button("Build report");

  TextField classID = new TextField("classID");
  DateField startDate = new DateField("startDate");
  DateField endDate = new DateField("endDate");
  TextField grade = new TextField("grade");
  TextField material = new TextField("material");
  TextField isPrint = new TextField("isPrint");
  TextField localSortColumn = new TextField("localSortColumn");
  TextField localSortAsc = new TextField("localSortAsc");
  TextField lastNDays = new TextField("lastNDays");
  TextField lastSolvedProblemsNumber = new TextField("lastSolvedProblemsNumber");



  TestPrepReportRequest TPRequest  = new TestPrepReportRequest();
  TestPrepReportResponse TPResponse = new TestPrepReportResponse();

  BeanFieldGroup<TestPrepReportRequest> formFieldBindings = BeanFieldGroup.bindFieldsBuffered(TPRequest, this);

  public TestPrepReportRequestComponent() {

    saveButton.addClickListener(ClickListener);
    saveButton.setDisableOnClick(true);
    saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);

    startDate.setConverter(new DateField2RMDateConverter());
    endDate.setConverter(new DateField2RMDateConverter());
    startDate.setConvertedValue(new RMDate(2015, 8, 21, 0, 0));
    endDate.setConvertedValue(new RMDate(2015, 11, 22, 0, 0));
    //isPrint.setConverter(new BooleanConverter());
    //isPrint.setConvertedValue(true);

    addComponents(classID, startDate, endDate, grade, material, isPrint, localSortColumn, localSortAsc, lastNDays, lastSolvedProblemsNumber, saveButton);
  }

  Button.ClickListener ClickListener = new Button.ClickListener()
  {
    public void buttonClick(Button.ClickEvent event)
    {
      try {
        formFieldBindings.commit();
        //TestPrepReportService.getReport(TPRequest, TPResponse); // Here we can save returned Adult as global system object
        TPResponse = DataMapping.getFakeTPResponse();
        addComponent(new TestPrepReportResponseComponent(TPResponse));
      //} catch (FieldGroup.CommitException e) {
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  };

}