# DMN Decision Table

![CI Build](https://github.com/axonivy-market/decision-table/actions/workflows/ci.yml/badge.svg)

Enables you to apply DMN decision tables on your data without scripting effort.

## Decision Table Activity
Simple and expressive decision table element. 
![Process with Decision Table](doc/in-action.png)

### DMN
Exposes the decision in standard [DMN](http://www.omg.org/spec/DMN/) format so that it can be run and edited in any DMN engine.
![DMN XML](doc/dmn-tab.png)

### Edit
Convenient condition editing with zero scripting
![Condition Editing](doc/edit-condition.png)

## Setup
1. Download the `dmn-decision-table-*.jar`
2. Copy the file into the `dropins` directory of your Axon Ivy Designer
3. Start Axon Ivy Designer
4. Open a process and use the additional beans provided in the `Rules` drawer of Process Editor palette
