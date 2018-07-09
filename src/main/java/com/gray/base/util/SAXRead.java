package com.gray.base.util;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class SAXRead {

	public static void main(String[] args) throws Exception {
        //1.创建解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
        //2.得到解析器
        SAXParser sp=factory.newSAXParser();
        //3得到解读器
        XMLReader reader=sp.getXMLReader();
        //设置内容处理器
        reader.setContentHandler(new ListHandler());
        //读取xml的文档内容
        reader.parse("Book.xml");

    }

	
}
