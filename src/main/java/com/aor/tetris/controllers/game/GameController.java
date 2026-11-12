package com.aor.tetris.controllers.game;

import com.aor.tetris.controllers.Controller;
import com.aor.tetris.model.game.Screen;

public abstract class GameController extends Controller<Screen> {

    public GameController(Screen screen) {
        super(screen);
    }
}
