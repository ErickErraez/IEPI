package edu.yavirac.lambdas;

import javax.xml.ws.handler.MessageContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SIN LAMBDA
		OnOneListener oneListener = new OnOneListener() {

			@Override
			public void onOne(String message) {
				// TODO Auto-generated method stub

				System.out.println("ONE: " + message);

			}
		};

		// EJEMPLO CON LAMBDA
		OnOneListener oneListener2 = (String message) -> {
			System.out.println("ONE LAMBDA: " + message);
		};

		oneListener.onOne("Sin Lambda :(");
		oneListener2.onOne("Con Lambda :");
		

		// EJEMPLO CON LAMBDA Y VARIABLE
		OnOneListener oneListener3 = message -> System.out.println("WELCOME " + message);
		oneListener3.onOne("Con Lambda mas corta:");
	}

}
