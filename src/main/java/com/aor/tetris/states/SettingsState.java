package com.aor.tetris.states;

import com.aor.tetris.controllers.Controller;
import com.aor.tetris.controllers.menu.SettingsController;
import com.aor.tetris.model.settings.Settings;
import com.aor.tetris.viewer.Viewer;
import com.aor.tetris.viewer.menu.SettingsViewer;

public class SettingsState extends State<Settings> {
        public SettingsState(Settings model) {
            super(model);
        }

        @Override
        protected Viewer<Settings> getViewer() {
            return new SettingsViewer(getModel());
        }

        @Override
        protected Controller<Settings> getController() {
            return new SettingsController(getModel());
        }
    }

