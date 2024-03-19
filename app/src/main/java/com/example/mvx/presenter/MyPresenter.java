package com.example.mvx.presenter;

import com.example.mvx.model.Board;
import com.example.mvx.model.Player;
import com.example.mvx.view.MyView;

public class MyPresenter {

    private MyView view;
    private Board model;

    public MyPresenter(MyView view) {
        this.view = view;
        this.model = new Board();
    }

    public void onButtonSelected(int row, int col) {
        Player playerThatMoved = model.mark(row, col);

        if(playerThatMoved != null) {
            view.setButtonText(row, col, playerThatMoved.toString());

            if (model.getWinner() != null) {
                view.showWinner(playerThatMoved.toString());
            }
        }
    }

    public void onResetSelected() {
        model.restart();
        view.clearWinnerDisplay();
        view.clearButtons();
    }
}
