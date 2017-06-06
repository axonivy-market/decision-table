package com.axonivy.ivy.process.element.rule;

import javax.swing.table.AbstractTableModel;

import com.axonivy.ivy.process.element.rule.model.RulesModel;

public class RulesTableModel extends AbstractTableModel
{
  private RulesModel model;
  
  public RulesTableModel(RulesModel model)
  {
    this.model = model;
  }

  @Override
  public String getColumnName(int column)
  {
    return model.getColumns().get(column).getText();
  }
  
  @Override
  public int getRowCount()
  {
    return model.getRows().size();
  }

  @Override
  public int getColumnCount()
  {
    return model.getColumns().size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    return model.getRows().get(rowIndex).getCells().get(columnIndex).getText();
  }
}
