package br.com.javaspring.controllers;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaspring.converters.NumberConverter;

import br.com.javaspring.exceptions.UnsupportedMathOperationException;
import br.com.javaspring.math.SimpleMath;

@RestController
public class MathController {

	private static final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();

	@RequestMapping(value = "/sum/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String sum(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return "Subtração dos valores: " + numOne + " + " + numTwo + " = "
				+ math.sum(NumberConverter.convertToDouble(numOne), NumberConverter.convertToDouble(numTwo));
	}

	@RequestMapping(value = "/sub/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String sub(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Subtração dos valores: " + numOne + " - " + numTwo + " = "
				+ math.sub(NumberConverter.convertToDouble(numOne), NumberConverter.convertToDouble(numTwo));
	}

	@RequestMapping(value = "/mult/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String mult(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Multiplicação dos valores: " + numOne + " * " + numTwo + " = "
				+ math.mult(NumberConverter.convertToDouble(numOne), NumberConverter.convertToDouble(numTwo));
	}

	@RequestMapping(value = "/div/{numOne}/{numTwo}", method = RequestMethod.GET)
	public String div(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo)
			throws Exception {
		if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Divisão dos valores " + numOne + " / " + numTwo + " = "
				+ math.div(NumberConverter.convertToDouble(numOne), NumberConverter.convertToDouble(numTwo));
	}

	@RequestMapping(value = "/raiz/{numOne}", method = RequestMethod.GET)
	public String raiz(@PathVariable(value = "numOne") String numOne) throws Exception {
		if (!NumberConverter.isNumeric(numOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Raiz quadrada: " + numOne + "² = " + math.raiz(NumberConverter.convertToDouble(numOne));
	}

	@RequestMapping(value = "/media/{numOne}/{numTwo}/{media}", method = RequestMethod.GET)
	public String raiz(@PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo,
			@PathVariable(value = "media") String media) throws Exception {
		if (!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo) || !NumberConverter.isNumeric(media)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return "Média dos valores: (" + numOne + " + " + numTwo + ") / " + media + " = "
				+ math.media(NumberConverter.convertToDouble(numOne), NumberConverter.convertToDouble(numTwo), NumberConverter.convertToDouble(media));
	}



}
