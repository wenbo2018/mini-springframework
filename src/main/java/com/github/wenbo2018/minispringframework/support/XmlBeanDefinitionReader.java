package com.github.wenbo2018.minispringframework.support;

import com.github.wenbo2018.minispringframework.beans.BeanDefinition;
import com.github.wenbo2018.minispringframework.beans.Io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wenbo.shen on 2017/12/16.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            registerBeanDefinitions(document, resource);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void registerBeanDefinitions(Document doc, Resource resource) {
        Element root = doc.getDocumentElement();
        doRegisterBeanDefinitions(root);
    }

    protected void doRegisterBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                parseDefaultElement(ele);
            }
        }
    }

    protected void parseDefaultElement(Element ele) {
        processBeanDefinition(ele);
    }

    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);
        beanDefinition.setName(name);
        getRegistry().registerBeanDefinition(name, beanDefinition);
    }

}