package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import game.Handler;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */
public class Client {

	private Handler handler;

	// this is client id
	private int id;

	public static void main(String[] args) {
		new Client();
	}

	public Client() {
		Socket s;

		try {
			// local only (on same computer)
			s = new Socket("localhost", 65535);

			ObjectOutputStream outputToServer = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream inputFromServer = new ObjectInputStream(s.getInputStream());
			
			// just added basic connections
			while (true) {
				String msg = (String) inputFromServer.readObject();
				System.out.println("Server: " + msg);
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
