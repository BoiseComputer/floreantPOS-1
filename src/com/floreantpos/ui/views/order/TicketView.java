/*
 * TicketView.java
 *
 * Created on August 4, 2006, 3:42 PM
 */

package com.floreantpos.ui.views.order;

import com.floreantpos.POSConstants;
import com.floreantpos.PosException;
import com.floreantpos.config.PrintConfig;
import com.floreantpos.main.Application;
import com.floreantpos.model.*;
import com.floreantpos.model.dao.MenuItemDAO;
import com.floreantpos.print.PosPrintService;
import com.floreantpos.ui.dialog.POSMessageDialog;
import com.floreantpos.ui.views.SwitchboardView;
import com.floreantpos.ui.views.order.actions.OrderListener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author  MShahriar
 */
public class TicketView extends JPanel {
	private java.util.Vector<OrderListener> orderListeners = new java.util.Vector<OrderListener>();
	private Ticket ticket;

	public final static String VIEW_NAME = "TICKET_VIEW";

	public TicketView() {
		initComponents();

		chkTaxExempt.setEnabled(false);
		ticketViewerTable.getRenderer().setInTicketScreen(true);
		ticketViewerTable.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					updateSelectionView();
				}
			}

		});
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new com.floreantpos.swing.TransparentPanel();
		jSeparator1 = new javax.swing.JSeparator();
		jPanel3 = new com.floreantpos.swing.TransparentPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		tfSubtotal = new javax.swing.JTextField();
		tfTax = new javax.swing.JTextField();
		tfDiscount = new javax.swing.JTextField();
		tfTotal = new javax.swing.JTextField();
		chkTaxExempt = new javax.swing.JCheckBox();
		bottomPanel = new com.floreantpos.swing.TransparentPanel();
		btnPay = new com.floreantpos.swing.PosButton();
		btnCancel = new com.floreantpos.swing.PosButton();
		btnFinish = new com.floreantpos.swing.PosButton();
		jPanel5 = new com.floreantpos.swing.TransparentPanel();
		btnIncreaseAmount = new com.floreantpos.swing.PosButton();
		btnDecreaseAmount = new com.floreantpos.swing.PosButton();
		btnScrollUp = new com.floreantpos.swing.PosButton();
		btnScrollDown = new com.floreantpos.swing.PosButton();
		btnDelete = new com.floreantpos.swing.PosButton();
		jPanel2 = new com.floreantpos.swing.TransparentPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		ticketViewerTable = new com.floreantpos.ui.ticket.TicketViewerTable();

		setBorder(javax.swing.BorderFactory.createTitledBorder(null, com.floreantpos.POSConstants.TICKET, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		setPreferredSize(new java.awt.Dimension(280, 463));
		setLayout(new java.awt.BorderLayout(5, 5));

		jPanel1.setLayout(new java.awt.BorderLayout(5, 5));
		jPanel1.add(jSeparator1, java.awt.BorderLayout.CENTER);

		jPanel3.setLayout(new java.awt.GridBagLayout());

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel5.setText(com.floreantpos.POSConstants.SUBTOTAL + ":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 0);
		jPanel3.add(jLabel5, gridBagConstraints);

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel6.setText(com.floreantpos.POSConstants.TOTAL + ":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 0);
		jPanel3.add(jLabel6, gridBagConstraints);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel1.setText(com.floreantpos.POSConstants.DISCOUNT + ":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		jPanel3.add(jLabel1, gridBagConstraints);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel2.setText(com.floreantpos.POSConstants.TAX + ":");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		jPanel3.add(jLabel2, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		jPanel3.add(jSeparator2, gridBagConstraints);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		jPanel3.add(jSeparator3, gridBagConstraints);

		tfSubtotal.setEditable(false);
		tfSubtotal.setFont(new java.awt.Font("Tahoma", 1, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
		jPanel3.add(tfSubtotal, gridBagConstraints);

		tfTax.setEditable(false);
		tfTax.setFont(new java.awt.Font("Tahoma", 1, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
		jPanel3.add(tfTax, gridBagConstraints);

		tfDiscount.setEditable(false);
		tfDiscount.setFont(new java.awt.Font("Tahoma", 1, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
		jPanel3.add(tfDiscount, gridBagConstraints);

		tfTotal.setEditable(false);
		tfTotal.setFont(new java.awt.Font("Tahoma", 1, 12));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 5);
		jPanel3.add(tfTotal, gridBagConstraints);

		chkTaxExempt.setFont(new java.awt.Font("Tahoma", 1, 12));
		chkTaxExempt.setText(com.floreantpos.POSConstants.TAX_EXEMPT);
		chkTaxExempt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		chkTaxExempt.setFocusable(false);
		chkTaxExempt.setMargin(new java.awt.Insets(0, 0, 0, 0));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 3, 0);
		jPanel3.add(chkTaxExempt, gridBagConstraints);

		jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

		bottomPanel.setLayout(new java.awt.GridBagLayout());

		btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay_32.png")));
		btnPay.setText(com.floreantpos.POSConstants.PAY_NOW);
		btnPay.setPreferredSize(new java.awt.Dimension(76, 45));
		btnPay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doPayNow(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
		bottomPanel.add(btnPay, gridBagConstraints);

		btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32.png")));
		btnCancel.setText(com.floreantpos.POSConstants.CANCEL);
		btnCancel.setPreferredSize(new java.awt.Dimension(76, 45));
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doCancelOrder(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		bottomPanel.add(btnCancel, gridBagConstraints);

		btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finish_32.png")));
		btnFinish.setText(com.floreantpos.POSConstants.FINISH);
		btnFinish.setPreferredSize(new java.awt.Dimension(76, 45));
		btnFinish.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doFinishOrder(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		bottomPanel.add(btnFinish, gridBagConstraints);

		jPanel1.add(bottomPanel, java.awt.BorderLayout.SOUTH);

		jPanel5.setLayout(new java.awt.GridBagLayout());

		btnIncreaseAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_user_32.png")));
		btnIncreaseAmount.setPreferredSize(new java.awt.Dimension(76, 45));
		btnIncreaseAmount.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doIncreaseAmount(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		jPanel5.add(btnIncreaseAmount, gridBagConstraints);

		btnDecreaseAmount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus_32.png")));
		btnDecreaseAmount.setPreferredSize(new java.awt.Dimension(76, 45));
		btnDecreaseAmount.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doDecreaseAmount(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		jPanel5.add(btnDecreaseAmount, gridBagConstraints);

		btnScrollUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up_32.png")));
		btnScrollUp.setPreferredSize(new java.awt.Dimension(76, 45));
		btnScrollUp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doScrollUp(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		jPanel5.add(btnScrollUp, gridBagConstraints);

		btnScrollDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down_32.png")));
		btnScrollDown.setPreferredSize(new java.awt.Dimension(76, 45));
		btnScrollDown.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doScrollDown(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
		jPanel5.add(btnScrollDown, gridBagConstraints);

		btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_32.png")));
		btnDelete.setText(com.floreantpos.POSConstants.DELETE);
		btnDelete.setPreferredSize(new java.awt.Dimension(80, 17));
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doDeleteSelection(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
		jPanel5.add(btnDelete, gridBagConstraints);

		jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

		add(jPanel1, java.awt.BorderLayout.SOUTH);

		jPanel2.setLayout(new java.awt.BorderLayout());

		jScrollPane1.setBorder(null);
		jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		jScrollPane1.setPreferredSize(new java.awt.Dimension(180, 200));
		jScrollPane1.setViewportView(ticketViewerTable);

		jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		add(jPanel2, java.awt.BorderLayout.CENTER);
	}// </editor-fold>//GEN-END:initComponents

	private void doFinishOrder(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doFinishOrder
		try {
			updateModel();

			OrderController.saveOrder(ticket);

			if (PrintConfig.isPrintReceiptWhenCreated()) {
				PosPrintService.printTicket(ticket);
			}

			if (PrintConfig.isPrintKitchenWhenCreated()) {
				if (ticket.needsKitchenPrint()) {
					PosPrintService.printToKitchen(ticket);
				}
				ticket.clearDeletedItems();
				OrderController.saveOrder(ticket);
			}
			RootView.getInstance().showView(SwitchboardView.VIEW_NAME);
		} catch (PosException x) {
			POSMessageDialog.showError(x.getMessage());
		} catch (Exception e) {
			POSMessageDialog.showError(Application.getPosWindow(), POSConstants.ERROR_MESSAGE, e);
		}
	}//GEN-LAST:event_doFinishOrder

	private void doCancelOrder(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doCancelOrder
		RootView.getInstance().showView(SwitchboardView.VIEW_NAME);
	}//GEN-LAST:event_doCancelOrder

	private void updateModel() {
		if (ticket.getTicketItems() == null || ticket.getTicketItems().size() == 0) {
			throw new PosException(com.floreantpos.POSConstants.TICKET_IS_EMPTY_);
		}
		ticket.calculatePrice();
	}

	private void doPayNow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doPayNow
		try {
			updateModel();
			firePayOrderSelected();
		} catch (PosException e) {
			POSMessageDialog.showError(e.getMessage());
		}
	}//GEN-LAST:event_doPayNow

	private void doDeleteSelection(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doDeleteSelection
		Object object = ticketViewerTable.deleteSelectedItem();
		if (object != null) {
			updateView();

			if (object instanceof TicketItemModifier) {
				ModifierView modifierView = OrderView.getInstance().getModifierView();
				if (modifierView.isVisible()) {
					modifierView.updateVisualRepresentation();
				}
			}
		}

	}//GEN-LAST:event_doDeleteSelection

	private void doIncreaseAmount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doIncreaseAmount
		if (ticketViewerTable.increaseItemAmount()) {
			ModifierView modifierView = OrderView.getInstance().getModifierView();
			if (modifierView.isVisible()) {
				modifierView.updateVisualRepresentation();
			}
			updateView();
		}

	}//GEN-LAST:event_doIncreaseAmount

	private void doDecreaseAmount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doDecreaseAmount
		if (ticketViewerTable.decreaseItemAmount()) {
			ModifierView modifierView = OrderView.getInstance().getModifierView();
			if (modifierView.isVisible()) {
				modifierView.updateVisualRepresentation();
			}
			updateView();
		}
	}//GEN-LAST:event_doDecreaseAmount

	private void doScrollDown(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doScrollDown
		ticketViewerTable.scrollDown();
	}//GEN-LAST:event_doScrollDown

	private void doScrollUp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doScrollUp
		ticketViewerTable.scrollUp();
	}//GEN-LAST:event_doScrollUp

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.floreantpos.swing.TransparentPanel bottomPanel;
	private com.floreantpos.swing.PosButton btnCancel;
	private com.floreantpos.swing.PosButton btnDecreaseAmount;
	private com.floreantpos.swing.PosButton btnDelete;
	private com.floreantpos.swing.PosButton btnFinish;
	private com.floreantpos.swing.PosButton btnIncreaseAmount;
	private com.floreantpos.swing.PosButton btnPay;
	private com.floreantpos.swing.PosButton btnScrollDown;
	private com.floreantpos.swing.PosButton btnScrollUp;
	private javax.swing.JCheckBox chkTaxExempt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private com.floreantpos.swing.TransparentPanel jPanel1;
	private com.floreantpos.swing.TransparentPanel jPanel2;
	private com.floreantpos.swing.TransparentPanel jPanel3;
	private com.floreantpos.swing.TransparentPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JTextField tfDiscount;
	private javax.swing.JTextField tfSubtotal;
	private javax.swing.JTextField tfTax;
	private javax.swing.JTextField tfTotal;
	private com.floreantpos.ui.ticket.TicketViewerTable ticketViewerTable;

	// End of variables declaration//GEN-END:variables

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket _ticket) {
		this.ticket = _ticket;

		ticketViewerTable.setTicket(_ticket);

		updateView();
	}

	public void addTicketItem(TicketItem ticketItem) {
		ticketViewerTable.addTicketItem(ticketItem);
		updateView();
	}

	public void removeModifier(TicketItem parent, TicketItemModifier modifier) {
		ticketViewerTable.removeModifier(parent, modifier);
	}

	private NumberFormat numberFormat = new DecimalFormat("0.00");

	public void updateAllView() {
		ticketViewerTable.updateView();
		updateView();
	}

	public void selectRow(int rowIndex) {
		ticketViewerTable.selectRow(rowIndex);
	}

	public void updateView() {
		if (ticket == null || ticket.getTicketItems() == null || ticket.getTicketItems().size() <= 0) {
			tfSubtotal.setText("");
			tfDiscount.setText("");
			tfTax.setText("");
			tfTotal.setText("");

			return;
		}

		ticket.calculatePrice();

		//		double calculatedSubtotalPrice = ticket.getCalculatedSubtotalPrice();
		//		double discount = ticket.getCalculatedTotalDiscount();
		//		double calculatedTax = ticket.getCalculatedTax();
		//		double calculatedTotalPrice = ticket.getCalculatedTotalPrice();

		tfSubtotal.setText(numberFormat.format(ticket.getSubtotalAmount()));
		tfDiscount.setText(numberFormat.format(ticket.getDiscountAmount()));

		if (ticket.isTaxExempt()) {
			tfTax.setText("0");
			chkTaxExempt.setSelected(true);
		}
		else {
			tfTax.setText(numberFormat.format(ticket.getTaxAmount()));
			chkTaxExempt.setSelected(false);
		}

		tfTotal.setText(numberFormat.format(ticket.getTotalAmount()));
	}

	public void addOrderListener(OrderListener listenre) {
		orderListeners.add(listenre);
	}

	public void removeOrderListener(OrderListener listenre) {
		orderListeners.remove(listenre);
	}

	public void firePayOrderSelected() {
		for (OrderListener listener : orderListeners) {
			listener.payOrderSelected(getTicket());
		}
	}

	public void setControlsVisible(boolean visible) {
		if (visible) {
			bottomPanel.setVisible(true);
			btnIncreaseAmount.setEnabled(true);
			btnDecreaseAmount.setEnabled(true);
			btnDelete.setEnabled(true);
		}
		else {
			bottomPanel.setVisible(false);
			btnIncreaseAmount.setEnabled(false);
			btnDecreaseAmount.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}

	private void updateSelectionView() {
		Object selectedObject = ticketViewerTable.getSelected();

		OrderView orderView = OrderView.getInstance();

		TicketItem selectedItem = null;
		if (selectedObject instanceof TicketItem) {
			selectedItem = (TicketItem) selectedObject;
			MenuItemDAO dao = new MenuItemDAO();
			MenuItem menuItem = dao.get(selectedItem.getItemId());
			MenuGroup menuGroup = menuItem.getParent();
			MenuItemView itemView = OrderView.getInstance().getItemView();
			if (!menuGroup.equals(itemView.getMenuGroup())) {
				itemView.setMenuGroup(menuGroup);
			}
			orderView.showView(MenuItemView.VIEW_NAME);

			MenuCategory menuCategory = menuGroup.getParent();
			orderView.getCategoryView().setSelectedCategory(menuCategory);
			return;
		}
		else if (selectedObject instanceof TicketItemModifier) {
			selectedItem = ((TicketItemModifier) selectedObject).getParent().getParent();
		}
		if (selectedItem == null)
			return;

		ModifierView modifierView = orderView.getModifierView();

		if (selectedItem.isHasModifiers()) {
			MenuItemDAO dao = new MenuItemDAO();
			MenuItem menuItem = dao.get(selectedItem.getItemId());
			if (!menuItem.equals(modifierView.getMenuItem())) {
				menuItem = dao.initialize(menuItem);
				modifierView.setMenuItem(menuItem, selectedItem);
			}

			MenuCategory menuCategory = menuItem.getParent().getParent();
			orderView.getCategoryView().setSelectedCategory(menuCategory);

			orderView.showView(ModifierView.VIEW_NAME);
		}
	}
}
