import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class exerciseGraph extends JFrame {

   public static final long serialVersionUID = 1L;

   public exerciseGraph(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart exerciseChart = ChartFactory.createXYLineChart(chartTitle, "Date of Entry", "Active Hours (hrs)", 
        		exerciseDataset(),PlotOrientation.VERTICAL, true, true, false);
        
        // Adding chart into a chart panel
        ChartPanel exerciseChart_Panel = new ChartPanel(exerciseChart);
        
        // add to contentPane
        setContentPane(exerciseChart_Panel);
        
        
   }
   
   public XYDataset exerciseDataset() {
	     
	      final XYSeries workoutLabel = new XYSeries("workout");
	      workoutLabel.add(1.0, 1.0);
	      workoutLabel.add(2.0, 3.0);
	      workoutLabel.add(3.0, 4.0);
	     
	      final XYSeriesCollection exercise = new XYSeriesCollection();
	      exercise.addSeries(workoutLabel);
	      
	      return exercise;
   }
   
   
   
}