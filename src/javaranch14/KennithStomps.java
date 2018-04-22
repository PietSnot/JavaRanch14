/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.layout.GridPane;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
 
@SuppressWarnings("restriction")

/**
 *
 * @author Sylvia
 */
//public class KennithStomps {
//
//}

class CourseScoreLambda extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create gridPane object
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);

        // set grid properties
//        grid.setAlignment(Pos.CENTER);
//        grid.setPadding(new Insets(9, 14, 9, 14)); // set padding 9px top, bottom, 14 px left, right ****NOTE: this padding is not working or changing anything, and I am not sure why.
//        grid.setVgap(15); // set vertical gap to 15
//        grid.setHgap(12); // set horizontal gap to 12
//
//        Label earnedScore = new Label("Earned Score"); // create earned score & maxPossible
//        earnedScore.setStyle("-fx-font: 11 cambria;");
//        earnedScore.setAlignment(Pos.BASELINE_CENTER);// center earned score label horizontally NOTE: earned score and max possible .setAlignment is also not working and I am not sure why
//        grid.add(earnedScore, 1, 0);

//        Label maxPossible = new Label("Max Possible"); // so that I am able to customize
//        maxPossible.setStyle("-fx-font:11 cambria;");
//        maxPossible.setAlignment(Pos.BASELINE_CENTER); // center max possible label horizontally
//        grid.add(maxPossible, 2, 0);

        // declare textFields
        final TextField txtEarnedScoreOne = new TextField(); // earned scores
        final TextField txtEarnedScoreTwo = new TextField();
        final TextField txtEarnedScoreThree = new TextField();
        final TextField txtEarnedScoreFour = new TextField();
        final TextField txtEarnedScoreFive = new TextField();
        final TextField txtEarnedScoreSix = new TextField();
        final TextField txtMaxPointsOne = new TextField();  // max possible
        final TextField txtMaxPointsTwo = new TextField();
        final TextField txtMaxPointsThree = new TextField();
        final TextField txtMaxPointsFour = new TextField();
        final TextField txtMaxPointsFive = new TextField();
        final TextField txtMaxPointsSix = new TextField();

        // add score labels, and text fields to the grid
//        grid.add(new Label("Score #1:"), 0, 1);
//        grid.add(txtEarnedScoreOne, 1, 1);
//        grid.add(txtMaxPointsOne, 2, 1);
//        grid.add(new Label("Score #2:"), 0, 2);
//        grid.add(txtMaxPointsTwo, 1, 2);
//        grid.add(txtMaxPointsTwo, 2, 2);
//        grid.add(new Label("Score #3:"), 0, 3);
//        grid.add(txtEarnedScoreThree, 1, 3);
//        grid.add(txtMaxPointsThree, 2, 3);
//        grid.add(new Label("Score #4:"), 0, 4);
//        grid.add(txtEarnedScoreFour, 1, 4);
//        grid.add(txtMaxPointsFour, 2, 4);
//        grid.add(new Label("Score #5:"), 0, 5);
//        grid.add(txtEarnedScoreFive, 1, 5);
//        grid.add(txtMaxPointsFive, 2, 5);
//        grid.add(new Label("Score #6:"), 0, 6);
//        grid.add(txtEarnedScoreSix, 1, 6);
//        grid.add(txtMaxPointsSix, 2, 6);

        // declare results textField, set as uneditable, set as not visible, add them to the grid
        TextField totalEarnedResult = new TextField();
        TextField maxPossibleResult = new TextField();
        TextField finalScoreResult = new TextField();
        TextField finalGradeResult = new TextField();
        totalEarnedResult.setEditable(false);                                                       // ***THIS WILL NOT ALLOW ME TO MAKE THESE PRIVAATE
        maxPossibleResult.setEditable(false);
        finalScoreResult.setEditable(false);
        finalGradeResult.setEditable(false);
        totalEarnedResult.setVisible(false);
        maxPossibleResult.setVisible(false);
        finalScoreResult.setVisible(false);
        finalGradeResult.setVisible(false);
//        grid.add(new Label("TOTAL:"), 0, 7);
//        grid.add(totalEarnedResult, 1, 7);
//        grid.add(maxPossibleResult, 2, 7);
//        grid.add(new Label("FINAL SCORE:"), 0, 8);
//        grid.add(finalScoreResult, 1, 8);
//        grid.add(new Label("FINAL GRADE:"), 0, 9);
//        grid.add(finalGradeResult, 1, 9);
//        grid.add(new Label("FINAL GRADE"), 0, 9);

        //perfect score
        Label perfectScore = new Label("Perfect score!");
        perfectScore.setStyle("-fx-text-fill: dodgerblue;-fx-font: 17 cambria;");
        perfectScore.setVisible(false);
//        grid.add(perfectScore, 1, 10);

        // calculate button
//        Button calculate = new Button("Calculate"); // create calculate button
//        calculate.setStyle("-fx-background-color: maroon; -fx-font: 14 papyrus;-fx-text-fill: white;"); // calculate button maroon / 14 pt font papyrus / white text
//        grid.add(calculate, 2, 10);

//        double total, max, finalScore;
//        String grade;
//        calculate.setOnAction( (ActionEvent e) -> {
//            String grade = "NULL";
//            double total = Double.parseDouble(txtEarnedScoreOne.getText() + txtEarnedScoreTwo.getText() + txtEarnedScoreThree.getText() + txtEarnedScoreFour.getText() + txtEarnedScoreFive.getText() + txtEarnedScoreSix.getText());
//            double max = Double.parseDouble(txtMaxPointsOne.getText() + txtMaxPointsTwo.getText() + txtMaxPointsThree.getText() + txtMaxPointsFour.getText() + txtMaxPointsFive.getText() + txtMaxPointsSix.getText());
//            double finalScore = total / max;
//            String totalString = String.valueOf(total); // convert calculations into a String to display
//            String maxString = String.valueOf(max);
//            String finalScoreString = String.valueOf(finalScore);
//            if (finalScore >= 90) {
//                grade = "A";
//            }
//            if (finalScore >= 80 && finalScore < 90) {
//                grade = "B";
//            }
//            if (finalScore >= 70 && finalScore < 80) {
//                grade = "C";
//            }
//            if (finalScore >= 60 && finalScore < 70) {
//                grade = "D";
//            }
//            if (finalScore < 60) {
//                grade = "F";
//            }
//            totalEarnedResult.setText(totalString);
//            maxPossibleResult.setText(maxString);
//            finalScoreResult.setText(finalScoreString);
//            finalGradeResult.setText(grade);
//            totalEarnedResult.setVisible(true);
//            maxPossibleResult.setVisible(true);
//            finalScoreResult.setVisible(true);
//            finalGradeResult.setVisible(true);
//            if (finalScore == 100) {
//                perfectScore.setVisible(true);
//            }
//        });

        // start over button
        Button startOver = new Button("Start Over"); // create start over button
//        startOver.setStyle("-fx-background-color: midnightblue;-fx-font:12 papyrus;-fx-text-fill: yellow;"); // start over button midnight blue background / 12 pt papyrus font / yellow text
//        grid.add(startOver, 2, 11);
//        calculate.setAlignment(Pos.BASELINE_RIGHT); // position calculate button on the right horizontally
//        startOver.setAlignment(Pos.BASELINE_RIGHT); // position statOver button on the right horizontally

        //create scene and put calcCourseScore inside
        Scene scene1 = new Scene(grid);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Calculate Course Score");
        primaryStage.setResizable(false);
        primaryStage.show();
    }// end start method

    //double points = Double.parseDouble(totalPointsEarned.getText());
    public static void main(String[] args) {
        Application.launch(args);

    }

}
