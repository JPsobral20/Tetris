package com.aor.tetris.states;

import com.aor.tetris.controllers.Controller;
import com.aor.tetris.controllers.game.EndController;
import com.aor.tetris.model.gameender.End;
import com.aor.tetris.viewer.Viewer;
import com.aor.tetris.viewer.game.EndViewer;

public class EndState extends State<End> {

    public EndState(End gameOver) {super(gameOver);}

    @Override
    protected Viewer<End> getViewer() {
        return new EndViewer(getModel());
    }

    @Override
    protected Controller<End> getController() {
        return new EndController(getModel());
    }
}
