package com.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlCollectionsDemo {

    private List<Object> list;

    private Properties pros;

    private Set<Object> sets;

    private Map<String, Object> maps;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Object> list() {
        return list;
    }

    public void setLists(List<Object> list) {
        this.list = list;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    public Set<Object> getSets() {
        return sets;
    }

    public void setSets(Set<Object> sets) {
        this.sets = sets;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory = context;
        XmlCollectionsDemo annontationInstance = (XmlCollectionsDemo) factory.getBean("xmlCollectionsDemo");
        System.out.println(annontationInstance.list);
        System.out.println(annontationInstance.pros);
        System.out.println(annontationInstance.sets);
        System.out.println(annontationInstance.maps);
        System.out.println(annontationInstance.date);
    }
}
