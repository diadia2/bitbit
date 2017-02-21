package kr.co.bit.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.controller.Controller;

public class ReserveResponseController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String time = request.getParameter("jTime");
		int roomNo = Integer.parseInt(request.getParameter("jRoomNo"));
		String roomName = null;

		switch (roomNo) {
		case 1:
			roomName = "����û";
			break;
		case 2:
			roomName = "����û";
			break;
		case 3:
			roomName = "�����";
			break;
		case 4:
			roomName = "����û";
			break;
		case 5:
			roomName = "����û";
			break;
		case 6:
			roomName = "����û";
			break;
		case 7:
			roomName = "�ҹ�û";
			break;
		}
		
		request.setAttribute("id", id);
		request.setAttribute("time", time);
		request.setAttribute("roomName", roomName);
		
		return "/reserve/reserveResponse.jsp";
	}

}
