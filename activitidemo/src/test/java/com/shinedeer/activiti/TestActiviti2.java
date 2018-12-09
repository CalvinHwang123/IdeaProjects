package com.shinedeer.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author Calvin Hwang
 * 2018/12/8 15:27
 * 流程定义管理 CRUD
 */
public class TestActiviti2 {

    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     *  加载 zip 文件部署流程定义
     */
    @Test
    public void testDeploymentProcessDefinitionByZip() {

        ZipInputStream inputStream = new ZipInputStream(
            getClass().getClassLoader()
                .getResourceAsStream("diagrams/helloworld.zip"));

        Deployment deployment = processEngine.getRepositoryService()
            .createDeployment()
            .name("测试部署流程定义")
            .addZipInputStream(inputStream)
            .deploy();

        System.out.println("部署 id：" + deployment.getId());
        System.out.println("部署 name：" + deployment.getName());

    }

    /**
     * 查看流程定义
     */
    @Test
    public void testQueryProcessDefinition() {
        List<ProcessDefinition> processDefinitionList = processEngine.getRepositoryService()
            .createProcessDefinitionQuery()
            .list();

        for (ProcessDefinition processDefinition: processDefinitionList) {
            System.out.println("流程定义 id：" + processDefinition.getId());
            System.out.println("流程定义 名称：" + processDefinition.getName());
            System.out.println("流程定义 KEY：" + processDefinition.getKey());
            System.out.println("流程定义 版本：" + processDefinition.getVersion());
        }

    }

    /**
     * 删除流程定义
     */
    @Test
    public void testDeleteProcessDefinition() {
        processEngine.getRepositoryService()
            .deleteDeployment("1", true);
    }

    /**
     * 启动流程实例(并且 设置流程变量)
     */
    @Test
    public void startProcessInstance() {
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("请假天数", 3);
        variableMap.put("请假原因", "祖国未统一，心情很郁闷");
        variableMap.put("请假时间", new Date());
        processEngine.getRuntimeService()
            .startProcessInstanceByKey("helloworld", variableMap);
    }

    /**
     * 设置请假人
     */
    @Test
    public void setAssignee() {
        String taskId = "5001";
        processEngine.getRuntimeService()
            .setVariable(taskId, "请假人", "小明");
    }

    /**
     * 完成任务
     */
    @Test
    public void completeTask() {
        processEngine.getTaskService()
            .complete("7504");
    }

    /**
     * 查看历史记录
     */
    @Test
    public void testQueryHistoryVariable() {
        List<HistoricVariableInstance> list = processEngine.getHistoryService()
            .createHistoricVariableInstanceQuery()
            .variableName("请假人")
            .list();
        if (list != null && list.size() > 0) {
            for (HistoricVariableInstance historicVariableInstance: list) {
                System.out.println("变量名：" + historicVariableInstance.getVariableName());
                System.out.println("变量值：" + historicVariableInstance.getValue());
            }
        }
    }
}
