package com.aor.tetris.controllers.menu;

import com.aor.tetris.Game;
import com.aor.tetris.controllers.Controller;
import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.model.instructions.Instructions;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.model.settings.Settings;
import com.aor.tetris.states.GameState;
import com.aor.tetris.states.InstructionsState;
import com.aor.tetris.states.SettingsState;



public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new Screen(10, 20)));
                if (getModel().isSelectedInstructions()) game.setState(new InstructionsState(new Instructions()));
                if (getModel().isSelectedSettings()) game.setState(new SettingsState(new Settings()));
            }
            case QUIT -> game.setState(null);
        }
    }
}
