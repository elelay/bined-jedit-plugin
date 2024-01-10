/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.framework.bined;

import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.auxiliary.binary_data.BinaryData;
import org.exbin.bined.extended.layout.ExtendedCodeAreaLayoutProfile;
import org.exbin.bined.operation.swing.CodeAreaOperationCommandHandler;
import org.exbin.bined.operation.undo.BinaryDataUndoHandler;
import org.exbin.bined.swing.basic.color.CodeAreaColorsProfile;
import org.exbin.bined.swing.extended.ExtCodeArea;
import org.exbin.bined.swing.extended.theme.ExtendedCodeAreaThemeProfile;
import org.exbin.framework.api.XBApplication;
import org.exbin.framework.bined.gui.BinEdComponentPanel;
import org.exbin.framework.bined.options.CodeAreaColorOptions;
import org.exbin.framework.bined.options.CodeAreaLayoutOptions;
import org.exbin.framework.bined.options.CodeAreaThemeOptions;
import org.exbin.framework.bined.options.EditorOptions;
import org.exbin.framework.bined.options.impl.CodeAreaOptionsImpl;
import org.exbin.framework.bined.preferences.BinaryEditorPreferences;

/**
 * Component for BinEd editor instances.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class BinEdEditorComponent {

    private final ExtendedCodeAreaLayoutProfile defaultLayoutProfile;
    private final ExtendedCodeAreaThemeProfile defaultThemeProfile;
    private final CodeAreaColorsProfile defaultColorProfile;

    private BinEdComponentPanel componentPanel = new BinEdComponentPanel();

    public BinEdEditorComponent() {
        ExtCodeArea codeArea = componentPanel.getCodeArea();
        defaultLayoutProfile = codeArea.getLayoutProfile();
        defaultThemeProfile = codeArea.getThemeProfile();
        defaultColorProfile = codeArea.getColorsProfile();
    }

    public void setApplication(XBApplication application) {

    }

    @Nonnull
    public BinEdComponentPanel getComponentPanel() {
        return componentPanel;
    }

    @Nonnull
    public ExtCodeArea getCodeArea() {
        return componentPanel.getCodeArea();
    }

    @Nonnull
    public Optional<BinaryDataUndoHandler> getUndoHandler() {
        return componentPanel.getUndoHandler();
    }

    public void setUndoHandler(BinaryDataUndoHandler undoHandler) {
        componentPanel.setUndoHandler(undoHandler);
    }

    public void onInitFromPreferences(BinaryEditorPreferences preferences) {
        componentPanel.onInitFromPreferences(preferences);

        ExtCodeArea codeArea = componentPanel.getCodeArea();
        CodeAreaOptionsImpl.applyToCodeArea(preferences.getCodeAreaPreferences(), codeArea);

        EditorOptions editorOptions = preferences.getEditorPreferences();
        if (codeArea.getCommandHandler() instanceof CodeAreaOperationCommandHandler) {
            ((CodeAreaOperationCommandHandler) codeArea.getCommandHandler()).setEnterKeyHandlingMode(editorOptions.getEnterKeyHandlingMode());
            ((CodeAreaOperationCommandHandler) codeArea.getCommandHandler()).setTabKeyHandlingMode(editorOptions.getTabKeyHandlingMode());
        }

        applyProfileFromPreferences(preferences);
    }

    public void applyProfileFromPreferences(BinaryEditorPreferences preferences) {
        ExtCodeArea codeArea = componentPanel.getCodeArea();

        CodeAreaLayoutOptions layoutOptions = preferences.getLayoutPreferences();
        int selectedLayoutProfile = layoutOptions.getSelectedProfile();
        if (selectedLayoutProfile >= 0) {
            codeArea.setLayoutProfile(layoutOptions.getLayoutProfile(selectedLayoutProfile));
        } else {
            codeArea.setLayoutProfile(defaultLayoutProfile);
        }

        CodeAreaThemeOptions themeOptions = preferences.getThemePreferences();
        int selectedThemeProfile = themeOptions.getSelectedProfile();
        if (selectedThemeProfile >= 0) {
            codeArea.setThemeProfile(themeOptions.getThemeProfile(selectedThemeProfile));
        } else {
            codeArea.setThemeProfile(defaultThemeProfile);
        }

        CodeAreaColorOptions colorOptions = preferences.getColorPreferences();
        int selectedColorProfile = colorOptions.getSelectedProfile();
        if (selectedColorProfile >= 0) {
            codeArea.setColorsProfile(colorOptions.getColorsProfile(selectedColorProfile));
        } else {
            codeArea.setColorsProfile(defaultColorProfile);
        }
    }

    @Nonnull
    public BinaryData getContentData() {
        ExtCodeArea codeArea = componentPanel.getCodeArea();
        return codeArea.getContentData();
    }

    public void setContentData(@Nullable BinaryData data) {
        ExtCodeArea codeArea = componentPanel.getCodeArea();
        codeArea.setContentData(data);
    }
}
