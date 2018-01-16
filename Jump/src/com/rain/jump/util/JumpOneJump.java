package com.rain.jump.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @classname JumpOneJump.java
 * @package com.rain.jump.util
 * @project Jump
 * @author Rain 
 * @describe ΢����һ����Ŀ
 * @version 1.0
 * @date 2018��1��13�� ����12:06:07
 */
public class JumpOneJump extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//������������
	int x0,y0,x1,y1;
	//����������ǵ�һ�λ���...
	boolean flag=true;
	public JumpOneJump()
	{
		super("΢����һ��");//������ķ���
		//���ô��ڴ�С
		this.setSize(316,565);
		//ȥ�����ڵ�װ��(������)
		this.setUndecorated(true);
		//���ô��ھ���
		this.setLocationRelativeTo(null);
		//���ô��ڵ�͸����(float��)
		this.setOpacity(0.3f);
		//���ô����ö�
		this.setAlwaysOnTop(true);
		//���ô����Ƿ�ɼ�
		this.setVisible(true);
		//���X�˳�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��������Ҽ���ȡ����
		
		//����һ��С���
		JLabel jLabel=new JLabel();
		this.add(jLabel);
		
		//��jLabel���һ������
		this.addMouseListener(new MouseAdapter() {
			//�����������ʱ��
			public void mouseClicked(MouseEvent e){
				//���� �����¼�Դ
				//System.out.println(e);
				if(e.getButton()==MouseEvent.BUTTON3)
				{
					//System.out.println("������");
					
					
					if(flag)
					{
						x0=e.getX(); 
						y0=e.getY();
						flag=false;
						System.out.println("��һ�ε����������:("+x0+","+y0+")");
					}
					else{
						x1=e.getX();
						y1=e.getY();
						flag=true;
						System.out.println("�ڶ��ε����������:("+x1+","+y1+")");
						//ȡ����ֵ
						double _x=Math.abs(x0-x1);
						double _y=Math.abs(y0-y1);
						//��ƽ��(����ľ���)
						double dis = Math.sqrt(_x*_x+_y*_y);
						System.out.println(dis);
						//����adb����
//						String cmd="adb shell input touchscreen "
//								+"swipe 200 187 200 187 "+Math.round(dis*3);
						String cmd="adb shell input swipe 320 410 320 410 "+Math.round(dis*5);
						Runtime run = Runtime.getRuntime();
						
						try {
							//ִ������
							Process p=run.exec(cmd);
							System.out.println(cmd);
							p.waitFor();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}//end else
					
				}//end if
			}//end mouseClick()
		});
		
	}
	
	//��������
	public static void main(String[] args) {
		
		//��һ������  ͨ��usb�������ֻ�  ��ȡ�ֻ���Ļ�Ľ�ͼ
		//����һ������
		 new JumpOneJump();
	}

}
