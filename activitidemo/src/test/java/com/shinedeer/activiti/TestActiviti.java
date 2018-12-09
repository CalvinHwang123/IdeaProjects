package com.shinedeer.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @author Calvin Hwang
 * 2018/12/7 22:51
 * Activiti 测试类
 */
public class TestActiviti {

    @Test
    public void testDbByPropertites() {
        // 加载 classpath 下名为 acitivi.cfg.xml 的文件
        // 创建核心对象 ProcessEngine，系统数据库会自动创建表 ^.^
        ProcessEngine processEngine = ProcessEngineConfiguration
            .createProcessEngineConfigurationFromResource("activiti.cfg.xml")
            //.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP) // Schema 方式为：删除并新建
            .buildProcessEngine();
        System.out.println(processEngine);
    }

    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 1、测试部署流程定义
     */
    @Test
    public void testDeploymentProcessDefinition() {
        Deployment deployment = processEngine.getRepositoryService()
            .createDeployment() // 创建一个部署对象
            .addClasspathResource("diagrams/helloworld.bpmn") // 每次只能加载一个文件
            .addClasspathResource("diagrams/helloworld.png") // 可多次加载
            .name("helloworld 入门程序")
            .deploy();// 完成部署

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    /**
     * 2、启动流程实例
     */
    @Test
    public void testStartProcessInstance() {
        final String PROCESS_KEY = "helloworld";
        ProcessInstance processInstance = processEngine.getRuntimeService()
            .startProcessInstanceByKey(PROCESS_KEY); // 根据 KEY 启动流程实例

        System.out.println(processInstance.getId()); // 流程实例 id
        System.out.println(processInstance.getProcessInstanceId()); // 流程实例 id
        System.out.println(processInstance.getProcessDefinitionId()); // 流程定义 id
    }

    /**
     * 3、查询当前人的个人任务
     */
    @Test
    public void testCurrentAssigneeTask() {
        String ASSIGNEE = "张三";
        ASSIGNEE = "李四";
        ASSIGNEE = "王五";
        List<Task> taskList = processEngine.getTaskService()
            .createTaskQuery() // 创建查询对象
            .taskCandidateOrAssigned(ASSIGNEE) // 指定办理人
            .list();
        if (taskList != null && taskList.size() > 0) {
            for (Task task: taskList) {
                System.out.println(task.getId());
                System.out.println(task.getName());
                System.out.println(task.getCreateTime());
                System.out.println(task.getAssignee()); // 获取办理人
                System.out.println("********************");
            }
        }
    }

    /**
     * 4、测试完成当前人任务
     */
    @Test
    public void testFinishCurrentTask() {
        String TASK_ID = "5004";
        TASK_ID = "7502";
        TASK_ID = "10002";
        processEngine.getTaskService()
            .complete(TASK_ID); // 完成指定 任务 id 的任务
    }

}
