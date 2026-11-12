package com.aor.tetris.controllers.game;

import com.aor.tetris.Game;
import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.states.MenuState;

public class ScreenController extends GameController{


    private final PieceController pieceController;
    public ScreenController(Screen screen){
        super(screen);

        this.pieceController = new PieceController(screen);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            pieceController.step(game, action, time);
        }
    }

}
