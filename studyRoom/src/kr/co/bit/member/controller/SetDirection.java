package kr.co.bit.member.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import kr.co.bit.controller.Controller;

public class SetDirection {

	private Map<String, Controller> mapping;

	public SetDirection(String args) {
		mapping = new HashMap<>();
		Properties prop = new Properties();

		try {

			InputStream input = new FileInputStream(args); // args�� properties
															// ���� �̸��̴�.
			prop.load(input); // properties ��ü�� ���� properties ������ ������ ���ε����ش�.

			Set<Object> key = prop.keySet(); // set �ݷ����� ���� ������ key����
												// uri(*.do) ���� �־��ش�

			for (Object keys : key) { // mapping �ؽ��� �ȿ� properties ��ü ���� uri����
										// ��ü�� �־��ش�. (key, value) = (uri, ��ü)

				Class<?> makingClass = Class.forName(prop.getProperty(keys.toString()));
				mapping.put(keys.toString(), (Controller) makingClass.newInstance());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Controller getController(String uri) {

		return mapping.get(uri); // join.do�� ���� uri�� �´� Controller ��ü�� �������ش�.
	}

}
