import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;


public class RealEstate {

	protected Shell shlRealEstateProgram;
	private Text lotText;
	private Text firstText;
	private Text lastText;
	private Text priceText;
	private Text feetText;
	private Text bedText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RealEstate window = new RealEstate();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRealEstateProgram.open();
		shlRealEstateProgram.layout();
		while (!shlRealEstateProgram.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRealEstateProgram = new Shell();
		shlRealEstateProgram.setSize(329, 462);
		shlRealEstateProgram.setText("Real Estate Program");
		
		lotText = new Text(shlRealEstateProgram, SWT.BORDER);
		lotText.setBounds(163, 60, 140, 27);
		
		firstText = new Text(shlRealEstateProgram, SWT.BORDER);
		firstText.setBounds(163, 93, 140, 27);
		
		lastText = new Text(shlRealEstateProgram, SWT.BORDER);
		lastText.setBounds(163, 126, 140, 27);
		
		priceText = new Text(shlRealEstateProgram, SWT.BORDER);
		priceText.setBounds(163, 159, 140, 27);
		
		feetText = new Text(shlRealEstateProgram, SWT.BORDER);
		feetText.setBounds(163, 192, 140, 27);
		
		bedText = new Text(shlRealEstateProgram, SWT.BORDER);
		bedText.setBounds(163, 225, 140, 27);
		
		Label lblLotNumber = new Label(shlRealEstateProgram, SWT.NONE);
		lblLotNumber.setAlignment(SWT.RIGHT);
		lblLotNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLotNumber.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblLotNumber.setBounds(46, 60, 91, 21);
		lblLotNumber.setText("Lot Number :");
		
		Label lblFirstName = new Label(shlRealEstateProgram, SWT.NONE);
		lblFirstName.setAlignment(SWT.RIGHT);
		lblFirstName.setText("First Name:");
		lblFirstName.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblFirstName.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblFirstName.setBounds(46, 93, 91, 21);
		
		Label lblLastName = new Label(shlRealEstateProgram, SWT.NONE);
		lblLastName.setAlignment(SWT.RIGHT);
		lblLastName.setText("Last Name :");
		lblLastName.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblLastName.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblLastName.setBounds(46, 126, 91, 21);
		
		Label lblPrice = new Label(shlRealEstateProgram, SWT.NONE);
		lblPrice.setAlignment(SWT.RIGHT);
		lblPrice.setText("Price :");
		lblPrice.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblPrice.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblPrice.setBounds(46, 159, 91, 21);
		
		Label lblSquareFeet = new Label(shlRealEstateProgram, SWT.NONE);
		lblSquareFeet.setAlignment(SWT.RIGHT);
		lblSquareFeet.setText("Square Feet :");
		lblSquareFeet.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblSquareFeet.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblSquareFeet.setBounds(46, 192, 91, 21);
		
		Label lblBedRooms = new Label(shlRealEstateProgram, SWT.NONE);
		lblBedRooms.setAlignment(SWT.RIGHT);
		lblBedRooms.setText("Bed Rooms :");
		lblBedRooms.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblBedRooms.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblBedRooms.setBounds(46, 225, 91, 21);
		
		Label statusLabel = new Label(shlRealEstateProgram, SWT.BORDER | SWT.HORIZONTAL | SWT.SHADOW_NONE | SWT.CENTER);
		statusLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		statusLabel.setAlignment(SWT.CENTER);
		statusLabel.setText("Next House Displayed");
		statusLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		statusLabel.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		statusLabel.setBounds(10, 21, 291, 33);
		
		Button Reset = new Button(shlRealEstateProgram, SWT.NONE);
		Reset.setBounds(10, 274, 140, 41);
		Reset.setText("Reset");
		
		Button Next = new Button(shlRealEstateProgram, SWT.NONE);
		Next.setText("Next");
		Next.setBounds(163, 274, 140, 41);
		
		Button Add = new Button(shlRealEstateProgram, SWT.NONE);
		Add.setText("Add");
		Add.setBounds(10, 321, 140, 41);
		
		Button Delete = new Button(shlRealEstateProgram, SWT.NONE);
		Delete.setText("Delete");
		Delete.setBounds(163, 321, 140, 41);
		
		Button Clear = new Button(shlRealEstateProgram, SWT.NONE);
		Clear.setText("Clear");
		Clear.setBounds(10, 367, 140, 41);
		
		Button Find = new Button(shlRealEstateProgram, SWT.NONE);
		Find.setText("Find");
		Find.setBounds(163, 367, 140, 41);

	}
}
