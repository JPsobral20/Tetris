package com.aor.tetris.states;

import com.aor.tetris.controllers.Controller;
import com.aor.tetris.controllers.menu.LevelStartSelectionController;
import com.aor.tetris.model.settings.LevelStartSelection;
import com.aor.tetris.viewer.Viewer;
import com.aor.tetris.viewer.menu.LevelStartSelectionViewer;


public class LevelStartSelectionState extends State<LevelStartSelection>{

    public LevelStartSelectionState(LevelStartSelection model) {
        super(model);
    }


    @Override
    protected Viewer<LevelStartSelection> getViewer() { return new LevelStartSelectionViewer(getModel()); }

    @Override
    protected Controller<LevelStartSelection> getController() { return new LevelStartSelectionController(getModel()); }
}

