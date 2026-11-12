package com.aor.tetris.controllers.menu;

import com.aor.tetris.Game;
import com.aor.tetris.controllers.Controller;
import com.aor.tetris.gui.GUI;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.model.settings.LevelStartSelection;
import com.aor.tetris.model.settings.Settings;
import com.aor.tetris.states.LevelStartSelectionState;
import com.aor.tetris.states.MenuState;

import java.io.IOException;

public class SettingsController extends Controller<Settings> {
    public SettingsController(Settings model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch(action){
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();

            case SELECT -> {
                if (getModel().isSelectedGoToMenu()) game.setState(new MenuState(new Menu()));
                if(getModel().isSelectedLevelSelection()) game.setState(new LevelStartSelectionState(new LevelStartSelection()));
            }

            case QUIT -> game.setState(new MenuState(new Menu()));
        }
}
}
