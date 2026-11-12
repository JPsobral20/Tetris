package com.aor.tetris.states;

import com.aor.tetris.controllers.Controller;
import com.aor.tetris.controllers.game.ScreenController;
import com.aor.tetris.model.game.Screen;
import com.aor.tetris.viewer.Viewer;
import com.aor.tetris.viewer.game.GameViewer;

public class GameState extends State<Screen> {
    public GameState(Screen screen) {super(screen);}

    @Override
    protected Viewer<Screen> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Screen> getController() {
        return new ScreenController(getModel());
    }
}