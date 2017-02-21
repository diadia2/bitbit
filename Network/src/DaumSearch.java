import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class DaumSearch {

	public static void main(String[] args) {

		if(args.length != 2){
			System.out.println("args �߸��Է� keyword filename");
			System.exit(1);
		}
		
		try {
			String keyword = URLEncoder.encode(args[0]);
			//http://search.daum.net/search?
			//w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q=%EC%82%AC%EA%B3%BC
			String query = "w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&q="+keyword;
			String u = "http://search.daum.net/search";
			System.out.println(u+query);
			URL url = new URL(u);
			URLConnection connection = url.openConnection();
			HttpURLConnection hurlc = (HttpURLConnection)connection;
			hurlc.setRequestMethod("GET");
			hurlc.setDoOutput(true);
			hurlc.setDoInput(true);
			hurlc.setUseCaches(false);
			hurlc.setDefaultUseCaches(false);
			PrintWriter out = new PrintWriter(hurlc.getOutputStream());
			out.println(query);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(hurlc.getInputStream()));
			PrintWriter pw = new PrintWriter(new FileWriter(args[1]));
			String inputLine = null;
			while((inputLine = in.readLine())!=null){
				pw.println(inputLine);
			}
			in.close();
			pw.close();
			System.out.println("�˻��� ����� "+args[1]+" ���Ͽ� ����Ǿ����ϴ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
