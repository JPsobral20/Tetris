package com.aor.tetris.controllers.menu;

import com.aor.tetris.Game;
import com.aor.tetris.controllers.Controller;
import com.aor.tetris.gui.GUI;

import com.aor.tetris.model.game.Screen;
import com.aor.tetris.model.menu.Menu;
import com.aor.tetris.model.settings.LevelStartSelection;
import com.aor.tetris.model.settings.Settings;
import com.aor.tetris.states.GameState;
import com.aor.tetris.states.MenuState;
import com.aor.tetris.states.SettingsState;

import java.io.IOException;


public class LevelStartSelectionController extends Controller<LevelStartSelection> {

    public LevelStartSelectionController(LevelStartSelection levelStartSelection) {
        super(levelStartSelection);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        switch (action) {

            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case QUIT -> game.setState(new SettingsState(new Settings()));

            case SELECT -> {
                Screen screen = new Screen(10,20);
                if (getModel().isSelectedReturntoMenu()) {
                    game.setState(new MenuState(new Menu()));
                } else if (getModel().isSelectedDefault()) {
                    game.setState(new GameState(screen));
                }
                else if (getModel().isSelectedMarathon()) {
                    //EndGame -> 15 levels
                    screen.getStats().setGamemode("marathon");
                    game.setState(new GameState(screen));
                }
                else if (getModel().isSelected40Lines()) {
                    //EndGame -> 40 linhas
                    screen.getStats().setGamemode("40 lines");
                    game.setState(new GameState(screen));
                }

                else if (getModel().isSelectedUltra()) {
                    //EndGame 3Minutos
                        screen.getStats().setGamemode("ultra");
                        game.setState(new GameState(screen));

                }



            }
        }
    }
}


