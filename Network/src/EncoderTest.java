import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncoderTest {

	public static void main(String[] args) {
		
		if(args.length != 2){
			System.out.println("args �߸��Է�");
			System.exit(1);
		}
		
		String encodeStr = URLEncoder.encode(args[0]);
		System.out.println(args[0]+"==>>"+encodeStr);
		String decodeStr = URLDecoder.decode(args[1]);
		System.out.println(args[1]+"==>>"+decodeStr);
		
	}

}
