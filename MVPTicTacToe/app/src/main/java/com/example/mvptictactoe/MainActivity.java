package com.example.mvptictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements BoardView{

    BoardPresenter presenter;

    TableLayout board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new BoardPresenter(this);

        board = findViewById(R.id.board);

        for (byte row = 0; row < 3; row++) {

            TableRow tableRow = (TableRow) board.getChildAt(row);

            for (byte col = 0; col < 3; col++) {

                Button button = (Button) tableRow.getChildAt(col);
                BoardPresenter.CellClickListener buttonListener = new BoardPresenter.CellClickListener(presenter, row, col);
                button.setOnClickListener(buttonListener);
                presenter.addCellClickListener(buttonListener);

            }

        }

    }

    @Override
    public void newGame() {

        TableLayout board = findViewById(R.id.board);

        for (int row=0; row<3; row++){

            TableRow tableRow = (TableRow)board.getChildAt(row);

            for (int col=0; col<3; col++){

                Button button = (Button)tableRow.getChildAt(col);
                button.setText("");
                button.setEnabled(true);

            }

        }

    }

    @Override
    public void putSymbol(char symbol, byte row, byte col) {

        TableRow tableRow = (TableRow)board.getChildAt(row);
        Button button = (Button)tableRow.getChildAt(col);
        button.setText(Character.toString(symbol));

    }

    @Override
    public void gameEnded(byte winner) {


        for (int row=0; row<3; row++){

            TableRow tableRow = (TableRow)board.getChildAt(row);

            for (int col=0; col<3; col++){

                Button button = (Button)tableRow.getChildAt(col);
                button.setEnabled(false);

            }

        }

        switch (winner){

            case BoardView.DRAW :
                Toast.makeText(this,"Game is Draw", Toast.LENGTH_LONG).show();
                break;

            case BoardView.PLAYER_1_WINNER :
                Toast.makeText(this,"Player 1 Wins", Toast.LENGTH_LONG).show();
                break;

            case BoardView.PLAYER_2_WINNER :
                Toast.makeText(this,"Player 2 Wins", Toast.LENGTH_LONG).show();
                break;
        }

    }

    public void invalidPlay(byte row, byte col) {

        Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();

    }
}