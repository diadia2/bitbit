package kr.co.bit.framwork;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import kr.co.bit.framwork.annotation.RequestMapping;

public class HandlerMapping {

	private Map<String, CtrlAndMethod> mappings = null;

	public HandlerMapping(String ctrlNames) throws Exception {

		mappings = new HashMap<>();

		String[] ctrls = ctrlNames.split("\\|"); // ���Խ��̱� ������ \\ ����
		for (String ctrl : ctrls) {
			Class<?> clz = Class.forName(ctrl.trim()); // web.xml�� ���ʿ� ���� �߻��� �� �־ trim �߰�
			Object target = clz.newInstance();

			Method[] methods = clz.getMethods(); // public ��� �޼ҵ�
			// Method[] methods = clz.getDeclaredMethods(); // ���� ������ �޼ҵ常
			for (Method method : methods) {
				RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);

				if (reqAnno != null) {
					String uri = reqAnno.value();
					CtrlAndMethod cam = new CtrlAndMethod(target, method);

					mappings.put(uri, cam);
				}
			}

		}
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri){
		return mappings.get(uri);
	}
}
