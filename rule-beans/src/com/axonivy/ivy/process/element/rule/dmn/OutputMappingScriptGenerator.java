package com.axonivy.ivy.process.element.rule.dmn;

import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class OutputMappingScriptGenerator
{
  private OutputMappingScriptGenerator()
  {
  }

  public static String create(Map<String, Object> entryMap)
  {
    StringBuilder ivyScript = new StringBuilder();
    for (Map.Entry<String, Object> entry : entryMap.entrySet())
    {
      if (entry.getValue() != null && StringUtils.isNotEmpty(entry.getValue().toString())) {
        String property = entry.getKey().replaceFirst("out", "in");
        ivyScript.append(createAssignment(property, entry.getValue()));
      }
    }
    return ivyScript.toString();
  }

  private static String createAssignment(String property, Object value)
  {
    StringBuilder builder = new StringBuilder();
    builder.append(property);
    builder.append(" = ");
    builder.append(valueToIvyScript(value));
    builder.append(";");
    return builder.toString();
  }

  private static String valueToIvyScript(Object value)
  {
    String v = value.toString();
    if ("true".equals(v) || "false".equals(v))
    {
      return v;
    }
    if (NumberUtils.isNumber(v))
    {
      return v;
    }
    return "\"" + StringEscapeUtils.escapeJava(v) + "\"";
  }

}
