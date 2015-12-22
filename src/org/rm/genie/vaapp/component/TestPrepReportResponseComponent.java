package org.rm.genie.vaapp.component;

import com.vaadin.client.widget.grid.sort.Sort;
import com.vaadin.client.widgets.*;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.Grid;
import org.rm.genie.vaapp.genie.shared.content.TPStandard;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportResponse;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestReportCell;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestReportStudent;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TestPrepReportResponseComponent extends HorizontalLayout
{
  Grid grid = new Grid();
  TestPrepReportResponse TPResponse;

  public TestPrepReportResponseComponent(TestPrepReportResponse TPResponse)
  {
    setWidth("100%");
    this.TPResponse = TPResponse;
/*
    Grid.Column c1 = grid.addColumn("name", String.class);
    Grid.Column c2 = grid.addColumn("born", Integer.class);

    Grid.HeaderRow h1 = grid.prependHeaderRow();
    Grid.HeaderCell hc1 = h1.getCell("name");
    Grid.HeaderCell hc2 = h1.getCell("born");

    h1.join(hc1, hc2).setHtml("qwerqweTB");

    grid.addHeaderRowAt(2);

    grid.addRow("Nicolaus Copernicus", 1);
    grid.addRow("Galileo Galilei",     2);
    grid.addRow("Johannes Kepler",     4);
 */

    compose();

    addComponent(grid);

  }

  private void compose()
  {

    List<Grid.Column> columns = new ArrayList<>();

    columns.add(grid.addColumn("@", String.class));
    columns.add(grid.addColumn("name", String.class));
    columns.add(grid.addColumn("assignments", String.class));
    columns.add(grid.addColumn("total", String.class));

    grid.setWidth("100%");


    Map<Integer, Integer> cntCat = new LinkedHashMap<>();

    // Set columns (and "Standards" headers)
    int currentCategoryID = 0;

    for (TPStandard tpStandard : TPResponse.getTpStandards())
    {
      if (!cntCat.containsKey(tpStandard.getCategoryID()))
        cntCat.put(tpStandard.getCategoryID(), 0);

      Grid.Column c;
      if (currentCategoryID != 0 && tpStandard.getCategoryID() != currentCategoryID)
      {
        columns.add(grid.addColumn(currentCategoryID + "Tolal", String.class).setHeaderCaption("Tolal"));
        cntCat.put(currentCategoryID, cntCat.get(currentCategoryID) + 1);
      }

      columns.add(grid.addColumn(tpStandard.getStd(), String.class).setHeaderCaption(tpStandard.getStd()));
      currentCategoryID = tpStandard.getCategoryID();
      cntCat.put(tpStandard.getCategoryID(), cntCat.get(tpStandard.getCategoryID()) + 1);
    }
    columns.add(grid.addColumn(currentCategoryID + "Tolal", String.class).setHeaderCaption("Tolal"));
    cntCat.put(currentCategoryID, cntCat.get(currentCategoryID) + 1);

    int startFor = 3;
    int lengthFor = columns.size() - startFor;

/*
    // "class total" Row
    String[] studentsTotal = new String[columns.size()];
    studentsTotal[0] = "";
    studentsTotal[1] = "class total";
    studentsTotal[2] = "";
    for(int i = 0; i<lengthFor; i++)
    {
      String value;
      if (TPResponse.getTotal()[i] == -1)
        value = "-";
      else
        value = new BigDecimal(100 * TPResponse.getTotal()[i]).setScale(0, RoundingMode.HALF_UP) + "%";//(Math.rint(100 * TPResponse.getTotal()[i])) + "%";

      studentsTotal[i + startFor] = value;
    }
    grid.addRow((Object[])studentsTotal);
*/
    Grid.HeaderRow hTotal = grid.appendHeaderRow();
    for(int ci = 0; ci < lengthFor; ci++)
    {
      String value;
      if (TPResponse.getTotal()[ci] == -1)
        value = "-";
      else
        value = new BigDecimal(100 * TPResponse.getTotal()[ci]).setScale(0, RoundingMode.HALF_UP) + "%";
      hTotal.getCell(columns.get(ci + startFor).getPropertyId()).setText(value);
    }



    // "students" Rows
    String[][] students = new String[TPResponse.getStudents().size()][columns.size()];
    for (int si = 0; si < TPResponse.getStudents().size(); si++)
    {
      TestReportStudent student = TPResponse.getStudents().get(si);
      students[si][0] = "";
      students[si][1] = student.getFirstName() + " " + student.getLastName();
      students[si][2] = "";
      for (int ii = 0; ii < lengthFor; ii++)
      {
        TestReportCell cell = student.getCells().get(ii);

        String cVal;
        if (cell.getRatio() == -1)
          cVal = "-";
        else
          cVal = new BigDecimal(100 * cell.getRatio()).setScale(0, RoundingMode.HALF_UP) + "%";
        students[si][ii + startFor] = cVal;
      }

      grid.addRow((Object[])students[si]);
    }


    //Top header
    Grid.HeaderRow h0 = grid.prependHeaderRow();
    int from = 4;
    for(Map.Entry<Integer, Integer> e : cntCat.entrySet())
    {
      String catId = e.getKey().toString();
      int cnt = e.getValue();
      Object[] as = new Object[cnt];
      for(int ai = 0; ai < cnt; ai++)
      {
        as[ai] = columns.get(from + ai).getPropertyId();
      }
      from = from + cnt;
      h0.join(as).setText(TPResponse.getCategories().get(catId));//catId as int is not work. Here is probably incorrect mapping from json
    }


    grid.getHeaderRow(0).getCell(columns.get(1).getPropertyId()).setHtml("<div style='text-align:center; width:100%;'>test header</div>");

    grid.setFrozenColumnCount(2);
  }

}
