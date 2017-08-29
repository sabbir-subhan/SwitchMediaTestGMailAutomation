package supportClasses;

import java.io.IOException;

public class AutoITWindowsGUIAutomationFileUpload {

		public void AutoITWindowsGUIAutomationFileUpload(String AutoITExeFileName){
			
			//file upload page  open
			  /*------AutoIT script will handle window AutoMantion
			   * https://www.autoitscript.com
			   */
			  try {
				Runtime.getRuntime().exec(AutoITExeFileName);
			  } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("AutoIT Windows automtion failed");
			}
		}
		
}
