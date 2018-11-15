package ui;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class FrameGame extends JFrame{
	/**
	 * ��Ϸ��Frame�� -> ��Ҫ������Ϸ����Ļ������
	 */
	private static final long serialVersionUID = 1L;

	// ���캯��
	public FrameGame(){
		// ���ñ���
		this.setTitle("Java����˹����");
		// ����Ĭ�Ϲر�����(�������)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô����С
		this.setSize(1200, 700);
		// ���ò������û��ı䴰�ڴ�С
		this.setResizable(false);
		// ���þ������� -> ���ݲ�ͬ�û���ʾ���ķֱ���������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth()-this.getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-this.getHeight())/2 - 36;
		this.setLocation(x, y);
		this.setVisible(true);
		// ����Ĭ��Panel
		this.setContentPane(new PanelGame());

	}
}	
