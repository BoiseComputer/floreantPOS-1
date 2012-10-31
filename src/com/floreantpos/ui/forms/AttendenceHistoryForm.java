/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.floreantpos.ui.forms;

import com.floreantpos.PosException;
import com.floreantpos.model.AttendenceHistory;
import com.floreantpos.model.dao.AttendenceHistoryDAO;
import com.floreantpos.model.util.IllegalModelStateException;
import com.floreantpos.ui.BeanEditor;
import com.floreantpos.ui.dialog.POSMessageDialog;

import javax.swing.*;
import java.util.Calendar;

/**
 * @author Howler
 */
public class AttendenceHistoryForm extends BeanEditor {
	AttendenceHistory history;
	private boolean editMode = false;

	/**
	 * Creates new form AttendenceHistoryForm
	 */
	public AttendenceHistoryForm() {
		initComponents();
	}

	@Override
	public boolean save() {
		try {
			updateModel();
		} catch (IllegalModelStateException e) {
			POSMessageDialog.showError(this, e.getMessage());
			return false;
		}

		AttendenceHistory attendenceHistory = (AttendenceHistory) getBean();
		AttendenceHistoryDAO attendenceHistoryDAO = AttendenceHistoryDAO.getInstance();

		try {
			attendenceHistoryDAO.saveOrUpdate(attendenceHistory);
		} catch (PosException x) {
			POSMessageDialog.showError(this, x.getMessage(), x);
			x.printStackTrace();
			return false;
		} catch (Exception x) {
			POSMessageDialog.showError(this, "Could not save history", x);
			x.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public void dispose() {

	}

	@Override
	protected void updateView() {
		if (history == null) {
			return;
		}

		txtUserId.setText(history.getUser().getUserId().toString());

		Calendar cal = Calendar.getInstance();
		cal.setTime(history.getClockInTime());

		spinnerClockInHour.setValue(cal.get(Calendar.HOUR_OF_DAY));
		spinnerClockInMinute.setValue(cal.get(Calendar.MINUTE));
		jxDateClockIn.setDate(cal.getTime());

		cal.setTime(history.getClockOutTime());
		spinnerClockOutHour.setValue(cal.get(Calendar.HOUR_OF_DAY));
		spinnerClockOutMinute.setValue(cal.get(Calendar.MINUTE));
		jxDateClockOut.setDate(cal.getTime());

		cbClockedOut.setSelected(history.isClockedOut());
	}

	@Override
	protected boolean updateModel() throws IllegalModelStateException {
		AttendenceHistory history = null;
		if (!(getBean() instanceof AttendenceHistory)) {
			history = new AttendenceHistory();
		} else {
			history = (AttendenceHistory) getBean();
		}

		Calendar clockInDate = Calendar.getInstance();
		clockInDate.setTime(jxDateClockIn.getDate());
		clockInDate.set(Calendar.MINUTE, Integer.valueOf(spinnerClockInMinute.getValue().toString()));
		clockInDate.set(Calendar.HOUR_OF_DAY, Integer.valueOf(spinnerClockInHour.getValue().toString()));

		Calendar clockOutDate = Calendar.getInstance();
		clockOutDate.setTime(jxDateClockOut.getDate());
		clockOutDate.set(Calendar.MINUTE, Integer.valueOf(spinnerClockOutMinute.getValue().toString()));
		clockOutDate.set(Calendar.HOUR_OF_DAY, Integer.valueOf(spinnerClockOutHour.getValue().toString()));


		history.setClockInHour((short)clockInDate.get(Calendar.HOUR));

		history.setClockOutHour((short)clockOutDate.get(Calendar.HOUR));

		history.setClockInTime(clockInDate.getTime());
		history.setClockOutTime(clockOutDate.getTime());

		history.setClockedOut(cbClockedOut.isSelected());

		setBean(history);
		return true;
	}

	@Override
	public String getDisplayText() {
		return null;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public void setAttendenceHistory(AttendenceHistory history) {
		this.history = history;
		setBean(history);
		updateView();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userId = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jxDateClockIn = new org.jdesktop.swingx.JXDatePicker();
        spinnerClockInHour = new javax.swing.JSpinner(new SpinnerNumberModel());
        jLabel2 = new javax.swing.JLabel();
        spinnerClockInMinute = new javax.swing.JSpinner(new SpinnerNumberModel());
        jLabel3 = new javax.swing.JLabel();
        jxDateClockOut = new org.jdesktop.swingx.JXDatePicker();
        spinnerClockOutHour = new javax.swing.JSpinner(new SpinnerNumberModel());
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spinnerClockOutMinute = new javax.swing.JSpinner(new SpinnerNumberModel());
        cbClockedOut = new javax.swing.JCheckBox();

        userId.setText("User ID:");

        jLabel1.setText("Clock In Date:");

        jLabel2.setText("Clock In Hour:");

        jLabel3.setText("Clock In Minute:");

        jLabel4.setText("Clock Out Date:");

        jLabel5.setText("Clock Out Minute:");

        jLabel6.setText("Clock Out Hour:");

        cbClockedOut.setText("Clocked Out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jxDateClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(spinnerClockInHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbClockedOut)
                                    .addComponent(spinnerClockInMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jxDateClockOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(spinnerClockOutHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerClockOutMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userId)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jxDateClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerClockInHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerClockInMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jxDateClockOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbClockedOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerClockOutHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spinnerClockOutMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbClockedOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private org.jdesktop.swingx.JXDatePicker jxDateClockIn;
    private org.jdesktop.swingx.JXDatePicker jxDateClockOut;
    private javax.swing.JSpinner spinnerClockInHour;
    private javax.swing.JSpinner spinnerClockInMinute;
    private javax.swing.JSpinner spinnerClockOutHour;
    private javax.swing.JSpinner spinnerClockOutMinute;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JLabel userId;
    // End of variables declaration//GEN-END:variables
}
