package sample;

import javafx.concurrent.Task;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Courier extends Task<String> {



    private final String mode1;
    private final String gameid1;
    private final String payload1;
    private final String judge1;
    private final int socket1;



    public final String delimiter = "spergzilion";

    public Courier(String mode, String gameid, String payload, String judge, int socket)
    {this.mode1 = mode;
    this.gameid1 = gameid;
    this.payload1 = payload;
    this.judge1 = judge;
    this.socket1 = socket;}

    @Override
    protected String call() throws Exception
    {return sendmessagepaloki(mode1,gameid1,payload1,judge1);}

    public String sendmessagepaloki
            (String mode, String gameid, String payload, String judge)
            throws Exception {
        String fatman = mode + delimiter + gameid + delimiter + payload + delimiter + judge;

        try (Socket s = new Socket("localhost", socket1);
             DataInputStream din = new DataInputStream(s.getInputStream());
             DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        ) { try {dout.writeUTF(fatman);
                dout.flush();
                System.out.println("1");
                updateValue(din.readUTF());
                System.out.println(getValue());
                System.out.println("4");

                return getValue();

            } catch (EOFException e)
            {e.printStackTrace();}
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        return getValue();}}











