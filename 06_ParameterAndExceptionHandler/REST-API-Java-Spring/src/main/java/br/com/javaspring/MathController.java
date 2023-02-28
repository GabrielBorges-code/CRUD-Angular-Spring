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
	public Double sum(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!isNumeric(numOne) || !isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return covertToDouble(numOne) + covertToDouble(numTwo);
	}

	public static Double covertToDouble(String strNumber) {
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
