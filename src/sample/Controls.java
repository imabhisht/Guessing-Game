package sample;

import sample.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controls {
    @FXML
    private TextField userGuess;

    @FXML
    private TextArea messageBox;

    @FXML
    private Button GuessNumber;

    @FXML
    private Button GiveUpGame;

    @FXML
    private Button CloseGame;

    public Operation obj;

    public void disableButton(boolean x) {
        GuessNumber.setDisable(x);
        GiveUpGame.setDisable(x);
    }

    public void refreshGame(ActionEvent Echo) {
        userGuess.clear();
        disableButton(false);
        userGuess.setStyle("-fx-background-color: #f2f0f0; ");
        messageBox.setStyle("-fx-background-color: blue;");
        messageBox.setText("Press Guess Number after Guessing!!");
        this.obj = new Operation();
        System.out.println("Refresh Pressed");
        obj.generateNumber();
    }

    public void guessNumber(ActionEvent charlie) {
        String userNumber = userGuess.getText();
        Operation.Check(userNumber, obj);
        String answerOp = obj.getMessageBox();
        String styleOp = obj.getMessageStyle();
        messageBox.setText(answerOp);
        messageBox.setStyle(styleOp);
        userGuess.setStyle(styleOp);

        if (obj.getComputerNumber() == -1) {
            disableButton(true);
        }
    }

    public void giveUpGame(ActionEvent delta) {
        System.out.println("User is Giving up!!");
        messageBox.setText("The Number was: " + obj.getComputerNumber() + "\n\nBetter Luck Next Time...");
        messageBox.setStyle("-fx-background-color: yellow;");
        userGuess.setStyle("-fx-background-color: yellow;");
        userGuess.setText(String.valueOf(obj.getComputerNumber()));
        disableButton(true);
    }

    public void closeGame(ActionEvent fortox) {

        Platform.exit();

    }

}
