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
package org.exbin.framework.gui.utils.gui;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.OkCancelListener;
import org.exbin.framework.gui.utils.WindowUtils;
import org.exbin.framework.gui.utils.handler.RemovalControlHandler;

/**
 * Basic control panel with support for removal.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class RemovalControlPanel extends javax.swing.JPanel implements RemovalControlHandler.RemovalControlService {

    private final java.util.ResourceBundle resourceBundle;
    private RemovalControlHandler handler;
    private OkCancelListener okCancelListener;

    public RemovalControlPanel() {
        this(LanguageUtils.getResourceBundleByClass(RemovalControlPanel.class));
    }

    public RemovalControlPanel(java.util.ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        initComponents();

        okCancelListener = new OkCancelListener() {
            @Override
            public void okEvent() {
                performClick(RemovalControlHandler.ControlActionType.OK);
            }

            @Override
            public void cancelEvent() {
                performClick(RemovalControlHandler.ControlActionType.CANCEL);
            }
        };
    }

    public void setHandler(RemovalControlHandler handler) {
        this.handler = handler;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        cancelButton.setText(resourceBundle.getString("cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText(resourceBundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        removeButton.setText(resourceBundle.getString("removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton)
                    .addComponent(removeButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (handler != null) {
            handler.controlActionPerformed(RemovalControlHandler.ControlActionType.CANCEL);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (handler != null) {
            handler.controlActionPerformed(RemovalControlHandler.ControlActionType.OK);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (handler != null) {
            handler.controlActionPerformed(RemovalControlHandler.ControlActionType.REMOVE);
        }
    }//GEN-LAST:event_removeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void performClick(RemovalControlHandler.ControlActionType actionType) {
        WindowUtils.doButtonClick(actionType == RemovalControlHandler.ControlActionType.OK ? okButton : cancelButton);
    }

    @Nonnull
    @Override
    public OkCancelListener getOkCancelListener() {
        return okCancelListener;
    }

    @Nonnull
    @Override
    public RemovalControlHandler.RemovalControlEnablementListener createEnablementListener() {
        return (RemovalControlHandler.ControlActionType actionType, boolean enablement) -> {
            switch (actionType) {
                case OK: {
                    okButton.setEnabled(enablement);
                    break;
                }
                case CANCEL: {
                    cancelButton.setEnabled(enablement);
                    break;
                }
                default:
                    throw new IllegalStateException("Illegal action type " + actionType.name());
            }
        };
    }
}
