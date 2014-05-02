import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class sleepGraph extends JFrame {

   public static final long serialVersionUID = 1L;

   public sleepGraph(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        
        JFreeChart sleepChart = ChartFactory.createXYLineChart(chartTitle, "Date of Entry", "Amount of Sleep (hrs)", 
        		sleepDataset(),PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel sleepChart_Panel = new ChartPanel(sleepChart);
        
        setContentPane(sleepChart_Panel);
              
   }
   
   public XYDataset sleepDataset() { 
   	
	      final XYSeries sleepHours = new XYSeries("Sleep Summary");
	      sleepHours.add(3.0, 4.0);
	      sleepHours.add(4.0, 5.0);
	      sleepHours.add(5.0, 4.0);
	      
	      final XYSeriesCollection sleep = new XYSeriesCollection();
	      sleep.addSeries(sleepHours);
	     
	      return sleep;
	     
   }
   
   
   
   
}