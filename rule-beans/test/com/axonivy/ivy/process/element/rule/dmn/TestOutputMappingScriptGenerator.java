package com.axonivy.ivy.process.element.rule.dmn;

import static org.junit.Assert.assertEquals;

import org.camunda.bpm.dmn.engine.impl.DmnDecisionRuleResultImpl;
import org.camunda.bpm.engine.variable.impl.value.PrimitiveTypeValueImpl.BooleanValueImpl;
import org.camunda.bpm.engine.variable.impl.value.PrimitiveTypeValueImpl.DoubleValueImpl;
import org.camunda.bpm.engine.variable.impl.value.PrimitiveTypeValueImpl.IntegerValueImpl;
import org.camunda.bpm.engine.variable.impl.value.PrimitiveTypeValueImpl.StringValueImpl;
import org.junit.Test;

public class TestOutputMappingScriptGenerator
{
  @Test
  public void mapStringProperty()
  {
    DmnDecisionRuleResultImpl result = new DmnDecisionRuleResultImpl();
    result.putValue("out.person.name", new StringValueImpl("Alex"));
    assertIvyScript(result, "in.person.name = \"Alex\";");
  }

  @Test
  public void mapBooelanProperty()
  {
    DmnDecisionRuleResultImpl result = new DmnDecisionRuleResultImpl();
    result.putValue("out.person.gender", new BooleanValueImpl(true));
    assertIvyScript(result, "in.person.gender = true;");
  }

  @Test
  public void mapIntegerProperty()
  {
    DmnDecisionRuleResultImpl result = new DmnDecisionRuleResultImpl();
    result.putValue("out.person.age", new IntegerValueImpl(10));
    assertIvyScript(result, "in.person.age = 10;");
  }

  @Test
  public void mapDoubleProperty()
  {
    DmnDecisionRuleResultImpl result = new DmnDecisionRuleResultImpl();
    result.putValue("out.person.cost", new DoubleValueImpl(106.75));
    assertIvyScript(result, "in.person.cost = 106.75;");
  }

  @Test
  public void mapMultipleProperties()
  {
    DmnDecisionRuleResultImpl result = new DmnDecisionRuleResultImpl();
    result.putValue("out.person.name", new StringValueImpl("Peter Hochstrasser"));
    result.putValue("out.person.cost", new DoubleValueImpl(-684.7897));
    result.putValue("out.person.gender", new BooleanValueImpl(false));

    assertIvyScript(result, "in.person.gender = false;in.person.name = \"Peter Hochstrasser\";in.person.cost = -684.7897;");
  }

  private void assertIvyScript(DmnDecisionRuleResultImpl result, String expectedIvyScript)
  {
    String ivyScript = OutputMappingScriptGenerator.create(result);
    assertEquals(ivyScript, expectedIvyScript);
  }
}
