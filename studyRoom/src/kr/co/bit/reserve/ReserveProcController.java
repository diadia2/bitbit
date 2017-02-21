package kr.co.bit.reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bit.controller.Controller;
import kr.co.bit.reserve.dao.ReserveDAO;

public class ReserveProcController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		ReserveDAO dao = new ReserveDAO();
		
		String day = request.getParameter("date"); 							// 	���� ��¥ yyyy-mm-dd
		String[] time = request.getParameter("time").split(",");			// 	����ð�
		String[] roomName = request.getParameter("roomName").split(",");	//	���̸�
		String[] people = request.getParameter("people").split(",");		//	�ο���
		String id = (String)session.getAttribute("id");						// 	ID
		//String id = "admin";
		for(int i=0; i<time.length; i++){
			dao.insertReserve(day,roomName[i],people[i],id,time[i]);
		}
		
		return "/reserve/reserveProc.jsp";
	}

}