package application;
import java.net.ServerSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 
/**
 * ����� �������. ����� ���� �� �����, ��������� ���������, ������� SocketProcessor �� ������ ���������
 */
public class Server {
    private ServerSocket ss; // ��� ������-�����
    private Thread serverThread; // ������� ���� ��������� ������-������
    private int port; // ���� ������ ������.
    //�������, ��� ��������� ��� SocketProcessor� ��� ��������
    BlockingQueue<SocketProcessor> q = new LinkedBlockingQueue<SocketProcessor>();
 
    /**
     * ����������� ������� �������
     * @param port ����, ��� ����� ������� �������� ���������.
     * @throws IOException ���� �� �������� ������� ������-�����, ������� �� ���������, ������ ������� �� ����� ������
     */
    public Server(int port) throws IOException {
        ss = new ServerSocket(port); // ������� ������-�����
        this.port = port; // ��������� ����.
    }
 
    /**
     * ������� ���� �������������/�������� ��������.
     */
    void run() {
        serverThread = Thread.currentThread(); // �� ������ ��������� ���� (����� ����� �� ���� interrupt())
        while (true) { //����������� ����, ����...
            Socket s = getNewConn(); // �������� ����� ���������� ��� ����-���������
            if (serverThread.isInterrupted()) { // ���� ��� ����-����������, �� ���� ���� ���� interrupted(),
                // ���� ����������
                break;
            } else if (s != null){ // "������ ���� ������� ������� ������"...
                try {
                    final SocketProcessor processor = new SocketProcessor(s); // ������� �����-���������
                    final Thread thread = new Thread(processor); // ������� ��������� ����������� ���� ������ �� ������
                    thread.setDaemon(true); //������ �� � ������ (����� �� ������� �� ��������)
                    thread.start(); //���������
                  System.out.println("connect");
                    q.offer(processor); //��������� � ������ �������� �����-�����������
                } //��� ������ � �������. ���� ������� ������� (new SocketProcessor()) ����������,
                // �� ��������� ������ �������, ���� ��������� �� �����, � ������ �� ��������
                catch (IOException ignored) {}  // ���� �� ���������� �������� �������� ��� �� ���������.
            }
        }
    }
 
    /**
     * ������� ����� �����������.
     * @return ����� ������ �����������
     */
    private Socket getNewConn() {
        Socket s = null;
        try {
            s = ss.accept();
        } catch (IOException e) {
            shutdownServer(); // ���� ������ � ������ ������ - "�����" ������
        }
        return s;
    }
 
    /**
     * ����� "��������" �������
     */
    private synchronized void shutdownServer() {
        // ������������ ������ ������� ���������, ��������� ������
        for (SocketProcessor s: q) {
            s.close();
        }
        if (!ss.isClosed()) {
            try {
                ss.close();
            } catch (IOException ignored) {}
        }
    }
 
    /**
     * ������� ����� ���������
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new Server(23454).run(); // ���� ������ �� ��������, ���������
        // ������� �� ���������, � ����� run() �� �����������
    }
 
    /**
     * ��������� ����� ����������� ��������� ������ ��������.
     */
    private class SocketProcessor implements Runnable{
        Socket s; // ��� �����
        BufferedReader br; // ��������������� �������� ������
        BufferedWriter bw; // ���������������� �������� � �����
 
        /**
         * ��������� �����, ������� ������� �������� � ��������. ���� �� ���������� - �������� ��� �������� �������
         * @param socketParam �����
         * @throws IOException ���� ������ � �������� br || bw
         */
        SocketProcessor(Socket socketParam) throws IOException {
            s = socketParam;
            br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8") );
        }
 
        /**
         * ������� ���� ������ ���������/��������
         */
        public void run() {
        	
        	while (!s.isClosed()) { // ���� ����� �� ������...
        		 System.out.println("run");
        		String line = null;
                try {
                    line = br.readLine(); // ������� ��������.
               
                } catch (IOException e) {
                	 System.out.println("ex");
                	close(); // ���� �� ���������� - ��������� �����.
                }
 
                if (line == null) { // ���� ������ null - ������ ���������� � ������� ������.
                    close(); // �� ��������� �����
                } else if ("shutdown".equals(line)) { // ���� ��������� ������� "�������� ������", ��...
                    serverThread.interrupt(); // ������� �������� ���� � �������� ���� � ������������� ����������.
                    try {
                        new Socket("localhost", 23454); // ������� ����-������� (����� ����� �� .accept())
                    } catch (IOException ignored) { //������ �����������
                    } finally {
                        shutdownServer(); // � ����� ������ ������ ������� ��� ������ shutdownServer().
                    }
                } else { // ����� - ��������� �������� �� ������ �����-�����������
                   System.out.println("sending/");
                	line = line+"7";
                   for (SocketProcessor sp:q) {
                       
                		sp.send(line);
                    }
                }
            }
        }
 
        /**
         * ����� �������� � ����� ���������� ������
         * @param line ������ �� �������
         */
        public synchronized void send(String line) {
            try {
               line = "5/"+line;
            	bw.write(line); // ����� ������
                bw.write("\n"); // ����� ������� ������
                bw.flush(); // ����������
            } catch (IOException e) {
                close(); //���� ���� � ������ �������� - ��������� ������ �����.
            }
        }
 
        /**
         * ����� ��������� ��������� ����� � ������� ��� �� ������ �������� �������
         */
        public synchronized void close() {
            q.remove(this); //������� �� ������
            if (!s.isClosed()) {
                try {
                    s.close(); // ���������
                } catch (IOException ignored) {}
            }
        }
 
        /**
         * ����������� ������ �� ������ ������.
         * @throws Throwable
         */
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            close();
        }
    }
}
 