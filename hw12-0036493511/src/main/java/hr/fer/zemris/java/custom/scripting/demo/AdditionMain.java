package hr.fer.zemris.java.custom.scripting.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static hr.fer.zemris.java.custom.scripting.demo.Util.readFromDisk;

import hr.fer.zemris.java.custom.scripting.exec.SmartScriptEngine;
import hr.fer.zemris.java.custom.scripting.parser.SmartScriptParser;
import hr.fer.zemris.java.webserver.RequestContext;
import hr.fer.zemris.java.webserver.RequestContext.RCCookie;

/**
 * Razred <code>AdditionMain</code> testira rad parsera i rad
 * {@link SmartScriptEngine}-a. Testira funkcije paramGet te funkciju zbrajanja.
 * Ne očekuju se argumenti.
 * 
 * @author Filip
 *
 */
public class AdditionMain {
	/**
	 * Metoda se poziva kada se pokrene program.
	 * 
	 * @param args
	 *            argumenti komandne linije
	 */
	public static void main(String[] args) {
		String documentBody = readFromDisk("src/main/resources/zbrajanje.smscr");
		Map<String, String> parameters = new HashMap<String, String>();
		Map<String, String> persistentParameters = new HashMap<String, String>();
		List<RCCookie> cookies = new ArrayList<RequestContext.RCCookie>();
		parameters.put("a", "4");
		parameters.put("b", "2");

		new SmartScriptEngine(new SmartScriptParser(documentBody).getDocumentNode(),
				new RequestContext(System.out, parameters, persistentParameters, cookies)).execute();

	}
}
