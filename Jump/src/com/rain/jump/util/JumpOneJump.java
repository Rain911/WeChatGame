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
 * @describe 微信跳一跳项目
 * @version 1.0
 * @date 2018年1月13日 下午12:06:07
 */
public class JumpOneJump extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义两点坐标
	int x0,y0,x1,y1;
	//设置鼠标点击是第一次还是...
	boolean flag=true;
	public JumpOneJump()
	{
		super("微信跳一跳");//调父类的方法
		//设置窗口大小
		this.setSize(316,565);
		//去除窗口的装饰(标题栏)
		this.setUndecorated(true);
		//设置窗口居中
		this.setLocationRelativeTo(null);
		//设置窗口的透明度(float型)
		this.setOpacity(0.3f);
		//设置窗口置顶
		this.setAlwaysOnTop(true);
		//设置窗口是否可见
		this.setVisible(true);
		//点击X退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置鼠标右键获取坐标
		
		//创建一个小面板
		JLabel jLabel=new JLabel();
		this.add(jLabel);
		
		//给jLabel添加一个监听
		this.addMouseListener(new MouseAdapter() {
			//当你鼠标点击的时候
			public void mouseClicked(MouseEvent e){
				//参数 鼠标的事件源
				//System.out.println(e);
				if(e.getButton()==MouseEvent.BUTTON3)
				{
					//System.out.println("哈哈哈");
					
					
					if(flag)
					{
						x0=e.getX(); 
						y0=e.getY();
						flag=false;
						System.out.println("第一次点击的坐标是:("+x0+","+y0+")");
					}
					else{
						x1=e.getX();
						y1=e.getY();
						flag=true;
						System.out.println("第二次点击的坐标是:("+x1+","+y1+")");
						//取绝对值
						double _x=Math.abs(x0-x1);
						double _y=Math.abs(y0-y1);
						//开平方(两点的距离)
						double dis = Math.sqrt(_x*_x+_y*_y);
						System.out.println(dis);
						//定义adb命令
//						String cmd="adb shell input touchscreen "
//								+"swipe 200 187 200 187 "+Math.round(dis*3);
						String cmd="adb shell input swipe 320 410 320 410 "+Math.round(dis*5);
						Runtime run = Runtime.getRuntime();
						
						try {
							//执行命令
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
	
	//程序的入口
	public static void main(String[] args) {
		
		//跳一跳辅助  通过usb线连接手机  获取手机屏幕的截图
		//创建一个窗口
		 new JumpOneJump();
	}

}
