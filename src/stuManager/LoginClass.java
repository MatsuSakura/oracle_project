package stuManager;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;


public class LoginClass {
	boolean packFrame = false;

	public LoginClass() {
		LoginFrame frame = new LoginFrame();
		if (packFrame) {
			frame.pack();
		} else {
			frame.validate();
		}
		// 调整窗体大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		;
		frame.setVisible(true);
	}

	// 主方法
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//把外观设置成你所使用的平台的外观
				} catch (Exception e) {
					e.printStackTrace();
				}
				new LoginClass();
			}
		});
	}
}
