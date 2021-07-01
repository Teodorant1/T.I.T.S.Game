package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button downloaderOfCards;

    @FXML
    public Button BatchUpload;

    @FXML
    public TextField FileLocation1;

    @FXML
    public TextArea Creator1;

    @FXML
    public TextArea Destination1;

    @FXML
    public Label cardfinal;


    @FXML

    public Label scores;

    @FXML

    public Label answers;

    @FXML

    public TextField votetarget;


    @FXML

    public TextField gameidtext;

    @FXML

    public Button answerbutton;

    @FXML

    public Button sendstuff;


    @FXML


    public Button votebutton;

    @FXML

    public Button joingame;


    @FXML

    public Button creategame;

    @FXML


    public TextField username;

    @FXML

    public TextField personalanswer;

    @FXML

    public Button update1;

    // SqlMinion Sqlminion1 = new SqlMinion();
    // ThreadPoolExecutor ThreadPoolExecutor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    // ThreadPoolExecutor1.submit(() -> { ;});
   // RNGjesus Ron1 = new RNGjesus();
  //  Courier lonecourier = new Courier();
    String placeholder = "placeholder";






    @FXML
    private void createGame(ActionEvent event) throws Exception {
        {
            try {
               Courier task1 = new Courier("addsession", gameidtext.getText(), username.getText(), "Paloki",3333);
               Thread thread1 = new Thread(task1);
                thread1.setDaemon(true);
                thread1.start();

            } catch (Exception e) {e.printStackTrace();}
             {
                 Courier task2 = new Courier("getquestion", gameidtext.getText(), placeholder, placeholder, 3334 );
                 Thread thread2 = new Thread(task2);
                 thread2.setDaemon(true);
                 cardfinal.textProperty().bind(task2.valueProperty());
                 task2.setOnSucceeded( e -> {cardfinal.textProperty().unbind();});
                 thread2.start();

                 Courier task1 = new Courier("getanswers", gameidtext.getText(), placeholder, placeholder, 3335);
                 Thread thread1 = new Thread(task1);
                 thread1.setDaemon(true);
                 answers.textProperty().bind(task1.valueProperty());
                 task1.setOnSucceeded( e -> {answers.textProperty().unbind();});
                 thread1.start();

                 Courier task3 = new Courier("getscore", gameidtext.getText(), placeholder, placeholder, 3336);
                 Thread thread3 = new Thread(task3);
                 thread3.setDaemon(true);
                 scores.textProperty().bind(task3.valueProperty());
                 task3.setOnSucceeded( e -> {scores.textProperty().unbind();});
                 thread3.start();
             }
        }

    }
    @FXML
    private void get(ActionEvent event) throws Exception
    {



        Courier task2 = new Courier("getquestion", gameidtext.getText(), placeholder, placeholder, 3334 );
        Thread thread2 = new Thread(task2);
        thread2.setDaemon(true);
        cardfinal.textProperty().bind(task2.valueProperty());
        task2.setOnSucceeded( e -> {cardfinal.textProperty().unbind();});
        thread2.start();

        Courier task1 = new Courier("getanswers", gameidtext.getText(), placeholder, placeholder, 3335);
        Thread thread1 = new Thread(task1);
        thread1.setDaemon(true);
        answers.textProperty().bind(task1.valueProperty());
        task1.setOnSucceeded( e -> {answers.textProperty().unbind();});
        thread1.start();

        Courier task3 = new Courier("getscore", gameidtext.getText(), placeholder, placeholder, 3336);
        Thread thread3 = new Thread(task3);
        thread3.setDaemon(true);
        scores.textProperty().bind(task3.valueProperty());
        task3.setOnSucceeded( e -> {scores.textProperty().unbind();});
        thread3.start();

    }

    @FXML
    private void set(ActionEvent event) throws Exception
    {Courier task1 = new Courier("vote", gameidtext.getText(), username.getText(), votetarget.getText(),3337);
        Thread thread1 = new Thread(task1);
        thread1.setDaemon(true);
        thread1.start();
        votetarget.setText(placeholder);
        Courier task2 = new Courier("answer", gameidtext.getText(), username.getText(), personalanswer.getText(),3338);
        Thread thread2 = new Thread(task2);
        thread2.setDaemon(true);
        thread2.start();
        personalanswer.setText(placeholder);

    }

    @FXML
    private void joingame(ActionEvent event) throws Exception {
        {
            try {
                 Courier task1 = new Courier("addplayer", gameidtext.getText(), username.getText(), "Paloki",3333);
                Thread thread1 = new Thread(task1);
                thread1.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            {   Courier task1 = new Courier("getanswers", gameidtext.getText(), placeholder, placeholder,3334);
                Thread thread1 = new Thread(task1);
                thread1.setDaemon(true);
                answers.textProperty().bind(task1.valueProperty());

                task1.setOnSucceeded( e -> {answers.textProperty().unbind();});
                thread1.start();


                Courier task2 = new Courier("getquestion", gameidtext.getText(), placeholder, placeholder,3335);
                Thread thread2 = new Thread(task2);
                thread2.setDaemon(true);
                cardfinal.textProperty().bind(task2.valueProperty());
                task2.setOnSucceeded( e -> {cardfinal.textProperty().unbind();});
                thread2.start();

                Courier task3 = new Courier("getscore", gameidtext.getText(), placeholder, placeholder,3336);
                Thread thread3 = new Thread(task3);
                thread3.setDaemon(true);
                scores.textProperty().bind(task3.valueProperty());
                task3.setOnSucceeded( e -> {scores.textProperty().unbind();});
                thread3.start();}
        }

    }

    @FXML
    private void vote(ActionEvent event) throws Exception {
         {Courier task1 = new Courier("vote", gameidtext.getText(), username.getText(), votetarget.getText(),3337 );
             Thread thread1 = new Thread(task1);
             thread1.setDaemon(true);
             thread1.start();
             votetarget.setText(placeholder);
    }}

    @FXML
    private void answer(ActionEvent event) throws Exception {
         {Courier task1 = new Courier("answer", gameidtext.getText(), username.getText(), personalanswer.getText(),3338);
             Thread thread1 = new Thread(task1);
             thread1.setDaemon(true);
             thread1.start();
             personalanswer.setText(placeholder);}}




    @FXML
    private void uploadcards(ActionEvent event) throws Exception {

            try { CarbonCourier task1 = new CarbonCourier(Destination1.getText(), Creator1.getText(), FileLocation1.getText(),placeholder);
                Thread thread1 = new Thread(task1);
                thread1.setDaemon(true);
                thread1.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
            Destination1.setText(" ");
            Creator1.setText(" ");
            FileLocation1.setText(" ");
        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
