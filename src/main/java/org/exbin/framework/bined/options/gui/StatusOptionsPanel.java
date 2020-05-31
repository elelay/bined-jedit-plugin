/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.framework.bined.options.gui;

import java.util.ResourceBundle;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.bined.PositionCodeType;
import org.exbin.framework.bined.options.impl.StatusOptionsImpl;
import org.exbin.framework.bined.StatusCursorPositionFormat;
import org.exbin.framework.bined.StatusDocumentSizeFormat;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.WindowUtils;
import org.exbin.framework.gui.options.api.OptionsCapable;
import org.exbin.framework.gui.options.api.OptionsModifiedListener;

/**
 * Editor status bar options panel.
 *
 * @version 0.2.1 2019/07/20
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class StatusOptionsPanel extends javax.swing.JPanel implements OptionsCapable<StatusOptionsImpl> {

    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(StatusOptionsPanel.class);

    public StatusOptionsPanel() {
        initComponents();
    }

    @Nonnull
    @Override
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    @Override
    public void saveToOptions(StatusOptionsImpl options) {
        StatusCursorPositionFormat cursorPositionFormat = new StatusCursorPositionFormat();
        cursorPositionFormat.setCodeType(PositionCodeType.valueOf((String) cursorPositionCodeTypeComboBox.getSelectedItem()));
        cursorPositionFormat.setShowOffset(cursorPositionShowOffsetCheckBox.isSelected());
        options.setCursorPositionFormat(cursorPositionFormat);

        StatusDocumentSizeFormat documentSizeFormat = new StatusDocumentSizeFormat();
        documentSizeFormat.setCodeType(PositionCodeType.valueOf((String) documentSizeCodeTypeComboBox.getSelectedItem()));
        documentSizeFormat.setShowRelative(cursorPositionShowOffsetCheckBox.isSelected());
        options.setDocumentSizeFormat(documentSizeFormat);

        options.setOctalSpaceGroupSize((int) octalGroupSizeSpinner.getValue());
        options.setDecimalSpaceGroupSize((int) decimalGroupSizeSpinner.getValue());
        options.setHexadecimalSpaceGroupSize((int) hexadecimalGroupSizeSpinner.getValue());
    }

    @Override
    public void loadFromOptions(StatusOptionsImpl options) {
        StatusCursorPositionFormat cursorPositionFormat = options.getCursorPositionFormat();
        cursorPositionCodeTypeComboBox.setSelectedIndex(cursorPositionFormat.getCodeType().ordinal());
        cursorPositionShowOffsetCheckBox.setSelected(cursorPositionFormat.isShowOffset());

        StatusDocumentSizeFormat documentSizeFormat = options.getDocumentSizeFormat();
        documentSizeCodeTypeComboBox.setSelectedIndex(documentSizeFormat.getCodeType().ordinal());
        cursorPositionShowOffsetCheckBox.setSelected(documentSizeFormat.isShowRelative());

        octalGroupSizeSpinner.setValue(options.getOctalSpaceGroupSize());
        decimalGroupSizeSpinner.setValue(options.getDecimalSpaceGroupSize());
        hexadecimalGroupSizeSpinner.setValue(options.getHexadecimalSpaceGroupSize());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cursorPositionCodeTypeLabel = new javax.swing.JLabel();
        cursorPositionCodeTypeComboBox = new javax.swing.JComboBox<>();
        cursorPositionShowOffsetCheckBox = new javax.swing.JCheckBox();
        documentSizeCodeTypeLabel = new javax.swing.JLabel();
        documentSizeCodeTypeComboBox = new javax.swing.JComboBox<>();
        documentSizeShowRelativeCheckBox = new javax.swing.JCheckBox();
        octalGroupSizeLabel = new javax.swing.JLabel();
        octalGroupSizeSpinner = new javax.swing.JSpinner();
        decimalGroupSizeLabel = new javax.swing.JLabel();
        decimalGroupSizeSpinner = new javax.swing.JSpinner();
        hexadecimalGroupSizeLabel = new javax.swing.JLabel();
        hexadecimalGroupSizeSpinner = new javax.swing.JSpinner();

        cursorPositionCodeTypeLabel.setText(resourceBundle.getString("cursorPositionCodeTypeLabel.text")); // NOI18N

        cursorPositionCodeTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OCTAL", "DECIMAL", "HEXADECIMAL" }));
        cursorPositionCodeTypeComboBox.setSelectedIndex(1);

        cursorPositionShowOffsetCheckBox.setSelected(true);
        cursorPositionShowOffsetCheckBox.setText(resourceBundle.getString("cursorPositionShowOffsetCheckBox.text")); // NOI18N

        documentSizeCodeTypeLabel.setText(resourceBundle.getString("documentSizeCodeTypeLabel.text")); // NOI18N

        documentSizeCodeTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OCTAL", "DECIMAL", "HEXADECIMAL" }));
        documentSizeCodeTypeComboBox.setSelectedIndex(1);

        documentSizeShowRelativeCheckBox.setSelected(true);
        documentSizeShowRelativeCheckBox.setText(resourceBundle.getString("documentSizeShowRelativeCheckBox.text")); // NOI18N

        octalGroupSizeLabel.setText(resourceBundle.getString("octalGroupSizeLabel.text")); // NOI18N

        octalGroupSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 0, null, 1));

        decimalGroupSizeLabel.setText(resourceBundle.getString("decimalGroupSizeLabel.text")); // NOI18N

        decimalGroupSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(3, 0, null, 1));

        hexadecimalGroupSizeLabel.setText(resourceBundle.getString("hexadecimalGroupSizeLabel.text")); // NOI18N

        hexadecimalGroupSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 0, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cursorPositionCodeTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(documentSizeCodeTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cursorPositionCodeTypeLabel)
                    .addComponent(cursorPositionShowOffsetCheckBox)
                    .addComponent(documentSizeCodeTypeLabel)
                    .addComponent(documentSizeShowRelativeCheckBox)
                    .addComponent(decimalGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(octalGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(hexadecimalGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(decimalGroupSizeLabel)
                    .addComponent(octalGroupSizeLabel)
                    .addComponent(hexadecimalGroupSizeLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cursorPositionCodeTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cursorPositionCodeTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cursorPositionShowOffsetCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(documentSizeCodeTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentSizeCodeTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentSizeShowRelativeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(octalGroupSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(octalGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decimalGroupSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decimalGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hexadecimalGroupSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hexadecimalGroupSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeDialog(new StatusOptionsPanel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cursorPositionCodeTypeComboBox;
    private javax.swing.JLabel cursorPositionCodeTypeLabel;
    private javax.swing.JCheckBox cursorPositionShowOffsetCheckBox;
    private javax.swing.JLabel decimalGroupSizeLabel;
    private javax.swing.JSpinner decimalGroupSizeSpinner;
    private javax.swing.JComboBox<String> documentSizeCodeTypeComboBox;
    private javax.swing.JLabel documentSizeCodeTypeLabel;
    private javax.swing.JCheckBox documentSizeShowRelativeCheckBox;
    private javax.swing.JLabel hexadecimalGroupSizeLabel;
    private javax.swing.JSpinner hexadecimalGroupSizeSpinner;
    private javax.swing.JLabel octalGroupSizeLabel;
    private javax.swing.JSpinner octalGroupSizeSpinner;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setOptionsModifiedListener(OptionsModifiedListener listener) {
    }
}
