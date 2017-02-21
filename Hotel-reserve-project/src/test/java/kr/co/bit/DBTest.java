package kr.co.bit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.bit.company.vo.CompanyFacilitiesVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.company.vo.CompanyVO;
import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.member.vo.reserve.MemberReserveVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/**/*.xml"})
public class DBTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
//	@Test
	public void ���ȸ������() throws Exception{
		MemberVO member = new MemberVO();
		member.setId("ghosdi0624");
		member.setPassword("1234");
		member.setEmail("ghosdi0624@naver.com");
		member.setName("ȫ����");
		member.setTel1("010");
		member.setTel2("9700");
		member.setTel3("2782");
		sqlSessionTemplate.insert("kr.co.bit.member.MemberDAO.insertMember", member);
	}
	
//	@Test
	public void ���ȸ������() throws Exception{
		CompanyVO companyVO = new CompanyVO();
		
		sqlSessionTemplate.insert("kr.co.bit.company.CompanyDAO.insertCompany", companyVO);
	}
	
//	@Test
	public void ���̵�üũ() throws Exception{

		String id = "ghosdi0624";
		
		String result = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.selectIdcheck", id);
		System.out.println(result);
	}
	
//	@Test
	public void �α���üũ() throws Exception{

		CompanyVO vo = new CompanyVO();
		vo.setId("company");
		vo.setPassword("1234");
		
		CompanyVO result = sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyDAO.selectcompany", vo);
		System.out.println(result);
	}
	
//	@Test
	public void ����α���üũ() throws Exception{

		MemberVO vo = new MemberVO();
		vo.setId("ghosdi0624");
		vo.setPassword("1234");
		
		MemberVO result = sqlSessionTemplate.selectOne("kr.co.bit.member.MemberDAO.selectmember", vo);
		System.out.println(result);
	}
	
//	@Test
	public void ȣ�ڵ��() throws Exception{

		CompanyInfoVO vo = new CompanyInfoVO();
		vo.setAddr("����� ����");
		vo.setBreakfast(null);
		vo.setHotelName("��Ʈȣ��");
		vo.setId("company");
		vo.setInternet("on");
		vo.setIntroduce("�츮ȣ���ְ�");
		vo.setParking("on");
		
		sqlSessionTemplate.insert("kr.co.bit.company.CompanyInfoDAO.insertinfo", vo);
	}
	
//	@Test
	public void searchHotel() {
		
		List<CompanyInfoVO> list = sqlSessionTemplate.selectList("kr.co.bit.company.CompanyInfoDAO.selectAll");
		
		for(CompanyInfoVO vo : list){
			System.out.println(vo);
		}
	}
	
//	@Test
	public void �δ�ü���ȸ() {
		
		String name = "��Ʈȣ��";
		CompanyFacilitiesVO companyFacilitiesVO 
			= sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyFacilitiesDAO.selectByName", name);
		
		System.out.println(companyFacilitiesVO);
	}
	
//	@Test
	public void getIntroduce(){
		
		String name = "��Ʈȣ��";
		
		CompanyInfoVO vo = sqlSessionTemplate.selectOne("kr.co.bit.company.CompanyInfoDAO.selectIntro", name);
		System.out.println(vo);
	}
	
	@Test
	public void listTest(){
		
		String name = "��Ʈȣ��";
		
		List<CompanyInfoVO> companyList = new ArrayList<>();
		CompanyInfoVO vo1 = new CompanyInfoVO();
		vo1.setHotelName("���۴�ȣ��");
		CompanyInfoVO vo2 = new CompanyInfoVO();
		vo2.setHotelName("����ȣ��");
		
		companyList.add(vo1);
		companyList.add(vo2);
		
		
		List<MemberReserveVO> list = sqlSessionTemplate.selectList("kr.co.bit.reserve.MemberReserveDAO.selectReservation", companyList);
		
		for(MemberReserveVO vo : list){
			System.out.println(vo);
		}
	}
}
