
import java.awt.EventQueue;
//Main Class where program is executed


//There is already a main on line 260 of the GUI file?
public class FT360 {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			GUI gui = new GUI();
			gui.login.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
});



}

}


