import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class geoParserTest{	
	public static void main(String[] args) throws IOException, SAXException, TikaException{
		Parser geoparser= new geoParser();
		InputStream in= new FileInputStream("testdata1");
		ContentHandler handler= new BodyContentHandler();
		Metadata metadata= new Metadata();
		geoparser.parse(in, handler, metadata, new ParseContext());
		//System.out.println(handler.toString());
		for (String name : metadata.names()) {
			 String value = metadata.get(name);
			  
			 if (value != null) {
				 System.out.println("Metadata Name: " + name);
				 System.out.println("Metadata Value: " + value);
			 }
		} 
		in.close();
	}
}