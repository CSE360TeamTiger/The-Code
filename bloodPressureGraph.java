import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class bloodPressureGraph extends JFrame {

   public static final long serialVersionUID = 1L;

   public bloodPressureGraph(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        
        JFreeChart bloodPressureChart = ChartFactory.createXYLineChart(chartTitle, "Date of Entry", "Blood Pressure (mmHg)", 
        		bloodPressureDataset(),PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel bloddPressureChart_Panel = new ChartPanel(bloodPressureChart);
        
        setContentPane(bloddPressureChart_Panel);        
        
   }
   
   public XYDataset bloodPressureDataset() {  
	      
	      final XYSeries systolic = new XYSeries("Systolic Blood Pressure");
	      systolic.add(1.0, 4.0);
	      systolic.add(2.0, 6.0);
	      systolic.add(3.0, 5.0);
	        
	      final XYSeries diastolic = new XYSeries("Diastolic Blood Pressure");
	      diastolic.add(3.0, 4.0);
	      diastolic.add(4.0, 5.0);
	      diastolic.add(5.0, 4.0);
	      
	      final XYSeriesCollection bloodPressure = new XYSeriesCollection();
	      bloodPressure.addSeries(systolic);
	      bloodPressure.addSeries(diastolic);
	     
	      return bloodPressure;
	}
   
   	
   
   
}