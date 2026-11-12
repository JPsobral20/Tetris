package com.aor.tetris.controllers.game;

import com.aor.tetris.Game;
import com.aor.tetris.controllers.Controller;
import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.model.gameender.End;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.states.GameState;
import com.aor.tetris.states.MenuState;

public class EndController extends Controller<End> {
    public EndController(End endGame) {
        super(endGame);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedPlayAgain()) game.setState(new GameState(new Screen(10, 20)));
                if (getModel().isSelectedGoToMenu()) game.setState(new MenuState(new Menu()));
            }
            case QUIT -> game.setState(null);
        }
    }
}