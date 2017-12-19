package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * @author Yang Yang Lu, John Bui, Jordan Siaha, Jero
 */
public class Server {

	private Vector<ObjectOutputStream> outputToClients = new Vector<>();

	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		ServerSocket ss;

		try {
			ss = new ServerSocket(65535);
			
			// only passively listen in from client
			// and broadcast to everyone the amount of client connected
			while (true) {
				System.out.println("waiting for connection...");
				Socket client = ss.accept();
				System.out.println("client connected");
				System.out.println("client Name: " + client.getInetAddress().getHostName());
				System.out.println("client IP: " + client.getInetAddress().getHostAddress());

				outputToClients.add(new ObjectOutputStream(client.getOutputStream()));
				System.out.println("Clients connected: " + outputToClients.size());

				broadcast();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void broadcast() {
		for (ObjectOutputStream output : outputToClients) {
			try {
				output.reset();
				output.writeObject("Current clients connected: " + outputToClients.size());
				output.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("/nClient Disconnected");
				outputToClients.remove(output);
				e.printStackTrace();
			}
		}
	}

}
