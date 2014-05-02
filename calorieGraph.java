import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class calorieGraph extends JFrame {

   public static final long serialVersionUID = 1L;

   public calorieGraph(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        
        JFreeChart calorieChart = ChartFactory.createXYLineChart(chartTitle, "Date of Entry", "Calories (kcal)", 
        		calorieDataset(),PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel calorieChart_Panel = new ChartPanel(calorieChart);
        
        setContentPane(calorieChart_Panel);
        
   }
   
   public XYDataset calorieDataset() {  
	      
	      final XYSeries burned = new XYSeries("Calories Burned");
	      burned.add(1.0, 1.0);
	      burned.add(2.0, 3.0);
	      burned.add(3.0, 4.0);
	     
	      final XYSeries intake = new XYSeries("Caloric Intake");
	      intake.add(1.0, 4.0);
	      intake.add(2.0, 6.0);
	      intake.add(3.0, 5.0);
	    
	      final XYSeriesCollection calories = new XYSeriesCollection();
	      calories.addSeries(burned);
	      calories.addSeries(intake);
	     
	      return calories;
   }
   
      
   
}