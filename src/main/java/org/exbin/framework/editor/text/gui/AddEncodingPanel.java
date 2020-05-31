/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.framework.editor.text.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.WindowUtils;

/**
 * Encoding selection panel.
 *
 * @version 0.2.1 2019/07/19
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class AddEncodingPanel extends javax.swing.JPanel {

    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(AddEncodingPanel.class);
    private final EncodingsTableModel tableModel = new EncodingsTableModel();

    public AddEncodingPanel() {
        initComponents();
        init();
    }

    private void init() {
        encodingsTable.setModel(tableModel);

        nameTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                nameTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                nameTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                nameTextChanged();
            }

            private void nameTextChanged() {
                tableModel.setNameFilter(nameTextField.getText());
            }
        });

        countryTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                countryTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                countryTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                countryTextChanged();
            }

            private void countryTextChanged() {
                tableModel.setCountryFilter(countryTextField.getText());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        countryTextField = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        supportedEncodingsLabel = new javax.swing.JLabel();
        encodinsScrollPane = new javax.swing.JScrollPane();
        encodingsTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceBundle.getString("filterPanel.title"))); // NOI18N

        nameLabel.setText(resourceBundle.getString("nameLabel.text")); // NOI18N

        countryLabel.setText(resourceBundle.getString("countryLabel.text")); // NOI18N

        clearButton.setText(resourceBundle.getString("clearButton.text")); // NOI18N
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filterPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countryLabel)
                    .addGroup(filterPanelLayout.createSequentialGroup()
                        .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryLabel)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(filterPanel, java.awt.BorderLayout.PAGE_START);

        supportedEncodingsLabel.setText(resourceBundle.getString("supportedEncodingsLabel.text")); // NOI18N

        encodinsScrollPane.setViewportView(encodingsTable);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encodinsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(supportedEncodingsLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supportedEncodingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encodinsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        nameTextField.setText("");
        countryTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    public void setUsedEncodings(List<String> encodings) {
        tableModel.setUsedEncodings(encodings);
    }

    @Nonnull
    public List<String> getEncodings() {
        ArrayList<String> result = new ArrayList<>();
        int[] selectedValues = encodingsTable.getSelectedRows();
        for (int rowIndex : selectedValues) {
            String value = (String) tableModel.getValueAt(rowIndex, 0);
            result.add((String) value);
        }
        return result;
    }

    @Nonnull
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeDialog(new AddEncodingPanel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JTable encodingsTable;
    private javax.swing.JScrollPane encodinsScrollPane;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel supportedEncodingsLabel;
    // End of variables declaration//GEN-END:variables
}
