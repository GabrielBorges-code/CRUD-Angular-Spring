package br.com.javaspring.math;

public class SimpleMath {

	public Double sum(Double numOne, Double numTwo) {
		return numOne + numTwo;
	}

	public Double sub(Double numOne, Double numTwo) {
		return numOne - numTwo;
	}

	public Double mult(Double numOne, Double numTwo) {
		return numOne * numTwo;
	}

	public Double div(Double numOne, Double numTwo) {

		return numOne / numTwo;
	}

	public Double raiz(Double numOne) {
		return Math.sqrt(numOne);
	}

	public Double media(Double numOne, Double numTwo, Double media) {
		return (numOne + numTwo) / media;
	}
}
