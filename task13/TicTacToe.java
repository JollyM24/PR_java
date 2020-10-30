package task13;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class TicTacToe extends Application {
       private int k = 0;
        private final Tile[][] board = new Tile[3][3];
        private boolean playable = true;
        private Text text;
        private Text text2;

        private Parent createBoard() {
            Pane root = new Pane();

            text = new Text("");
            text.setFont(Font.font(90));
            int y = 90;
            for (int i=0; i<board.length;++i)
                y += 200;
            text.setLayoutY(y);
            text.setLayoutX(200);
            text.setFill(Color.WHITE);

            root.getChildren().add(text);

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    Tile tile = new Tile();
                    tile.setTranslateX(i * 200);
                    tile.setTranslateY(j * 200);
                    root.getChildren().addAll(tile);
                    board[i][j] = tile;
                }
            }
            return root;
        }

        public void run() {
            Application.launch();
        }

        private void check() {
            boolean isWin=(this.Rows() || this.Columns() || this.Diagonals());
            if (isWin)
                endGameWin();

            int c = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!board[i][j].getValue().equals(""))
                        c++;
                }
            }
            System.out.println(c);
            if (c == 9) {
                playable = false;
                text.setText("Draw");
            }
        }

        public boolean Rows(){
            int x = 0, o = 0;
            for (Tile[] tiles : board) {
                for (int j = 0; j < board.length; ++j) {
                    if (tiles[j].getValue().equals("x"))
                        x++;
                    if (tiles[j].getValue().equals("O"))
                        o++;
                }
                if (x > 2 || o > 2) {
                    System.out.println("Row win");
                    return true;
                }
                x = 0; o=0;
            }

            return false;
        }

    private Parent createBoardWin() {
        Pane root = new Pane();

        text2 = new Text("");
        text2.setFont(Font.font(90));
        int y = 90;
        for (int i=0; i<board.length;++i)
            y += 200;
        text2.setLayoutY(y);
        text2.setLayoutX(200);
        text2.setFill(Color.WHITE);

        return root;
    }

        public boolean Columns(){
            int x = 0, o = 0;
            for(int column = 0; column < board.length; column++) {
                for (Tile[] tiles : board) {
                    if (tiles[column].getValue().equals("x"))
                        x++;
                    if (tiles[column].getValue().equals("O"))
                        o++;
                }
                if (x > 2){
                    System.out.println("X win");
                    return true;
                }
                if (o > 2){
                    System.out.println("O win");
                    return true;
                }
                x=0; o=0;
            }
            return false;
        }

        public boolean Diagonals() {
            int x = 0, o = 0;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board.length; ++j) {
                    if (i == j) {
                        if (board[i][j].getValue().equals("x"))
                            x++;
                        if (board[i][j].getValue().equals("O"))
                            o++;
                    }
                }
            }
            if (x > 2){
                System.out.println("X win");
                return true;
            }
            if (o > 2){
                System.out.println("O win");
                return true;
            }

            x = 0;
            o = 0;

            int i = board.length - 1;
            int j = 0;
            while(i>-1 && j<board.length){
                if (board[i][j].getValue().equals("x"))
                    x++;
                if (board[i][j].getValue().equals("O"))
                    o++;
                i--;
                j++;
            }
            if (x > 2){
                System.out.println("X win");
                return true;
            }
            if (o > 2){
                System.out.println("O win");
                return true;
            }
            return false;
        }

        private void endGameWin() {
            playable = false;
            Win();
        }

        private void Win() {
            String result;
            if (k % 2 == 0)
                result = "O has won";
            else
                result = "X has won";

            text.setText(result);
        }

        private class Tile extends StackPane {
            Text text = new Text();

            public Tile() {
                text.setFont(Font.font(80));
                Rectangle border = new Rectangle(200, 200);
                border.setFill(null);
                border.setStroke(Color.BLACK);
                getChildren().addAll(border, text);

                setOnMouseClicked(event -> {
                    if (playable) {
                        if (k % 2 == 0)
                            X();
                        else
                            O();
                        k++;
                        check();
                    }
                });
            }

            private void X() {
                text.setText("x");
            }

            private void O() {
                text.setText("O");
            }
            public String getValue() {
                return text.getText();
            }
        }

        public void start(Stage stage) {
            Scene scene = new Scene(createBoard(), Color.WHITE);
            stage.setScene(scene);
            stage.setTitle("TicTacToe");
            stage.setWidth(610);
            stage.setHeight(630);
            stage.show();
            stage.setScene(scene);
            stage.show();
        }
    }


