package kr.co.bit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class downController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// ���� ���ε�� ���
		String root = "C:/Users/bit/workspace/jspProject3/WebContent/";
		//C:\Users\bit\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jspProject3
		String savePath = root + "uploadFile/";
System.out.println("savePath: "+savePath);
		// ������ ���� ����� ���ϸ�
		String filename = request.getParameter("saveName");
		// ���� ������ ���ϸ�
		String orgfilename = request.getParameter("fileName");

		/* InputStream in = null;
		OutputStream os = null; */
		File file = null;
		boolean fileOn = false;
		String client = "";

		try {
			file = new File(savePath, filename);
			System.out.println("file : "+file);
		} catch (NullPointerException fe) {
			System.out.println("NullPointerException");
			fileOn = true;
		}
		try (InputStream in = new FileInputStream(file); OutputStream os = response.getOutputStream();
		) {
			// ������ �о� ��Ʈ���� ���
			/* try {
				file = new File(savePath, filename);
				in = new FileInputStream(file); 
			} catch (NullPointerException fe) {
				fileOn = true;
			} */
			client = request.getHeader("User-Agent");
			System.out.println("client: "+client);
			// ���� �ٿ�ε� ��� ����
			int i=0;
			response.reset();
			System.out.println(i++);
			response.setContentType("application/octet-stream");//������ �ٿ�ε�ǵ��� ����
			System.out.println(i++);
			response.setHeader("Content-Description", "JSP Generated Data");
			System.out.println(i++);
			if (!fileOn) {
				// IE
				System.out.println("if1");
				if (client.indexOf("MSIE") != -1) {System.out.println("if2");
					response.setHeader("Content-Disposition",
							"attachment; filename=" + new String(orgfilename.getBytes("KSC5601"), "ISO8859_1"));
				} else {System.out.println("else1");
					// �ѱ� ���ϸ� ó��
					orgfilename = new String(orgfilename.getBytes("utf-8"), "iso-8859-1");

					response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
					response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
				}
				response.setHeader("Content-Length", "" + file.length());
				/* os = response.getOutputStream(); */
				byte b[] = new byte[(int) file.length()];
				int leng = 0;
				System.out.println("while��");
				while ((leng = in.read(b)) > 0) {
					os.write(b, 0, leng);
				}System.out.println("while��");
			} else {System.out.println("else2");
				response.setContentType("text/html;charset=UTF-8");
			//	out.println("<script language='javascript'>alert('������ ã�� �� �����ϴ�');history.back();</script>");
			}
			/* 		in.close();
					os.close(); */
			System.out.println(i++ +"sss");
		} catch (Exception e) {
System.out.println("����ddddddddddddd");
			e.printStackTrace();
		}
		System.out.println("sssfff");
		return "/board/down.jsp";
	}

}
