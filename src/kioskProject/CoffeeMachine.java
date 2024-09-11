package kioskProject;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class CoffeeMachine extends JFrame {
	JPanel CoffeeMenu, CoffeeOrder, Payment;
	JTextArea totalMenu;
	JLabel EX;
	
	int count = 0;
	
	public CoffeeMachine() {
		setTitle("Ŀ�� �ӽ�");
		setSize(420,500);
		setResizable(false);
		
		JFrame frame = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel main = new JLabel("Ŀ�Ǹ� �ֹ��ϼ���");
		add(main, BorderLayout.CENTER);

		
		
		//Ŀ�� �޴� �гΰ� ��ư
		CoffeeMenu = new JPanel(); add(CoffeeMenu);
		CoffeeMenu.setLayout(new GridLayout(3,2,10,5));
		
		String[] coffeetext = {"�Ƹ޸�ī��", "ī���", "ī���ī", "īǪġ��", "��ü��", "�ݵ���"};
		JButton[] coffee = new JButton[coffeetext.length];
		
		String[] coffeePriceText = {"2000��", "2500��", "3000��", "3000��", "4000��", "4500��"};
		JLabel[] coffeePrice = new JLabel[coffeePriceText.length];
		

		for (int i=0; i < coffeetext.length; i++) {
			coffee[i] = new JButton(coffeetext[i]);
			CoffeeMenu.add(coffee[i]);
			coffeePrice[i] = new JLabel(coffeePriceText[i]);
			CoffeeMenu.add(coffeePrice[i]);
			coffee[i].addActionListener(new MyActionListener());
		}
		
		
	    //�Է¹��� �ֹ� ����
		totalMenu = new JTextArea("�޴�\t"+"����\t"+"���� ����\t"+"���� ����"+"\t\n", 7, 35);
		add(totalMenu, BorderLayout.CENTER);
		totalMenu.setEditable(false);
		totalMenu.setBackground(Color.white);
		
		JScrollPane scrollPane = new JScrollPane(totalMenu);
		add(scrollPane);
		totalMenu.setCaretPosition(totalMenu.getDocument().getLength());

		
		//�ֹ� ���� Ȯ��
		CoffeeOrder= new JPanel(); add(CoffeeOrder);

		JButton OK = new JButton("Ȯ��");
		JButton CANCEL = new JButton("�ֹ� ���");
		
		CoffeeOrder.setLayout(new FlowLayout());
		CoffeeOrder.add(OK);
		CoffeeOrder.add(CANCEL);
		
		//�ֹ� ��� ��ư ������ �ʱ�ȭ
		CANCEL.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				totalMenu.setText("\t"+"�޴�\t"+"����\t"+"���� ����\t"+"\t\n");
				count = 0;
				EX.setText("�� ��: " + count + "");
				
				//�ֹ� ��� ��ư ������ Ŀ�ǹ�ư Ȱ��ȭ
				for (int i=0; i < coffee.length; i++) {
					coffee[i].setEnabled(true);
				}
			}
		});
		

		OK.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				
			//Ȯ�� ��ư ������ �� �̻� �ֹ��� �� ������ ��ư ��Ȱ��ȭ
			for (int i=0; i < coffee.length; i++) {
				coffee[i].setEnabled(false);
			}
		
				
			Payment = new JPanel(); add(Payment);
			Payment.setLayout(new GridLayout(3,1));
			
			JLabel PaymentMent1 = new JLabel("���� ������ ������ �ּ���.");
			JLabel PaymentMent2 = new JLabel("������ ������ �Ұ����մϴ�.");
			 
			Payment.add(PaymentMent1);
			Payment.add(PaymentMent2);
			
			String[] PaymentText = {"ī��", "����� ����", "����Ƽ��"};
			JButton[] PaymentBtn = new JButton[PaymentText.length];
			
			for (int i=0; i < PaymentText.length; i++) {
				PaymentBtn[i] = new JButton(PaymentText[i]);
				Payment.add(PaymentBtn[i]);
				PaymentBtn[i].addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
						
						//�˾� â Ŭ�� �� ���� �ʱ�ȭ
						for (int i=0; i < coffee.length; i++) {
							coffee[i].setEnabled(true);
						}
						totalMenu.setText("�޴�\t"+"����\t"+"���� ����\t"+"���� ����"+"\t\n");
						count = 0;
						EX.setText("�� ��: " + count + "");
						Payment.setVisible(false);

					}
				});
			       
			}
				
			setVisible(true);

			}
		});
		
		EX = new JLabel("�� ��: " + count + ""); CoffeeOrder.add(EX);

		
		//ȭ�� ���̱�
		setVisible(true);
		
	}
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();

			
			if (b.getText().equals("�Ƹ޸�ī��")){
				count += 2000;
				EX.setText("�� ��: " + count + "");
				totalMenu.append("�Ƹ޸�ī��\t"+"2000��\t"+(totalMenu.getLineCount()-1) +"\t"+""+count+"\n");
			}
			else if (b.getText().equals("ī���")){
				count += 2500;
				EX.setText("�� ��: " + count + "");
				totalMenu.append("ī���\t"+"2000��\t"+(totalMenu.getLineCount()-1) +"\t"+""+count+"\n");
			}
			else if (b.getText().equals("ī���ī")){
				count += 3000;
				EX.setText("�� ��: " + count + "");
				totalMenu.append("ī���ī\t"+"2000��\t"+(totalMenu.getLineCount()-1) +"\t"+""+count+"\n");
			}
			else if (b.getText().equals("īǪġ��")){
				count += 3000;
				EX.setText("�� ��: " + count + "");
				totalMenu.append("īǪġ��\t"+"3000��\t"+(totalMenu.getLineCount()-1) +"\t"+""+count+"\n");
			}
			else if (b.getText().equals("��ü��")){
				count += 4000;
				EX.setText("�� ��: " + count + "");
				totalMenu.append("��ü��\t"+"4000��\t"+(totalMenu.getLineCount()-1) +"\t"+""+count+"\n");
			}			
			else if (b.getText().equals("�ݵ���")){
				count += 4500;
				EX.setText("�� ��: " + count + "");
				totalMenu.append("�ݵ���\t"+"4500��\t"+(totalMenu.getLineCount()-1) +"\t"+""+count+"\n");		
			}

		}
	}
	
	public static void main(String[] args) {
		new CoffeeMachine();
		
	}
}