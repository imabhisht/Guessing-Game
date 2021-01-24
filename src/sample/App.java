package sample;

public class App {

    private int computerNumber;

    public void generateNumber() {
        this.computerNumber = (int) (Math.random() * 100 + 1);
        System.out.println(computerNumber);
    }

    public int getComputerNumber() {
        return this.computerNumber;
    }

    public void setDefaultComputerNumber() {
        this.computerNumber = -1;
    }
}

class Operation extends App {

    private String messageBox;
    private String messageStyle;

    public void setMessageBox(String a) {
        this.messageBox = a;
    }

    public void setMessageStyle(String a) {
        this.messageStyle = a;
    }

    public String getMessageBox() {
        return this.messageBox;
    }

    public String getMessageStyle() {
        return this.messageStyle;
    }

    public static void Check(String a, Operation obj) {

        System.out.println("The Number is : " + obj.getComputerNumber());

        try {
            int userNumber = Integer.parseInt(a);
            if (userNumber == obj.getComputerNumber()) {
                obj.setDefaultComputerNumber();
                obj.messageBox = "The Number is Correct\n\nGreat Job!!";
                obj.messageStyle = "-fx-background-color: #53f707;";

            } else if (userNumber > obj.getComputerNumber()) {
                obj.messageBox = "The Number Guess is too High!!\n\nTry Again";
                obj.messageStyle = "-fx-background-color: #ff1c2f;";
            } else if (userNumber < obj.getComputerNumber()) {
                obj.messageBox = "The Number Guess is too Low!!\n\nTry Again";
                obj.messageStyle = "-fx-background-color: #ff1c2f;";
            } else {
                obj.messageBox = "Something went Wrong";
            }

        } catch (Exception e) {
            obj.messageBox = "One/Two Digits are Allowed!!\n\nCheck the Input Field...";
            obj.messageStyle = "-fx-background-color: #f53333;";
        }

    }
}