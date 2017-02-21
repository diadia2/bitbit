
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MouseEventHandler implements MouseListener{
	// ���콺 ��ư�� Ŭ���Ǿ��� �� (���ȴ� Ǯ������) ȣ��
	public void mouseClicked(MouseEvent e){
		JButton button = (JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked Button"+e.getButton());
		System.out.println("���콺 ��ư ���ȴ� Ǯ��");
	}
	// ���콺 Ŀ���� ��ư���� �ö󰡸� ȣ��
	public void mouseEntered(MouseEvent e){
		//System.out.println("Ŀ�� ��ư �� ����");
	}
	// ���콺 Ŀ���� ��ư�� ���������� ȣ��
	public void mouseExited(MouseEvent e){
		//System.out.println("Ŀ�� ��ư �� Ż��");
	}
	// ���콺 ��ư�� ������ ���� ȣ��
	public void mousePressed(MouseEvent e){
		//System.out.println("���콺 ��ư ����");
	}
	// ���콺 ��ư�� Ǯ���� ���� ȣ��
	public void mouseReleased(MouseEvent e){
		//System.out.println("���콺 ��ư Ǯ��");
	}
}

class MyJFrame extends JFrame implements MouseListener{
	MouseListener listener;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	
	public MyJFrame(String title){
		super(title);
		setBounds(120, 120, 400, 100);
		setLayout(new FlowLayout());
		addMouseListener(this);
		
		listener = new MouseEventHandler();
		btn1 = new JButton("My Button");
		btn2 = new JButton("Your Button");
		btn3 = new JButton("Our Button");
		
		btn1.addMouseListener(listener);
		btn2.addMouseListener(listener);
		btn3.addMouseListener(listener);
		
		add(btn1);
		add(btn2);
		add(btn3);
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("JFrame�󿡼� ���콺 ��ư ���ȴ� Ǯ��");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}

public class FirstSwing {

	public static void main(String[] args) {

		JFrame frm = new MyJFrame("Frist Swing");
		frm.setVisible(true);		
		
	}

}
