package sample;

import javafx.concurrent.Task;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CarbonCourier extends Task<Void> {



    private final String mode1;
    private final String gameid1;
    private final String payload1;
    private final String judge1;


    public final String delimiter = "spergzilion";

    public CarbonCourier(String mode, String gameid, String payload, String judge)
    {this.mode1 = mode;
        this.gameid1 = gameid;
        this.payload1 = payload;
        this.judge1 = judge;}

    @Override
    protected Void call() throws Exception
    {return insertToServer(mode1,gameid1,payload1);}

    public String sendmessagepaloki
            (String mode, String gameid, String payload, String judge)
            throws Exception {
        String fatman = mode + delimiter + gameid + delimiter + payload + delimiter + judge;
        try (Socket s = new Socket("localhost", 3333);
             DataInputStream din = new DataInputStream(s.getInputStream());
             DataOutputStream dout = new DataOutputStream(s.getOutputStream());


        ) {

            try {
                dout.writeUTF(fatman);
                dout.flush();
                String lilboy = (din.readUTF());
                return lilboy;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return fatman;
    }

    public Void insertToServer(String QorS, String creator, String file)
            throws Exception {
        StringBuilder endgamepaloki = new StringBuilder(" ");
        File file1 = new File(file);
        Scanner sc = new Scanner(file1);
        ArrayList<String> Bonerstorm = new ArrayList<>();
        while (sc.hasNextLine())
        {Bonerstorm.add(sc.nextLine());}
        if (1 > 0) {
            for (int i = 0; i < Bonerstorm.size(); i++) {
                if (Bonerstorm.get(i).isEmpty()) { System.out.println("derp"); }
                else
                {endgamepaloki.append(Bonerstorm.get(i)+"yormungandryormungandr");}
            }
        } if (QorS.equals("q")){
            this.sendmessagepaloki( "questionbatch", creator , String.valueOf(endgamepaloki), "yolo" );}
        else if (QorS.equals("s"))
        {this.sendmessagepaloki( "situationbatch", creator , String.valueOf(endgamepaloki), "yolo" );}
        return null;
    }

    // @Override
    // public void run(String mode, String gameid, String payload, String judge) throws Exception {sendmessagepaloki(mode, gameid, payload, judge);

}
