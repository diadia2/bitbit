class Robot {

}

class DanceRobot extends Robot {

	void dance() {
		System.out.println("���� ���");
	}
}

class SingRobot extends Robot {

	void sing() {
		System.out.println("�뷡�� �θ���");
	}
}

class DrawRobot extends Robot {

	void draw() {
		System.out.println("�׸��� �׸���");
	}

}

public class Practice1 {

	public static void action(Robot r) {
		if (r instanceof DanceRobot)
			((DanceRobot) r).dance();
		else if (r instanceof SingRobot)
			((SingRobot) r).sing();
		else if (r instanceof DrawRobot)
			((DrawRobot) r).draw();
	}

	public static void main(String[] args) {

		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };

		for (int i = 0; i < arr.length; i++)
			action(arr[i]);

	}

}
