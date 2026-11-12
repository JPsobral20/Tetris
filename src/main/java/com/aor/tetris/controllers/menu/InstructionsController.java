package com.aor.tetris.controllers.menu;

import com.aor.tetris.Game;
import com.aor.tetris.controllers.Controller;
import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.instructions.Instructions;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Instructions> {

    public InstructionsController(Instructions instructions) {
        super(instructions);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedGoToMenu()){ game.setState(new MenuState(new Menu())); }
            case QUIT: {
                game.setState(new MenuState(new Menu()));
            }
        }
    }
}
