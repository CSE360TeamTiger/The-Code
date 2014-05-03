import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;




public class pieCharts{
	

	// creates weekly summary of exercise durations for the week
	public static JFreeChart exercisePieChart(){
		
		//makes the data set for the chart
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Monday", 3.00);
		data.setValue("Tuesday", 2.5);
		data.setValue("Wednesday", 0.00);
		data.setValue("Thursday", 1.5);
		data.setValue("Friday", 1.00);
		data.setValue("Saturday",  2.00);
		data.setValue("Sunday", 4.25);
		
		//creates the pie chart with the data set
		JFreeChart pie = ChartFactory.createPieChart("Weekly summary of Active Hours", data,
				true,true,false);
		
		JFrame frame = new JFrame();
		// Adding chart into a chart panel
        ChartPanel panel = new ChartPanel(pie);   
        // add to frame
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
		
		
		//returns the pie chart with the correct data of exercise durations
		return pie ;
	}
	
	//creates weekly summary of hours slept
	public static JFreeChart sleepPieChart(){
		
		//makes data set for the chart
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Monday", 12.00);
		data.setValue("Tuesday", 5.00);
		data.setValue("Wednesday", 8.00);
		data.setValue("Thursday", 7.5);
		data.setValue("Friday", 7.5);
		data.setValue("Saturday",  6.00);
		data.setValue("Sunday", 6.5);
		
		//creates pie chart with the data set made above
		JFreeChart pie = ChartFactory.createPieChart("Weekly Summary of Hours Slept", data,
				true,true,false);
		
		JFrame frame = new JFrame();
		// Adding chart into a chart panel
        ChartPanel panel = new ChartPanel(pie);   
        // add to frame
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
		
		return pie;
	}

	//creates weekly summary of calories eaten - calories burned
	public static JFreeChart caloriePieChart(){
		
		//makes data set for the chart
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("Monday", 500);
		data.setValue("Tuesday", 750);
		data.setValue("Wednesday", 630);
		data.setValue("Thursday", 425);
		data.setValue("Friday", 701);
		data.setValue("Saturday", 1000);
		data.setValue("Sunday", 800);
		
		//creates pie chart with the data set above
		JFreeChart pie = ChartFactory.createPieChart("Weekly Summary of Caloric Intake", data,
				true,true,false);
		
		JFrame frame = new JFrame();
		// Adding chart into a chart panel
        ChartPanel panel = new ChartPanel(pie);   
        // add to frame
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
		
		return pie;
	}
	
	//method to generate PDFs from the charts made above
	public static void generatePDF(JFreeChart pie, int width, int height, String file){
		
		PdfWriter write = null;
		
		Document pdf = new Document();
		
		try{
			write = PdfWriter.getInstance(pdf, new FileOutputStream(file));
			pdf.open();
			PdfContentByte content = write.getDirectContent();
			PdfTemplate pdfTemp = content.createTemplate(width,height);
			Graphics2D graphics2d = pdfTemp.createGraphics(width,height, new DefaultFontMapper());
			Rectangle2D rectangle2d = new Rectangle2D.Double(0,0,width,height);
			pie.draw(graphics2d,  rectangle2d);;
			
			graphics2d.dispose();
			content.addTemplate(pdfTemp,0,0);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		pdf.close();
		
	
	}
	
	public static void print(){
		Desktop desktop = Desktop.getDesktop();
			
		
		try{
			desktop.print(new File("weeklyExerciseChart.pdf"));
			desktop.print(new File("weeklySleepChart.pdf"));
			desktop.print(new File("weeklyCalorieChart.pdf"));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	


	
}
