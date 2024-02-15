import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import testBase.Browser.BaseClass;
public class getRandomNumbers extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=25;i++) {
			BaseClass baseClass = new BaseClass();
			
			System.out.println(baseClass.randomeNumber());
			
		}
	}

}
