package com.aor.tetris.states;

import com.aor.tetris.controllers.Controller;
import com.aor.tetris.controllers.menu.InstructionsController;
import com.aor.tetris.model.instructions.Instructions;
import com.aor.tetris.viewer.Viewer;
import com.aor.tetris.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<Instructions>{

    public InstructionsState(Instructions model) {
        super(model);
    }


    @Override
    protected Viewer<Instructions> getViewer() { return new InstructionsViewer(getModel()); }

    @Override
    protected Controller<Instructions> getController() { return new InstructionsController(getModel()); }
}

