package br.com.javaspring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaspring.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private static final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String sum(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return "Subtração dos valores " + numOne + " + " + numTwo + " = "
				+ (convertToDouble(numOne) + convertToDouble(numTwo));
	}

	@RequestMapping(value = "/sub/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String sub(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Subtração dos valores " + numOne + " - " + numTwo + " = "
				+ (convertToDouble(numOne) - convertToDouble(numTwo));
	}

	@RequestMapping(value = "/mult/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String mult(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Multiplicação dos valores " + numOne + " * " + numTwo + " = "
				+ (convertToDouble(numOne) * convertToDouble(numTwo));
	}

	@RequestMapping(value = "/div/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String div(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Divisão dos valores " + numOne + " / " + numTwo + " = "
				+ (convertToDouble(numOne) / convertToDouble(numTwo));
	}

	@RequestMapping(value = "/raiz/{numOne}", method = RequestMethod.GET)
	public String raiz(@PathVariable(value = "numOne") String numOne) throws Exception {
		if (!isNumeric(numOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Raiz quadrada " + numOne + "² = " + (Math.sqrt(convertToDouble(numOne)));
	}

	@RequestMapping(value = "/media/{numOne}/{numTwo}/{media}", method = RequestMethod.GET)
	public String raiz(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo,
			@PathVariable(value = "media") String media) throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo) || !isNumeric(media)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Média dos valores (" + numOne + " + " + numTwo + ") / " + media + " = "
				+ ((convertToDouble(numOne) + convertToDouble(numTwo)) / convertToDouble(media));
	}

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0d;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 1.0d;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");

	}

}
